package com.springcloud.msvc.service;

import com.springcloud.msvc.dao.RootRepository;
import com.springcloud.msvc.entity.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RootServiceImpl implements RootService{

    @Autowired
    private RootRepository daoRoot;
    @Override
    public List<Root> getAllMessages() {
        return daoRoot.findAll();
    }
}
