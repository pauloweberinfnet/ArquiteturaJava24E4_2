package br.edu.infnet.pauloweber.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.pauloweber.model.domain.Eletric;
import br.edu.infnet.pauloweber.model.service.EletricService;

@RestController
@RequestMapping("/api/vehicles/eletric")
public class EletricController {

    @Autowired
    private EletricService eletricService;

    @GetMapping
    public Collection<Eletric> getAll(String sort) {
        return eletricService.getAll(sort);
    }

    @GetMapping("/count")
    public long getCount() {
        return eletricService.count();
    }

    @PostMapping
    public Eletric add(@RequestBody Eletric eletric) {
        return eletricService.add(eletric);
    }
}
