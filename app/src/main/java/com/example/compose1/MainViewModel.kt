package com.example.compose1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val textFieldState= MutableLiveData<String>("")

    fun onTextFieldChange(newValue:String){
        textFieldState.value = newValue
    }
}