package com.std.ec.clients.controller;

import com.std.ec.clients.model.dto.ClientDTO;
import com.std.ec.clients.model.entity.Client;
import com.std.ec.clients.model.payload.MessageResponse;
import com.std.ec.clients.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1") //recurso que trabaja con url
public class ClientController {
    @Autowired
    private ClientService clientService;
    @PostMapping("client")
    public ResponseEntity<?> create(@RequestBody ClientDTO clientDTO){
        try{
            clientService.save(clientDTO);
            return ResponseEntity.ok(clientDTO);
        } catch (DataAccessException e){
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping ("client/{id}")
    public ResponseEntity<?> update(@RequestBody ClientDTO clientDTO, @PathVariable Integer id){
        Client client = clientService.findById(id);
        if(client !=null){
            clientDTO.setId(client.getId());
            clientService.save(clientDTO);
            return ResponseEntity.ok(clientDTO);
        }else{
            return ResponseEntity.notFound().build();
            }
    }
    @DeleteMapping("client/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){

        try{
            Client clientDelete = clientService.findById(id);
            clientService.delete(clientDelete);
            return new ResponseEntity<>(clientDelete, HttpStatus.NO_CONTENT);
        }catch (DataAccessException e){
            return  ResponseEntity.notFound().build();
        }
    }
    @GetMapping("client/{id}")
    public ResponseEntity<?> showById(@PathVariable Integer id){
        Client client = clientService.findById(id);
        if(client == null){
            return  ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(MessageResponse.builder()
                .message("Client FOUND!")
                .object(ClientDTO.builder()
                        .name(client.getName())
                        .email(client.getEmail())
                        .id(client.getId())
                        .phone(client.getPhone()).build())
                .build(), HttpStatus.OK);
    }
}
