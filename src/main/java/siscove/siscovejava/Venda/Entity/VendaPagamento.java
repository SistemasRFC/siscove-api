package siscove.siscovejava.Venda.Entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity (name = "EN_VENDA_PAGAMENTO")
public class VendaPagamento {
	
	@Id
	@Column(name="NRO_SEQUENCIAL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nroSequencial;
	
	@Column(name="COD_VENDA")
	private Integer codVenda;
	
	@Column(name="DTA_PAGAMENTO")
	private LocalDateTime dtaPagamento;
	
	@Column(name="VALOR_PAGAMENTO")
	private Float valorPagamento;
	
	@Column(name="NRO_CHEQUE")
	private Integer nroCheque;
	
	@Column(name="NRO_BANCO")
	private Integer nroBanco;
	
	@Column(name="NME_PROPRIETARIO")
	private String nmeProprietario;
	
	@Column(name="COD_TIPO_PAGAMETO")
	private Integer codTipoPagamento;
	
	@Column(name="DSC_MERCADORIA")
	private String dscMercadoria;
	
	@Column(name="NRO_SEQUEMCIAL_ENTRADA")
	private Integer nroSequencialEntrada;
	
	@Column(name="DTA_REGISTRO")
	private LocalDateTime txtObservacao;
	
	@Column(name="COD_USUARIO")
	private Integer codUsuario;

}
