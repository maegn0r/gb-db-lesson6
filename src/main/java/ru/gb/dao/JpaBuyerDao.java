package ru.gb.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Buyer;

@Repository
@Transactional
public class JpaBuyerDao implements BuyerDao {
    @Override
    public Iterable<Buyer> findAll() {
        return null;
    }

    @Override
    public Buyer findById(Long id) {
        return null;
    }

    @Override
    public String findNameById(Long id) {
        return null;
    }

    @Override
    public Buyer save(Buyer buyer) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(Buyer buyer) {

    }
}
