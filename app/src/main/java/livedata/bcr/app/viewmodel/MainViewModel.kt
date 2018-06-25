package livedata.bcr.app.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import livedata.bcr.app.repository.MainRepository
import livedata.bcr.app.model.User


class MainViewModel: ViewModel() {

    var repository: MainRepository? = MainRepository()
    var notif: MutableLiveData<User>? = MutableLiveData()
    val name = ObservableField<String>()

    init {
        loadUser("")
    }

    fun setUserName(name: String) {
        loadUser(name)
        this.name.set("From Binding $name")
    }

    fun loadUser(name: String){
        notif?.value = repository?.loadUser(name)?.value
    }

}