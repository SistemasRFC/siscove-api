package siscove.siscovejava.Produto.Dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Marca.Dto.MarcaDto;
import siscove.siscovejava.Produto.Entity.Produto;
import siscove.siscovejava.TipoProduto.Dto.TipoProdutoDto;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoDto {

	private Integer codProduto;
	private String dscProduto;
	private Float vlrProduto;
	private Float vlrMinimo;
	private String indTipoRegistro;
	private Integer codMarca;
	private MarcaDto marca;
	private Integer codClienteFinal;
	private Integer codTipoProduto;
	private TipoProdutoDto tipoProduto;
	private Integer nroAroPneu;
	private String indAtivo;
	private String indSituacaoProduto;
	private String indComissaoGerencia;

	public static ProdutoDto build(Produto produto) {
		ProdutoDto produtoDto = new ProdutoDto();
		if(produto.getCodProduto() != null && !produto.getCodProduto().equals(0)) {
			produtoDto.setCodProduto(produto.getCodProduto());
		}
		produtoDto.setDscProduto(produto.getDscProduto());
		produtoDto.setVlrProduto(produto.getVlrProduto());
		produtoDto.setVlrMinimo(produto.getVlrMinimo());
		produtoDto.setIndTipoRegistro(produto.getIndTipoRegistro());
		produtoDto.setCodMarca(produto.getCodMarca());
		if(produto.getMarca() != null && !produto.getMarca().getCodMarca().equals(0)) {
			produtoDto.setMarca(MarcaDto.build(produto.getMarca()));			
		}
		produtoDto.setCodClienteFinal(produto.getCodClienteFinal());
		produtoDto.setCodTipoProduto(produto.getCodTipoProduto());
		if(produto.getTipoProduto() != null && !produto.getTipoProduto().getCodTipoProduto().equals(0)) {
			produtoDto.setTipoProduto(TipoProdutoDto.build(produto.getTipoProduto()));
		}
		produtoDto.setNroAroPneu(produto.getNroAroPneu());
		produtoDto.setIndAtivo(produto.getIndAtivo());
		produtoDto.setIndSituacaoProduto(produto.getIndSituacaoProduto());
		produtoDto.setIndComissaoGerencia(produto.getIndComissaoGerencia());
				

		return produtoDto;
	}


	public static Produto parse(ProdutoDto produtoDto) {
		Produto produto = new Produto();
		produto.setCodProduto(produtoDto.getCodProduto());
		produto.setDscProduto(produtoDto.getDscProduto());
		produto.setVlrProduto(produtoDto.getVlrProduto());
		produto.setVlrMinimo(produtoDto.getVlrMinimo());
		produto.setIndTipoRegistro(produtoDto.getIndTipoRegistro());
		produto.setCodMarca(produtoDto.getCodMarca());
		produto.setCodClienteFinal(produtoDto.getCodClienteFinal());
		produto.setCodTipoProduto(produtoDto.getCodTipoProduto());
		produto.setNroAroPneu(produtoDto.getNroAroPneu());
		produto.setIndAtivo(produtoDto.getIndAtivo());
		produto.setIndSituacaoProduto(produtoDto.getIndSituacaoProduto());
		produto.setIndComissaoGerencia(produtoDto.getIndComissaoGerencia());
		
		return produto;

	}
}
