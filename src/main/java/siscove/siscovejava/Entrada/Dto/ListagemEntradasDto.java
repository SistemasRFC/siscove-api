package siscove.siscovejava.Entrada.Dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Entrada.Entity.Entrada;
import siscove.siscovejava.EntradaEstoque.Dto.EntradaEstoqueDto;
import siscove.siscovejava.EntradaEstoque.Entity.EntradaEstoque;
import siscove.siscovejava.Util.UtilData;
import siscove.siscovejava.UtilMoeda.UtilMoeda;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListagemEntradasDto {

	private Integer nroSequencial;
	private String nroNotaFiscal;
	private Date dtaEntrada;
	private String txtObservacao;
	private String indEntrada;
	private Integer codClienteFinal;
	private Integer codFornecedor;
	private String dscFornecedor;
	private Integer codDeposito;
	private String dscDeposito;
	private Double vlrTotal;
	private String dtaEntradaFormatada;
	private String vlrTotalFormatada;
	private Integer codProduto;
	private String dscProduto;

	
	public static ListagemEntradasDto build(Entrada entrada) {
		List<EntradaEstoqueDto> listarEntradaEstoqueDto = new ArrayList<EntradaEstoqueDto>();
		Double vlrTotal = 0.0;
		if (null != entrada.getListaEntradaEstoque()) {
			for (EntradaEstoque entradaEstoque : entrada.getListaEntradaEstoque()) {
				listarEntradaEstoqueDto.add(EntradaEstoqueDto.build(entradaEstoque));
				vlrTotal += entradaEstoque.getVlrUnitario() * entradaEstoque.getQtdEntrada();
			}

		} else {
			EntradaEstoque entradaEstoque = new EntradaEstoque();
			listarEntradaEstoqueDto.add(EntradaEstoqueDto.build(entradaEstoque));

		}
		String indEntrada = "";
		if (null != entrada.getIndEntrada()) {
			indEntrada = entrada.getIndEntrada();
		}

		ListagemEntradasDto entradaDto = new ListagemEntradasDto(
				entrada.getNroSequencial(), 
				entrada.getNroNotaFiscal(),
				entrada.getDtaEntrada(), 
				entrada.getTxtObservacao(), 
				entrada.getIndEntrada(),
				entrada.getCodClienteFinal(),
				entrada.getCodFornecedor(),
				entrada.getFornecedor().getDscFornecedor(),
				entrada.getDeposito().getCodDeposito(),
				entrada.getDeposito().getDscDeposito(),
				vlrTotal,
				UtilData.formataData(entrada.getDtaEntrada()),
				UtilMoeda.formataMoeda(vlrTotal),
				null, null);
				
		return entradaDto;
	}

	public static Entrada parse(ListagemEntradasDto entradaDto) {
		Entrada entrada = new Entrada();
		entrada.setNroSequencial(entradaDto.getNroSequencial());
		entrada.setNroNotaFiscal(entradaDto.getNroNotaFiscal());
		entrada.setDtaEntrada(entradaDto.getDtaEntrada());
//		entrada.setCodUsuario(entradaDto.getCodUsuario());
		entrada.setTxtObservacao(entradaDto.getTxtObservacao());
		entrada.setIndEntrada(entradaDto.getIndEntrada());
		entrada.setCodClienteFinal(entradaDto.getCodClienteFinal());
		entrada.setCodFornecedor(entradaDto.getCodFornecedor());
//		entrada.setDeposito(entradaDto.getDeposito());
//		entrada.getCodProduto(entradaDto.getCodProduto());
		
		return entrada;
	}
}