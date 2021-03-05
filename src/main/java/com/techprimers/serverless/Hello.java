package com.techprimers.serverless;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class Hello implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Hello.class);
	
    @Override
    public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent input) {
        APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
        LOGGER.info("Input :" +input.getBody());
        responseEvent.setStatusCode(200);
        responseEvent.setBody("Hello! Reached the Spring Cloud Function with message: " + input.getBody());
        return responseEvent;
    }
}
