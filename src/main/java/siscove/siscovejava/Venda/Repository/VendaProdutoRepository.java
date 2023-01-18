package siscove.siscovejava.Venda.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Venda.Entity.VendaProduto;
import siscove.siscovejava.Venda.Entity.VendaProdutoId;


@Repository(value = "VendaProdutoDao")
public interface VendaProdutoRepository extends CrudRepository<VendaProduto, Integer> {
	
	public List<VendaProduto> findByIdCodVenda(Integer codVenda);
	
	public VendaProduto findById(VendaProdutoId id);
	   
   
}
