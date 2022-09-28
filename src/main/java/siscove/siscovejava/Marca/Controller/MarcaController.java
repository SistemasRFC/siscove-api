package siscove.siscovejava.Marca.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import siscove.siscovejava.Config.response.BaseController;
import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Marca.Dto.MarcaDto;
import siscove.siscovejava.Marca.Service.MarcaService;

@RestController
@RequestMapping(value = "/marca")
public class MarcaController extends BaseController {

	@Autowired
	private MarcaService marcaService;
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<MarcaDto>> getListaMarca() {
		return marcaService.getListaMarca();
	}

	@RequestMapping(value = "/listar/ativos", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<MarcaDto>> ListaMarcasAtiva() {
		return marcaService.getListarMarcasAtivas();
	}
	
	@RequestMapping(value="/salvar", method = RequestMethod.POST, consumes = {"*/*"})
	public EnvelopeResponse<MarcaDto> salvarMarca(@RequestBody MarcaDto marcaDto){
		EnvelopeResponse<MarcaDto> retorno = marcaService.salvar(marcaDto);
		return retorno;
	}
}