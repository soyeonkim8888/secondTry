package com.example.secondTry.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemNames,  int itemPrice);
}
