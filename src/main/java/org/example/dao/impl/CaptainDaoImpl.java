package org.example.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.config.HibernateConfig;
import org.example.dao.CaptainDao;
import org.example.entities.Captain;
import org.hibernate.HibernateException;

public class CaptainDaoImpl implements CaptainDao {
    @Override
    public void save(Captain captain) {
        try(EntityManager entityManager  = HibernateConfig.entityManagerFactory().createEntityManager()){
            entityManager.getTransaction().begin();
            entityManager.persist(captain);
            entityManager.getTransaction().commit();
        }catch (HibernateException h){
            System.out.println(h.getMessage());
        }
    }
}
