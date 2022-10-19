package siscove.siscovejava.Venda.Service;

import java.util.ArrayList;
import java.util.List;

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
	
	public EnvelopeResponse<List<VendaDto>> getListaVendasAbertas() {
		List<Venda> listaVendasAbertas = vendaDao.getListaVendasAbertas();
		
		List<VendaDto> listaVendasAbertasDto = new ArrayList<VendaDto>();
		for (Venda vendas : listaVendasAbertas) {
			listaVendasAbertasDto.add(VendaDto.build(vendas));
		}
		
		return new EnvelopeResponse<List<VendaDto>>(listaVendasAbertasDto);
	}
	
	public EnvelopeResponse<List<VendaDto>> getListaVendasFechadas() {
		List<Venda> listaVendasFechadas = vendaDao.getListaVendasFechadas();
		
		List<VendaDto> listaVendasFechadasDto = new ArrayList<VendaDto>();
		for (Venda vendas : listaVendasFechadas) {
			listaVendasFechadasDto.add(VendaDto.build(vendas));
		}
		
		return new EnvelopeResponse<List<VendaDto>>(listaVendasFechadasDto);
	}

}
