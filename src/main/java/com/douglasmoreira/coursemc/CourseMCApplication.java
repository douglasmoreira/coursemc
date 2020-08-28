package com.douglasmoreira.coursemc;

import com.douglasmoreira.coursemc.domain.*;
import com.douglasmoreira.coursemc.domain.enums.ClientType;
import com.douglasmoreira.coursemc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.util.Arrays.asList;

@SpringBootApplication
public class CourseMCApplication implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;

    public static void main(String[] args) {
        SpringApplication.run(CourseMCApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Computing");
        Category cat2 = new Category(null, "Office");

        Product p1 = new Product(null, "computing", 2000.0);
        Product p2 = new Product(null, "printer", 800.0);
        Product p3 = new Product(null, "mouse", 80.00);

        cat1.getProducts().addAll(asList(p1, p2, p3));
        cat2.getProducts().addAll(asList(p2));

        p1.getCategories().addAll(asList(cat1));
        p2.getCategories().addAll(asList(cat1, cat2));
        p3.getCategories().addAll(asList(cat1));

        categoryRepository.saveAll(asList(cat1, cat2));

        productRepository.saveAll(asList(p1, p2, p3));

        State state1 = new State(null, "Minas Gerais");
        State state2 = new State(null, "São Paulo");

        City city1 = new City(null, "Uberlãndia", state1);
        City city2 = new City(null, "São Paulo", state2);
        City city3 = new City(null, "Campinas", state2);

        state1.getCities().addAll(asList(city1));
        state2.getCities().addAll(asList(city2));
        state2.getCities().addAll(asList(city3));

        stateRepository.saveAll(asList(state1,state2));
        cityRepository.saveAll(asList(city1,city2,city3));

        Client client = new Client(null, "Maria Silva", "maria@gmail.com", "36378912377", ClientType.PHYSICAL_PERSON);

        client.getPhone().addAll(asList("27363323", "93838393"));

        Address address1 = new Address(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", client, city1);
        Address address2 = new Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", client, city2);

        client.getAddresses().addAll(asList(address1, address2));

        clientRepository.save(client);
        addressRepository.saveAll(asList(address1, address2));
    }
}
