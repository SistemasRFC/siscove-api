package siscove.siscovejava.BaixaEstoque.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.BaixaEstoque.Dto.BaixaEstoqueDto;
import siscove.siscovejava.BaixaEstoque.Entity.BaixaEstoque;
import siscove.siscovejava.BaixaEstoque.Repository.BaixaEstoqueDao;
import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Token.Service.TokenService;

@Service
public class BaixaEstoqueService {

	@Autowired
	private BaixaEstoqueDao baixaEstoqueDao;

	@Autowired
	private TokenService tokenService;

	public EnvelopeResponse<List<BaixaEstoqueDto>> getListarBaixaEstoque(String txtTermo) {

		List<BaixaEstoque> listarBaixaEstoque = (List<BaixaEstoque>) baixaEstoqueDao.findBycodProduto(txtTermo);
		List<BaixaEstoqueDto> listarBaixaEstoqueDto = new ArrayList<BaixaEstoqueDto>();
		for (BaixaEstoque baixaEstoque : listarBaixaEstoque) {
			BaixaEstoqueDto baixaEstoqueDto = BaixaEstoqueDto.build(baixaEstoque);
			listarBaixaEstoqueDto.add(baixaEstoqueDto);

		}

		return new EnvelopeResponse<List<BaixaEstoqueDto>>(listarBaixaEstoqueDto);
	}

}
