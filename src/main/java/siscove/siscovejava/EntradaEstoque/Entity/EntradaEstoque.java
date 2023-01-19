package siscove.siscovejava.EntradaEstoque.Entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Produto.Entity.Produto;

@NoArgsConstructor
@Data
@Entity(name = "EN_ENTRADA_ESTOQUE")

public class EntradaEstoque implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="COD_PRODUTO", insertable = false, updatable = false)
	private Produto produto;
}