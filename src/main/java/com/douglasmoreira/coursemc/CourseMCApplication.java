package com.douglasmoreira.coursemc;

import com.douglasmoreira.coursemc.domain.*;
import com.douglasmoreira.coursemc.domain.enums.ClientType;
import com.douglasmoreira.coursemc.domain.enums.PaymentStatus;
import com.douglasmoreira.coursemc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;

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
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private PaymentRepository paymentRepository;

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
        p1.getCategories().addAll(asList(cat1));
        p1.getCategories().addAll(asList(cat1));
        p2.getCategories().addAll(asList(cat1, cat2));
        p3.getCategories().addAll(asList(cat1));

        productRepository.saveAll(asList(p1, p2, p3));

        categoryRepository.saveAll(asList(cat1, cat2));

        State state1 = new State(null, "Minas Gerais");
        State state2 = new State(null, "São Paulo");

        City city1 = new City(null, "Uberlãndia", state1);
        City city2 = new City(null, "São Paulo", state2);
        City city3 = new City(null, "Campinas", state2);

        state1.getCities().addAll(asList(city1));
        state2.getCities().addAll(asList(city2));
        state2.getCities().addAll(asList(city3));

        stateRepository.saveAll(asList(state1, state2));
        cityRepository.saveAll(asList(city1, city2, city3));

        Client client = new Client(null, "Maria Silva", "maria@gmail.com", "36378912377", ClientType.PHYSICAL_PERSON);

        client.getPhone().addAll(asList("27363323", "93838393"));

        Address address1 = new Address(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", client, city1);
        Address address2 = new Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", client, city2);

        client.getAddresses().addAll(asList(address1, address2));

        clientRepository.save(client);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Request request1 = new Request(null, sdf.parse("30/09/2017 10:32"), client, address1);
        Request request2 = new Request(null, sdf.parse("10/10/2017 19:35"), client, address2);

        Payment payment1 = new PaymentWithCard(null, PaymentStatus.SETTLED, request1, 6);
        request1.setPayment(payment1);
        Payment payment2 = new PaymentWithBillet(null, PaymentStatus.PENDING, request2, sdf.parse("20/10/2017 00:00"), null);
        request2.setPayment(payment2);

        client.getRequests().addAll(asList(request1, request2));

        requestRepository.saveAll(asList(request1, request2));
        paymentRepository.saveAll(asList(payment1, payment2));


    }
}
