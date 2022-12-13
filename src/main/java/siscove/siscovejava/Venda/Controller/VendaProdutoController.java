package siscove.siscovejava.Venda.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import siscove.siscovejava.Config.response.BaseController;
import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Venda.Dto.VendaProdutoDto;
import siscove.siscovejava.Venda.Service.VendaProdutoService;

@RestController
@RequestMapping(value = "/venda/produto")
public class VendaProdutoController extends BaseController{
	
	@Autowired
	private VendaProdutoService vendaProdutoService;
	
	@RequestMapping(value="/salvar", method = RequestMethod.POST, consumes = {"*/*"})
	public EnvelopeResponse<VendaProdutoDto> salvarVendaProduto(HttpServletRequest request, @RequestBody VendaProdutoDto vendaProdutoDto){
		HttpSession session = request.getSession();
		String token = session.getAttribute("token").toString();
		EnvelopeResponse<VendaProdutoDto> retorno = vendaProdutoService.salvar(vendaProdutoDto, token);
		return retorno;
	}
	
	@RequestMapping(value = "/listar/{codVenda}", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<VendaProdutoDto>> listarProdutosVenda(@PathVariable Integer codVenda) {
		return vendaProdutoService.getListaProdutosVenda(codVenda);
	}
	
	@RequestMapping(value = "/excluir/{nroSequencial}/{codVenda}/{codProduto}", method = RequestMethod.DELETE, consumes = { "*/*" })
	public EnvelopeResponse<List<VendaProdutoDto>> excluirProdutosVenda(
			@PathVariable Integer nroSequencial,
			@PathVariable Integer codVenda,
			@PathVariable Integer codProduto) {
		return vendaProdutoService.excluirProdutosVenda(nroSequencial, codVenda, codProduto);
	}
}
