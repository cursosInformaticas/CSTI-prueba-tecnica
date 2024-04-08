package com.springcloud.msvc.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springcloud.msvc.dao.RootRepository;
import com.springcloud.msvc.entity.Person;
import com.springcloud.msvc.entity.Root;
import jakarta.xml.bind.JAXBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.nio.file.Path;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class XmlFileProcessingService {

    private static final Logger logger = LoggerFactory.getLogger(XmlFileProcessingService.class);

    @Autowired
    private XmlProcessorService xmlProcessorService;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Autowired
    private RootRepository rootRepository;

    public void processFilesFromDirectory(String directoryPath) throws IOException, JAXBException {
        logger.info("Iniciando el procesamiento de archivos en el directorio: {}", directoryPath);
        File dir = new File(directoryPath);
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                if (child.isFile() && child.getName().endsWith(".xml")) {

                    Path filePath = child.toPath();
                    BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
                    LocalDateTime lastModifiedTime = LocalDateTime.ofInstant(attrs.lastModifiedTime().toInstant(), ZoneId.systemDefault());
                    if (lastModifiedTime.isBefore(LocalDateTime.now().minusMinutes(3))) {
                        String xmlContent = new String(Files.readAllBytes(child.toPath()));
                        Root root = xmlProcessorService.processXml(xmlContent);
                        Person person = root.getPerson();
                        root.setPerson(person);
                        root.setLastUpdate("MICROSERVICES_PROCESS_01_ "+getCurrentDateTime());
                        rootRepository.save(root);
                        String jsonContent = convertRootToJson(root);
                        kafkaProducerService.send("mscti-v01", jsonContent);
                        logger.info("Finalizado el procesamiento de archivos en el directorio: {}", directoryPath);
                    } else {
                        System.out.println("Archivo modificado recientemente, se omitirá: " + child.getName());
                    }

                }
            }
        } else {
            System.out.println("El directorio especificado no existe o no se puede leer.");
        }
    }
    private String convertRootToJson(Root root) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(root);
    }
    private String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return sdf.format(new Date());
    }
}
