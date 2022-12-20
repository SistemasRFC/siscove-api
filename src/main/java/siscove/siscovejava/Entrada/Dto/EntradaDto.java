package siscove.siscovejava.Entrada.Dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Deposito.Dto.DepositoDto;
import siscove.siscovejava.Entrada.Entity.Entrada;
import siscove.siscovejava.EntradaEstoque.Dto.EntradaEstoqueDto;
import siscove.siscovejava.EntradaEstoque.Entity.EntradaEstoque;
import siscove.siscovejava.Fornecedor.Dto.FornecedorDto;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntradaDto {

	private Integer nroSequencial;
	private String nroNotaFiscal;
	private LocalDate dtaEntrada;
	private FornecedorDto fornecedorDto;
	private DepositoDto depositoDto;
	private Integer codUsuario;
	private String txtObservacao;
	private String indEntrada;
	private Integer codClienteFinal;
	private Float vlrProduto;
	private Float vlrVenda;
	private Float vlrMinimo;
	private Float vlrUnitario;
	private List<EntradaEstoqueDto> listaEntradaEstoque;
	private float vlrTotal;

	

	public static EntradaDto build(Entrada entrada) {
		List<EntradaEstoqueDto> listarEntradaEstoqueDto = new ArrayList<EntradaEstoqueDto>();
		float vlrTotal = 0;
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
		FornecedorDto fornecedorDto = new FornecedorDto();
		if (null != entrada.getFornecedor()) {
			fornecedorDto = FornecedorDto.build(entrada.getFornecedor());
		}
		DepositoDto depositoDto = new DepositoDto();
		if (null != entrada.getDeposito()) {
			depositoDto = DepositoDto.build(entrada.getDeposito());
		}

		EntradaDto entradaDto = new EntradaDto(entrada.getNroSequencial(), entrada.getNroNotaFiscal(),
				entrada.getDtaEntrada(), fornecedorDto, depositoDto, entrada.getCodUsuario(),
				entrada.getTxtObservacao(), indEntrada, entrada.getCodClienteFinal(), listarEntradaEstoqueDto,
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

		if (null != entradaDto.getDepositoDto()) {
			entrada.setCodDeposito(entradaDto.getDepositoDto().getCodDeposito());
		}
		if (null != entradaDto.getFornecedorDto()) {
			entrada.setCodFornecedor(entradaDto.getFornecedorDto().getCodFornecedor());
		}
		return entrada;
	}
}