package ru.gb.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Order;

import java.util.Collection;

@Repository
@Transactional
public class JpaOrderDao implements OrderDao {
    @Override
    public Iterable<Order> findAll() {
        return null;
    }

    @Override
    public Order findById() {
        return null;
    }

    @Override
    public Order save(Order order) {
        return null;
    }

    @Override
    public void deleteAll(Collection<Order> orders) {

    }
}
