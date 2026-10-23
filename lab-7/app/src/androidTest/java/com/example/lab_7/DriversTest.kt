package com.example.lab_7

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.v2.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DriversTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity
    @Test
    fun navigate_add_clear_drivers_and_return_home() {
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()

        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()


        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Verstappen")


        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()


        composeTestRule
            .onNodeWithText("Verstappen")
            .assertExists()


        composeTestRule
            .onNodeWithTag("clearDriversButton")
            .performClick()


        composeTestRule
            .onAllNodesWithText("Verstappen")
            .assertCountEquals(0)

        composeTestRule
            .onNodeWithTag("driversBackButton")
            .performClick()

        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }

}