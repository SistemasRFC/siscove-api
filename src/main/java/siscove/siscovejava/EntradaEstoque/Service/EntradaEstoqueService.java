package siscove.siscovejava.EntradaEstoque.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Entrada.Dto.EntradaDto;
import siscove.siscovejava.Entrada.Entity.Entrada;
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
	//public EnvelopeResponse<List<EntradaEstoqueDto>>calcular() {
	//	List<EntradaEstoque> listaEntrada = (List<EntradaEstoque>) entradaEstoqueDao.findAll();

	//	List<EntradaEstoqueDto> listaEntradaDto = new ArrayList<EntradaEstoqueDto>();
	//	for (EntradaEstoque entradaEstoque : listaEntrada) {
	//		if (entradaEstoque.getQtdEntrada().equals("S")) {
	//			listaEntradaDto.add(EntradaDto.build(entrada));
	//		}
	//	}
	//	return new EnvelopeResponse<List<EntradaEstoqueDto>>(listaEntradaDto);
	}


