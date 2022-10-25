package siscove.siscovejava.EntradaEstoque.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.EntradaEstoque.Dto.EntradaEstoqueDto;
import siscove.siscovejava.EntradaEstoque.Entity.EntradaEstoque;
import siscove.siscovejava.EntradaEstoque.Repository.EntradaEstoqueDao;

@Service
public class EntradaEstoqueService {

	@Autowired
	private EntradaEstoqueDao entradaEstoqueDao;

	public EnvelopeResponse<List<EntradaEstoqueDto>> getListarEntradaEstoque() {
		List<EntradaEstoque> listarEntradaEstoque = (List<EntradaEstoque>) entradaEstoqueDao.findAll();

		List<EntradaEstoqueDto> listarEntradaEstoqueDto = new ArrayList<EntradaEstoqueDto>();
		for (EntradaEstoque entradaEstoque : listarEntradaEstoque) {

			listarEntradaEstoqueDto.add(EntradaEstoqueDto.build(entradaEstoque));
		}
		return new EnvelopeResponse<List<EntradaEstoqueDto>>(listarEntradaEstoqueDto);

	}

	public EnvelopeResponse<List<EntradaEstoqueDto>> getCalcular() {
		List<EntradaEstoque> listarEntradaEstoque = (List<EntradaEstoque>) entradaEstoqueDao.findAll();

		List<EntradaEstoqueDto> listarEntradaEstoqueDto = new ArrayList<EntradaEstoqueDto>();
		float vlrTotal = 0;
		for (EntradaEstoque entradaEstoque : listarEntradaEstoque) {
			vlrTotal += entradaEstoque.getVlrUnitario() * entradaEstoque.getVlrMinimo();
			listarEntradaEstoqueDto.add(EntradaEstoqueDto.build(entradaEstoque));
			
		}
		return new EnvelopeResponse<List<EntradaEstoqueDto>>(listarEntradaEstoqueDto);
	}
	
	public EnvelopeResponse<List<EntradaEstoqueDto>> getListaEntradaEstoqueByNroSequencial(Integer nroSequencial) {
		List<EntradaEstoque> listarEntradaEstoque = entradaEstoqueDao.getListaEntradaEstoqueByNroSequencial(nroSequencial);

		List<EntradaEstoqueDto> listarEntradaEstoqueDto = new ArrayList<EntradaEstoqueDto>();
		for (EntradaEstoque entradaEstoque : listarEntradaEstoque) {

			listarEntradaEstoqueDto.add(EntradaEstoqueDto.build(entradaEstoque));
		}
		return new EnvelopeResponse<List<EntradaEstoqueDto>>(listarEntradaEstoqueDto);

	}

}