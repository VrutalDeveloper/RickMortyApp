package tech.vrutal.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import tech.vrutal.core.remote.RemoteSource
import tech.vrutal.core.remote.toCharac
import tech.vrutal.domain.Charac
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val remoteSource: RemoteSource
) : ViewModel() {

    private val _characterList = MutableStateFlow<List<Charac>>(emptyList())
    val characterList: StateFlow<List<Charac>> get() = _characterList

    init {

        viewModelScope.launch {
            try {
                val list = remoteSource
                    .getAllCharacters()
                    .results
                    .map { item -> item.toCharac() }
                _characterList.value = list
            } catch (err: Error) {

            }
        }
    }
}