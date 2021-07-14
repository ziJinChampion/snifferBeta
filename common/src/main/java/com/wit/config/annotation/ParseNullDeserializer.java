package com.wit.config.annotation;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * @author Sonrisa
 * @ClassName ParseNullDeserializer
 * @Description TODO
 * @Date 2021/1/31 12:55
 */
public class ParseNullDeserializer extends JsonDeserializer<String> {

    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        if(jsonParser == null) {
            return null;
        }
        if("".equals(jsonParser.getText())) {
            return null;
        }
        return jsonParser.getText().trim();
    }
}
