package com.std.ec.clients.service.impl;

import com.std.ec.clients.model.dao.ClientDao;
import com.std.ec.clients.model.dto.ClientDTO;
import com.std.ec.clients.model.entity.Client;
import com.std.ec.clients.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientImpl implements ClientService {
    @Autowired
    private ClientDao clientDao;
    @Transactional
    @Override
    public void save(ClientDTO clientDTO) {
        Client client = Client.builder()
                .name(clientDTO.getName())
                .email(clientDTO.getEmail())
                .id(clientDTO.getId())
                .phone(clientDTO.getPhone()).build();
         clientDao.save(client);
    }
    @Transactional(readOnly = true)
    @Override
    public Client findById(Integer id) {
        return clientDao.findById(id).orElse(null);
    }
    @Transactional
    @Override
    public void delete(Client client) {
        clientDao.delete(client);
    }
}
