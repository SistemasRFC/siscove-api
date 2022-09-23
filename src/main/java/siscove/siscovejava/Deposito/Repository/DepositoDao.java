package siscove.siscovejava.Deposito.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Deposito.Entity.Deposito;


@Repository(value = "DepositoDao")
public interface DepositoDao extends CrudRepository<Deposito, Integer> {
	
	@Query(value="SELECT u.* FROM EN_DEPOSITO u WHERE COD_DEPOSITO = ?1 AND DSC_DEPOSITO = ?2", nativeQuery=true)
	public Deposito depositoLogin(Integer codDeposito , String dscDeposito);
	
}	
