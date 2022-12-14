package siscove.siscovejava.LogVendaPagamento.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.LogVendaPagamento.Entity.LogVendaPagamento;

@Repository(value = "LogVendaPagamentoRepository")
public interface LogVendaPagamentoRepository extends CrudRepository<LogVendaPagamento, Integer> {
	

}