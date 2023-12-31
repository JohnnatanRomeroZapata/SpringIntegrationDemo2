package com.example.SpringIntegrationDemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.dsl.IntegrationFlow;

@Configuration
public class InboundFlowConfig {
                
    @Bean
    public IntegrationFlow messageInFlow(@Autowired Converter converter){
        
        return IntegrationFlow
                .from("channelMessageIn")
                .transform(message -> converter.toUpperCase(message.toString()))
                .channel("channelMessageOut")
                .get();
    }

    @Bean
    public IntegrationFlow studentInFlow(@Autowired Converter converter){

        return IntegrationFlow
                .from("channelStudentIn")
                .transform((GenericTransformer<Object, Object>) source -> {
                    
                    var studentSource = (Student) source;
                    
                    Student studentTransformed = new Student();
                    studentTransformed.setFirstName(studentSource.getFirstName().toUpperCase());
                    studentTransformed.setLastName(studentSource.getLastName());
                    
                    return studentTransformed;
                })
                .channel("channelStudentOut")
                .get();
    }
    
}
