package com.example.daggerhilttuto

import androidx.lifecycle.ViewModel
import com.example.daggerhilttuto.domain.repo.MyRepo
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(      // This tells dagger to inject all dependencies [mentioned in this constructor && can be provided through DI module]
    private val repository: Lazy<MyRepo>    // Lazy injection
): ViewModel() {

    init {
        repository.get()
    }
}