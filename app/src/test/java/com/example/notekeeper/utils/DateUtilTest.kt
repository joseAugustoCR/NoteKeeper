package com.example.notekeeper.utils

import com.example.notekeeper.utils.DateUtil.*
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInfo
import org.junit.jupiter.api.TestReporter
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.util.*

class DateUtilTest {

    val today = "02-2020"

    @Test
    internal fun getCurrentTimestamp() {
        assertDoesNotThrow{
            assertEquals(today, DateUtil.getCurrentTimeStamp())
        }
    }

    @ParameterizedTest
    @ValueSource(ints = intArrayOf(0, 1,  2, 3, 4, 5, 6, 7, 8, 9, 10, 11))
    internal fun testGetMonthFromNumber(monthNumber:Int, testInfo: TestInfo, testReporter: TestReporter){
        assertEquals(months[monthNumber], DateUtil.getMonthFromNumber(monthNumbers[monthNumber]))

    }

    @ParameterizedTest
    @ValueSource(ints = intArrayOf( 1,  2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12))
    internal fun testGetMonthFromNumberError(monthNumber:Int, testInfo: TestInfo, testReporter: TestReporter){
       val randomInt = Random().nextInt(90) +13
        assertEquals(getMonthFromNumber((monthNumber * randomInt).toString()), GET_MONTH_ERROR)
    }
}