package uz.gita.lesson22.app

import android.app.Application


class App : Application() {

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
//        Database.init(this)
        instance = this

    }
}