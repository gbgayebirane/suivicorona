package com.gb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gb.entities.CasConfirme;
@Repository
public interface ICasConfirme extends JpaRepository<CasConfirme, Integer> {

}
