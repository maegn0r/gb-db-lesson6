package ru.gb.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
@Transactional
public class JpaOrderDao implements OrderDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Iterable<Order> findAll() {
        return entityManager.createQuery("select o from Order o").getResultList();
    }

    @Override
    public Order findById() {
        return null;
    }

    @Override
    public Order save(Order order) {
        if (order.getId() == null) {
            entityManager.persist(order);
        } else {
            entityManager.merge(order);
        }
        return order;
    }

    @Override
    public void deleteAll(Collection<Order> orders) {

    }
}
