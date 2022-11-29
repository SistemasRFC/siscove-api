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
import siscove.siscovejava.Produto.Dto.ProdutoAutoDto;
import siscove.siscovejava.Produto.Dto.ProdutoDto;
import siscove.siscovejava.Produto.Service.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController extends BaseController {

	@Autowired
	private ProdutoService ProdutoService;

	@RequestMapping(value = "/listar/byTermo", method = RequestMethod.POST, consumes = { "*/*" })
	public EnvelopeResponse<List<ProdutoDto>> getListaProdutos(@RequestBody String txtTermo) {
		return ProdutoService.getListaProdutos(txtTermo);
	}
	
	@RequestMapping(value = "/listar/autoComplete/{dscProduto}", method = RequestMethod.GET, consumes = { "*/*" })
	public List<ProdutoAutoDto> getListaProdutoAutoComplete(@PathVariable String dscProduto) {
		return ProdutoService.getListaProdutoByDscProduto(dscProduto).getObjeto();
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST, consumes = { "*/*" })
	public EnvelopeResponse<ProdutoDto> salvarProduto(@RequestBody ProdutoDto produtoDto) {
		EnvelopeResponse<ProdutoDto> envProduto = ProdutoService.salvar(produtoDto);
		return envProduto;
	}
}
