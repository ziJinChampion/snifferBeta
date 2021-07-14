package com.wit.config.annotation;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * @author Sonrisa
 * @ClassName ParseNumDeserializer
 * @Description TODO
 * @Date 2021/2/2 10:44
 */
public class ParseNumDeserializer extends JsonDeserializer<Integer> {

    @Override
    public Integer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        if(jsonParser == null) {
            return null;
        }
        if(jsonParser.getValueAsInt() == 0) {
            return null;
        }
        return jsonParser.getValueAsInt();
    }
}
