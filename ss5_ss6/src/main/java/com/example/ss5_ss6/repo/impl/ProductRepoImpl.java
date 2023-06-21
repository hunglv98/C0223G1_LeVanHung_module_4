package com.example.ss5_ss6.repo.impl;

import com.example.ss5_ss6.ConnectUtils;
import com.example.ss5_ss6.model.Product;
import com.example.ss5_ss6.repo.IProductRepo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepoImpl implements IProductRepo {

    private static final String SELECT_ALL_PRODUCT = "from Product";

    @Override
    public void addProduct(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public void editProduct(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Product product1 = findById(product.getId());
            product1.setName(product.getName());
            product1.setDescription(product.getDescription());
            product1.setPrice(product.getPrice());
            product1.setManufacturer(product.getManufacturer());
            session.update(product);
            transaction.commit();
            ConnectUtils.getEntityManager().clear();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectUtils.getSessionFactory().openSession();
            transaction = session.getTransaction();
            transaction.begin();
            Product product = findById(id);
            session.remove(product);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findByName(String name) {
        Session session = ConnectUtils.getSessionFactory().openSession();
        TypedQuery<Product> query = session.createQuery("from Product where name like concat('%',:name,'%') ");
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<Product> getList() {
        return ConnectUtils.getEntityManager().createQuery(SELECT_ALL_PRODUCT).getResultList();
    }

    @Override
    public Product findById(int id) {
        Session session = ConnectUtils.getSessionFactory().openSession();
        TypedQuery<Product> query = session.createQuery("from Product where id=:id");
        query.setParameter("id", id);
        for (Product p : query.getResultList()) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
