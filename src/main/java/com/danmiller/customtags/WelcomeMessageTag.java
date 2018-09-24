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
    
    private static final LocalDate GROUNDHOGDAY = LocalDate.of(2018,2,2);

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();

        getGreeting();
        out.println("\r\n");
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
        //LocalDate currentDate = LocalDate.now();
        LocalDate date = LocalDate.parse("2018-02-02",DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        if (date.equals(GROUNDHOGDAY)) {
            out.println("Today is Ground Hogs Day");
        } else {
            out.println(date);
        }
    }


}