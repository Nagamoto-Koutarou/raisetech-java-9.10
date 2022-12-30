package com.rasetech.java9.controller;

import com.rasetech.java9.service.NameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NameController {
    private final NameService nameService;

    public NameController(NameService nameService) {
        this.nameService = nameService;
    }

    @GetMapping("/names")
    public List<NameResponse> getNames() {
        return nameService.findAll().stream().map(NameResponse::new).toList();
    }

    @GetMapping("/names/{id}")
    public NameResponse findById(@PathVariable int id) {
        return new NameResponse(nameService.findById(id));
    }
}