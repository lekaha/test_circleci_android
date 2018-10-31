package com.testcircleci.lekaha

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class HelloWorldInstrumentedTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    val helloWorldDto = HelloWorldDto()

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.testcircleci.lekaha", appContext.packageName)
    }

    @Test
    fun test_click_button() {
        onView(withId(R.id.btnGreeting)).perform(click())
        onView(withId(R.id.txtGreeting)).check(matches(withText(helloWorldDto.getGreeting())))
    }
}
