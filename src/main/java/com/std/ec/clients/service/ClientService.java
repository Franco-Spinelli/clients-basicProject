package com.std.ec.clients.service;

import com.std.ec.clients.model.dto.ClientDTO;
import com.std.ec.clients.model.entity.Client;

public interface ClientService {
    void save(ClientDTO client);
    Client findById(Integer id);
    void delete(Client client);
}
