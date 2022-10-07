package siscove.siscovejava.Estoque.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity (name = "EN_ESTOQUE")

public class Estoque {
	
	@Id
	@Column(name="COD_PRODUTO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codProduto;
	
	@Column(name="NRO_SEQUENCIAL")
	private Integer nroSequencial;

	@Column(name="QTD_ESTOQUE")
	private String qtdEstoque;

}

