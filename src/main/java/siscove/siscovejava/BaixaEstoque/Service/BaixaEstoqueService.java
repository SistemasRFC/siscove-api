package siscove.siscovejava.BaixaEstoque.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.BaixaEstoque.Dto.BaixaEstoqueDto;
import siscove.siscovejava.BaixaEstoque.Entity.BaixaEstoque;
import siscove.siscovejava.BaixaEstoque.Repository.BaixaEstoqueRepository;
import siscove.siscovejava.Config.response.EnvelopeResponse;

@Service
public class BaixaEstoqueService {

	@Autowired
	private BaixaEstoqueRepository baixaEstoqueRepository;

	
	public EnvelopeResponse<List<BaixaEstoqueDto>> getListarBaixaEstoque(String txtTermo) {
		List<BaixaEstoque> listaBaixaEstoque = new ArrayList<BaixaEstoque>();
		listaBaixaEstoque = baixaEstoqueRepository.getListarBaixaEstoque(txtTermo);

		List<BaixaEstoqueDto> listarBaixaEstoqueDto = new ArrayList<BaixaEstoqueDto>();
		for (BaixaEstoque baixaEstoque : listaBaixaEstoque) {

			listarBaixaEstoqueDto.add(BaixaEstoqueDto.build(baixaEstoque));
		}
		return new EnvelopeResponse<List<BaixaEstoqueDto>>(listarBaixaEstoqueDto);

	}

}
