package br.edu.infnet.pauloweber.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.pauloweber.model.domain.Eletric;
import br.edu.infnet.pauloweber.model.repository.EletricRepository;

@Service
public class EletricService {
  @Autowired
  private EletricRepository eletricRepository;

  public Eletric add(Eletric eletric) {
    return eletricRepository.save(eletric);
  }

  public long count() {
    return eletricRepository.count();
  }

  public Collection<Eletric> getAll() {
    return (Collection<Eletric>) eletricRepository.findAll();
  }
}
