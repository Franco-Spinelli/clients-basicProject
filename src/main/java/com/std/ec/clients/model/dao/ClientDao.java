package com.std.ec.clients.model.dao;

import com.std.ec.clients.model.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientDao extends CrudRepository<Client,Integer> {
}
