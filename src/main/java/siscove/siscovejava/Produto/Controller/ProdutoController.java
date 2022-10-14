package siscove.siscovejava.Produto.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	private ProdutoService produtoService;

	@RequestMapping(value = "/listar/byTermo", method = RequestMethod.POST, consumes = { "*/*" })
	public EnvelopeResponse<List<ProdutoDto>> getListarProdutos(@RequestBody String txtTermo) {
		return produtoService.getListarProdutos(txtTermo);
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST, consumes = { "*/*" })
	public EnvelopeResponse<ProdutoDto> salvarProduto(@RequestBody ProdutoDto produtoDto) {
		EnvelopeResponse<ProdutoDto> envLogin = produtoService.salvar(produtoDto);
		return envLogin;
	}
	
	@RequestMapping(value = "/listar/byTermo/{txtTermo}", method = RequestMethod.GET, consumes = { "*/*" })
	public List<ProdutoDto> getListarProdutosAutoComplete(@PathVariable String txtTermo) {
		return produtoService.getListarProdutos(txtTermo).getObjeto();
	}
}
