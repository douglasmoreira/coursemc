package com.douglasmoreira.coursemc.services;

import com.douglasmoreira.coursemc.domain.Client;
import com.douglasmoreira.coursemc.repositories.ClientRepository;
import com.douglasmoreira.coursemc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client findById(Integer id) {
        return clientRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("object not found id: " + id +
                        ", Type: " + Client.class.getName()));
    }
}
