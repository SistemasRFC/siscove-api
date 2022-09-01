package siscove.siscovejava.Deposito.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Deposito.Entity.Deposito;


@Repository(value = "DepositoDao")
public interface DepositoDao extends CrudRepository<Deposito, Integer> {
	
}	
