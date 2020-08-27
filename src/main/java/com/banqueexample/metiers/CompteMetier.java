package com.banqueexample.metiers;

import com.banqueexample.entities.Compte;

public interface CompteMetier {

    public Compte saveCompte(Compte cpt);

    public Compte getCompte(String code);
}
