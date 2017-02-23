package com.example.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.log4j.Logger;
import java.lang.invoke.MethodHandles;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


public class Handler implements RequestHandler<Map<String, Object>, Map<String, String>> {
    static final Logger log = Logger.getLogger(Handler.class);

    public Handler() {
        log.info("Calling constructor for:" + MethodHandles.lookup().lookupClass().getCanonicalName());
    }

    @Override
    public Map<String, String> handleRequest(Map<String, Object> input, Context context) {
        log.info("handleRequest method was invoked with input: " + input);
        Map<String, String> returnable = new HashMap<>();
        returnable.put("result", "hey, been trying to meet you! input:" + input);
        returnable.put("time", LocalDateTime.now().toString());
        return returnable;
    }

}
