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
	
	@Column(name="COD_USUARIO")
	private Integer codUsurio;

}
