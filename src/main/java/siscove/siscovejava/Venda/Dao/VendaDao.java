package siscove.siscovejava.Venda.Dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import siscove.siscovejava.Venda.Dto.VendaBuscaDto;

@Repository(value = "VendaDao")
public class VendaDao {

	@PersistenceContext
	private EntityManager em;
	
	public List<VendaBuscaDto> getListaVendasPorStatus(String status){
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT V.COD_VENDA, "
			+ "	   		  C.DSC_CLIENTE, "
			+ "			  COALESCE(C.NRO_CPF, C.NRO_CNPJ) AS NRO_DOCUMENTO, "
			+ "       	  U.NME_USUARIO_COMPLETO, "
			+ "       	  V.DTA_VENDA, "
			+ "       	  (SELECT SUM(VP.VLR_VENDA*VP.QTD_VENDIDA) AS VLR"
			+ "				 FROM RE_VENDA_PRODUTO VP WHERE VP.COD_VENDA = V.COD_VENDA) AS VLR_VENDA,"
			+ "       	  V.DSC_VEICULO"
			+ "  	 FROM EN_VENDA V"
			+ "		INNER JOIN EN_CLIENTE C ON V.COD_CLIENTE = C.COD_CLIENTE"
			+ "		INNER JOIN SE_USUARIO U ON V.COD_USUARIO = U.COD_USUARIO"
			+ " WHERE V.NRO_STATUS_VENDA = '"+status+"'" );

		List<Object[]> lista = em.createNativeQuery(sb.toString()).getResultList();
		
		
		List<VendaBuscaDto> listaRetorno = new ArrayList<VendaBuscaDto>();
		for (Object[] item : lista) {
			VendaBuscaDto dto = new VendaBuscaDto();
			dto.setCodVenda((Integer) item[0]);
			dto.setNmeCliente((String) item[1]);
			dto.setNroDocumentoCliente((String) item[2]);
			dto.setNmeVendedor((String) item[3]);
			if(null != item[4]) {
				dto.setDtaVenda((LocalDateTime) LocalDateTime.parse(item[4].toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm:ss.S")));				
			}
			dto.setVlrVenda((Double) item[5]);
			dto.setDscVeiculo((String) item[6]);
			
			listaRetorno.add(dto);
		}
		
		return listaRetorno;
	}
	
}
