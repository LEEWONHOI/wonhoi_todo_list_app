package com.example.wonhoi_todo_list_app04

import android.app.Application
import com.example.wonhoi_todo_list_app04.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class TodoListApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // TODO Koin Trigger
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@TodoListApplication)
            modules(appModule)
        }
    }
}