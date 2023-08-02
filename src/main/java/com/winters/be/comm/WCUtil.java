package com.winters.be.comm;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WCUtil {
    static public String ConvertObjectToJson(Object object)  {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

//    static public <T> Class<T> ConvertJsonToObject(String str, Class<T> type){
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//
//            return mapper.readValue(str, type);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
}
