package org.charly.consumerservice.service.consumer;

import lombok.extern.slf4j.Slf4j;
import org.charly.consumerservice.domain.FoodOrder;
import org.charly.consumerservice.domain.dto.FoodOrderDto;
import org.charly.consumerservice.service.FoodOrderService;
import org.charly.consumerservice.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FoodOrderConsumer implements Consumer {

    private static final String foodOrderTopic = "${topic.name.foodOrder}";

    private final MapperUtil mapperUtil;
    private final FoodOrderService foodOrderService;

    @Autowired
    public FoodOrderConsumer(MapperUtil mapperUtil, FoodOrderService foodOrderService) {
        this.mapperUtil = mapperUtil;
        this.foodOrderService = foodOrderService;
    }

    @KafkaListener(topics = foodOrderTopic)
    public void consumeMessage(String message) {
        try {
            log.info("message consumed {}", message);
            FoodOrder foodOrder = mapperUtil.deserializeAndMap(message, FoodOrderDto.class, FoodOrder.class);
            foodOrderService.persistFoodOrder(foodOrder);
        } catch (Exception e) {
            log.error("Failed to process message", e);
        }
    }
}
