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

	public EnvelopeResponse<EntradaEstoqueDto> salvar(EntradaEstoqueDto entradaEstoqueDto) {

		EntradaEstoque entradaEstoque = entradaEstoqueDao.save(EntradaEstoqueDto.parse(entradaEstoqueDto));

		entradaEstoqueDto = EntradaEstoqueDto.build(entradaEstoque);

		return new EnvelopeResponse<EntradaEstoqueDto>(entradaEstoqueDto);
	}

	public EnvelopeResponse<List<EntradaEstoqueDto>> getListarEntradaEstoque() {
		List<EntradaEstoque> listarEntradaEstoque = (List<EntradaEstoque>) entradaEstoqueDao.findAll();

		List<EntradaEstoqueDto> listarEntradaEstoqueDto = new ArrayList<EntradaEstoqueDto>();
		for (EntradaEstoque entradaEstoque : listarEntradaEstoque) {

				listarEntradaEstoqueDto.add(EntradaEstoqueDto.build(entradaEstoque));
			
		}
		return new EnvelopeResponse<List<EntradaEstoqueDto>>(listarEntradaEstoqueDto);
	}

}