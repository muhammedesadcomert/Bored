package com.muhammedesadcomert.bored.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muhammedesadcomert.bored.domain.entity.ActivityEntity
import com.muhammedesadcomert.bored.domain.usecase.GetActivityUseCase
import com.muhammedesadcomert.bored.util.NetworkResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getActivityUseCase: GetActivityUseCase
) : ViewModel() {

    private val _boredActivity =
        MutableStateFlow<HomeUiState<ActivityEntity>>(value = HomeUiState.Initial)
    val boredActivity: StateFlow<HomeUiState<ActivityEntity>> get() = _boredActivity

    fun getBoredActivity() {
        viewModelScope.launch {
            getActivityUseCase().collectLatest { result ->
                when (result) {
                    NetworkResponseState.Loading -> {
                        _boredActivity.emit(HomeUiState.Loading)
                    }
                    is NetworkResponseState.Error -> {
                        _boredActivity.emit(HomeUiState.Error(result.errorMessage))
                    }
                    is NetworkResponseState.Success -> {
                        _boredActivity.emit(HomeUiState.Success(result.data))
                    }
                }
            }
        }
    }
}

sealed interface HomeUiState<out T : Any> {
    data class Success<out T : Any>(val data: T) : HomeUiState<T>
    data class Error(val errorMessage: String) : HomeUiState<Nothing>
    object Loading : HomeUiState<Nothing>
    object Initial : HomeUiState<Nothing>
}