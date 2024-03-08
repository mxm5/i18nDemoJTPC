package com.example.thei18ndemofromthenet

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import java.util.Locale

class MainActivity : ComponentActivity() {
//    if had many activity fill this too from the shared prefs
//    override fun attachBaseContext(newBase: Context) {
//        super.attachBaseContext(ContextWrapper(newBase.setAppLocale("en")))
//    }

    override fun onCreate(savedInstanceState: Bundle?) {

        setApplicationLanguageToLocaleSelectedBeforeStart()
        super.onCreate(savedInstanceState)
        setContent {
//            HomeScreen()
            ChangeLanguageScreen()
        }
    }

    private fun loadPreviouslySelectedLanguageFromSharedPrefs(): Locale {
        val sharedPreferences =
            applicationContext.getSharedPreferences("lang_prefs", MODE_PRIVATE)
        val savedLanguageTag = sharedPreferences.getString("selected_lang_tag", "fa")
        return Locale(savedLanguageTag!!)

    }

    private fun setApplicationLanguageToLocaleSelectedBeforeStart() {
        val locale = loadPreviouslySelectedLanguageFromSharedPrefs();
        val config = resources.configuration
        Locale.setDefault(locale)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
            config.setLocale(locale)
        else
            config.locale = locale

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            applicationContext.createConfigurationContext(config)
        resources.updateConfiguration(config, resources.displayMetrics)
    }
}




