package siscove.siscovejava.Entrada.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import siscove.siscovejava.Entrada.Dto.EntradaDto;
import siscove.siscovejava.Entrada.Dto.EntradasAbertasDto;
import siscove.siscovejava.Entrada.Dto.EntradasFechadasDto;
import siscove.siscovejava.EntradaEstoque.Dto.EntradaEstoqueDto;

@Repository(value = "EntradaDao")
public class EntradaDao {

	@PersistenceContext
	private EntityManager entityManager;

	public List<EntradasAbertasDto> getListaEntradasAbertas() {
		StringBuilder sb = new StringBuilder();
		sb.append("select ee.NRO_SEQUENCIAL, ");
		sb.append("	   DTA_ENTRADA, ");
		sb.append("	   ee.COD_FORNECEDOR, ");
		sb.append("	   ef.DSC_FORNECEDOR, ");
		sb.append("	   ed.COD_DEPOSITO, ");
		sb.append("	   ed.DSC_DEPOSITO, ");
		sb.append("	   sum(eee.VLR_UNITARIO*eee.QTD_ENTRADA) as vlr_total, ");
		sb.append("	   ee.NRO_NOTA_FISCAL, ");
		sb.append("	   ee.TXT_OBSERVACAO, ");
		sb.append("	   ee.COD_USUARIO, ");
		sb.append("	   ee.COD_CLIENTE_FINAL ");
		sb.append("  from en_entrada ee ");
		sb.append(" inner join en_fornecedor ef on ee.COD_FORNECEDOR =ef.COD_FORNECEDOR  ");
		sb.append(" inner join en_entrada_estoque eee on ee.NRO_SEQUENCIAL = eee.NRO_SEQUENCIAL  ");
		sb.append("inner join en_deposito ed on ee.COD_DEPOSITO = ed.COD_DEPOSITO ");
		sb.append(" where ee.IND_ENTRADA ='A' ");
		sb.append(" group by ee.NRO_SEQUENCIAL ");

		List<Object[]> listaRetorno = entityManager.createNativeQuery(sb.toString()).getResultList();

		List<EntradasAbertasDto> listaEntradasAbertas = new ArrayList<EntradasAbertasDto>();
		for (Object[] item : listaRetorno) {
			EntradasAbertasDto dto = new EntradasAbertasDto();
			dto.setNroSequencial((Integer) item[0]);
			dto.setDtaEntrada((Date) item[1]);
			dto.setCodFornecedor((Integer) item[2]);
			dto.setDscFornecedor((String) item[3]);
			dto.setCodDeposito((Integer) item[4]);
			dto.setDscDeposito((String) item[5]);
			dto.setVlrTotal((Double) item[6]);
			dto.setNroNotaFiscal((String) item[7]);
			dto.setTxtObservacao((String) item[8]);
			dto.setCodUsuario((Integer) item[9]);
			dto.setCodClienteFinal((Integer) item[10]);
			listaEntradasAbertas.add(dto);

		}
		return listaEntradasAbertas;
	}

	public List<EntradasFechadasDto> getListaEntradasFechadas(Integer codFornecedor) {
		StringBuilder sb = new StringBuilder();
		sb.append("select ee.NRO_SEQUENCIAL, ");
		sb.append("	   DTA_ENTRADA, ");
		sb.append("	   ee.COD_FORNECEDOR, ");
		sb.append("	   ef.DSC_FORNECEDOR, ");
		sb.append("	   ed.COD_DEPOSITO, ");
		sb.append("	   ed.DSC_DEPOSITO, ");
		sb.append("	   ep.VLR_PRODUTO, ");
		sb.append("	   ep.VLR_MINIMO, ");
		sb.append("	   ep.VLR_VENDA, ");
		sb.append("	   ep.VLR_UNITARIO, ");
		sb.append("	   sum(eee.VLR_UNITARIO*eee.QTD_ENTRADA) as vlr_total, ");
		sb.append("	   ee.NRO_NOTA_FISCAL, ");
		sb.append("	   ee.TXT_OBSERVACAO, ");
		sb.append("	   ee.COD_USUARIO, ");
		sb.append("	   ee.COD_CLIENTE_FINAL ");
		sb.append("  from en_entrada ee ");
		sb.append(" inner join en_fornecedor ef on ee.COD_FORNECEDOR =ef.COD_FORNECEDOR  ");
		sb.append(" inner join en_entrada_estoque eee on ee.NRO_SEQUENCIAL = eee.NRO_SEQUENCIAL  ");
		sb.append("inner join en_deposito ed on ee.COD_DEPOSITO = ed.COD_DEPOSITO ");
		sb.append(" where ee.IND_ENTRADA ='F' and ee.COD_FORNECEDOR = " + codFornecedor);
		sb.append(" group by ee.NRO_SEQUENCIAL ");

		List<Object[]> listaRetorno = entityManager.createNativeQuery(sb.toString()).getResultList();

		List<EntradasFechadasDto> listaEntradasFechadas = new ArrayList<EntradasFechadasDto>();
		for (Object[] item : listaRetorno) {
			EntradasFechadasDto dto = new EntradasFechadasDto();
			dto.setNroSequencial((Integer) item[0]);
			dto.setDtaEntrada((Date) item[1]);
			dto.setCodFornecedor((Integer) item[2]);
			dto.setDscFornecedor((String) item[3]);
			dto.setCodDeposito((Integer) item[4]);
			dto.setDscDeposito((String) item[5]);
			dto.setVlrProduto((Float) item[6]);
			dto.setVlrMinimo((Float) item[7]);
			dto.setVlrVenda((Float) item[8]);
			dto.setVlrUnitario((Float) item[9]);
			dto.setNroNotaFiscal((String) item[10]);
			dto.setTxtObservacao((String) item[11]);
			dto.setCodUsuario((Integer) item[12]);
			dto.setCodClienteFinal((Integer) item[13]);
			listaEntradasFechadas.add(dto);

		}
		return listaEntradasFechadas;
	}

	public List<EntradaEstoqueDto> getListarEntrada() {
		StringBuilder sb = new StringBuilder();
		sb.append("select ee.NRO_SEQUENCIAL, ");
		sb.append("	   DTA_ENTRADA, ");
		sb.append("	   ee.COD_FORNECEDOR, ");
		sb.append("	   ef.DSC_FORNECEDOR, ");
		sb.append("	   ed.COD_DEPOSITO, ");
		sb.append("	   ed.DSC_DEPOSITO, ");
		sb.append("	   ep.VLR_PRODUTO, ");
		sb.append("	   ep.VLR_MINIMO, ");
		sb.append("	   ep.VLR_VENDA, ");
		sb.append("	   ep.VLR_UNITARIO, ");
		sb.append("	   ep.COD_PRODUTO, ");
		sb.append("	   ep.DSC_PRODUTO, ");
		sb.append("	   sum(eee.VLR_UNITARIO*eee.QTD_ENTRADA) as vlr_total, ");
		sb.append("	   ee.NRO_NOTA_FISCAL, ");
		sb.append("	   ee.TXT_OBSERVACAO, ");
		sb.append("	   ee.COD_USUARIO, ");
		sb.append("	   ee.COD_CLIENTE_FINAL ");
		sb.append("  from en_entrada ee ");
		sb.append(" inner join en_fornecedor ef on ee.COD_FORNECEDOR =ef.COD_FORNECEDOR  ");
		sb.append(" inner join en_entrada_estoque eee on ee.NRO_SEQUENCIAL = eee.NRO_SEQUENCIAL  ");
		sb.append("inner join en_deposito ed on ee.COD_DEPOSITO = ed.COD_DEPOSITO ");
		sb.append(" group by ee.NRO_SEQUENCIAL ");

		List<Object[]> listaRetorno = entityManager.createNativeQuery(sb.toString()).getResultList();

		List<EntradaDto> ListarEntrada = new ArrayList<EntradaDto>();
		for (Object[] item : listaRetorno) {
			EntradaDto dto = new EntradaDto();
			dto.setNroSequencial((Integer) item[0]);
			dto.setDtaEntrada((Date) item[1]);
			dto.setCodFornecedor((Integer) item[2]);
			dto.setDscFornecedor((String) item[3]);
			dto.setCodDeposito((Integer) item[4]);
			dto.setDscDeposito((String) item[5]);
			dto.setVlrProduto((Float) item[6]);
			dto.setVlrMinimo((Float) item[7]);
			dto.setVlrVenda((Float) item[8]);
			dto.setVlrUnitario((Float) item[9]);
			dto.setNroNotaFiscal((String) item[10]);
			dto.setTxtObservacao((String) item[11]);
			dto.setCodUsuario((Integer) item[12]);
			dto.setCodClienteFinal((Integer) item[13]);
			ListarEntrada.add(dto);


		}
		return ListarEntrada;
	}
}