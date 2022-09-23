package siscove.siscovejava.ClienteFinal.Dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.ClienteFinal.Entity.ClienteFinal;


@Repository(value = "ClienteFinalDao")
public interface ClienteFinalDao extends CrudRepository<ClienteFinal, Integer> {
	
	@Query(value="SELECT u.* FROM EN_CLIENTE_FINAL u WHERE COD_CLIENTE_FINAL = ?1", nativeQuery=true)
	public ClienteFinal findByCodClienteFinal(Integer codClienteFinal);
	
}	
