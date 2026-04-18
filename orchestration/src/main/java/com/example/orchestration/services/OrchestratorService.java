package com.example.orchestration.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.orchestration.clients.AcademicClient;
import com.example.orchestration.clients.LibraryClient;

@Service
public class OrchestratorService {

    private final AcademicClient academicClient;
    private final LibraryClient libraryClient;

    public OrchestratorService(AcademicClient academicClient,
                               LibraryClient libraryClient) {
        this.academicClient = academicClient;
        this.libraryClient = libraryClient;
    }

    public ResponseEntity<?> processRequest(int id) {

        log("Pedido recebido: " + id);

        // 1. Verificar elegibilidade
        boolean eligible = academicClient.checkEligibility(id);
        log("Elegibilidade: " + eligible);

        if (!eligible) {
            return ResponseEntity.badRequest().body("Sem direito");
        }

        // 2. Verificar biblioteca
        boolean libraryClear = libraryClient.checkLibrary(id);
        log("Biblioteca OK: " + libraryClear);

        try {
            // 3. Pedir certificado
            ResponseEntity<?> response =
                academicClient.requestCertificate(id, libraryClear);

            log("Certificado gerado");

            return response;

        } catch (Exception e) {

            log("Erro ao obter certificado: " + e.getMessage());

            return ResponseEntity.badRequest().body("Erro no processamento: " + e.getMessage());
        }
    }

    private void log(String msg) {
        System.out.println("[ORCHESTRATOR] " + msg);
    }
}
