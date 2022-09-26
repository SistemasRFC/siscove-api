package siscove.siscovejava.TipoPagamento.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.TipoPagamento.Entity.TipoPagamento;

@Repository(value = "TipoPagamentoDao")
public interface TipoPagamentoDao extends CrudRepository<TipoPagamento, Integer> {

}	
