package siscove.siscovejava.BaixaEstoque.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.BaixaEstoque.Entity.BaixaEstoque;
import siscove.siscovejava.EntradaEstoque.Entity.EntradaEstoqueId;

@Repository(value = "BaixaEstoqueRepository")
public interface BaixaEstoqueRepository extends JpaRepository<BaixaEstoque, EntradaEstoqueId> {

	@Query(value = "SELECT u.* FROM EN_BAIXA_ESTOQUE u WHERE NRO_SEQUENCIAL = ?1 ", nativeQuery = true)
	public List<BaixaEstoque> getListarBaixaEstoque(String txtTermo);

}
