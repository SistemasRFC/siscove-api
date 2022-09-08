package siscove.siscovejava.MenuPerfil.Dto;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VincularPerfilDto {

	private List<Integer> listaMenus;
	private Integer codPerfilW;

}