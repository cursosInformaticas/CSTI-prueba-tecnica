package com.springcloud.msvc.controller;

import com.springcloud.msvc.entity.Person;
import com.springcloud.msvc.entity.PersonUpdated;
import com.springcloud.msvc.entity.Root;
import com.springcloud.msvc.entity.RootUpdated;
import com.springcloud.msvc.service.PersonService;
import com.springcloud.msvc.service.RootService;
import com.springcloud.msvc.service.upd.PersonServiceUpd;
import com.springcloud.msvc.service.upd.RootServiceUpd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonaController {

    @Autowired
    private PersonService service;

    @Autowired
    private PersonServiceUpd serviceupd;

    @Autowired
    private RootService rootService;

    @Autowired
    private RootServiceUpd rootServiceUpd;

    @GetMapping("/person")
    public List<Person> getPerson() {
        return service.getAllMessages();
    }

    @GetMapping("/person-upd")
    public List<PersonUpdated> getPersonUpd() {
        return serviceupd.getAllMessages();
    }

    @GetMapping("/root")
    public List<Root> getRoot() {
        return rootService.getAllMessages();
    }

    @GetMapping("/root-upd")
    public List<RootUpdated> getRootUpd() {
        return rootServiceUpd.getAllMessages();
    }
}
