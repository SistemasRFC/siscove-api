package siscove.siscovejava.EntradaEstoque.Dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.EntradaEstoque.Entity.EntradaEstoque;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntradaEstoqueDto {

	private Integer codProduto;
	private Integer nroSequencial;
	private LocalDate dtaEntradaProduto;
	private Float qtdEntrada;
	private Float vlrUnitario;
	private Float vlrMinimo;
	private Float vlrVenda;

	public static EntradaEstoque parse(EntradaEstoqueDto entradaEstoqueDto) {
		EntradaEstoque entradaEstoque = new EntradaEstoque();
		entradaEstoque.setCodProduto(entradaEstoqueDto.getCodProduto());
		entradaEstoque.setNroSequencial(entradaEstoqueDto.getNroSequencial());
		entradaEstoque.setDtaEntradaProduto(entradaEstoqueDto.getDtaEntradaProduto());
		entradaEstoque.setQtdEntrada(entradaEstoqueDto.getQtdEntrada());
		entradaEstoque.setVlrUnitario(entradaEstoqueDto.getVlrUnitario());
		entradaEstoque.setVlrMinimo(entradaEstoqueDto.getVlrMinimo());
		entradaEstoque.setVlrVenda(entradaEstoqueDto.getVlrVenda());
		return entradaEstoque;
	}

	public static EntradaEstoqueDto build(EntradaEstoque entradaEstoque) {
		EntradaEstoqueDto entradaEstoqueDto = new EntradaEstoqueDto(
		entradaEstoque.getCodProduto(), 
		entradaEstoque.getNroSequencial(),
		entradaEstoque.getDtaEntradaProduto(),
		entradaEstoque.getQtdEntrada(),
		entradaEstoque.getVlrUnitario(),
		entradaEstoque.getVlrMinimo(),
		entradaEstoque.getVlrVenda());
		return entradaEstoqueDto;
	}
}
