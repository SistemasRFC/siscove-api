package siscove.siscovejava.Produto.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import siscove.siscovejava.Config.response.BaseController;
import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Produto.Dto.ProdutoDto;
import siscove.siscovejava.Produto.Service.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController extends BaseController {

	@Autowired
	private ProdutoService ProdutoService;
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<ProdutoDto>> getListarProdutos() {
		return ProdutoService.getListarProdutos();
	}
}