package TipoProduto.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity (name = "EN_TIPO_PRODUTO")
public class TipoProduto {
	
	@Id
	@Column(name="COD_TIPO_PRODUTO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codTipoProduto;
	
	@Column(name="DSC_TIPO_PRODUTO")
	private String dscTipoProduto;
	
	@Column(name="COD_CLIENTE_FINAL")
	private String codClienteFinal;
	
	@Column(name="IND_ATIVO")
	private String indAtivo;

}
