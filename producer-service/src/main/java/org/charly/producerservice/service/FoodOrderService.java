package org.charly.producerservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.charly.producerservice.domain.FoodOrder;
import org.charly.producerservice.service.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FoodOrderService {

    @Value("${topic.name.foodOrder}")
    private String foodOrderTopic;

    private final ObjectMapper objectMapper;
    private final Producer producer;

    @Autowired
    public FoodOrderService(ObjectMapper objectMapper, Producer producer) {
        this.objectMapper = objectMapper;
        this.producer = producer;
    }

    public String createFoodOrder(FoodOrder foodOrder) throws JsonProcessingException {
        String orderAsMessage = objectMapper.writeValueAsString(foodOrder);
        return producer.sendMessage(foodOrderTopic, orderAsMessage);
    }
}
