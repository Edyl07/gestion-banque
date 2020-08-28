package com.banqueexample.services;

import com.banqueexample.entities.Operation;
import com.banqueexample.metiers.OperationMetier;
import com.banqueexample.metiers.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OperationRestService {

    @Autowired
    private OperationMetier operationMetier;

    @RequestMapping(value = "/versement", method = RequestMethod.PUT)
    public boolean verser(@RequestParam String code, @RequestParam double montant, @RequestParam Long codeEmp) {
        return operationMetier.verser(code, montant, codeEmp);
    }

    @RequestMapping(value = "/retirer", method = RequestMethod.PUT)
    public boolean retirer(@RequestParam String code, @RequestParam double montant, @RequestParam Long codeEmp) {
        return operationMetier.retirer(code, montant, codeEmp);
    }

    @RequestMapping(value = "/virement", method = RequestMethod.PUT)
    public boolean virement(@RequestParam String cpt1, @RequestParam String cpt2, @RequestParam double montant, @RequestParam Long codeEmp) {
        return operationMetier.virement(cpt1, cpt2, montant, codeEmp);
    }

//    @RequestMapping(value = "/operations", method = RequestMethod.GET)
//    public List<Operation> listOperation() {
//        return operationMetier.listOperation();
//    }

    @RequestMapping(value = "/operations", method = RequestMethod.GET)
    public PageOperation getOperation(@RequestParam String codeCompte,
                                      @RequestParam int page,
                                      @RequestParam int size) {
        return operationMetier.getOperation(codeCompte, page, size);
    }
}
