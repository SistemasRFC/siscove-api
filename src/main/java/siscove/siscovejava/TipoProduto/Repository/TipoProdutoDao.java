package siscove.siscovejava.TipoProduto.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.TipoProduto.Entity.TipoProduto;

@Repository(value = "TipoProdutoDao")
public interface TipoProdutoDao extends CrudRepository<TipoProduto, Integer> {

}	