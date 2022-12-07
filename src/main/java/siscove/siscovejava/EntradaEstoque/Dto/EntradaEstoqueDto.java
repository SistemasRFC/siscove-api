package siscove.siscovejava.EntradaEstoque.Dto;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.EntradaEstoque.Entity.EntradaEstoque;
import siscove.siscovejava.EntradaEstoque.Entity.EntradaEstoqueId;
import siscove.siscovejava.Produto.Dto.ProdutoDto;
import siscove.siscovejava.Produto.Entity.Produto;

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
		
		Produto produto = new Produto();
		
		if (null!=entradaEstoqueDto.getProduto()) {
			produto = ProdutoDto.parse(entradaEstoqueDto.getProduto());
		}
		entradaEstoqueId.setProduto(produto);
		
		entradaEstoque.setEntradaEstoqueId(entradaEstoqueId);

		LocalDate dtaEntradaProduto = LocalDate.now();
		
		if (null!=entradaEstoqueDto.getDtaEntradaProduto()) {
			dtaEntradaProduto = entradaEstoqueDto.getDtaEntradaProduto();
		}
		
		entradaEstoque.setDtaEntradaProduto(dtaEntradaProduto);
		entradaEstoque.setQtdEntrada(entradaEstoqueDto.getQtdEntrada());
		entradaEstoque.setVlrUnitario(entradaEstoqueDto.getVlrUnitario());
		entradaEstoque.setVlrMinimo(entradaEstoqueDto.getVlrMinimo());
		entradaEstoque.setVlrVenda(entradaEstoqueDto.getVlrVenda());

		return entradaEstoque;
	}

	public static EntradaEstoqueDto build(EntradaEstoque entradaEstoque) {
		ProdutoDto produtoDto = new ProdutoDto();
		Integer nroSequencial = null;
		if (null!=entradaEstoque.getEntradaEstoqueId()) {
			produtoDto = ProdutoDto.build(entradaEstoque.getEntradaEstoqueId().getProduto());
			nroSequencial = entradaEstoque.getEntradaEstoqueId().getNroSequencial();
		}
		EntradaEstoqueDto entradaEstoqueDto = new EntradaEstoqueDto(
				produtoDto,
				nroSequencial, 
				entradaEstoque.getDtaEntradaProduto(),
				entradaEstoque.getQtdEntrada(), 
				entradaEstoque.getVlrUnitario(), 
				entradaEstoque.getVlrMinimo(),
				entradaEstoque.getVlrVenda());
		return entradaEstoqueDto;
	}
}