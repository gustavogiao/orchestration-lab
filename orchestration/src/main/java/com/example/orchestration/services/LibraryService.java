package com.example.orchestration.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public class LibraryService {

    @WebMethod
    public boolean isClear(int studentId){
        return studentId % 3 != 0;
    }

}
