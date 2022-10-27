package siscove.siscovejava.ClienteFinal.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.ClienteFinal.Dto.ClienteFinalDto;
import siscove.siscovejava.ClienteFinal.Entity.ClienteFinal;
import siscove.siscovejava.ClienteFinal.Repository.ClienteFinalDao;
import siscove.siscovejava.Config.response.EnvelopeResponse;

@Service
public class ClienteFinalService {
	
	@Autowired
	private ClienteFinalDao clienteFinalDao;  
	
	public EnvelopeResponse<ClienteFinalDto> salvar(ClienteFinalDto clienteFinalDto) {
		
		
		ClienteFinal clienteFinal = clienteFinalDao.save(ClienteFinalDto.parse(clienteFinalDto));
		
		
		clienteFinalDto = ClienteFinalDto.build(clienteFinal);


		return new EnvelopeResponse<ClienteFinalDto>(clienteFinalDto);
	}
	
	public EnvelopeResponse<List<ClienteFinalDto>> getListaClienteFinal(){
		List<ClienteFinal> listaClienteFinal = (List<ClienteFinal>) clienteFinalDao.findAll();
		
		List<ClienteFinalDto> listaClienteFinalDto = new ArrayList<ClienteFinalDto>();
		for (ClienteFinal clienteFinal : listaClienteFinal) {
			listaClienteFinalDto.add(ClienteFinalDto.build(clienteFinal));
		
		}
		return new EnvelopeResponse<List<ClienteFinalDto>>(listaClienteFinalDto);
	}
	
	public EnvelopeResponse<List<ClienteFinalDto>> getListaClienteFinalAtivos(){
		List<ClienteFinal> listarAtivos = (List<ClienteFinal>) clienteFinalDao.findAll();
		
		List <ClienteFinalDto> listarAtivosDto = new ArrayList<ClienteFinalDto>();
		for (ClienteFinal clienteFinal : listarAtivos) {
			if (clienteFinal.getIndAtivo().equals("S")) 
			    listarAtivosDto.add(ClienteFinalDto.build(clienteFinal));
		}
		return new EnvelopeResponse<List<ClienteFinalDto>>(listarAtivosDto);
	}

	public EnvelopeResponse<List<ClienteFinalDto>> ListaTipoProduto(Integer codClienteFinal) {
		ClienteFinal clienteFinal = clienteFinalDao.findById(codClienteFinal).get();

		List<ClienteFinalDto> listaClienteFinalDto = new ArrayList<ClienteFinalDto>();
			listaClienteFinalDto.add(ClienteFinalDto.build(clienteFinal));
		
		return new EnvelopeResponse<List<ClienteFinalDto>>(listaClienteFinalDto);
	}
}
	
	


	