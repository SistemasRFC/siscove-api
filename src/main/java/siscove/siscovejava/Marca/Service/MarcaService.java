package siscove.siscovejava.Marca.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Marca.Dto.MarcaDto;
import siscove.siscovejava.Marca.Entity.Marca;
import siscove.siscovejava.Marca.Repository.MarcaDao;

@Service
public class MarcaService {

	@Autowired
	private MarcaDao marcaDao;

	public EnvelopeResponse<List<MarcaDto>> getListarMarcasAtivas() {
		List<Marca> listarMarcasAtivas = (List<Marca>) marcaDao.findAll();

		List<MarcaDto> listarMarcaDto = new ArrayList<MarcaDto>();
		for (Marca marca : listarMarcasAtivas) {
			if (marca.getIndAtiva().equals("S")) {
				listarMarcaDto.add(MarcaDto.build(marca));
			}
		}
		return new EnvelopeResponse<List<MarcaDto>>(listarMarcaDto);
	}
}
