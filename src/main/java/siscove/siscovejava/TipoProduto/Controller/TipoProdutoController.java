package siscove.siscovejava.TipoProduto.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import siscove.siscovejava.Config.response.BaseController;
import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.TipoProduto.Dto.TipoProdutoDto;
import siscove.siscovejava.TipoProduto.Service.TipoProdutoService;

@RestController
@RequestMapping(value = "tipo/produto")
public class TipoProdutoController extends BaseController {

	@Autowired
	private TipoProdutoService tipoProdutoService;

	@RequestMapping(value = "/salvar", method = RequestMethod.POST, consumes = { "*/*" })
	public EnvelopeResponse<TipoProdutoDto> salvarTipoProduto(HttpServletRequest request, @RequestBody TipoProdutoDto tipoProdutoDto) {
		HttpSession session = request.getSession();
		String token = session.getAttribute("token").toString();
		EnvelopeResponse<TipoProdutoDto> retorno = tipoProdutoService.salvar(tipoProdutoDto, token);
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


