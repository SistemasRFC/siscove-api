package siscove.siscovejava.Venda.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Venda.Entity.Venda;

@Repository(value = "VendaDao")
public interface VendaDao extends CrudRepository<Venda, Integer> {
	
	@Query(value="SELECT * FROM EN_VENDA WHERE NRO_STATUS_VENDA = 'A' ", nativeQuery=true)
	public List<Venda> getListaVendasAbertas();
	
	@Query(value="SELECT * FROM EN_VENDA WHERE NRO_STATUS_VENDA = 'F' ", nativeQuery=true)
	public List<Venda> getListaVendasFechadas();

}
