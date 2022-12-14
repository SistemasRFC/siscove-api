package siscove.siscovejava.LogVendaProduto.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.LogVendaProduto.Entity.LogVendaProduto;

@Repository(value = "LogVendaProdutoRepository")
public interface LogVendaProdutoRepository extends CrudRepository<LogVendaProduto, Integer> {
	

}