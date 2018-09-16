package com.example.user.datetimepickers

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.widget.DatePicker
import java.util.*

/**
 * A simple [Fragment] subclass for the date picker.
 * Sets the current date for the picker using Calendar.
 */
class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

    /**
     * Creates the date picker dialog with the current date from Calendar.
     * @param savedInstanceState    Saved instance
     * @return DatePickerDialog     The date picker dialog
     */
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Use the current date as the default date in the picker.
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        // Create a new instance of DatePickerDialog and return it.
        return DatePickerDialog(activity!!, this, year, month, day)
    }

    /**
     * Grabs the date and passes it to processDatePickerResult().
     * @param view  The date picker view
     * @param year  The year chosen
     * @param month The month chosen
     * @param day   The day chosen
     */
    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
        // Convert the date elements to strings.
        // Set the activity to the Main Activity.
        val activity = activity as MainActivity?
        // Invoke Main Activity's processDatePickerResult() method.
        activity!!.processDatePickerResult(year, month, day)
    }

}