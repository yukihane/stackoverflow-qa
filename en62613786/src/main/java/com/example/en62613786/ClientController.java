package com.example.en62613786;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    @Autowired
    private ClientRepository restRepository;

    @GetMapping("/client")
    public List<Client> getAllOrders() {
        return restRepository.findAll();
    }

    @PostMapping("/client")
    public Client createAccount(@RequestBody final Client client) {
        return restRepository.save(client);
    }

    @GetMapping("/")
    public String index() {
        final Client c = new Client();
        final ArrayList<Order> orders = new ArrayList<>();
        final Order o1 = new Order();
        o1.setName("order1");
        o1.setPrice(100);
        orders.add(o1);
        c.setOrders(orders);
        final Client saved = restRepository.save(c);
        return saved.toString();
    }

    //    @PutMapping("/client/{id}/order")
    //    public ResponseEntity<Client> updateOrders(@PathVariable(value = "id") final Long clientId,
    //        @Validated @RequestBody final Issuer orderDetails) throws ResourceNotFoundException {
    //        final Client client = restRepository
    //            .findById(clientId)
    //            .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado: " + userId));
    //        client.getOrders().add(orderDetails);
    //        client.setMoney(client.getCash() - (orderDetails.getTotal_items() * orderDetails.getItem_price()));
    //
    //        final Account updatedClient = restRepository.save(client);
    //        return ResponseEntity.ok(updatedClient);
    //    }
}