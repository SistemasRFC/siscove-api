package siscove.siscovejava.ClienteFinal.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.ClienteFinal.Dao.ClienteFinalDao;
import siscove.siscovejava.ClienteFinal.Dto.ClienteFinalDto;
import siscove.siscovejava.ClienteFinal.Entity.ClienteFinal;
import siscove.siscovejava.Config.response.EnvelopeResponse;

@Service
public class ClienteFinalService {

	@Autowired
	private ClienteFinalDao clienteFinalDao;

	public EnvelopeResponse<ClienteFinalDto> findByCodClienteFinal(Integer codClienteFinal) {
		return new EnvelopeResponse<ClienteFinalDto>(
				ClienteFinalDto.build(clienteFinalDao.findByCodClienteFinal(codClienteFinal)));
	}

	public EnvelopeResponse<List<ClienteFinalDto>> getListaClienteFinalAtivos() {
		List<ClienteFinal> listaClienteFinal = (List<ClienteFinal>) clienteFinalDao.findAll();

		List<ClienteFinalDto> listaClienteFinalDto = new ArrayList<ClienteFinalDto>();
		for (ClienteFinal clienteFinal : listaClienteFinal) {
			if (null != clienteFinal.getIndAtivo() && clienteFinal.getIndAtivo().equals("S")) {
				listaClienteFinalDto.add(ClienteFinalDto.build(clienteFinal));
			}
		}
		return new EnvelopeResponse<List<ClienteFinalDto>>(listaClienteFinalDto);

	}

}
