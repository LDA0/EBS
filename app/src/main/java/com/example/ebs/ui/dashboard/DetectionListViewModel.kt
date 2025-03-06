package com.example.ebs.ui.dashboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ebs.data.repositories.remote.DataTest
import com.example.ebs.data.repositories.remote.DataTestRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface DetectionListUiState {
    data class Success(val dataTest: List<DataTest>) : DetectionListUiState
    object Error : DetectionListUiState
    object Loading : DetectionListUiState
}

class DetectionListViewModel(
    private val dataTestRepository: DataTestRepository
) : ViewModel() {
    var detectionListUiState: DetectionListUiState by mutableStateOf(DetectionListUiState.Loading)
        private set

    init {
        getData()
    }

    fun getData() {
        viewModelScope.launch {
            detectionListUiState = DetectionListUiState.Loading
            detectionListUiState = try {
                DetectionListUiState.Success(dataTestRepository.getData())
            } catch (e: IOException) {
                DetectionListUiState.Error
            } catch (e: HttpException) {
                DetectionListUiState.Error
            }
        }
    }

//    /**
//     * Factory for [MarsViewModel] that takes [MarsPhotosRepository] as a dependency
//     */
//    companion object {
//        val Factory: ViewModelProvider.Factory = viewModelFactory {
//            initializer {
//                val application = (this[APPLICATION_KEY] as MarsPhotosApplication)
//                val marsPhotosRepository = application.container.marsPhotosRepository
//                MarsViewModel(marsPhotosRepository = marsPhotosRepository)
//            }
//        }
//    }
}