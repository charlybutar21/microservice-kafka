package org.charly.consumerservice.repository;

import org.charly.consumerservice.domain.FoodOrder;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {
}
