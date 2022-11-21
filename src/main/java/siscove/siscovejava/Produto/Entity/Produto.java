package siscove.siscovejava.Produto.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Marca.Entity.Marca;

@NoArgsConstructor
@Data
@Entity (name = "EN_PRODUTO")
public class Produto {

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

	@Column(name="IND_TIPO_REGISTRO")
	private String indTipoRegistro;
	
	@Column(name="COD_MARCA")
	private Integer codMarca;
	
	@ManyToOne
	@JoinColumn(name="COD_MARCA", insertable = false, updatable = false)
	private Marca marca;
	
	@Column(name="COD_CLIENTE_FINAL")
	private Integer codClienteFinal;
	
	@Column(name="COD_TIPO_PRODUTO")
	private Integer codTipoProduto;

	@Column(name="NRO_ARO_PNEU")
	private Integer nroAroPneu;
	
	@Column(name="IND_ATIVO")
	private String indAtivo;
	
	@Column(name="IND_SITUACAO_PRODUTO")
	private String indSituacaoProduto;
	
	@Column(name="IND_COMISSAO_GERENCIA")
	private String indComissaoGerencia;}
