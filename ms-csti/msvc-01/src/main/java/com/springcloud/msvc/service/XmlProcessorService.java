package com.springcloud.msvc.service;

import com.springcloud.msvc.entity.Root;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.StringReader;
import org.springframework.stereotype.Service;

@Service
public class XmlProcessorService {

    public Root processXml(String xmlContent) throws JAXBException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Root.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(xmlContent);
            return (Root) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }


}