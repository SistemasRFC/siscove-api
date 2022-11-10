package siscove.siscovejava.Venda.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Venda.Entity.VendaProduto;


@Repository(value = "VendaProdutoDao")
public interface VendaProdutoDao extends CrudRepository<VendaProduto, Integer> {
	
	public List<VendaProduto> findByCodVenda(Integer codVenda);
	
}
    

