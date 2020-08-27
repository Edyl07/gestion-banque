package com.banqueexample.metiers;

import com.banqueexample.entities.Employe;

import java.util.List;

public interface EmployeMetier {
    
    public Employe saveEmploye(Employe employe);
    
    public List<Employe> listEmploye();
}
