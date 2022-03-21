package android.example.flowerschemistry.application

import android.app.Application
import android.example.flowerschemistry.koin.retrofitModule
import android.example.flowerschemistry.koin.viewModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(retrofitModule, viewModules))
            androidContext(this@MyApplication)
        }
    }
}