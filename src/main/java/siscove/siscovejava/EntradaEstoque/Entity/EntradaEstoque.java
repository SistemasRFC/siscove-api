package siscove.siscovejava.EntradaEstoque.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity(name = "EN_ENTRADA_ESTOQUE")

public class EntradaEstoque {


	@Id
	@Column(name = "NRO_SEQUENCIAL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nroSequencial;

	@Column(name = "COD_PRODUTO")
	private Integer codProduto;

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
