package com.gimhani.android.driver2

import com.gimhani.android.driver2.services.Calculate
import org.junit.Assert.assertEquals
import org.junit.Test

class CalculateTest {
    @Test
    fun it_should_add_2_and_2_and_return_4(){
        val calculate = Calculate()
        var result = calculate.add(2,2)
        assertEquals(4,result)
    }

    @Test
    fun it_should_add_minus2_and_2_and_return_0(){
        val calculate = Calculate()
        var result = calculate.add(-2,2)
        assertEquals(0,result)
    }
}