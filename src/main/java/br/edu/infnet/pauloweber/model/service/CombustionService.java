package br.edu.infnet.pauloweber.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.pauloweber.model.domain.Combustion;
import br.edu.infnet.pauloweber.model.repository.CombustionRepository;

@Service
public class CombustionService {
  @Autowired
  private CombustionRepository combustionRepository;

  public Combustion add(Combustion combustion) {
    return combustionRepository.save(combustion);
  }

  public long count() {
    return combustionRepository.count();
  }
  public Collection<Combustion> getAll() {
    return (Collection<Combustion>) combustionRepository.findAll();
  }
}
