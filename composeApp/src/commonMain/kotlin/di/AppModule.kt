package di

import local.DataSource
import org.koin.core.context.startKoin
import org.koin.dsl.module
import screen.home.HomeViewModel

val myModule = module {
    factory { HomeViewModel(DataSource()) }
}

fun initKoin(){
    startKoin {
        modules(myModule)
    }
}