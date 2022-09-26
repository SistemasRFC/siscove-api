package siscove.siscovejava.TipoPagamento.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity (name = "EN_TIPO_PAGAMENTO")
public class TipoPagamento {
	
	@Id
	@Column(name="COD_TIPO_PAGAMENTO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codTipoPagamento;
	
	@Column(name="DSC_TIPO_PRODUTO")
	private String dscTipoPagamento;
	
	@Column(name="VLR_PORCENTAGEM")
	private Float vlrPorcentagem;
	
	@Column(name="IND_ATIVO")
	private String indAtivo;

}
