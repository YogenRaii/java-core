package com.eprogrammerz.examples.testing.schedulerService;

/**
 * Created by 542596 on 3/3/2017.
 */
public class ScheduleService {
    private CurrentDayService currentDayService;

    public ScheduleService(CurrentDayService currentDayService) {
        this.currentDayService = currentDayService;
    }

    public Schedule getTodaySchedule() {
        int day = currentDayService.getCurrentDay();
        return lookupAccordingToDay(day);
    }

    private Schedule lookupAccordingToDay(int day) {
        return new Schedule("Schedule for day: " + day);
    }
}
