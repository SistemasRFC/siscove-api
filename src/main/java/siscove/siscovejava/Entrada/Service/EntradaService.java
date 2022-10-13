package siscove.siscovejava.Entrada.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Entrada.Dto.EntradaDto;
import siscove.siscovejava.Entrada.Entity.Entrada;
import siscove.siscovejava.Entrada.Repository.EntradaDao;

@Service
public class EntradaService {

	@Autowired
	private EntradaDao entradaDao;

	public EnvelopeResponse<List<EntradaDto>> getListarEntradaAtivos() {
		List<Entrada> listaEntrada = (List<Entrada>) entradaDao.findAll();

		List<EntradaDto> listaEntradaDto = new ArrayList<EntradaDto>();
		for (Entrada entrada : listaEntrada) {
			if (entrada.getIndEntrada().equals("S")) {
				listaEntradaDto.add(EntradaDto.build(entrada));
			}
		}
		return new EnvelopeResponse<List<EntradaDto>>(listaEntradaDto);
	}

	public EnvelopeResponse<List<EntradaDto>> getListarEntrada() {
		List<Entrada> listaEntrada = (List<Entrada>) entradaDao.findAll();

		List<EntradaDto> listaEntradaDto = new ArrayList<EntradaDto>();
		for (Entrada entrada : listaEntrada) {
			listaEntradaDto.add(EntradaDto.build(entrada));
		}
		return new EnvelopeResponse<List<EntradaDto>>(listaEntradaDto);

	}

	public EnvelopeResponse<EntradaDto> salvar(EntradaDto entradaDto) {
		Entrada entrada = entradaDao.save(EntradaDto.parse(entradaDto));

		entradaDto = EntradaDto.build(entrada);

		return new EnvelopeResponse<EntradaDto>(entradaDto);
	}
	public EnvelopeResponse<List<EntradaDto>> getListarEntradas(String txtTermo) {
		List<Entrada> listarEntradas = (List<Entrada>) entradaDao.findBydscCliente(txtTermo);

		List<EntradaDto> listarEntradasDto = new ArrayList<EntradaDto>();
		for (Entrada entrada : listarEntradas) {
			EntradaDto entradaDto = EntradaDto.build(entrada);
			listarEntradasDto.add(entradaDto);
		}
		
		return new EnvelopeResponse<List<EntradaDto>>(listarClientesDto);
	}
}
