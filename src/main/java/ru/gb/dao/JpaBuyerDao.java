package ru.gb.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Buyer;
import ru.gb.entity.Manufacturer;
import ru.gb.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Repository
@Transactional
public class JpaBuyerDao implements BuyerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Iterable<Buyer> findAll() {
        return entityManager.createQuery("select b from Buyer b").getResultList();
    }

    @Override
    public Buyer findById(Long id) {
        Query query = entityManager.createQuery("select b from Buyer b where b.id = :id");
        query.setParameter("id", id);
        return (Buyer) query.getSingleResult();
    }

    @Override
    public String findNameById(Long id) {
        return null;
    }

    @Override
    public Buyer save(Buyer buyer) {
        if (buyer.getId() == null) {
            entityManager.persist(buyer);
        } else {
            entityManager.merge(buyer);
        }
        return buyer;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(Buyer buyer) {

    }

    @Override
    public long findLast() {
        return (Long)entityManager.createQuery("select b.id from Buyer b order by b.id DESC").setMaxResults(1).getSingleResult();
    }
}
