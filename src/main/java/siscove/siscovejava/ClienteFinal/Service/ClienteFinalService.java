package siscove.siscovejava.ClienteFinal.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.ClienteFinal.Dao.ClienteFinalDao;
import siscove.siscovejava.ClienteFinal.Dto.ClienteFinalDto;
import siscove.siscovejava.ClienteFinal.Entity.ClienteFinal;
import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Token.Dto.TokenDto;
import siscove.siscovejava.Token.Service.TokenService;

@Service
public class ClienteFinalService {

	@Autowired
	private ClienteFinalDao clienteFinalDao;
	
	@Autowired
	private TokenService tokenService;  

	public EnvelopeResponse<List<ClienteFinalDto>> getListarClienteFinalAtivo s()   {
		List<ClienteFinal> listarClienteFinalAtivas = (List<ClienteFinal>) clienteFinalDao.findAll();

		List<ClienteFinalDto> listarClienteFinalDto = new ArrayList<ClienteFinalDto>();
		for (ClienteFinal clienteFinal : listarClienteFinalAtivos) {
			if (clienteFinal.getIndAtivo().equals("S")) {
				listarClienteFinalDto.add(ClienteFinalDto.build(clienteFinal));
			}
		}
		return new EnvelopeResponse<List<ClienteFinalDto>>(listarClienteFinalDto);
	}

	public EnvelopeResponse<ClienteFinalDto> findByCodClienteFinal(Integer codClienteFinal) {
		ClienteFinal clienteFinal = clienteFinalDao.findByCodClienteFinal(codClienteFinal);
		if (null != clienteFinal) {
			return new EnvelopeResponse<ClienteFinalDto>(ClienteFinalDto.build(clienteFinal));

		}
		return new EnvelopeResponse<ClienteFinalDto>(null);
	}

	public EnvelopeResponse<ClienteFinalDto> getClienteFinalByCodigoClienteFinal(Integer codigoClienteFinal) {
		return new EnvelopeResponse<ClienteFinalDto>(ClienteFinalDto.build(clienteFinalDao.findById(codigoClienteFinal).get()));
	}

	public EnvelopeResponse<List<ClienteFinalDto>> getListaClienteFinal() {
		List<ClienteFinal> listaClienteFinal = (List<ClienteFinal>) clienteFinalDao.findAll();

		List<ClienteFinalDto> listaClienteFinalDto = new ArrayList<ClienteFinalDto>();
		for (ClienteFinal clienteFinal : listaClienteFinal) {
			 dto = ClienteFinalDto.build(clienteFinal);
			listaClienteFinalDto.add(dto);
		}

		return new EnvelopeResponse<List<ClienteFinalDto>>(listaClienteFinalDto);
	}

	public EnvelopeResponse<ClienteFinalDto> salvar(ClienteFinalDto clienteFinalDto, String token) {
		TokenDto tokenDto = tokenService.getByToken(token).getObjeto();
		
		clienteFinalDto.setCodClienteFinal(tokenDto.getCodClienteFinal());
		
		ClienteFinal clienteFinal = clienteFinalDao.save(ClienteFinalDto.parse(clienteFinalDto));

		clienteFinalDto = ClienteFinalDto.build(clienteFinal);

		return new EnvelopeResponse<ClienteFinalDto>(clienteFinalDto);
	}

}


	