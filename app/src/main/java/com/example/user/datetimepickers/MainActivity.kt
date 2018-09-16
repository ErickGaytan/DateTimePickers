package com.example.user.datetimepickers

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast

/**
 * This app shows the time and date pickers when you click the appropriate button.
 */
class MainActivity : AppCompatActivity() {

    /**
     * Creates the view based on the layout for the main activity.
     * @param savedInstanceState    Saved instance
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showDatePickerDialog(v: View) {
        val newFragment = DatePickerFragment()
        newFragment.show(supportFragmentManager, getString(R.string.date_picker))
    }

    fun showTimePickerDialog(view: View) {
        val newFragment = TimePickerFragment()
        newFragment.show(supportFragmentManager, getString(R.string.time_picker))
    }

    fun processDatePickerResult(year: Int, month: Int, day: Int) {
        // The month integer returned by the date picker starts counting at 0
        // for January, so you need to add 1 to show months starting at 1.
        val month_string = Integer.toString(month + 1)
        val day_string = Integer.toString(day)
        val year_string = Integer.toString(year)
        // Assign the concatenated strings to dateMessage.
        val dateMessage = "$month_string/$day_string/$year_string"
        Toast.makeText(this, getString(R.string.date) + dateMessage, Toast.LENGTH_SHORT).show()
    }

    fun processTimePickerResult(hourOfDay: Int, minute: Int) {
        // Convert time elements into strings.
        val hour_string = Integer.toString(hourOfDay)
        val minute_string = Integer.toString(minute)
        // Assign the concatenated strings to timeMessage.
        val timeMessage = hour_string + ":" + minute_string
        Toast.makeText(this, getString(R.string.time) + timeMessage, Toast.LENGTH_SHORT).show()
    }

}