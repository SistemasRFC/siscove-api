package siscove.siscovejava.Entrada.Entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Deposito.Entity.Deposito;
import siscove.siscovejava.EntradaEstoque.Entity.EntradaEstoque;
import siscove.siscovejava.Fornecedor.Entity.Fornecedor;

@NoArgsConstructor
@Data
@Entity(name = "EN_ENTRADA")

public class Entrada {

	@Id
	@Column(name = "NRO_SEQUENCIAL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nroSequencial;

	@Column(name = "NRO_NOTA_FISCAL")
	private String nroNotaFiscal;

	@Column(name = "DTA_ENTRADA")
	private LocalDate dtaEntrada;

	@Column(name = "COD_USUARIO")
	private Integer codUsuario;

	@Column(name = "TXT_OBSERVACAO")
	private String txtObservacao;

	@Column(name = "IND_ENTRADA")
	private String indEntrada;

	@Column(name = "COD_CLIENTE_FINAL")
	private Integer codClienteFinal;

	@Column(name = "COD_FORNECEDOR")
	private Integer codFornecedor;
	
	@Column(name = "COD_DEPOSITO")
	private Integer codDeposito;
	
	@ManyToOne
	@JoinColumn(name="COD_FORNECEDOR", insertable = false, updatable = false)
	private Fornecedor fornecedor;
	
	@ManyToOne
	@JoinColumn(name="COD_DEPOSITO", insertable = false, updatable = false)
	private Deposito deposito;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="NRO_SEQUENCIAL", insertable = false, updatable = false)
	private List<EntradaEstoque> listaEntradaEstoque;
	
}