package siscove.siscovejava.BaixaEstoque.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import siscove.siscovejava.BaixaEstoque.Dto.BaixaEstoqueDto;
import siscove.siscovejava.BaixaEstoque.Service.BaixaEstoqueService;
import siscove.siscovejava.Config.response.BaseController;

@RestController
@RequestMapping(value = "/baixa/estoque")
public class BaixaEstoqueController extends BaseController {

	@Autowired
	private BaixaEstoqueService baixaEstoqueService;

	@RequestMapping(value = "/listar/byTermo/{txtTermo}", method = RequestMethod.GET, consumes = { "*/*" })
	public List<BaixaEstoqueDto> getListaBaixaEstoqueAutoComplete(@PathVariable String txtTermo) {
		return baixaEstoqueService.getListarBaixaEstoque(txtTermo).getObjeto();
	}

}
