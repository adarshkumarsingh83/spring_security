package com.espark.adarsh.web;

import com.espark.adarsh.db.entity.Subject;
import com.espark.adarsh.db.repository.SubjectRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Subject")
public class SubjectController {

    private final SubjectRepository subjectRepository;

    public SubjectController(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }
}
