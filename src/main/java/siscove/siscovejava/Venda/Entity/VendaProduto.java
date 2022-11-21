package siscove.siscovejava.Venda.Entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Produto.Entity.Produto;
import siscove.siscovejava.Usuario.Entity.Usuario;

@NoArgsConstructor
@Data
@Entity (name = "RE_VENDA_PRODUTO")
public class VendaProduto {
	
	@EmbeddedId
	private VendaProdutoId id;
	
	@ManyToOne
	@JoinColumn(name="COD_PRODUTO", insertable = false, updatable = false)
	private Produto produto;
	
	@Column(name="VLR_VENDA")
	private Float vlrVenda;
	
	@Column(name="QTD_VENDIDA")
	private Integer qtdVendida;
	
	@Column(name="VLR_DESCONTO")
	private Float vlrDesconto;
	
	@Column(name="COD_FUNCIONARIO")
	private Integer codFuncionario;
	
	@ManyToOne
	@JoinColumn(name="COD_FUNCIONARIO", insertable = false, updatable = false)
	private Usuario funcionario;
	
	@Column(name="IND_ESTOQUE")
	private String indEstoque;
	
	@Column(name="DTA_VENDA_PRODUTO")
	private LocalDateTime dtaVendaProduto;
	
	@Column(name="TXT_OBSERVACAO")
	private Integer txtObservacao;
	
	

}
