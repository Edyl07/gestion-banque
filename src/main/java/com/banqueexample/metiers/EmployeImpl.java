package com.banqueexample.metiers;

import com.banqueexample.Dao.EmployeRepository;
import com.banqueexample.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeImpl implements EmployeMetier {

    @Autowired
    private EmployeRepository employeRepository;
    @Override
    public Employe saveEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public List<Employe> listEmploye() {
        return employeRepository.findAll();
    }
}
