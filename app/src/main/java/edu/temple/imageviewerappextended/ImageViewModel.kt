package edu.temple.imageviewerappextended

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ImageViewModel: ViewModel() {
    private var image = MutableLiveData<Int>()

    fun getImage() : LiveData<Int>{
        return image
    }
    fun setImage(_image: Int){
        image.value = _image
    }
}