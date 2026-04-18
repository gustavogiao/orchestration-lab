package com.example.orchestration.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orchestration.models.Certificate;

@RestController
@RequestMapping("/academic")
public class AcademicController {

    @GetMapping("/eligible/{id}")
    public boolean hasRight(@PathVariable int id) {
        return id % 2 == 0;
    }

    @PostMapping("/certificate/{id}")
    public ResponseEntity<?> getCertificate(
            @PathVariable int id,
            @RequestBody boolean libraryClear) {

        if (id % 2 != 0) {
            return ResponseEntity.badRequest().body("Sem direito");
        }

        if (!libraryClear) {
            return ResponseEntity.badRequest().body("Irregular na biblioteca");
        }

        Certificate c = new Certificate();
        c.setStudentId(id);
        c.setName("Aluno " + id);
        c.setCourse("Engenharia");

        return ResponseEntity.ok(c);
    }
}