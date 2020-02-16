package com.example.notekeeper.di

import android.app.Application
import com.example.daggersample.di.ActivityBuildersModule
import com.example.daggersample.di.ViewModelFactoryModule
import com.example.notekeeper.BaseApplication
import dagger.BindsInstance
import dagger.BindsOptionalOf
import dagger.Component
import dagger.android.AndroidInjection
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(
    modules = arrayOf(
        AndroidInjectionModule::class,
        ViewModelFactoryModule::class,
        ActivityBuildersModule::class,
        AppModule::class
    )
)
interface AppComponent: AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application: Application) : Builder

        fun build(): AppComponent
    }
}