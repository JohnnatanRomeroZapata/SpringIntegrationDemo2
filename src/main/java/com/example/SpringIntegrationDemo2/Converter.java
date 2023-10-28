package com.example.SpringIntegrationDemo2;

import org.springframework.stereotype.Service;

@Service

public class Converter {
    
    public String toUpperCase(String message){
        return message.toUpperCase();
    }
}
