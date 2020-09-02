package com.douglasmoreira.coursemc.services;

import com.douglasmoreira.coursemc.domain.Address;
import com.douglasmoreira.coursemc.domain.City;
import com.douglasmoreira.coursemc.domain.Client;
import com.douglasmoreira.coursemc.domain.State;
import com.douglasmoreira.coursemc.domain.enums.ClientType;
import com.douglasmoreira.coursemc.repositories.ClientRepository;
import com.douglasmoreira.coursemc.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ClientServiceTest {

    @MockBean
    ClientRepository clientRepository;

    @Autowired
    ClientService clientService;

    Integer id = 1;
    Client client;
    Address address;

    @BeforeEach
    public void setUp() {

        client = new Client(id, "Maria Silva", "maria@gmail.com", "36378912377", ClientType.PHYSICAL_PERSON);
        client.getPhone().addAll(asList("27363323", "93838393"));
        address = new Address(null, "Rua Flores", "300", "Apto 303",
                "Jardim", "38220834", client, new City(null, "Uberlãndia", new State(null, "Minas Gerais")));
        client.getAddresses().addAll(asList(address));
    }

    @Test
    public void shouldGetClient() {

        when(clientRepository.findById(id)).thenReturn(java.util.Optional.of(client));

        Client result = clientService.findById(id);

        assertEquals(result, client);
    }

    @Test
    public void shouldThrowObjectNotFoundException() {
        try {
            id = 2;
            clientService.findById(id);
        } catch (ObjectNotFoundException e) {
            assertEquals("object not found id: " + id +
                    ", Type: " + Client.class.getName(), e.getMessage());
        }
    }
}
