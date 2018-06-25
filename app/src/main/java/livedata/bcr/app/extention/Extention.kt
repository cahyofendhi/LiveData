package livedata.bcr.app.extention

import android.app.Activity
import android.content.Context
import android.widget.Toast

fun Activity.toast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}