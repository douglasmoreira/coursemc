package com.douglasmoreira.coursemc.resources;

import com.douglasmoreira.coursemc.CourseMCApplication;
import com.douglasmoreira.coursemc.domain.Address;
import com.douglasmoreira.coursemc.domain.City;
import com.douglasmoreira.coursemc.domain.Client;
import com.douglasmoreira.coursemc.domain.State;
import com.douglasmoreira.coursemc.domain.enums.ClientType;
import com.douglasmoreira.coursemc.services.ClientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = CourseMCApplication.class)
@AutoConfigureMockMvc
public class ResourceClientTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ClientService clientService;

    private ObjectMapper objectMapper = new ObjectMapper();
    String json;

    Integer id = 1;
    Client client;
    Address address;

    @BeforeEach
    public void setUp() throws JsonProcessingException {

        client = new Client(id, "Maria Silva", "maria@gmail.com", "36378912377", ClientType.PHYSICAL_PERSON);
        client.getPhone().addAll(asList("27363323", "93838393"));
        address = new Address(null, "Rua Flores", "300", "Apto 303",
                "Jardim", "38220834", client, new City(null, "Uberlandia", new State(null, "Minas Gerais")));
        client.getAddresses().addAll(asList(address));

        json = objectMapper.writeValueAsString(client);
    }

    @Test
    public void shouldReturnClient() throws Exception {

        when(clientService.findById(id)).thenReturn(client);

        this.mockMvc.perform(get("http://localhost:8080/client/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(json))
                .andReturn();
    }

}
