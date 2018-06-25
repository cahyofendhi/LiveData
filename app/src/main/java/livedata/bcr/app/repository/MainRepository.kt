package livedata.bcr.app.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import livedata.bcr.app.model.User

class MainRepository {

    fun loadUser(name: String): LiveData<User>{
        val user = MutableLiveData<User>()
        user.value = User(if (name.isEmpty()) "Test Name" else name)
        return user
    }

}