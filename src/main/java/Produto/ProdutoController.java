package Produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import siscove.siscovejava.Config.response.BaseController;
import siscove.siscovejava.Config.response.EnvelopeResponse;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController extends BaseController {

	@Autowired
	private ProdutoService produtoService;

	@RequestMapping(value = "/salvar", method = RequestMethod.POST, consumes = { "*/*" })
	public EnvelopeResponse<ProdutoDto> salvarProduto(@RequestBody ProdutoDto produtoDto) {
		EnvelopeResponse<ProdutoDto> retorno = produtoService.salvar(produtoDto);
		return retorno;
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<ProdutoDto>> ListarProduto() {
		return produtoService.getListarProduto();
	}

	@RequestMapping(value = "/listar/ativos", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<ProdutoDto>> ListarAtivos() {
		return produtoService.getListarAtivos();
	}

}


