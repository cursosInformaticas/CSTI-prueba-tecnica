package com.springcloud.msvc.service;

import com.springcloud.msvc.dao.RootRepositoryUpd;
import com.springcloud.msvc.entity.RootUpdated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class DataService {
   /* @Autowired
    private RootRepositoryUpd rootRepository;

    @Transactional
    public void processAndSave(RootUpdated root) {
        // Modifica el campo regEx con un texto aleatorio
        root.setRegEx(generateRandomText());
        // Añade un campo LAST_MODIFIED
        root.setLastModified(getCurrentDateTime());
        // Guarda los cambios en la base de datos.
        // Esto guardará tanto Root como Person debido a la configuración de cascada.
        rootRepository.save(root);
    }

    private String generateRandomText() {
        // Implementa tu lógica para generar un texto aleatorio
        return "RandomText_" + Math.random();
    }

    private String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return sdf.format(new Date());
    }*/
}
