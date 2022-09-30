package siscove.siscovejava.Marca.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Marca.Dto.MarcaDto;
import siscove.siscovejava.Marca.Entity.Marca;
import siscove.siscovejava.Marca.Repository.MarcaDao;
import siscove.siscovejava.Token.Dto.TokenDto;
import siscove.siscovejava.Token.Service.TokenService;

@Service
public class MarcaService {

	@Autowired
	private MarcaDao marcaDao;
	
	@Autowired
	private TokenService tokenService;  

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

	public EnvelopeResponse<MarcaDto> findByCodMarca(Integer codMarca) {
		Marca marca = marcaDao.findByCodMarca(codMarca);
		if (null != marca) {
			return new EnvelopeResponse<MarcaDto>(MarcaDto.build(marca));

		}
		return new EnvelopeResponse<MarcaDto>(null);
	}

	public EnvelopeResponse<MarcaDto> getMarcaByCodigoMarca(Integer codigoMarca) {
		return new EnvelopeResponse<MarcaDto>(MarcaDto.build(marcaDao.findById(codigoMarca).get()));
	}

	public EnvelopeResponse<List<MarcaDto>> getListaMarca() {
		List<Marca> listaMarca = (List<Marca>) marcaDao.findAll();

		List<MarcaDto> listaMarcaDto = new ArrayList<MarcaDto>();
		for (Marca marca : listaMarca) {
			MarcaDto dto = MarcaDto.build(marca);
			listaMarcaDto.add(dto);
		}

		return new EnvelopeResponse<List<MarcaDto>>(listaMarcaDto);
	}

	public EnvelopeResponse<MarcaDto> salvar(MarcaDto marcaDto, String token) {
		TokenDto tokenDto = tokenService.getByToken(token).getObjeto();
		
		marcaDto.setCodClienteFinal(tokenDto.getCodClienteFinal())
		;
		Marca marca = marcaDao.save(MarcaDto.parse(marcaDto));

		marcaDto = MarcaDto.build(marca);

		return new EnvelopeResponse<MarcaDto>(marcaDto);
	}

}
