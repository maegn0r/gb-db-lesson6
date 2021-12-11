package ru.gb.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.dao.ProductDao;
import ru.gb.entity.Product;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {
    private final ProductDao productDao;

    public long count(){
        return productDao.count();
    }

    public Product save(Product product) {
        return productDao.save(product);
    }

    @Transactional(readOnly = true)
    public Product findById (Long id){
        return productDao.findById(id).get();
    }
}
