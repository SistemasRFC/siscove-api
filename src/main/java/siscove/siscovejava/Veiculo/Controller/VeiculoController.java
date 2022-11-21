package siscove.siscovejava.Veiculo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import siscove.siscovejava.Config.response.BaseController;
import siscove.siscovejava.Veiculo.Dto.VeiculoDto;
import siscove.siscovejava.Veiculo.Service.VeiculoService;

@RestController
@RequestMapping(value = "/veiculo")
public class VeiculoController extends BaseController {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@RequestMapping(value = "/listar/byTermo/{txtTermo}", method = RequestMethod.GET, consumes = { "*/*" })
	public List<VeiculoDto> getListarVeiculo(@PathVariable String txtTermo) {
		return veiculoService.getListarVeiculo(txtTermo);
	}

}
