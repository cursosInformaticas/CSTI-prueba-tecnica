package com.springcloud.msvc.service;

import com.springcloud.msvc.dao.PersonRepository;
import com.springcloud.msvc.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonRepository daoPerson;
    @Override
    public List<Person> getAllMessages() {
        return daoPerson.findAll();
    }
}
