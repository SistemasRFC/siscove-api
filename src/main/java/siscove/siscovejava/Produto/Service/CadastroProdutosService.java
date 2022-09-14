package siscove.siscovejava.Produto.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Produto.Dto.CadastroProdutosDto;
import siscove.siscovejava.Produto.Entity.CadastroProdutos;
import siscove.siscovejava.Produto.Repository.CadastroProdutosDao;

@Service
public class CadastroProdutosService {

	@Autowired
	private CadastroProdutosDao cadastroProdutosDao;

	public EnvelopeResponse<List<CadastroProdutosDto>> getListarProdutos() {
		List<CadastroProdutos> listaCadastroProdutos = (List<CadastroProdutos>) cadastroProdutosDao.findAll();

		List<CadastroProdutosDto> listarCadastroProdutosDto = new ArrayList<CadastroProdutosDto>();
		for (CadastroProdutos cadastroprodutos : listaCadastroProdutos) {
			CadastroProdutosDto cadastroProdutosDto= CadastroProdutosDto.build(cadastroprodutos);
			
			listarCadastroProdutosDto.add(cadastroProdutosDto);
		}
		return new EnvelopeResponse<List<CadastroProdutosDto>>(listarCadastroProdutosDto);

	}
}
