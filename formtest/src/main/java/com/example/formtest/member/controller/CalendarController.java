package com.example.formtest.member.controller;

import com.example.formtest.dto.Calendar;
import org.springframework.web.bind.annotation.GetMapping;
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
