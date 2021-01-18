package tech.vrutal.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import timber.log.Timber
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideTimberTree(): Timber.Tree = Timber.asTree()

    @Singleton
    @Provides
    fun provideName(): String = "RickMortyApp"
}