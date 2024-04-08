package com.springcloud.msvc.service.upd;

import com.springcloud.msvc.dao.RootRepositoryUpd;
import com.springcloud.msvc.entity.RootUpdated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RootServiceImplUpd implements RootServiceUpd {

    @Autowired
    private RootRepositoryUpd dao;
    @Override
    public List<RootUpdated> getAllMessages() {
        return dao.findAll();
    }
}
