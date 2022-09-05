package siscove.siscovejava.MenuPerfil.Dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.MenuPerfil.Entity.MenuPerfil;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenuPerfilDto {

	private Integer codMenuW;
	private Integer codPerfilW;
	
	public static MenuPerfilDto build(MenuPerfil menuperfil) {
		MenuPerfilDto menuperfilDto = new MenuPerfilDto(
				
				menuperfil.getCodMenuW(),
				menuperfil.getCodPerfilW());
				return menuperfilDto;
	
	}
}
