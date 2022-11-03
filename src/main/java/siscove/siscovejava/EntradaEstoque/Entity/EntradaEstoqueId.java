package siscove.siscovejava.EntradaEstoque.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Produto.Entity.Produto;

@NoArgsConstructor
@Data
@Embeddable
public class EntradaEstoqueId implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "NRO_SEQUENCIAL")
	private Integer nroSequencial;

	@ManyToOne
	@JoinColumn(name="COD_PRODUTO", insertable = true, updatable = true)
	private Produto produto;

}

