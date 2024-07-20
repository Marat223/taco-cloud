package com.example.tacocloud.tacos.messaging;

import com.example.tacocloud.tacos.model.TacoOrder;
import com.example.tacocloud.tacos.ui.KitchenUI;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderListener {
    @Autowired
    private KitchenUI ui;

    @KafkaListener(topics = "tacocloud.orders.topic", containerFactory = "listenerFactory")
    public void handle(TacoOrder order, ConsumerRecord<String, TacoOrder> record) {
        log.info("Получено из раздела: {}, смещение: {}, время: {}.", record.partition(), record.offset(), record.timestamp());
        ui.displayOrder(order);
    }
}
