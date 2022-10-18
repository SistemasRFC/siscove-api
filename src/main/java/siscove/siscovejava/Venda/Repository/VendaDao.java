package siscove.siscovejava.Venda.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Venda.Entity.Venda;

@Repository(value = "UsuarioDao")
public interface VendaDao extends CrudRepository<Venda, Integer> {

}
