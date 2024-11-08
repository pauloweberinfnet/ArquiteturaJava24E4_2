package br.edu.infnet.pauloweber.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.pauloweber.model.domain.Eletric;

@Repository
public interface EletricRepository extends CrudRepository<Eletric, Integer> {

}
