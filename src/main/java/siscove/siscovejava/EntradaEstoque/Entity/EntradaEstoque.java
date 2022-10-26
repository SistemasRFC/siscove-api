package siscove.siscovejava.EntradaEstoque.Entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity(name = "EN_ENTRADA_ESTOQUE")

public class EntradaEstoque implements Serializable{


	@EmbeddedId
	public EntradaEstoqueId entradaEstoqueId;
	
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
