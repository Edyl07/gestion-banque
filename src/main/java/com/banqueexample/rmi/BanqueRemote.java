package com.banqueexample.rmi;

import com.banqueexample.entities.Compte;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BanqueRemote extends Remote {

    public Compte saveCompte(Compte cpt) throws RemoteException;

    public Compte getCompte(String code) throws  RemoteException;

    public boolean verser(String code, double montant, Long codeEmp) throws RemoteException;

    public boolean retirer(String code, double montant, Long codeEmp) throws RemoteException;

    public  boolean virement(String cpt1, String cpt2, double montant, Long codeEmp) throws RemoteException;
}
