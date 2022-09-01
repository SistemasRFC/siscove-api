package siscove.siscovejava.Perfil.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Perfil.Dto.PerfilDto;
import siscove.siscovejava.Perfil.Entity.Perfil;
import siscove.siscovejava.Perfil.Repository.PerfilDao;

@Service
public class PerfilService {

	@Autowired
	private PerfilDao perfilDao;

	public EnvelopeResponse<List<PerfilDto>> getListaPerfil() {
		List<Perfil> listaPerfil = (List<Perfil>) perfilDao.findAll();

		List<PerfilDto> listaPerfilDto = new ArrayList<PerfilDto>();
		for (Perfil perfil : listaPerfil) {
			if (perfil.getIndAtivo().equals("S")) {
				listaPerfilDto.add(PerfilDto.build(perfil));
			}
		}
		return new EnvelopeResponse<List<PerfilDto>>(listaPerfilDto);
	}

	public EnvelopeResponse<PerfilDto> salvar(PerfilDto perfilDto) {
Perfil perfil = perfilDao.save(PerfilDto.parse(perfilDto));
		
		perfilDto = PerfilDto.build(perfil);


		return new EnvelopeResponse<PerfilDto>(perfilDto);
	}
	
}