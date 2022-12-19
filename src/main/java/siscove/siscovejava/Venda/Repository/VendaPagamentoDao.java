package siscove.siscovejava.Venda.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Venda.Entity.VendaPagamento;

@Repository(value = "VendaPagamentoDao")
	public interface VendaPagamentoDao extends CrudRepository<VendaPagamento, Integer> {
		
		
	}


