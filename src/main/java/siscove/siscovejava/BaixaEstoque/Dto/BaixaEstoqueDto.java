package siscove.siscovejava.BaixaEstoque.Dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.BaixaEstoque.Entity.BaixaEstoque;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaixaEstoqueDto {

	private 	Integer 	nroSequencial;
	private 	Integer 	codProduto;
	private 	Date 		dtaBaixa;
	private 	Integer 	qtdBaixa;
	private 	String 		txtBaixa;


	public static BaixaEstoqueDto build(BaixaEstoque baixaEstoque) {
		BaixaEstoqueDto baixaEstoqueDto = new BaixaEstoqueDto(
		baixaEstoque.getNroSequencial(), 
		baixaEstoque.getCodProduto(),
		baixaEstoque.getDtaBaixa(),
		baixaEstoque.getQtdBaixa(),
		baixaEstoque.getTxtBaixa());
		return	baixaEstoqueDto;
		
	}
}
