package siscove.siscovejava.Venda.Entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Cliente.Entity.Cliente;
import siscove.siscovejava.Usuario.Entity.Usuario;

@NoArgsConstructor
@Data
@Entity (name = "EN_VENDA")
public class Venda {
	
	@Id
	@Column(name="COD_VENDA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codVenda;
	
	@Column(name="DTA_VENDA")
	private LocalDateTime dtaVenda;
	
	@Column(name="NRO_STATUS_VENDA")
	private String nroStatusVenda;

	@Column(name="COD_CLIENTE")
	private Integer codCliente;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="COD_CLIENTE", insertable = false, updatable = false)
	private Cliente cliente;
	
	@Column(name="COD_USUARIO")
	private Integer codVendedor;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="COD_USUARIO", insertable = false, updatable = false)
	private Usuario vendedor;
	
	@Column(name="VLR_DESCONTO")
	private Float vlrDesconto;
	
	@Column(name="DSC_VEICULO")
	private String dscVeiculo;
	
	@Column(name="NRO_PLACA")
	private String nroPlaca;
	
	@Column(name="DTA_FECHAMENTO")
	private LocalDateTime dtaFechamento;
	
	@Column(name="COD_VEICULO")
	private Integer codVeiculo;
	
	@Column(name="TXT_OBSERVACAO")
	private String txtObservacao;
	
	@Column(name="TXT_JUSTIFICATIVA")
	private String txtJustificativa;
	
	@Column(name="COD_CLIENTE_FINAL")
	private Integer codClienteFinal;
	
	@Column(name="VLR_IMPOSTO_PRODUTO")
	private Float vlrImpostoProduto;
	
	@Column(name="VLR_IMPOSTO_SERVICO")
	private Float vlrImpostoServico;
	
	@Column(name="VLR_KM_RODADO")
	private Integer vlrKmRodado;
	
	@Column(name="COD_USUARIO_FECHAMENTO")
	private Integer codUsuarioFechamento;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="COD_VENDA", insertable = true, updatable = true)
	private VendaPagamento vendaPagamento;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="COD_VENDA", insertable = true, updatable = true)
	private VendaProduto vendaProduto;
}

