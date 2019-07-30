package com.rest.controller;

import com.rest.email.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
public class ReportsController {

    @Autowired
    Email gmail;

    @GetMapping("/report")
    public String submitReport() throws Exception {
        gmail.sendEmail();
        return "Report Submitted";
    }
}
