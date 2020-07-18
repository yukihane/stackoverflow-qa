package com.example.so62972132;

import com.example.so62972132.entity.ProductDetail;
import com.example.so62972132.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Ecommerce")
public class UserController
{
    @Autowired
    private ProductService productservice;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/products")
    public List<ProductDetail> ShowProducts()
    {
        return productservice.getProducts();
    }

    @PostMapping("/PlaceOrder")
    public User placeOrder(@RequestBody OrderRequest request)
    {
        return userRepository.save(request.getUser());
    }
}