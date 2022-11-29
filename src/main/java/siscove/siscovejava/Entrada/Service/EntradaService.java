package siscove.siscovejava.Entrada.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Entrada.Dao.EntradaDao;
import siscove.siscovejava.Entrada.Dto.EntradaDto;
import siscove.siscovejava.Entrada.Dto.EntradasAbertasDto;
import siscove.siscovejava.Entrada.Entity.Entrada;
import siscove.siscovejava.Entrada.Repository.EntradaRepository;
import siscove.siscovejava.Util.UtilData;
import siscove.siscovejava.UtilMoeda.UtilMoeda;

@Service
public class EntradaService {

	@Autowired
	private EntradaRepository entradaRepository;
	
	@Autowired
	private EntradaDao entradaDao;

	public EnvelopeResponse<List<EntradasAbertasDto>> findEntradasAbertas() {
		List<EntradasAbertasDto> listaEntradasAbertas = entradaDao.getListaEntradasAbertas();

		for (EntradasAbertasDto entrada : listaEntradasAbertas) {
			entrada.setDtaEntradaFormatada(UtilData.formataData(entrada.getDtaEntrada()));
		}
		
		for (EntradasAbertasDto entrada : listaEntradasAbertas) {
			entrada.setVlrTotalFormatada(UtilMoeda.formataMoeda(entrada.getVlrTotal()));
		}
		
		return new EnvelopeResponse<List<EntradasAbertasDto>>(listaEntradasAbertas);
	}

	public EnvelopeResponse<List<EntradaDto>> getListarEntrada() {
		List<Entrada> listaEntrada = (List<Entrada>) entradaRepository.findAll();

		List<EntradaDto> listaEntradaDto = new ArrayList<EntradaDto>();
		for (Entrada entrada : listaEntrada) {
			listaEntradaDto.add(EntradaDto.build(entrada));
		}
		return new EnvelopeResponse<List<EntradaDto>>(listaEntradaDto);

	}

	public EnvelopeResponse<EntradaDto> salvar(EntradaDto entradaDto) {
		Entrada entrada = entradaRepository.save(EntradaDto.parse(entradaDto));

		entradaDto = EntradaDto.build(entrada);

		return new EnvelopeResponse<EntradaDto>(entradaDto);
	}

}
