package org.charly.consumerservice.service;

import lombok.extern.slf4j.Slf4j;
import org.charly.consumerservice.domain.FoodOrder;
import org.charly.consumerservice.repository.FoodOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FoodOrderService {

    private final FoodOrderRepository foodOrderRepository;

    @Autowired
    public FoodOrderService(FoodOrderRepository foodOrderRepository) {
        this.foodOrderRepository = foodOrderRepository;
    }

    public void persistFoodOrder(FoodOrder foodOrder) {
        FoodOrder persistedFoodOrder = foodOrderRepository.save(foodOrder);
        log.info("food order persisted {}", persistedFoodOrder);
    }
}
