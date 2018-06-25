package livedata.bcr.app.view

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import livedata.bcr.app.R
import livedata.bcr.app.databinding.ActivityMainBinding
import livedata.bcr.app.extention.toast
import livedata.bcr.app.model.User
import livedata.bcr.app.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val model = ViewModelProviders.of(this).get(MainViewModel::class.java)

        binding.lv   = model
        model.notif?.observe(this, Observer<User> {
            if (it != null) {
                binding.vm = it
            }
        })

        binding.btnSubmit.setOnClickListener({
            if (!binding.edtName.text.isNullOrEmpty()){
                model.setUserName(binding.edtName.text.toString())
            } else {
                toast("Field not be empty")
            }
        })
    }
}
