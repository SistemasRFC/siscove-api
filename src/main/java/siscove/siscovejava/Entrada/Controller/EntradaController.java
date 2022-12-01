package siscove.siscovejava.Entrada.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import siscove.siscovejava.Config.response.BaseController;
import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Entrada.Dto.EntradaDto;
import siscove.siscovejava.Entrada.Dto.EntradasAbertasDto;
import siscove.siscovejava.Entrada.Service.EntradaService;

@RestController
@RequestMapping(value = "/entrada")
public class EntradaController extends BaseController {

	@Autowired
	private EntradaService entradaService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<EntradaDto>> getListarEntrada() {
		return entradaService.getListarEntrada();
	}

	@RequestMapping(value = "/listar/abertas", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<EntradasAbertasDto>> findEntradasAbertas() {
		return entradaService.findEntradasAbertas();
	}

	@RequestMapping(value = "/produto", method = RequestMethod.POST, consumes = { "*/*" })
	public List<String> reniciar(@PathVariable String termo) {
		List<String> retorno = new ArrayList<String>();
		return retorno;
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST, consumes = { "*/*" })
	public EnvelopeResponse<EntradaDto> salvar(@RequestBody EntradaDto entradaDto) {
		EnvelopeResponse<EntradaDto> envLogin = entradaService.salvar(entradaDto);
		return envLogin;
	}
	
}