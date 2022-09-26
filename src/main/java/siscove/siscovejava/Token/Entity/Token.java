package siscove.siscovejava.Token.Entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.ClienteFinal.Entity.ClienteFinal;
import siscove.siscovejava.Usuario.Entity.Usuario;

@NoArgsConstructor
@Data
@Entity (name = "SE_TOKEN")
public class Token{

	@Id
	@Column(name="COD_TOKEN")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codToken;

	@Column(name="DTA_TOKEN")
	private LocalDateTime dtaToken;
	
	@Column(name="TXT_TOKEN")
	private String txtToken;
	
	@ManyToOne
	@JoinColumn(name="COD_USUARIO", insertable = true, updatable = true)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="COD_CLIENTE_FINAL", insertable = true, updatable = true)
	private ClienteFinal clienteFinal;
	

}