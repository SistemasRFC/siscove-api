package siscove.siscovejava.Entrada.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Entrada.Entity.Entrada;

@Repository(value = "EntradaDao")
public interface EntradaDao extends CrudRepository<Entrada, Integer> {
}
