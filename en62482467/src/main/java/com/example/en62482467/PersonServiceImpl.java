package com.example.en62482467;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("default")
public class PersonServiceImpl implements PersonService {
}
