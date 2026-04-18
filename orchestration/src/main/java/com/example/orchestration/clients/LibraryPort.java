package com.example.orchestration.clients;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService(
    targetNamespace = "http://services.orchestration.example.com/",
    name = "LibraryService"
)
public interface LibraryPort {

    @WebMethod
    boolean isClear(int studentId);
}