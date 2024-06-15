package com.example.tacocloud.tacos.data;

import com.example.tacocloud.tacos.model.TacoOrder;

/**
 *
 * @author marat
 */
public interface OrderRepository {

    TacoOrder save(TacoOrder order);
}
