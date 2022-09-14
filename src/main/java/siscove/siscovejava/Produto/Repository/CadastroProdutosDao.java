package siscove.siscovejava.Produto.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Produto.Entity.CadastroProdutos;

@Repository(value = "CadastroProdutosDao")
public interface CadastroProdutosDao extends CrudRepository<CadastroProdutos, Integer> {

}
