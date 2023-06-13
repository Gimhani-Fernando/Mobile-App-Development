package com.gimhani.android.driver2

import com.gimhani.android.driver2.services.HelloMessageService
import org.junit.Assert.assertEquals
import org.junit.Test

class HelloMessageServiceTests {
    @Test
    fun it_should_return_error_empty_name(){
        val service = HelloMessageService()
        val message = service.compose("","23")
        assertEquals("Name should not be empty!", message)
    }

    @Test
    fun it_should_return_error_empty_age(){
        val service = HelloMessageService()
        val message = service.compose("Gimci","")
        assertEquals("Age should not be empty!", message)
    }

    @Test
    fun it_should_return_correct_message_with_values(){
        val service = HelloMessageService()
        val message = service.compose("Gimci","23")
        assertEquals("Hello Gimci. You are 23 years old.", message)
    }
}