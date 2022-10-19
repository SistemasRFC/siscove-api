package siscove.siscovejava.EntradaEstoque.Dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.EntradaEstoque.Entity.EntradaEstoque;
import siscove.siscovejava.Produto.Entity.Produto;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntradaEstoqueDto {

	private Produto produto;
	private Integer nroSequencial;
	private LocalDate dtaEntradaProduto;
	private Float qtdEntrada;
	private Float vlrUnitario;
	private Float vlrMinimo;
	private Float vlrVenda;

	public static EntradaEstoque parse(EntradaEstoqueDto entradaEstoqueDto) {
		EntradaEstoque entradaEstoque = new EntradaEstoque();
		
		entradaEstoque.setNroSequencial(entradaEstoqueDto.getNroSequencial());
		entradaEstoque.setDtaEntradaProduto(entradaEstoqueDto.getDtaEntradaProduto());
		entradaEstoque.setQtdEntrada(entradaEstoqueDto.getQtdEntrada());
		entradaEstoque.setVlrUnitario(entradaEstoqueDto.getVlrUnitario());
		entradaEstoque.setVlrMinimo(entradaEstoqueDto.getVlrMinimo());
		entradaEstoque.setVlrVenda(entradaEstoqueDto.getVlrVenda());
		
		Produto produto= entradaEstoqueDto.getProduto();
		entradaEstoque.setProduto(produto);

		return entradaEstoque;
	}

	public static EntradaEstoqueDto build(EntradaEstoque entradaEstoque) {
		EntradaEstoqueDto entradaEstoqueDto = new EntradaEstoqueDto(
		entradaEstoque.getProduto(), 
		entradaEstoque.getNroSequencial(),
		entradaEstoque.getDtaEntradaProduto(),
		entradaEstoque.getQtdEntrada(),
		entradaEstoque.getVlrUnitario(),
		entradaEstoque.getVlrMinimo(),
		entradaEstoque.getVlrVenda());
		return entradaEstoqueDto;
	}
}
