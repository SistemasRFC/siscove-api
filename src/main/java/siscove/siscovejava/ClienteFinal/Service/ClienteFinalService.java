package siscove.siscovejava.ClienteFinal.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.ClienteFinal.Dao.ClienteFinalDao;
import siscove.siscovejava.ClienteFinal.Dto.ClienteFinalDto;
import siscove.siscovejava.ClienteFinal.Entity.ClienteFinal;
import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Deposito.Dto.DepositoDto;
import siscove.siscovejava.Deposito.Entity.Deposito;

@Service
public class ClienteFinalService {

	@Autowired
	private ClienteFinalDao clienteFinalDao;

	public EnvelopeResponse<ClienteFinalDto> findByCodClienteFinal(Integer codClienteFinal){
		return new EnvelopeResponse<ClienteFinalDto>(ClienteFinalDto.build(clienteFinalDao.findByCodClienteFinal(codClienteFinal)));
	}
	
	public EnvelopeResponse<List<ClienteFinalDto>> getListaClienteFinalSAtivos() {
		List<ClienteFinal> listaClienteFinal = (List<ClienteFinal>) clienteFinalDao.findAll();

		List<ClienteFinalDto> listaClienteFinalDto = new ArrayList<ClienteFinalDto>();
		for (ClienteFinal clienteFinal : listaClienteFinal) {
			if (null!=clienteFinal.getIndAtivo() && clienteFinal.getIndAtivo().equals("S")) {
				listaClienteFinalDto.add(ClienteFinalDto.build(clienteFinal));
			}
		}
		return new EnvelopeResponse<List<ClienteFinalDto>>(listaClienteFinalDto);
		
	}
	
	public EnvelopeResponse<List<ClienteFinalDto>> getListaClienteFinal(){
		List<ClienteFinal> listaClienteFinal = (List<ClienteFinal>) clienteFinalDao.findAll();
		
		List<ClienteFinalDto> listaClientefinalDto = new ArrayList<ClienteFinalDto>();
		for (ClienteFinal clienteFinal : listaClienteFinal) {
			ClienteFinalDto dto  = ClienteFinalDto.build(clienteFinal);
			
			ClienteFinalDto clienteFinalDto = clienteFinalService.findByCodClienteFinal(clienteFinal.getCodClienteFinal()).getObjeto();
			dto.setDscClienteFinal(clienteFinalDto.getNmeClienteFinal());
			
			listaClienteFinalDto.add(dto);
		}
		return new EnvelopeResponse<List<ClienteFinalDto>>(listaClienteFinalDto);  
		
	}

	public EnvelopeResponse<DepositoDto> salvar(DepositoDto depositoDto) {
Deposito deposito = depositoDao.save(DepositoDto.parse(depositoDto));
		
		depositoDto = DepositoDto.build(deposito);


		return new EnvelopeResponse<DepositoDto>(depositoDto);
	}
}
