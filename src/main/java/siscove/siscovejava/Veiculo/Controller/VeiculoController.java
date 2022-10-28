package siscove.siscovejava.Veiculo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import siscove.siscovejava.Config.response.BaseController;
import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Veiculo.Dto.VeiculoDto;
import siscove.siscovejava.Veiculo.Service.VeiculoService;

@RestController
@RequestMapping(value = "/veiculo")
public class VeiculoController extends BaseController {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@RequestMapping(value = "/listar/byTermo", method = RequestMethod.POST, consumes = { "*/*" })
	public EnvelopeResponse<List<VeiculoDto>> getListarVeiculo(@RequestBody String dscVeiculo) {
		return veiculoService.getListarVeiculo(dscVeiculo);
	}

}
