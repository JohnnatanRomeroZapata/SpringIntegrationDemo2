package com.example.SpringIntegrationDemo2;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface IntegrationGateway {
    
    @Gateway(requestChannel = "channelMessageIn")
    public String sendMessage(String name);
    
    @Gateway(requestChannel = "channelStudentIn")
    public Student sendStudent(Student student);
}
