package siscove.siscovejava.CadastroProdutos.Dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CadastroProdutosDto {
	private Integer codProduto;
	private String dsc_Produto;
	private Float vlrProduto;
	private Float vlrMinimo;
	private String tpoProduto;
	private Integer codMarca;
	private String indAlinhamento;
	private Integer codClienteFinal;	
	private Integer codTipoFinal;
	private Integer codAroPneu;
	private String indAtivo;
	private Float vlrPorcentagem;
	private	String indTipoProduto;
	private String indComissaoGerencia;
	private Integer codCfop;
	private Integer codIcmsOrigem;
	private Integer codNcm;
	private Integer codIcmsSituacaoTributaria;
	private Integer codPisSituacaoTribuataria;
	private Integer codConfinsSituacaoTributaria; 
	
}
