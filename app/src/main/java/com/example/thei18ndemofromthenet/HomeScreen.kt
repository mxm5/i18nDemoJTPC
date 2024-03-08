package com.example.thei18ndemofromthenet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.thei18ndemofromthenet.ui.theme.TheI18nDemoFromTheNetTheme

@Composable
fun HomeScreen() {
    TheI18nDemoFromTheNetTheme {
        Column {
            Text(modifier = Modifier.padding(20.dp), text = stringResource(R.string.this_is_a_long_text))
        }

    }
}