package com.springcloud.msvc.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springcloud.msvc.dao.RootRepositoryUpd;
import com.springcloud.msvc.entity.RootUpdated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class KafkaConsumerListener {


    private Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerListener.class);
    private final RootRepositoryUpd rootRepository;
    private final ObjectMapper objectMapper;



    @Autowired
    public KafkaConsumerListener(RootRepositoryUpd rootRepository, ObjectMapper objectMapper) {
        this.rootRepository = rootRepository;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = {"mscti-v01"}, groupId = "mscti-group-id")
    @Transactional
    public void listen(String message) {
        LOGGER.info("Received message: {}", message);
        try {
            // Deserializar el mensaje a un objeto Root
            RootUpdated root = objectMapper.readValue(message, RootUpdated.class);
            // Modificar el campo regEx de Person con un texto aleatorio
            if (root.getPerson() != null) {
                root.setRegEx(generateRandomText());
            }
            // Añadir el campo lastModified en Root con la fecha y hora actual
            root.setLastModified("MICROSERVICES_PROCESS_02_ "+getCurrentDateTime());
            // Guardar el objeto Root modificado en la base de datos
            rootRepository.save(root);
            LOGGER.info("Root object saved to the database");
        } catch (Exception e) {
            LOGGER.error("Error processing message", e);
        }
    }
    private String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return sdf.format(new Date());
    }
    private String generateRandomText() {
        // Implementa tu lógica para generar un texto aleatorio
        return "RandomText_" + Math.random();
    }
}
