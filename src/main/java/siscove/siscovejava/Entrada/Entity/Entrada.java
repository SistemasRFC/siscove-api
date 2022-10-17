package siscove.siscovejava.Entrada.Entity;

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
import siscove.siscovejava.Deposito.Entity.Deposito;
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
	
	@ManyToOne
	@JoinColumn(name="COD_FORNECEDOR", insertable = true, updatable = true)
	private Fornecedor fornecedor;
	
	@ManyToOne
	@JoinColumn(name="COD_DEPOSITO", insertable = true, updatable = true)
	private Deposito deposito;
}