package siscove.siscovejava.Marca.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Marca.Entity.Marca;

@Repository(value = "MarcaDao")
public interface MarcaDao extends CrudRepository<Marca, Integer> {

	@Query(value="SELECT u.* FROM EN_MARCA u WHERE COD_MARCA = ?1", nativeQuery=true)
	public Marca findByCodMarca(Integer codMarca);
}