package com.example.user.datetimepickers

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.text.format.DateFormat
import android.widget.TimePicker
import java.util.*

/**
 * A simple [Fragment] subclass for a time picker.
 * Sets the current time for the picker using Calendar.
 */
class TimePickerFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    /**
     * Creates the time picker dialog with the current time from Calendar.
     * @param savedInstanceState    Saved instance
     * @return TimePickerDialog     The time picker dialog
     */
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Use the current time as the default values for the picker.
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)

        // Create a new instance of TimePickerDialog and return it.
        return TimePickerDialog(activity, this, hour, minute,
                DateFormat.is24HourFormat(activity))
    }

    /**
     * Grabs the time and converts it to a string to pass
     * to the Main Activity in order to show it with processTimePickerResult().
     * @param view          The time picker view
     * @param hourOfDay     The hour chosen
     * @param minute        The minute chosen
     */
    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        // Set the activity to the Main Activity.
        val activity = activity as MainActivity?
        // Invoke Main Activity's processTimePickerResult() method.
        activity!!.processTimePickerResult(hourOfDay, minute)
    }
}