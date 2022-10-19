package siscove.siscovejava.EntradaEstoque.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import siscove.siscovejava.Config.response.BaseController;
import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.EntradaEstoque.Dto.EntradaEstoqueDto;
import siscove.siscovejava.EntradaEstoque.Service.EntradaEstoqueService;

@RestController
@RequestMapping(value = "/entrada/estoque")
public class EntradaEstoqueController extends BaseController {

	@Autowired
	private EntradaEstoqueService entradaEstoqueService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<EntradaEstoqueDto>> getListarEntradaEstoque() {
		return entradaEstoqueService.getListarEntradaEstoque();
	}
	//@RequestMapping(value = "/calcular", method = RequestMethod.GET, consumes = { "*/*" })
	//public EnvelopeResponse<List<EntradaEstoqueDto>> getCalcular() {
	//	return entradaEstoqueService.getCalcular();
	//}
}