package com.banqueexample.metiers;

import com.banqueexample.entities.Client;

import java.util.List;

public interface ClientMetier {

    public Client saveClient(Client client);

    public List<Client> listClient();
}
