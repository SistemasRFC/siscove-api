package siscove.siscovejava.Entrada.Controller;

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
import siscove.siscovejava.Entrada.Dto.EntradaDto;
import siscove.siscovejava.Entrada.Dto.ListagemEntradasDto;
import siscove.siscovejava.Entrada.Service.EntradaService;

@RestController
@RequestMapping(value = "/entrada")
public class EntradaController extends BaseController {

	@Autowired
	private EntradaService entradaService;

	@RequestMapping(value = "/{nroSequencial}", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<EntradaDto> findByNroSequencial(@PathVariable Integer nroSequencial) {
		return entradaService.findByNroSequencial(nroSequencial);
	}

	@RequestMapping(value = "/listar/abertas", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<ListagemEntradasDto>> findEntradasAbertas() {
		return entradaService.findEntradasAbertas();
	}

	@RequestMapping(value = "/listar/fechadas/{codFornecedor}", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<ListagemEntradasDto>> findEntradasFechadas(@PathVariable Integer codFornecedor) {
		return entradaService.findEntradasFechadas(codFornecedor);
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST, consumes = { "*/*" })
	public EnvelopeResponse<Boolean> salvar(HttpServletRequest request, @RequestBody EntradaDto entradaDto) {
		HttpSession session = request.getSession();
		String token = session.getAttribute("token").toString();
		EnvelopeResponse<Boolean> envLogin = entradaService.salvar(entradaDto, token);
		return envLogin;
	}

}