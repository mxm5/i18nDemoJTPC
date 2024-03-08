package com.example.thei18ndemofromthenet

import android.app.Activity
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thei18ndemofromthenet.ui.theme.TheI18nDemoFromTheNetTheme
import java.util.Locale

class MainActivity : ComponentActivity() {


    // LocalContext.current.resources

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContent {
            TheI18nDemoFromTheNetTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        ChangeLang(getString(R.string.android))
                        Text(modifier = Modifier.padding(10.dp),text = stringResource(id = R.string.greeting))
                        Spacer(modifier = Modifier.height(100.dp))
                        ImageResourceDemo()
                    }
                }
            }
        }
    }
}

@Composable
fun ChangeLang(name: String, modifier: Modifier = Modifier) {

    val languages = arrayOf("en", "es", "de","ar","fa")
    val flags = arrayOf(
        R.drawable.flag_uk,
        R.drawable.flag_es,
        R.drawable.flag_es,
        R.drawable.flag_ar,
        R.drawable.flag_fa
    )
    Column(Modifier.padding(10.dp)) {
        languages.forEachIndexed { idx, lang ->
            SpecialText(name = lang, flagDrawable = flags[idx], locale = Locale(lang))
        }

    }
}


@Composable
fun ImageResourceDemo() {
    val image: Painter = painterResource(id = R.drawable.flag)
    Image(
        painter = image,
        contentDescription = "Compose Logo",
        modifier = Modifier
            .height(100.dp)
            .width(300.dp)
    )
}


@Composable
fun SpecialText(name: String, locale: Locale, @DrawableRes flagDrawable: Int) {
    val context = LocalContext.current
    val resources = context.resources

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier= Modifier
            .padding(5.dp)
            .background(Color.Yellow.copy(alpha = 0.3f))
            .clickable {
                val config = resources.configuration
                Locale.setDefault(locale)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
                    config.setLocale(locale)
                else
                    config.locale = locale

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                    context.createConfigurationContext(config)
                resources.updateConfiguration(config, resources.displayMetrics)

                (context as? Activity)?.recreate()


            }) {
        Text(
            text = name,
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Black,
            modifier = Modifier
        )

        Image(
            painter = painterResource(id = flagDrawable),
            contentDescription = "Compose Logo",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .height(60.dp)
                .width(60.dp)
                .background(Color.White)
                .padding(5.dp)
                .background(Color.Yellow)
                .padding(5.dp)

        )
    }
}