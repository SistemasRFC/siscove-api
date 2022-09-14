package siscove.siscovejava.Produto.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Produto.Entity.Produto;

@Repository(value = "ProdutoDao")
public interface ProdutoDao extends CrudRepository<Produto, Integer> {

}
