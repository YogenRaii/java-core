package com.eprogrammerz.examples.testing.junitCalender;

import lombok.Setter;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by 542596 on 3/1/2017.
 */
@Setter
public class DateManipulator implements Serializable {
    private Calendar calendar;

    public DateManipulator() {
        this.calendar = Calendar.getInstance();
    }

    public Schedule getTodaySchedule() {
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        return lookupAccordingToDay(day);
    }

    private Schedule lookupAccordingToDay(int day) {
        return new Schedule("Schedule for day: " + day);
    }
}
