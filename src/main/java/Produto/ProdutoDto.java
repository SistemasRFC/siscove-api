package Produto;


import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoDto {
	
	private Integer codTipoProduto;
	private String dscTipoProduto;
	private Integer codClienteFinal;
	private String indAtivo;

	public static ProdutoDto build(Produto produto) {
		ProdutoDto produtoDto = new ProdutoDto(
				
				produto.getCodTipoProduto(),
				produto.getDscTipoProduto(),
				produto.getCodClienteFinal(),
				produto.getIndAtivo());
				return produtoDto;
	}
}