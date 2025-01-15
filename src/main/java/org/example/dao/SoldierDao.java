package org.example.dao;

import org.example.entities.Soldier;

public interface SoldierDao {
    public boolean deleteSoldierNotAffectingCaptainTable(Long id);
}
