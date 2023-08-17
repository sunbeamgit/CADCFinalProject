package com.app.controller;

import com.app.pojos.Agency;
import com.app.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/agency")
public class AgencyController {
    @Autowired 
    private AgencyService agencyService;

    public AgencyController() {
        // Print a message to the console when an instance of the controller is created
        System.out.println("in ctor of " + getClass());
    }

    // Endpoint for adding agency details using POST method
    @PostMapping("/register")
    public String addAgencyDetails(@RequestBody Agency agency) {
        System.out.println("in add new agency " + agency);
        
        // Call the service to add agency details
        String status = agencyService.addAgencyDetails(agency);
        
        return status;
    }
}
