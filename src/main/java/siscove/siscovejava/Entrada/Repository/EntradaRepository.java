package siscove.siscovejava.Entrada.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Entrada.Entity.Entrada;

@Repository(value = "EntradaRepository")
public interface EntradaRepository extends CrudRepository<Entrada, Integer> {
	
	@Query(value="SELECT * FROM EN_ENTRADA  WHERE IND_ENTRADA = 'A'", nativeQuery=true)
	public List<Entrada> findEntradasAbertas();

}