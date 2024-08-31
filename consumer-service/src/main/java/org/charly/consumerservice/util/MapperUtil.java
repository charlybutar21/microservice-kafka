package org.charly.consumerservice.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MapperUtil {
    private final ObjectMapper objectMapper;
    private final ModelMapper modelMapper;

    /**
     * Generic method to deserialize a JSON string into an object of type Source,
     * and then map it to an object of type Target.
     *
     * @param message       The JSON string to deserialize.
     * @param sourceClass   The class type of the source object.
     * @param targetClass   The class type of the target object.
     * @param <Source>      The source type parameter.
     * @param <Target>      The target type parameter.
     * @return              The mapped object of target type.
     * @throws JsonProcessingException If deserialization fails.
     */
    public <Source, Target> Target deserializeAndMap(String message, Class<Source> sourceClass, Class<Target> targetClass) throws JsonProcessingException {
        // Deserialize JSON to Source type object
        Source sourceObject = objectMapper.readValue(message, sourceClass);
        // Map Source object to Target type object
        return modelMapper.map(sourceObject, targetClass);
    }
}
