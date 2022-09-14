package siscove.siscovejava.Marca.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Marca.Entity.Marca;

@Repository(value = "MarcaDao")
public interface MarcaDao extends CrudRepository<Marca, Integer> {

	Marca findByCodMarca(Integer codMarca);

}