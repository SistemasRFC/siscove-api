package siscove.siscovejava.Entrada.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import siscove.siscovejava.Entrada.Dto.EntradasAbertasDto;
import siscove.siscovejava.Entrada.Dto.EntradasFechadasDto;
import siscove.siscovejava.EntradaEstoque.Dto.EntradaEstoqueDto;

@Repository(value = "EntradaDao")
public class EntradaDao {

	@PersistenceContext
	private EntityManager entityManager;

	public List<EntradaEstoqueDto> getListaEntradaEstoqueByNroSequencial() {
		StringBuilder sb = new StringBuilder();
		sb.append("select ep.COD_PRODUTO, ");
		sb.append("	   DSC_PRODUTO, ");
		sb.append("	   ep.VLR_PRODUTO, ");
		sb.append("	   ep.VLR_MINIMO, ");
		sb.append("	   ep.VLR_VENDA, ");
		sb.append("	   ep.VLR_UNITARIO, ");
		sb.append("	   ed.DSC_DEPOSITO, ");
		sb.append("	   sum(eee.VLR_UNITARIO*eee.QTD_ENTRADA) as vlr_total, ");
		sb.append("  from en_produto ep ");
		sb.append(" inner join en_produto ep  on ee.COD_PRODUTO = eee.COD_PRODUTO  ");
		sb.append(" inner join en_entrada_estoque eee on ee.NRO_SEQUENCIAL = eee.NRO_SEQUENCIAL  ");
		sb.append("inner join en_deposito ed on ee.COD_DEPOSITO = ed.COD_DEPOSITO ");
		sb.append(" group by ee.NRO_SEQUENCIAL ");

		List<Object[]> listaRetorno = entityManager.createNativeQuery(sb.toString()).getResultList();

		List<EntradasAbertasDto> listaEntradasAbertas = new ArrayList<EntradasAbertasDto>();
		for (Object[] item : listaRetorno) {
			EntradasAbertasDto dto = new EntradasAbertasDto();
			dto.setCodProduto((Integer) item[0]);
			dto.setDscProduto((String) item[1]);
			dto.setVlrProduto((Float) item[2]);
			dto.setVlrMinimo((Float) item[3]);
			dto.setVlrVenda((Float) item[4]);
			dto.setVlrUnitario((Float) item[5]);
			listaEntradasAbertas.add(dto);

		}
		return getListaEntradaEstoqueByNroSequencial;
	}
}
