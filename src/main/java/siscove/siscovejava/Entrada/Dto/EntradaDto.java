package siscove.siscovejava.Entrada.Dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Deposito.Entity.Deposito;
import siscove.siscovejava.Entrada.Entity.Entrada;
import siscove.siscovejava.EntradaEstoque.Dto.EntradaEstoqueDto;
import siscove.siscovejava.EntradaEstoque.Entity.EntradaEstoque;
import siscove.siscovejava.Fornecedor.Entity.Fornecedor;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntradaDto {

	private Integer nroSequencial;
	private String nroNotaFiscal;
	private LocalDate dtaEntrada;
	private Fornecedor fornecedor;
	private Deposito deposito;
	private Integer codUsuario;
	private String txtObservacao;
	private String indEntrada;
	private Integer codClienteFinal;
	private List<EntradaEstoqueDto> listaEntradaEstoque;
	private float vlrTotal;
	
	public static EntradaDto build(Entrada entrada) {
		List<EntradaEstoqueDto> listarEntradaEstoqueDto = new ArrayList<EntradaEstoqueDto>();
		float vlrTotal =0;
		for (EntradaEstoque entradaEstoque : entrada.getListaEntradaEstoque()) {
			listarEntradaEstoqueDto.add(EntradaEstoqueDto.build(entradaEstoque));
			vlrTotal += entradaEstoque.getVlrUnitario()* entradaEstoque.getQtdEntrada();
		}
		
		EntradaDto entradaDto = new EntradaDto(
				entrada.getNroSequencial(), 
				entrada.getNroNotaFiscal(), 
				entrada.getDtaEntrada(), 
				entrada.getFornecedor(),
				entrada.getDeposito(),
				entrada.getCodUsuario(), 
				entrada.getTxtObservacao(), 
				entrada.getIndEntrada(), 
				entrada.getCodClienteFinal(),
				listarEntradaEstoqueDto,
				vlrTotal); 
				
				return entradaDto;
	}

	public static Entrada parse(EntradaDto entradaDto) {
		Entrada entrada = new Entrada();
		entrada.setNroSequencial(entradaDto.getNroSequencial());
		entrada.setNroNotaFiscal(entradaDto.getNroNotaFiscal());
		entrada.setDtaEntrada(entradaDto.getDtaEntrada());
		entrada.setCodUsuario(entradaDto.getCodUsuario());
		entrada.setTxtObservacao(entradaDto.getTxtObservacao());
		entrada.setIndEntrada(entradaDto.getIndEntrada());
		entrada.setCodClienteFinal(entradaDto.getCodClienteFinal());
		
		Fornecedor fornecedor= entradaDto.getFornecedor();
		entrada.setFornecedor(fornecedor);
		
		Deposito deposito= entradaDto.getDeposito();
		entrada.setDeposito(deposito);

		return entrada;
	}
}