package siscove.siscovejava.Perfil.Dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Perfil.Entity.Perfil;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PerfilDto {

	private Integer codPerfilW;
	private String dscPerfilW;
	private String indAtivo;

	public static PerfilDto build(Perfil perfil) {
		PerfilDto perfilDto = new PerfilDto(

				perfil.getCodPerfilW(), perfil.getDscPerfilW(), perfil.getIndAtivo());
		return perfilDto;
	}

}
