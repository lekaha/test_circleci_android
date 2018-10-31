package com.testcircleci.lekaha

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.not
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

const val GREETING = "Hello World"

@RunWith(MockitoJUnitRunner.Silent::class)
class HelloWorldTest {

    lateinit var helloWorld: HelloWorldViewModel

    @Mock
    lateinit var helloWorldDto: HelloWorldDto

    @Before
    fun setup() {
        helloWorld = HelloWorldViewModel(HelloWorldDto())
        `when`(helloWorldDto.getGreeting()).thenReturn(GREETING)
        helloWorld.get()
    }

    @Test
    fun greeting_isCorrect() {
        assertThat(helloWorld.greeting.get(), `is`(GREETING))
    }

    @Test
    fun greeting_isNotCorrect() {
        assertThat(helloWorld.greeting.get(), `not`("Hi"))
    }
}
