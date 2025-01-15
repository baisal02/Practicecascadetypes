package org.example;

import org.example.config.HibernateConfig;
import org.example.dao.CaptainDao;
import org.example.dao.SoldierDao;
import org.example.dao.impl.CaptainDaoImpl;
import org.example.dao.impl.SoldierDaoImpl;
import org.example.entities.Captain;
import org.example.entities.Soldier;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       /* HibernateConfig.entityManagerFactory();

        Captain captain = new Captain("Price");
        Soldier soldier = new Soldier("Soap");
        Soldier soldier1 = new Soldier("Gaz");
        Soldier soldier2 = new Soldier("Ghost");
        soldier1.setCaptain(captain);
        soldier2.setCaptain(captain);
        soldier.setCaptain(captain);
        List<Soldier> soldiers = Arrays.asList(soldier1, soldier2,soldier);
        captain.setSoldiers(soldiers); */
        CaptainDao captainDao = new CaptainDaoImpl();
        SoldierDao soldierDao = new SoldierDaoImpl();

        soldierDao.deleteSoldierNotAffectingCaptainTable(151L);

    }
}
