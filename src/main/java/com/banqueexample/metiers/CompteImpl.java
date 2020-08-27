package com.banqueexample.metiers;

import com.banqueexample.Dao.CompteRepository;
import com.banqueexample.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class CompteImpl implements CompteMetier {

    @Autowired
    private CompteRepository compteRepository;

    @Override
    public Compte saveCompte(Compte cpt) {
        cpt.setDateCreation(new Date());
        return compteRepository.save(cpt);
    }

    @Override
    public Compte getCompte(String code) {
        return compteRepository.findOne(code);
    }
}
