package siscove.siscovejava.Entrada.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import siscove.siscovejava.Config.response.BaseController;
import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Entrada.Dto.EntradaDto;
import siscove.siscovejava.Entrada.Service.EntradaService;

@RestController
@RequestMapping(value = "/entrada")
public class EntradaController extends BaseController {

	@Autowired
	private EntradaService entradaService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<EntradaDto>> ListarEntrada() {
		return entradaService.getListarEntrada();
	}
	@RequestMapping(value="/salvar", method = RequestMethod.POST, consumes = {"*/*"})
	public EnvelopeResponse<EntradaDto> salvarEntrada(@RequestBody EntradaDto entradaDto){
		EnvelopeResponse<EntradaDto> retorno = entradaService.salvar(entradaDto);
		return retorno;
	}
	
	@RequestMapping(value = "/listar/ativos", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<EntradaDto>> getListarEntradaAtivos() {
		return entradaService.getListarEntradaAtivos();
	}
}