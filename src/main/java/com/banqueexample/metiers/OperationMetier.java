package com.banqueexample.metiers;

import com.banqueexample.entities.Operation;

import java.util.List;

public interface OperationMetier {

    public boolean verser(String code, double montant, Long codeEmp);

    public boolean retirer(String code, double montant, Long codeEmp);

    public  boolean virement(String cpt1, String cpt2, double montant, Long codeEmp);

    public List<Operation> listOperation();

}
