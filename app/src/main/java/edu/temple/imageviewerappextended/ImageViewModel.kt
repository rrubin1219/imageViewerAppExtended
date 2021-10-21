package edu.temple.imageviewerappextended

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ImageViewModel: ViewModel() {
    private val image = MutableLiveData<Int>()
    private val text = MutableLiveData<String>()

    fun getImage() : LiveData<Int>{
        return image
    }
    fun setImage(_image: Int){
        image.value = _image
    }

    fun getText() : LiveData<String>{
        return text
    }
    fun setText(_text: String){
        text.value = _text
    }
}