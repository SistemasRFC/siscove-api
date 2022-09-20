package TipoProduto.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import TipoProduto.Dto.TipoProdutoDto;
import TipoProduto.Service.TipoProdutoService;
import siscove.siscovejava.Config.response.BaseController;
import siscove.siscovejava.Config.response.EnvelopeResponse;

@RestController
@RequestMapping(value = "/produto")
public class TipoProdutoController extends BaseController {

	@Autowired
	private TipoProdutoService tipoProdutoService;

	@RequestMapping(value = "/salvar", method = RequestMethod.POST, consumes = { "*/*" })
	public EnvelopeResponse<TipoProdutoDto> salvarTipoProduto(@RequestBody TipoProdutoDto tipoProdutoDto) {
		EnvelopeResponse<TipoProdutoDto> retorno = tipoProdutoService.salvar(tipoProdutoDto);
		return retorno;
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<TipoProdutoDto>> ListarTipoProduto() {
		return tipoProdutoService.getListarTipoProduto();
	}

	@RequestMapping(value = "/listar/ativos", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<TipoProdutoDto>> ListarAtivos() {
		return tipoProdutoService.getListarAtivos();
	}

}


