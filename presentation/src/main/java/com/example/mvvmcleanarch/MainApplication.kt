package com.example.mvvmcleanarch

import android.app.Application
import com.example.mvvmcleanarch.di.AppModule
import com.example.mvvmcleanarch.di.DaggerMyComponent
import com.example.mvvmcleanarch.di.MyComponent

class MainApplication : Application() {

    lateinit var component: MyComponent;

    override fun onCreate() {
        super.onCreate()
         component = DaggerMyComponent.builder().appModule(AppModule()).build()
    }

}