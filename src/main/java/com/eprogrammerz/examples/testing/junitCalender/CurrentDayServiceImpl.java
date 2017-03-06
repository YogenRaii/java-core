package com.eprogrammerz.examples.testing.junitCalender;

import java.util.Calendar;

/**
 * Created by 542596 on 3/3/2017.
 */
public class CurrentDayServiceImpl implements CurrentDayService {
    @Override
    public int getCurrentDay() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.WEEK_OF_MONTH);
    }
}
