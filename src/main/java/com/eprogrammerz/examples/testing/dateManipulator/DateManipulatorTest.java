package com.eprogrammerz.examples.testing.dateManipulator;

/**
 * @author Yogen Rai
 */

import com.eprogrammerz.examples.testing.schedulerService.Schedule;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Calendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by 542596 on 3/1/2017.
 *
 * TDD -> high code coverage and fast feedback
 * BDD -> automated acceptance test
 * Combine -> when[ACTION]then[IMPL]
 */
@RunWith(MockitoJUnitRunner.class)
public class DateManipulatorTest {

    private DateManipulator classUnderTest;

    @Before
    public void setUp() throws Exception {
        classUnderTest = new DateManipulator();
    }

    @After
    public void tearDown() throws Exception {
        classUnderTest = null;
    }

    @Test
    public void whenGetTodayScheduleThenReturnScheduleOfToday() throws Exception {
        Calendar calendar = Mockito.mock(Calendar.class);
        classUnderTest.setCalendar(calendar);
        Mockito.when(calendar.get(Calendar.DAY_OF_WEEK)).thenReturn(3);
        Schedule todaySchedule = classUnderTest.getTodaySchedule();
        assertThat("Schedule is string", todaySchedule.getDescription(), equalTo("Schedule for day: 3"));
    }
}