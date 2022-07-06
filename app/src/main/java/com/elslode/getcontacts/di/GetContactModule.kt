package com.elslode.getcontacts.di

import android.content.Context
import com.elslode.getcontacts.data.RepositoryImpl
import com.elslode.getcontacts.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class GetContactModule {

    @Binds
    abstract fun bindRepository(
        repository: RepositoryImpl
    ): Repository

}