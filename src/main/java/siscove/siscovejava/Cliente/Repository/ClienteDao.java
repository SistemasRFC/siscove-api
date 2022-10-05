package siscove.siscovejava.Cliente.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Cliente.Entity.Cliente;

@Repository(value = "ClienteDao")
public interface ClienteDao extends CrudRepository<Cliente, Integer> {

	@Query(value="SELECT * FROM EN_CLIENTE  WHERE DSC_CLIENTE like %?1%", nativeQuery=true)
	public List<Cliente> findBydscCliente(String dscCliente);

}