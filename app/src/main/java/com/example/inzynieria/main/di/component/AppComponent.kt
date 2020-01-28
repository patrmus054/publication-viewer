package com.example.inzynieria.main.di.component

import com.example.inzynieria.ApplicationCore
import com.example.inzynieria.main.di.module.*
import com.example.inzynieria.main.di.module.ActivityBindingModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton




@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, AppModule::class, DatabaseModule::class, NetworkModule::class,
        RepositoryModule::class, ViewModelModule::class, ActivityBindingModule::class]
)
interface AppComponent : AndroidInjector<ApplicationCore> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: ApplicationCore): Builder

        fun build(): AppComponent
    }
}