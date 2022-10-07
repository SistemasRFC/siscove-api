package siscove.siscovejava.Fornecedor.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Fornecedor.Entity.Fornecedor;

@Repository(value = "FornecedorDao")
public interface FornecedorDao extends CrudRepository<Fornecedor, Integer> {

}	
