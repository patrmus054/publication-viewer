package com.example.inzynieria.main.ui.main.home

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableList
import androidx.lifecycle.ViewModel
import androidx.work.impl.Schedulers
import com.example.inzynieria.main.data.Model
import com.example.inzynieria.main.data.local.room.MagazinesEntity
import com.example.inzynieria.main.data.repository.MagazineRepository
import com.example.inzynieria.main.ui.main.base.BaseViewModel
import com.example.inzynieria.main.utilities.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val magazineRepository: MagazineRepository): BaseViewModel() {
//    fun getMagazine() = quoteRepository.getMagazines()
//    fun addMagazine(magazine: Model.Magazines) = quoteRepository.addMagazine(magazine)

    val isRefreshing = ObservableBoolean(true)
    val items: ObservableList<MagazinesEntity> = ObservableArrayList()
    val onMagazinesOpenEvent = SingleLiveEvent<MagazinesEntity>()

    private var disposable: Disposable? = null

    override fun start() {
        getAllMagazines(false)
    }

    override fun stop() {
        disposable?.let { if(!it.isDisposed)it.dispose() }
    }

    fun refreshMagazines(){
        getAllMagazines(true)
    }

    fun openMagazine(magazine: MagazinesEntity){
        onMagazinesOpenEvent.value = magazine
    }

    private fun getAllMagazines(isRefresh: Boolean){
//        if(isRefresh) magazineRepository.refreshMagazines()
//
//        disposable = magazineRepository.getAllMagazines()
//            .subscribeOn(io.reactivex.schedulers.Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .doOnSubscribe{isRefreshing.set(true)}
//            .doAfterTerminate{isRefreshing.set(false)}
//            .subscribe({magazines ->
//                with(items) {
//                    clear()
//                    addAll(magazines)
//                }
//            },{ error -> error.printStackTrace()})
    }
}
