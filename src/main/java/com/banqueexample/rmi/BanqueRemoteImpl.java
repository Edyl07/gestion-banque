package com.banqueexample.rmi;

import com.banqueexample.entities.Compte;
import com.banqueexample.metiers.CompteMetier;
import com.banqueexample.metiers.OperationMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.rmi.RemoteException;

@Component("RMI-Service")
public class BanqueRemoteImpl implements BanqueRemote {

    @Autowired
    private CompteMetier compteMetier;

    @Autowired
    private OperationMetier operationMetier;

    @Override
    public Compte saveCompte(Compte cpt) throws RemoteException {
        return compteMetier.saveCompte(cpt);
    }

    @Override
    public Compte getCompte(String code) throws RemoteException {
        return getCompte(code);
    }

    @Override
    public boolean verser(String code, double montant, Long codeEmp) throws RemoteException {
        return operationMetier.verser(code, montant, codeEmp);
    }

    @Override
    public boolean retirer(String code, double montant, Long codeEmp) throws RemoteException {
        return operationMetier.retirer(code, montant, codeEmp);
    }

    @Override
    public boolean virement(String cpt1, String cpt2, double montant, Long codeEmp) throws RemoteException {
        return operationMetier.virement(cpt1, cpt2, montant, codeEmp);
    }
}
