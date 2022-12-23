package siscove.siscovejava.Venda.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@Embeddable
public class VendaProdutoId implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name="COD_VENDA")
	private Integer codVenda;
	
	@Column(name="NRO_SEQUENCIAL")
	private Integer nroSequencial;
	
	@Column(name = "COD_PRODUTO")
	private Integer codProduto;
	
	
	
}
