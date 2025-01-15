package org.example.dao.impl;

import jakarta.persistence.EntityManager;
import org.example.config.HibernateConfig;
import org.example.dao.SoldierDao;
import org.example.entities.Captain;
import org.example.entities.Soldier;
import org.hibernate.HibernateException;

import java.util.List;

public class SoldierDaoImpl implements SoldierDao {

    @Override
    public boolean deleteSoldierNotAffectingCaptainTable(Long id) {
        try (EntityManager entityManager = HibernateConfig.entityManagerFactory().createEntityManager()) {
            entityManager.getTransaction().begin();
            Soldier soldier = entityManager.find(Soldier.class, id);

            Long theSoldiersCaptainId = soldier.getCaptain().getId();

            Captain captain = entityManager.find(Captain.class, theSoldiersCaptainId);

            List<Soldier> newSoldierListforTheCaptainToMerge = captain.getSoldiers();

            newSoldierListforTheCaptainToMerge.remove(soldier);

            captain.setSoldiers(newSoldierListforTheCaptainToMerge);

            entityManager.merge(captain);

            entityManager.remove(soldier);

            entityManager.getTransaction().commit();

            return true;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}