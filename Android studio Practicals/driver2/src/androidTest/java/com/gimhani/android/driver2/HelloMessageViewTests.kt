package com.gimhani.android.driver2

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.gimhani.android.driver2.ui.theme.SENG22243_MobileApplicationTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HelloMessageViewTests {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun before(){
        composeTestRule.setContent{
            SENG22243_MobileApplicationTheme {
                TwoGreetings()
            }
        }
    }

    @Test
    fun it_should_show_message_for_no_age(){
        composeTestRule.onNodeWithText("Add").performClick()
        composeTestRule.onNodeWithText("Age should not be empty!").assertIsDisplayed()

    }

    @Test
    fun it_should_show_message_for_no_name(){
        composeTestRule.onNodeWithText("Age").performTextInput("23")
        composeTestRule.onNodeWithText("Add").performClick()
        composeTestRule.onNodeWithText("Name should not be empty!").assertIsDisplayed()

    }


    @Test
    fun it_should_show_hello_message_for_name_and_age(){
        composeTestRule.onNodeWithText("Age").performTextInput("23")
        composeTestRule.onNodeWithText("Age").performTextInput("Gimci")
        composeTestRule.onNodeWithText("Add").performClick()
        composeTestRule.onNodeWithText("Hello Gimci. You are 23 years old.").assertIsDisplayed()

    }
}