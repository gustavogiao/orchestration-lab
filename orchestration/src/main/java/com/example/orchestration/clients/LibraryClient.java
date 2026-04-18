package com.example.orchestration.clients;

import java.net.URL;
import javax.xml.namespace.QName;

import org.springframework.stereotype.Service;

@Service
public class LibraryClient {

    public boolean checkLibrary(int id) {
        try {
            URL wsdl = new URL("http://localhost:8081/library?wsdl");

            QName qname = new QName(
                "http://services.orchestration.example.com/",
                "LibraryServiceService"
            );

            jakarta.xml.ws.Service service =
                    jakarta.xml.ws.Service.create(wsdl, qname);

            LibraryPort port = service.getPort(LibraryPort.class);

            return port.isClear(id);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}