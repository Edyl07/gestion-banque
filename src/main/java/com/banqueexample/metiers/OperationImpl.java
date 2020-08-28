package com.banqueexample.metiers;

import com.banqueexample.Dao.CompteRepository;
import com.banqueexample.Dao.EmployeRepository;
import com.banqueexample.Dao.OperationRepository;
import com.banqueexample.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class OperationImpl implements OperationMetier {

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private EmployeRepository employeRepository;

    @Override
    @Transactional
    public boolean verser(String code, double montant, Long codeEmp) {
        Compte cpt = compteRepository.findOne(code);
        Employe emp = employeRepository.findOne(codeEmp);
        Operation o = new Versement();
        o.setDateOperation(new Date());
        o.setMontant(montant);
        o.setCompte(cpt);
        o.setEmploye(emp);
        operationRepository.save(o);
        cpt.setSolde(cpt.getSolde() + montant);
        return true;
    }

    @Override
    @Transactional
    public boolean retirer(String code, double montant, Long codeEmp) {
        Compte cpt = compteRepository.findOne(code);
        if(cpt.getSolde() < montant) throw new RuntimeException("Solde Insuffisant");
        Employe employe = employeRepository.findOne(codeEmp);
        Operation o = new Retrait();
        o.setDateOperation(new Date());
        o.setMontant(montant);
        o.setCompte(cpt);
        o.setEmploye(employe);
        operationRepository.save(o);
        cpt.setSolde(cpt.getSolde() - montant);
        return true;
    }

    @Override
    @Transactional
    public boolean virement(String cpt1, String cpt2, double montant, Long codeEmp) {
        retirer(cpt1, montant, codeEmp);
        verser(cpt2, montant, codeEmp);
        return true;
    }

    @Override
    public PageOperation getOperation(String codeCompte, int page, int size) {
        Page<Operation> ops = operationRepository.getOperations(codeCompte, new PageRequest(page, size));
        PageOperation pageOperation = new PageOperation();
        pageOperation.setOperations(ops.getContent());
        pageOperation.setNombreOperation(ops.getNumberOfElements());
        pageOperation.setPage(ops.getNumber());
        pageOperation.setTotalPages(ops.getTotalPages());
        pageOperation.setTotalOperation((int)ops.getTotalElements());
        return pageOperation;
    }

//    @Override
//    public List<Operation> listOperation() {
//        return operationRepository.findAll();
//    }
}
