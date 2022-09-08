package siscove.siscovejava.CadastroProdutos.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity (name = "EN_PRODUTO")
public class CadastroProdutos {

	@Id
	@Column(name="COD_PRODUTO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codProduto;
	
	@Column(name="DSC_PRODUTO")
	private String dscProduto;
	
	@Column(name="VLR_PRODUTO")
	private Float vlrProduto;
	
	@Column(name="VLR_MINIMO")
	private Float vlrMinimo;
	
	@Column(name="TPO_PRODUTO")
	private String tpoProduto;
	
	@Column(name="COD_MARCA")
	private Integer codMarca;
	
	@Column(name="IND_ALINHAMENTO")
	private String indAlinhamento;
	
	@Column(name="COD_CLIENTE_FINAL")
	private Integer codClienteFinal;
	
	@Column(name="COD_TIPO_PRODUTO")
	private Integer codTipoProduto;

	@Column(name="NRO_ARO_PNEU")
	private Integer nroAroPneu;
	
	@Column(name="IND_ATIVO")
	private String indAtivo;
	
	@Column(name="VLR_PORCENTAGEM")
	private Float vlrPorcentagem;
	
	@Column(name="IND_TIPO_PRODUTO")
	private String indTipoProduto;

	@Column(name="IND_COMISSAO_GERENCIA")
	private String indComissaoGerencia;
	
	@Column(name="COD_CFOP")
	private Integer codCfop;
	
	@Column(name="COD_ICMS_ORIGEM")
	private Integer codIcmsOrigem;
	
	@Column(name="COD_NCM")
	private Integer codNcm;
	
	@Column(name="COD_ICMS_SITUACAO_TRIBUTARIA")
	private Integer codIcmsSituacaoTributaria;
	
	@Column(name="COD_PIS_SITUACAO_TRIBUTARIA")
	private Integer codPisSituacaoTributaria;
	
	@Column(name="COD_CONFINS_SITUACAO_TRIBUTARIA")
	private Integer codConfinsSituacaoTributaria;
}
