package com.example.mockitokotlinsample.di

/*ーーーーーーー
   DI用クラス
 ーーーーーーー*/
import android.app.Application
import com.example.mockitokotlinsample.MainContact
import com.example.mockitokotlinsample.MainPresenter
import com.example.mockitokotlinsample.SampleRepository
import com.example.mockitokotlinsample.SampleRepositoryImp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(applicationContext)
            modules(module)
        }
    }

    // Koinモジュール
    private val module: Module = module  {
        factory <MainContact.Presenter>{ (v: MainContact.View) -> MainPresenter(v, get()) }
        factory <SampleRepository>{ SampleRepositoryImp() }
    }



}