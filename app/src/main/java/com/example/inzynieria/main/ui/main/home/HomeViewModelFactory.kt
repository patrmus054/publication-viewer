package com.example.inzynieria.main.ui.main.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.inzynieria.main.data.repository.MagazineRepository

class HomeViewModelFactory(private val quoteRepository: MagazineRepository):ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(quoteRepository) as T
    }
}