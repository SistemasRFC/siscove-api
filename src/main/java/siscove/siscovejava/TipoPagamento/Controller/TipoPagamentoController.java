package siscove.siscovejava.TipoPagamento.Controller;

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
import siscove.siscovejava.TipoPagamento.Dto.TipoPagamentoDto;
import siscove.siscovejava.TipoPagamento.Service.TipoPagamentoService;

@RestController
@RequestMapping(value = "tipo/pagamento")
public class TipoPagamentoController extends BaseController {

	@Autowired
	private TipoPagamentoService tipoPagamentoService;

	@RequestMapping(value = "/salvar", method = RequestMethod.POST, consumes = { "*/*" })
	public EnvelopeResponse<TipoPagamentoDto> salvarTipoPagamento(HttpServletRequest request,
			@RequestBody TipoPagamentoDto tipoPagamentoDto) {
		EnvelopeResponse<TipoPagamentoDto> retorno = tipoPagamentoService.salvar(tipoPagamentoDto, token);
		return retorno;
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<TipoPagamentoDto>> ListarTipoPagamento() {
		return tipoPagamentoService.getListarTipoPagamento();
	}

	@RequestMapping(value = "/listar/ativos", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<TipoPagamentoDto>> ListarAtivos() {
		return tipoPagamentoService.getListarAtivos();
	}

}
