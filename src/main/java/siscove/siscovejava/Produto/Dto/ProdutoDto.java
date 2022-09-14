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
	private String tpoProduto;
	private Integer codMarca;
	private String dscMarca;
	private String indAlinhamento;
	private Integer codClienteFinal;
	private Integer codTipoFinal;
	private Integer codTipoProduto;
	private Integer codNroAroPneu;
	private String indAtivo;
	private Float vlrPorcentagem;
	private String indTipoProduto;
	private String indComissaoGerencia;
	private Integer codCfop;
	private Integer codIcmsOrigem;
	private Integer codNcm;
	private Integer codIcmsSituacaoTributaria;
	private Integer codPisSituacaoTribuataria;
	private Integer codCofinsSituacaoTributaria;

	public static ProdutoDto build(Produto produto) {
		ProdutoDto produtoDto = new ProdutoDto(produto.getCodProduto(),
				produto.getDscProduto(), produto.getIndAtivo());
		return produtoDto;
	}

	public ProdutoDto(Integer codProduto, String dscProduto, String indAtivo) {
		this.codProduto=codProduto;
		this.dscProduto=dscProduto;
		this.indAtivo=indAtivo;
		
	}
}
