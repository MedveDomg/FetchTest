package com.example.fetch.presentation

import com.example.fetch.domain.Info

sealed class ViewState {

    data object Loading: ViewState()

    data class Error(val throwable: Throwable): ViewState()

    data class Success(val info: List<Info>): ViewState()
}