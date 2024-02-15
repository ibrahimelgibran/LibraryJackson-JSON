package iegcode.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class JsonObjectTest {
    @Test
    void createJson() throws JsonProcessingException {
        Map<String, Object> person = Map.of(
                "firstName", "Ibrahim",
                "lastName", "ElGibran",
                "age", 19,
                "marrried", false,
                "address", Map.of(
                        "street", "Jl. Monjali",
                        "city", "Sleman",
                        "country", "Indonesia"
                )
        );

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);

        System.out.println(json);
    }

    @Test
    void readJson() throws JsonProcessingException {
        String json = """
                {
                  "marrried": false,
                  "age": 19,
                  "lastName": "ElGibran",
                  "firstName": "Ibrahim",
                  "address": {
                    "street": "Jl. Monjali",
                    "country": "Indonesia",
                    "city": "Sleman"
                  }
                }
                """;

        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> person = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
        });

        Assertions.assertEquals("Ibrahim", person.get("firstName"));
        Assertions.assertEquals("ElGibran", person.get("lastName"));
    }
}
