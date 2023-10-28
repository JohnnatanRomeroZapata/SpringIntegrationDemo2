package com.example.SpringIntegrationDemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/integrate")
public class IntegrationController {
    
    @Autowired
    private IntegrationGateway integrationGateway;
    
    @GetMapping(value = "{name}")
    public String getMessageFromIntegrationService(@PathVariable("name") String name){
        return integrationGateway.sendMessage(name);
    }

    @PostMapping("/student")
    public Student getMessageFromIntegrationService(@RequestBody Student student){
        return integrationGateway.sendStudent(student);
    }
}
