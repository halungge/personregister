package ch.mlz.preg.model.events;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

public class PersonEventSerializer {

    private ObjectMapper mapper;
    private JsonParser parser;



    public PersonEventSerializer() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);



    }

    public String serialize(PersonEvent event) throws JsonProcessingException {
        return mapper.writeValueAsString(event);
    }

    public PersonEvent parseFromString(String nameChangeAsJson) throws IOException {
        return mapper.readValue(nameChangeAsJson, NameChanged.class);
    }
}
