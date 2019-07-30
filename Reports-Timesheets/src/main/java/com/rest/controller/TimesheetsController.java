package com.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
public class TimesheetsController {

    @GetMapping("/timesheet")
    public String submitTimesheet(){
        return "Timesheet Submitted";
    }
}
