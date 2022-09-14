package siscove.siscovejava.MenuPerfil.Entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity (name = "SE_MENU_PERFIL")
public class MenuPerfil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private MenuPerfilId menuPerfilId;
	
}

