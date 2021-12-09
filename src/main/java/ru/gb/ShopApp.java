package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.config.JpaConfig;
import ru.gb.dao.BuyerDao;
import ru.gb.dao.JpaBuyerDao;
import ru.gb.dao.OrderDao;
import ru.gb.dao.ProductDao;
import ru.gb.entity.Buyer;
import ru.gb.entity.Order;
import ru.gb.entity.Product;

import java.util.*;


public class ShopApp {



    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
        ProductDao productDao = context.getBean(ProductDao.class);
        BuyerDao buyerDao = context.getBean(BuyerDao.class);
        OrderDao orderDao = context.getBean(OrderDao.class);



        System.out.println(buyerDao.findAll());
        Buyer buyer1 = Buyer.builder().name("Buyer Name").build();
        buyerDao.save(buyer1);
        Product product1 = productDao.findById(13L);
        Product product2 = productDao.findById(14L);

        Product product3 = productDao.findById(15L);
        Product product4 = productDao.findById(16L);

        Order order1 = new Order();
        order1.setBuyer(buyer1);
        order1.addProduct(product1);
        order1.addProduct(product2);
        order1.setSum(order1.getOrderCost());

        orderDao.save(order1);


        Order order2 = new Order();
        order2.setBuyer(buyer1);
        order2.addProduct(product3);
        order2.addProduct(product4);
        order2.setSum(order2.getOrderCost());

        orderDao.save(order2);

        System.out.println(buyerDao.findById(buyerDao.findLast()).getOrders());
    }
}
