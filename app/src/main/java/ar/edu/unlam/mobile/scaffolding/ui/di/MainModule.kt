package ar.edu.unlam.mobile.scaffolding.ui.di

import ar.edu.unlam.mobile.scaffolding.domain.services.GameResultService
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GameResultUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class MainModule {
    @Binds
    abstract fun bindGameResults(gameResultService: GameResultService): GameResultUseCase
}
