package siscove.siscovejava.Produto.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import siscove.siscovejava.Config.response.BaseController;
import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Produto.Dto.CadastroProdutosDto;
import siscove.siscovejava.Produto.Service.CadastroProdutosService;

@RestController
@RequestMapping(value = "/cadastoprodutos")
public class CadastroProdutosController extends BaseController {

	@Autowired
	private CadastroProdutosService cadastroProdutosService;
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<CadastroProdutosDto>> ListarProdutos() {
		return cadastroProdutosService.getListarProdutos();
	}
}