package com.testcircleci.lekaha

import android.databinding.ObservableField

class HelloWorldViewModel(val dto: HelloWorldDto) {
    val greeting = ObservableField<String>()

    fun get() {
        greeting.set(dto.getGreeting())
    }
}