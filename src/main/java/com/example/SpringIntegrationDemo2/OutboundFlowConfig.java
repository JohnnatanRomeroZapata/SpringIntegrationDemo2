package com.example.SpringIntegrationDemo2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.dsl.IntegrationFlow;

@Configuration
public class OutboundFlowConfig {
    
    @Bean
    public IntegrationFlow messageOutFlow(){
        
        return IntegrationFlow
                .from("channelMessageOut")
                .transform(message -> message.toString() + " other execution")
                .get();
    }

    @Bean
    public IntegrationFlow studentOutFlow(){

        return IntegrationFlow
                .from("channelStudentOut")
                .transform((GenericTransformer<Object, Object>) source -> {
                    
                    var studentSource = (Student) source;

                    Student studentTransformed = new Student();
                    studentTransformed.setFirstName(studentSource.getFirstName());
                    studentTransformed.setLastName(studentSource.getLastName().toUpperCase());

                    return studentTransformed;
                })
                .get();
    }
}
