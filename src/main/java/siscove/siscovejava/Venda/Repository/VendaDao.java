package siscove.siscovejava.Venda.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Venda.Entity.Venda;

@Repository(value = "VendaDao")
public interface VendaDao extends CrudRepository<Venda, Integer> {
	
	public List<Venda> findByNroStatusVenda(String status);
	
	public List<Venda> findByCodVendaLike(Integer codVenda);

}
