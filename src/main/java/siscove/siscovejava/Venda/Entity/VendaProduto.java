package siscove.siscovejava.Venda.Entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity (name = "RE_VENDA_PRODUTO")
public class VendaProduto {
	
	@Id
	@Column(name="COD_VENDA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codVenda;
	
	@Column(name="NRO_SEQUENCIAL")
	private Integer nroSequencial;
	
	@Column(name="COD_PRODUTO")
	private Integer codProduto;
	
	@Column(name="VLR_VENDA")
	private Float vlrVenda;
	
	@Column(name="QTD_VENDIDA")
	private Integer qtdVendida;
	
	@Column(name="VLR_DESCONTO")
	private Float vlrDesconto;
	
	@Column(name="COD_FUNCIONARIO")
	private Integer codFuncionario;
	
	@Column(name="IND_ESTOQUE")
	private String indEstoque;
	
	@Column(name="DTA_VENDA_PRODUTO")
	private LocalDateTime dtaVendaProduto;
	
	@Column(name="TXT_OBSERVACAO")
	private Integer txtObservacao;
	
	

}
