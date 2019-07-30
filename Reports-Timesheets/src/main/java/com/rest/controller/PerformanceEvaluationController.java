package com.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
public class PerformanceEvaluationController {

    @GetMapping("/performanceEvalForm")
    public String submitPerformanceEvalForm(){
        return "Performance Evaluation Form Submitted";
    }
}
