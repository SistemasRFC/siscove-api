package siscove.siscovejava.LogVenda.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.LogVenda.Entity.LogVenda;

@Repository(value = "LogVendaRepository")
public interface LogVendaRepository extends CrudRepository<LogVenda, Integer> {
	

}
