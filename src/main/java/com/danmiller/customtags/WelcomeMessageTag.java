package com.danmiller.customtags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class WelcomeMessageTag extends SimpleTagSupport {

    private static final LocalTime MORNING = LocalTime.of(0, 0, 0);
    private static final LocalTime AFTER_NOON = LocalTime.of(12, 0, 0);
    private static final LocalTime EVENING = LocalTime.of(16, 0, 0);
    private static final LocalTime NIGHT = LocalTime.of(21, 0, 0);
    
    private static final LocalDate NEWYEARSDAY = LocalDate.of(2018,1,1);
    private static final LocalDate GROUNDHOGDAY = LocalDate.of(2018,2,2);
    private static final LocalDate VALENTINESDAY = LocalDate.of(2018,2,15);
    private static final LocalDate EASTER = LocalDate.of(2018,4,1);
    private static final LocalDate THANKSGIVING = LocalDate.of(2018,11,22);
    private static final LocalDate CHRISTMAS = LocalDate.of(2018,12,25);

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();

        getGreeting();
        getHoliday();

    }


    public void getGreeting() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        LocalTime now = LocalTime.now();

        if ((!now.isBefore(MORNING)) && (now.isBefore(AFTER_NOON))) {
            out.println("Good Morning");
        } else if ((!now.isBefore(AFTER_NOON)) && (now.isBefore(EVENING))) {
            out.println("Good Afternoon");
        } else if ((!now.isBefore(EVENING)) && (now.isBefore(NIGHT))) {
            out.println("Good Evening");
        } else {
            out.println("Good Night");
        }
    }

    public void getHoliday() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        LocalDate date = LocalDate.parse("2018-01-01",DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        if (date.equals(NEWYEARSDAY)) {
            out.println("Happy New Year");
        } else if (date.equals(GROUNDHOGDAY)) {
            out.println("Today is Ground Hogs Day");
        } else if (date.equals(VALENTINESDAY)) {
            out.println("Happy Valentines Day");
        } else if (date.equals(EASTER)) {
            out.println("Happy Easter");
        } else if (date.equals(THANKSGIVING)) {
            out.println("Happy Thanksgiving");
        } else if (date.equals(CHRISTMAS)) {
            out.println("Merry Christmas");
        } else {
            out.println(date);
        }
    }


}