package com.banqueexample.Dao;

import com.banqueexample.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface ClientRepository extends JpaRepository<Client, Serializable> {
}
