package siscove.siscovejava.Produto.Dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Produto.Entity.Produto;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoDto {

	private Integer codProduto;
	private String dscProduto;
	private Float vlrProduto;
	private Float vlrMinimo;
	private String indTipoProduto;
	private Integer codMarca;
	private String dscMarca;
	private Integer codClienteFinal;
	private Integer codTipoProduto;
	private Integer nroAroPneu;
	private String indAtivo;
	private String indSituacaoProduto;
	private String indComissaoGerencia;
	private String indTipoRegistro;

	public static ProdutoDto build(Produto produto) {
		ProdutoDto produtoDto = new ProdutoDto(
				produto.getCodProduto(), 
				produto.getDscProduto(),
				produto.getVlrMinimo(),
				produto.getVlrProduto(),
				produto.getIndTipoRegistro(),
				produto.getCodMarca(),
				produto.getDscProduto(),
				produto.getCodClienteFinal(),
				produto.getCodTipoProduto(),
				produto.getNroAroPneu(),
				produto.getIndAtivo(),
				produto.getIndSituacaoProduto(),
				produto.getIndComissaoGerencia(), 
				produto.getIndTipoRegistro());
				

		return produtoDto;
	}


	public static Produto parse(ProdutoDto produtoDto) {
		Produto produto = new Produto();
		produto.setCodProduto(produtoDto.getCodProduto());
		produto.setDscProduto(produtoDto.getDscProduto());
		produto.setIndAtivo(produtoDto.getIndAtivo());
		produto.setVlrProduto(produtoDto.getVlrProduto());
		produto.setVlrMinimo(produtoDto.getVlrMinimo());
		produto.setIndTipoRegistro(produtoDto.getIndTipoRegistro());
		produto.setCodMarca(produtoDto.getCodMarca());
		produto.setCodClienteFinal(produtoDto.getCodClienteFinal());
		produto.setIndAtivo(produtoDto.getIndAtivo());
		produto.setNroAroPneu(produtoDto.getNroAroPneu());
		produto.setIndComissaoGerencia(produtoDto.getIndComissaoGerencia());
		produto.setCodTipoProduto(produtoDto.getCodTipoProduto());
		produto.setIndSituacaoProduto(produtoDto.getIndSituacaoProduto());
		
		return produto;

	}
}
