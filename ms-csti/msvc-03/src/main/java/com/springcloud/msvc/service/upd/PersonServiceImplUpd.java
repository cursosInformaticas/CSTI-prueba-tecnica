package com.springcloud.msvc.service.upd;

import com.springcloud.msvc.dao.PersonRepositoryUpd;
import com.springcloud.msvc.entity.PersonUpdated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonServiceImplUpd implements PersonServiceUpd {

    @Autowired
    private PersonRepositoryUpd dao;
    @Override
    public List<PersonUpdated> getAllMessages() {
        return dao.findAll();
    }
}
