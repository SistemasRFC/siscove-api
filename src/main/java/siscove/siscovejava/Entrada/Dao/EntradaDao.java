package siscove.siscovejava.Entrada.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import siscove.siscovejava.Entrada.Dto.ListagemEntradasDto;

@Repository(value = "EntradaDao")
public class EntradaDao {

	@PersistenceContext
	private EntityManager entityManager;

	public List<ListagemEntradasDto> getListaEntradasAbertas() {
		StringBuilder sb = new StringBuilder();
		sb.append("select ee.NRO_SEQUENCIAL, ");
		sb.append("	   ee.DTA_ENTRADA, ");
		sb.append("	   ee.COD_FORNECEDOR, ");
		sb.append("	   ef.DSC_FORNECEDOR, ");
		sb.append("	   ee.COD_DEPOSITO, ");
		sb.append("	   ed.DSC_DEPOSITO, ");
		sb.append("	   ep.COD_PRODUTO, ");
		sb.append("	   ep.DSC_PRODUTO, ");
		sb.append("	   sum(eee.VLR_UNITARIO*eee.QTD_ENTRADA) as vlr_total, ");
		sb.append("	   ee.NRO_NOTA_FISCAL, ");
		sb.append("	   ee.TXT_OBSERVACAO, ");
		sb.append("	   ee.COD_CLIENTE_FINAL, ");
		sb.append("	   'A' as IND_ENTRADA ");
		sb.append("  from en_entrada ee ");
		sb.append(" inner join en_fornecedor ef on ee.COD_FORNECEDOR =ef.COD_FORNECEDOR ");
		sb.append(" and ee.IND_ENTRADA ='A' ");
		sb.append(" inner join en_entrada_estoque eee on ee.NRO_SEQUENCIAL = eee.NRO_SEQUENCIAL  ");
		sb.append(" inner join en_deposito ed on ee.COD_DEPOSITO = ed.COD_DEPOSITO ");
		sb.append(" inner join en_produto ep on eee.COD_PRODUTO = ep.COD_PRODUTO ");
		sb.append(" group by ee.NRO_SEQUENCIAL ");

		List<Object[]> listaRetorno = entityManager.createNativeQuery(sb.toString()).getResultList();

		List<ListagemEntradasDto> listaEntradasAbertas = new ArrayList<ListagemEntradasDto>();
		for (Object[] item : listaRetorno) {
			ListagemEntradasDto dto = new ListagemEntradasDto();
			dto.setNroSequencial((Integer) item[0]);
			dto.setDtaEntrada((Date) item[1]);
			dto.setCodFornecedor((Integer) item[2]);
			dto.setDscFornecedor((String) item[3]);
			dto.setCodDeposito((Integer) item[4]);
			dto.setDscDeposito((String) item[5]);
			dto.setCodProduto((Integer) item[6]);
			dto.setDscProduto((String) item[7]);
			dto.setVlrTotal((Double) item[8]);
			dto.setNroNotaFiscal((String) item[9]);
			dto.setTxtObservacao((String) item[10]);
			dto.setCodClienteFinal((Integer) item[11]);
			dto.setIndEntrada((String) item[12]);
			listaEntradasAbertas.add(dto);

		}
		return listaEntradasAbertas;
	}

	public List<ListagemEntradasDto> getListaEntradasFechadas(Integer codFornecedor) {
		StringBuilder sb = new StringBuilder();
		sb.append("select ee.NRO_SEQUENCIAL, ");
		sb.append("	   ee.DTA_ENTRADA, ");
		sb.append("	   ee.COD_FORNECEDOR, ");
		sb.append("	   ef.DSC_FORNECEDOR, ");
		sb.append("	   ee.COD_DEPOSITO, ");
		sb.append("	   ed.DSC_DEPOSITO, ");
		sb.append("	   ep.COD_PRODUTO, ");
		sb.append("	   ep.DSC_PRODUTO, ");
		sb.append("	   sum(eee.VLR_UNITARIO*eee.QTD_ENTRADA) as vlr_total, ");
		sb.append("	   ee.NRO_NOTA_FISCAL, ");
		sb.append("	   ee.TXT_OBSERVACAO, ");
		sb.append("	   ee.COD_CLIENTE_FINAL, ");
		sb.append("	   'F' as IND_ENTRADA ");
		sb.append("  from en_entrada ee ");
		sb.append(" inner join en_fornecedor ef on ee.COD_FORNECEDOR =ef.COD_FORNECEDOR ");
		sb.append(" and ee.IND_ENTRADA ='F' and ee.COD_FORNECEDOR = " + codFornecedor);
		sb.append(" inner join en_entrada_estoque eee on ee.NRO_SEQUENCIAL = eee.NRO_SEQUENCIAL  ");
		sb.append("inner join en_deposito ed on ee.COD_DEPOSITO = ed.COD_DEPOSITO ");
		sb.append("inner join en_produto ep on eee.COD_PRODUTO = ep.COD_PRODUTO ");
		sb.append(" group by ee.NRO_SEQUENCIAL ");

		List<Object[]> listaRetorno = entityManager.createNativeQuery(sb.toString()).getResultList();

		List<ListagemEntradasDto> listaEntradasFechadas = new ArrayList<ListagemEntradasDto>();
		for (Object[] item : listaRetorno) {
			ListagemEntradasDto dto = new ListagemEntradasDto();
			dto.setNroSequencial((Integer) item[0]);
			dto.setDtaEntrada((Date) item[1]);
			dto.setCodFornecedor((Integer) item[2]);
			dto.setDscFornecedor((String) item[3]);
			dto.setCodDeposito((Integer) item[4]);
			dto.setDscDeposito((String) item[5]);
			dto.setCodProduto((Integer) item[6]);
			dto.setDscProduto((String) item[7]);
			dto.setVlrTotal((Double) item[8]);
			dto.setNroNotaFiscal((String) item[9]);
			dto.setTxtObservacao((String) item[10]);
			dto.setCodClienteFinal((Integer) item[11]);
			dto.setIndEntrada((String) item[12]);
			listaEntradasFechadas.add(dto);

		}
		return listaEntradasFechadas;
	}

}
