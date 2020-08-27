package com.banqueexample.metiers;

import com.banqueexample.Dao.ClientRepository;
import com.banqueexample.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientImplement implements ClientMetier {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> listClient() {
        return clientRepository.findAll();
    }
}
