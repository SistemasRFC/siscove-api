package siscove.siscovejava.Cliente.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Cliente.Entity.Cliente;

@Repository(value = "ClienteDao")
public interface ClienteDao extends CrudRepository<Cliente, Integer> {

}