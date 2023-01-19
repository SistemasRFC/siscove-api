package siscove.siscovejava.BaixaEstoque.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import siscove.siscovejava.BaixaEstoque.Dto.BaixaEstoqueDto;
import siscove.siscovejava.Config.response.BaseController;
import siscove.siscovejava.Config.response.EnvelopeResponse;

@RestController
@RequestMapping(value = "/baixa/estoque")
public class BaixaEstoqueController extends BaseController {

	@Autowired
	private BaixaEstoqueDto baixaEstoqueService;
	
	@RequestMapping(value = "/listar/byTermo", method = RequestMethod.POST, consumes = { "*/*" })
	public EnvelopeResponse<List<BaixaEstoqueDto>>ListarBaixaEstoque(@RequestBody String txtTermo) {
		return baixaEstoqueService.getListaBaixaEstoque(txtTermo);
	}
	
}