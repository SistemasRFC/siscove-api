package siscove.siscovejava.EntradaEstoque.Entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Produto.Entity.Produto;

@NoArgsConstructor
@Data
@Embeddable
public class EntradaEstoqueId {


	@Column(name = "NRO_SEQUENCIAL")
	private Integer nroSequencial;

	@Column(name="COD_PRODUTO")
	private Produto produto;

}

