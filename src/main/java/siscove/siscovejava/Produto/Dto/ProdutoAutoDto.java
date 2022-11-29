package siscove.siscovejava.Produto.Dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoAutoDto {

	private Integer codProduto;
	
	private Integer nroSequencial;
	
	private String dscProduto;
	
	private Float vlrVenda;
	
	private Integer qtdEstoque;
	
}
