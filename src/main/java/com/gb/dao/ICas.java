package com.gb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gb.entities.Cas;
@Repository
public interface ICas  extends JpaRepository<Cas, Integer>{

}
