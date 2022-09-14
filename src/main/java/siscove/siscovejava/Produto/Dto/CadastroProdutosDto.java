package siscove.siscovejava.Produto.Dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Produto.Entity.CadastroProdutos;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CadastroProdutosDto {

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

	public static CadastroProdutosDto build(CadastroProdutos cadastroprodutos) {
		CadastroProdutosDto cadastroprodutosDto = new CadastroProdutosDto(cadastroprodutos.getCodProduto(),
				cadastroprodutos.getDscProduto(), cadastroprodutos.getIndAtivo());
		return cadastroprodutosDto;
	}

	public CadastroProdutosDto(Integer codProduto2, String dscProduto2, String indAtivo2) {
		this.codProduto=codProduto2;
		this.dscProduto=dscProduto2;
		this.indAtivo=indAtivo2;
		
	}
}
