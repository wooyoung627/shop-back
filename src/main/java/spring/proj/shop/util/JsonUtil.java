package spring.proj.shop.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JsonUtil {

    public static <T> String toJson(T object) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(object);
    }

}
