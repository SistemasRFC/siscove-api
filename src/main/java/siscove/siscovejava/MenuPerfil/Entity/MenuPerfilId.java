package siscove.siscovejava.MenuPerfil.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Embeddable
public class MenuPerfilId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="COD_PERFIL_W")
	private Integer codPerfilW;
	
	@Column(name="COD_MENU_W")
	private Integer codMenuW;
	
}

