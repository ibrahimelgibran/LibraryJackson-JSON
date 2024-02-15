package iegcode.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JavaBeanTest {

    @Test
    void createJavaFromObject() throws JsonProcessingException {
        Person person = new Person();
        person.setId("1");
        person.setName("Gibran");
        person.setHobbies(List.of("Coding", "Reading"));

        Address address = new Address();
        address.setStreet("Jl. Monjali Nandan");
        address.setCity("Sleman");
        address.setCountry("Indonesia");
        person.setAddress(address);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);

        System.out.println(json );
    }

    @Test
    void readObjectFromJson () throws JsonProcessingException {
        String json = """
                {
                  "id": "1",
                  "name": "Gibran",
                  "hobbies": [
                    "Coding",
                    "Reading"
                  ],
                  "address": {
                    "street": "Jl. Monjali Nandan",
                    "city": "Sleman",
                    "country": "Indonesia"
                  }
                }
                """;

        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(json, Person.class);

        Assertions.assertEquals("1", person.getId());
        Assertions.assertEquals("Gibran", person.getName());
        Assertions.assertEquals("Jl. Monjali Nandan", person.getAddress().getStreet());
        Assertions.assertEquals("Sleman", person.getAddress().getCity());
        Assertions.assertEquals("Indonesia", person.getAddress().getCountry());
    }
}
