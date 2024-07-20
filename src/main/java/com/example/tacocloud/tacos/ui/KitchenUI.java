package com.example.tacocloud.tacos.ui;

import com.example.tacocloud.tacos.model.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KitchenUI {

    public void displayOrder(TacoOrder order) {

        log.info("Полученный заказ: {}", order.toString());
    }
}
