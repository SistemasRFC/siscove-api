package siscove.siscovejava.Venda.Service;

import org.springframework.beans.factory.annotation.Autowired;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Venda.Dto.VendaDto;
import siscove.siscovejava.Venda.Entity.Venda;
import siscove.siscovejava.Venda.Repository.VendaDao;

public class VendaService {
	
	@Autowired
	private VendaDao vendaDao;

	public EnvelopeResponse<VendaDto> salvar(VendaDto vendaDto) {		
		Venda venda = vendaDao.save(VendaDto.parse(vendaDto));
		
		vendaDto = VendaDto.build(venda);

	return new EnvelopeResponse<VendaDto>(vendaDto);
	
	}

}
