package com.example.tacocloud.tacos.messaging;

import com.example.tacocloud.tacos.model.TacoOrder;

public interface OrderMessagingService {
    void sendOrder(TacoOrder order);
}
