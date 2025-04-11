package com.example.fetch.presentation

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel {
        MainViewModel(
            loadInfoUseCase = get()
        )
    }
}