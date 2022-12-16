package siscove.siscovejava.EntradaEstoque.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.EntradaEstoque.Entity.EntradaEstoque;
import siscove.siscovejava.EntradaEstoque.Entity.EntradaEstoqueId;

@Repository(value = "EntradaEstoqueDao")
public interface EntradaEstoqueDao extends CrudRepository<EntradaEstoque, EntradaEstoqueId> {

	@Query(value="SELECT u.* FROM EN_ENTRADA_ESTOQUE u WHERE NRO_SEQUENCIAL = ?1 ", nativeQuery=true)
	public List<EntradaEstoque> getListaEntradaEstoqueByNroSequencial(Integer nroSequencial);
}