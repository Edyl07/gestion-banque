package com.banqueexample.services;

import com.banqueexample.entities.Compte;
import com.banqueexample.metiers.CompteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompteRestService {

    @Autowired
    private CompteMetier compteMetier;

    @RequestMapping(value = "/comptes", method = RequestMethod.POST)
    public Compte saveCompte(@RequestBody Compte cpt) {
        return compteMetier.saveCompte(cpt);
    }

    @RequestMapping(value = "/comptes/{code}", method = RequestMethod.GET)
    public Compte getCompte(@PathVariable String code) {
        return compteMetier.getCompte(code);
    }
}
