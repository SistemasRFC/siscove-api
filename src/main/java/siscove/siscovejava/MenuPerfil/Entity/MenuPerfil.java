package siscove.siscovejava.MenuPerfil.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity (name = "SE_MENU_PERFIL")
public class MenuPerfil {

	@Id
	@Column(name="COD_PERFIL_W")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codPerfilW;
	
	@Column(name="COD_MENU_W")
	private Integer codMenuW;
	
}

