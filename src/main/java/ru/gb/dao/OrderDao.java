package ru.gb.dao;

import ru.gb.entity.Order;

import java.util.Collection;

public interface OrderDao {
    Iterable<Order> findAll();
    Order findById();
    Order save(Order order);
    void deleteAll(Collection<Order> orders);
}
