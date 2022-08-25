package siscove.siscovejava.Deposito.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import siscove.siscovejava.Config.response.BaseController;
import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Deposito.Dto.DepositoDto;
import siscove.siscovejava.Deposito.Service.DepositoService;

@RestController
@RequestMapping(value = "/deposito")
public class DepositoController extends BaseController {

	@Autowired
	private DepositoService depositoService;


	@RequestMapping(value = "/listar", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<DepositoDto>> getListaDeposito() {
		return depositoService.getListaDeposito();
	}
}

