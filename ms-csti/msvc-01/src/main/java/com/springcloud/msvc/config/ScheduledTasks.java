package com.springcloud.msvc.config;

import com.springcloud.msvc.service.XmlFileProcessingService;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class ScheduledTasks {

    @Autowired
    private XmlFileProcessingService xmlFileProcessingService;

    @Value("${registro.ruta.archivo}")
    private String DIRECTORY_PATH;

    @Scheduled(fixedRate = 180000)
    public void processFilesPeriodically() throws JAXBException, IOException {
        xmlFileProcessingService.processFilesFromDirectory(DIRECTORY_PATH);
    }
}
