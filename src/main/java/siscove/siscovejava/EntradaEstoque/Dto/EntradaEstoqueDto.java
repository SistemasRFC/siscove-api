package siscove.siscovejava.EntradaEstoque.Dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.EntradaEstoque.Entity.EntradaEstoque;
import siscove.siscovejava.EntradaEstoque.Entity.EntradaEstoqueId;
import siscove.siscovejava.Produto.Dto.ProdutoDto;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntradaEstoqueDto {

	private ProdutoDto produto;
	private Integer nroSequencial;
	private LocalDate dtaEntradaProduto;
	private Float qtdEntrada;
	private Float vlrUnitario;
	private Float vlrMinimo;
	private Float vlrVenda;

	public static EntradaEstoque parse(EntradaEstoqueDto entradaEstoqueDto) {
		EntradaEstoque entradaEstoque = new EntradaEstoque();
		
		EntradaEstoqueId entradaEstoqueId = new EntradaEstoqueId();
		entradaEstoqueId.setNroSequencial(entradaEstoqueDto.getNroSequencial());
		entradaEstoqueId.setProduto(ProdutoDto.parse( entradaEstoqueDto.getProduto()));
		
		entradaEstoque.setEntradaEstoqueId(entradaEstoqueId);

		entradaEstoque.setDtaEntradaProduto(entradaEstoqueDto.getDtaEntradaProduto());
		entradaEstoque.setQtdEntrada(entradaEstoqueDto.getQtdEntrada());
		entradaEstoque.setVlrUnitario(entradaEstoqueDto.getVlrUnitario());
		entradaEstoque.setVlrMinimo(entradaEstoqueDto.getVlrMinimo());
		entradaEstoque.setVlrVenda(entradaEstoqueDto.getVlrVenda());

		return entradaEstoque;
	}

	public static EntradaEstoqueDto build(EntradaEstoque entradaEstoque) {
		EntradaEstoqueDto entradaEstoqueDto = new EntradaEstoqueDto(
				ProdutoDto.build(entradaEstoque.getEntradaEstoqueId().getProduto()),
				entradaEstoque.getEntradaEstoqueId().getNroSequencial(), 
				entradaEstoque.getDtaEntradaProduto(),
				entradaEstoque.getQtdEntrada(), 
				entradaEstoque.getVlrUnitario(), 
				entradaEstoque.getVlrMinimo(),
				entradaEstoque.getVlrVenda());
		return entradaEstoqueDto;
	}
}