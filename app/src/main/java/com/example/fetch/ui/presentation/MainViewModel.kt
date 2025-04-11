package com.example.fetch.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetch.base.Result
import com.example.fetch.domain.LoadInfoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    val loadInfoUseCase: LoadInfoUseCase,
): ViewModel() {

    private val _uiState = MutableStateFlow<ViewState>(ViewState.Loading)
    val uiState: StateFlow<ViewState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            when(val result = loadInfoUseCase.invoke(Unit)) {
                is Result.Error -> _uiState.value = ViewState.Error(result.error)
                is Result.Success -> _uiState.value = ViewState.Success(result.data)
            }
        }
    }
}