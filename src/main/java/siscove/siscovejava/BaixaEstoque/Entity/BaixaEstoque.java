package siscove.siscovejava.BaixaEstoque.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity (name = "EN_BAIXA_ESTOQUE")
public class BaixaEstoque {
	
	@Id
	@Column(name="NRO_SEQUENCIAL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nroSequencial;
	
	@Column(name="COD_PRODUTO")
	private Integer codProduto;
	
	@Column(name="DTA_BAIXA")
	private Date dtaBaixa;

	@Column(name="QTD_BAIXA")
	private Integer qtdBaixa;
	
	@Column(name="TXT_BAIXA")
	private String txtBaixa;
	

}
