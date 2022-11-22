package com.example.calender.calendar.controller;

import com.example.calender.dto.Calendar;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CalendarController {

    private ArrayList<Calendar> calendarList = new ArrayList<>();

    @GetMapping("/all/schedule")
    public ArrayList<Calendar> allSchedule(){
        return calendarList;
    }

    @GetMapping("/put/schedule")
    public ArrayList<Calendar> putSchedule(Calendar calendar){
        if ( calendarList.contains(calendar)){
            return calendarList;
        }
        calendarList.add(calendar);
        return calendarList;
    }

}
