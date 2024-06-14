package ar.edu.unlam.mobile.scaffolding.data.di

import ar.edu.unlam.mobile.scaffolding.data.local.GameResultRoomRepository
import ar.edu.unlam.mobile.scaffolding.data.repository.GameResultDefaultRepository
import ar.edu.unlam.mobile.scaffolding.data.repository.GameResultLocalRepository
import ar.edu.unlam.mobile.scaffolding.domain.repository.GameResultsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModules {
    @Binds
    abstract fun bindGameResultRepository(gameResultRepositoryImpl: GameResultDefaultRepository): GameResultsRepository

    @Binds
    abstract fun bindLocalGameResultRepository(localGameResultRepository: GameResultRoomRepository): GameResultLocalRepository
}
