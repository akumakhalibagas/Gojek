package com.makhalibagas.gojek.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.makhalibagas.gojek.R

class HomeViewModel : ViewModel() {

    private val content : MutableLiveData<List<String>> = MutableLiveData()
    private val image : MutableLiveData<List<Int>> = MutableLiveData()
    private val gocar : MutableLiveData<List<Int>> = MutableLiveData()
    private val goride : MutableLiveData<List<Int>> = MutableLiveData()
    private val gofood : MutableLiveData<List<Int>> = MutableLiveData()

    fun setContent() = content.postValue(listContent())
    fun getContent() : LiveData<List<String>> = content

    fun setImage() = image.postValue(listImage())
    fun getImage() : LiveData<List<Int>> = image

    fun setGocar() = gocar.postValue(listGocar())
    fun getGocar() : LiveData<List<Int>> = gocar

    fun setGoride() = goride.postValue(listGoride())
    fun getGoride() : LiveData<List<Int>> = goride

    fun setGofood() = gofood.postValue(listGofood())
    fun getGofood() : LiveData<List<Int>> = gofood

    fun listContent()  = listOf(
            "Apa saja",
            "COVID-29",
            "Hiburan",
            "Makanan",
            "J3L",
            "Gaya Hidup",
            "Pembayaran",
            "Promo",
            "Belanja",
            "Berita"
    )
    fun listImage() = listOf(
            R.drawable.img1,
            R.drawable.img2
    )
    fun listGocar() = listOf(
        R.drawable.gocar1,
        R.drawable.gocar2,
        R.drawable.gocar3,
        R.drawable.gocar4
    )
    fun listGoride() = listOf(
        R.drawable.goride1,
        R.drawable.goride2
    )
    fun listGofood() = listOf(
        R.drawable.gofood,
        R.drawable.gofood,
        R.drawable.gofood
    )
}

