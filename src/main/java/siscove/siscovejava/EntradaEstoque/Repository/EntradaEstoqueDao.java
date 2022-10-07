package siscove.siscovejava.EntradaEstoque.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.EntradaEstoque.Entity.EntradaEstoque;

@Repository(value = "EntradaEstoqueDao")
public interface EntradaEstoqueDao extends CrudRepository<EntradaEstoque, Integer> {

}	

