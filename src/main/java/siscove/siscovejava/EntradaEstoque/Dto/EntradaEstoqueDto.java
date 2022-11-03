package siscove.siscovejava.EntradaEstoque.Dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.EntradaEstoque.Entity.EntradaEstoque;
import siscove.siscovejava.EntradaEstoque.Entity.EntradaEstoqueId;
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
		
		EntradaEstoqueId id = new EntradaEstoqueId();
		id.setNroSequencial(entradaEstoqueDto.getNroSequencial());
		
		entradaEstoque.setEntradaEstoqueId(id);
		entradaEstoque.setDtaEntradaProduto(entradaEstoqueDto.getDtaEntradaProduto());
		entradaEstoque.setQtdEntrada(entradaEstoqueDto.getQtdEntrada());
		entradaEstoque.setVlrUnitario(entradaEstoqueDto.getVlrUnitario());
		entradaEstoque.setVlrMinimo(entradaEstoqueDto.getVlrMinimo());
		entradaEstoque.setVlrVenda(entradaEstoqueDto.getVlrVenda());
		
		Produto produto= entradaEstoqueDto.getProduto();
		entradaEstoque.entradaEstoqueId.setProduto(produto);

		return entradaEstoque;
	}

	public static EntradaEstoqueDto build(EntradaEstoque entradaEstoque) {
		EntradaEstoqueDto entradaEstoqueDto = new EntradaEstoqueDto(
		entradaEstoque.getEntradaEstoqueId().getProduto(), 
		entradaEstoque.getEntradaEstoqueId().getNroSequencial(),
		entradaEstoque.getDtaEntradaProduto(),
		entradaEstoque.getQtdEntrada(),
		entradaEstoque.getVlrUnitario(),
		entradaEstoque.getVlrMinimo(),
		entradaEstoque.getVlrVenda());
		return entradaEstoqueDto;
	}
}
