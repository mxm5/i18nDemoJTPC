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
//        // before setting the application locale from the persistence unit
//        // the default settings are being applied from the device locale
//        // problem with that is the pre rendered stuff wont be recreated so the
//        // change functions are not being working completely so there should be
//        // another way for changing language so we need to try with per app
//        // locale configurations // this loc shows the locale before getting fetched
//        // from the shared prefs which is device default
//        Log.i(resources.configuration.locale.toLanguageTag(),"locale")

//        setApplicationLanguageToLocaleSelectedBeforeStart()


//        // this should be called in the start of the app but before the supers  super.onCreate()
//        Log.i(resources.configuration.locale.toLanguageTag(),"locale")
//        // this loads splash screen but with the unchanged locale because
//        // this built before anything else
//        val splashScreen = installSplashScreen()
//
//        Log.i(resources.configuration.locale.toLanguageTag(),"locale")



        super.onCreate(savedInstanceState)
        setContent {
//            val context = LocalContext.current
//            LaunchedEffect(key1 = Unit) {
//                launch(Dispatchers.Main) {
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//                        val systemService: LocaleManager =
//                            context.getSystemService(LocaleManager::class.java)
//                        systemService.applicationLocales = LocaleList.forLanguageTags(
//                            "fa"
//                        )
//                    } else {
//                        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags("fa"))
//                    }
//                }
//            }
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





