package ru.gb.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Manufacturer;
import ru.gb.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Collection;

@RequiredArgsConstructor
@Repository
@Transactional
public class JpaProductDao implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Iterable<Product> findAll() {
        return entityManager.createQuery("select p from Product p").getResultList();
    }

    @Override
    public Product findById(long id) {
        Query query = entityManager.createQuery("select p from Product p where p.id = :id");
        query.setParameter("id", id);
        return (Product) query.getSingleResult();
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public void deleteAll(Collection<Product> products) {

    }
}
