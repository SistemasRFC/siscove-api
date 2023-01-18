package siscove.siscovejava.Venda.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Venda.Entity.Venda;

@Repository(value = "VendaRepository")
public interface VendaRepository extends CrudRepository<Venda, Integer> {
	
	public List<Venda> findByNroStatusVenda(String status);
	
	public List<Venda> findByCodVendaLike(Integer codVenda);
	
}
