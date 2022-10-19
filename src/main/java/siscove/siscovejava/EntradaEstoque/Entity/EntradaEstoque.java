package siscove.siscovejava.EntradaEstoque.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Produto.Entity.Produto;

@NoArgsConstructor
@Data
@Entity(name = "EN_ENTRADA_ESTOQUE")

public class EntradaEstoque {


	@Id
	@Column(name = "NRO_SEQUENCIAL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nroSequencial;

	@ManyToOne
	@JoinColumn(name="COD_PRODUTO", insertable = true, updatable = true)
	private Produto produto;
	
	@Column(name = "DTA_ENTRADA_PRODUTO")
	private LocalDate dtaEntradaProduto;

	@Column(name = "QTD_ENTRADA")
	private Float qtdEntrada;

	@Column(name = "VLR_UNITARIO")
	private Float vlrUnitario;

	@Column(name = "VLR_MINIMO")
	private Float vlrMinimo;

	@Column(name = "VLR_VENDA")
	private Float vlrVenda;

}
