package br.edu.infnet.pauloweber.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.pauloweber.model.domain.Combustion;
import br.edu.infnet.pauloweber.model.service.CombustionService;

@RestController
@RequestMapping("/api/vehicles/combustion")
public class CombustionController {

    @Autowired
    private CombustionService combustionService;

    @GetMapping
    public Collection<Combustion> getAll(String sort) {
        return combustionService.getAll(sort);
    }

    @GetMapping("/count")
    public long getCount() {
        return combustionService.count();
    }

    @PostMapping
    public Combustion add(@RequestBody Combustion combustion) {
        return combustionService.add(combustion);
    }
}
