package siscove.siscovejava.Venda.Controller;

import java.util.List;

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
	public EnvelopeResponse<VendaProdutoDto> salvarVendaProduto(@RequestBody VendaProdutoDto vendaProdutoDto){
		EnvelopeResponse<VendaProdutoDto> retorno = vendaProdutoService.salvar(vendaProdutoDto);
		return retorno;
	}
	
	@RequestMapping(value = "/listar/{codVenda}", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<VendaProdutoDto>> ListarVendasProduto(@PathVariable Integer codVenda) {
		return vendaProdutoService.getListarVendasProduto(codVenda);
	}
	
	@RequestMapping(value = "/listar/funcionarios", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<VendaProdutoDto>> ListarVendedores(@RequestBody Integer codFuncionario) {
		return vendaProdutoService.getListarVendedores(codFuncionario);
	}
	
}
