package siscove.siscovejava.MenuPerfil.Dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VincularPerfilDto {

	private Integer listaMenus;
	private Integer codPerfilW;
	

}