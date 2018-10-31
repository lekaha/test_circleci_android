package com.testcircleci.lekaha

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.testcircleci.lekaha.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val helloWorld by lazy { HelloWorldViewModel(HelloWorldDto()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            helloWorld = this@MainActivity.helloWorld
            setLifecycleOwner(this@MainActivity)
        }

        btnGreeting.setOnClickListener {
            helloWorld.get()
        }
    }
}
