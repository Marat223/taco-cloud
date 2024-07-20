package com.example.tacocloud.tacos.messaging;

import com.example.tacocloud.tacos.model.TacoOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaOrderMessagingService implements OrderMessagingService {

    @Autowired
    private KafkaTemplate<String, TacoOrder> kafkaTemplate;

    @Override
    public void sendOrder(TacoOrder order){

        kafkaTemplate.send("tacocloud.orders.topic", order);
    }
}
