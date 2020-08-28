package com.banqueexample.Dao;

import com.banqueexample.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OperationRepository extends JpaRepository<Operation, Long> {

    @Query("SELECT o FROM Operation o WHERE o.compte.codeCompte=:x")
    public Page<Operation> getOperations(@Param("x") String code, Pageable pageable);
}
