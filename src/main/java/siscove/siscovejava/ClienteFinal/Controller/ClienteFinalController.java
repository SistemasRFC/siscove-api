package siscove.siscovejava.ClienteFinal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import siscove.siscovejava.ClienteFinal.Dto.ClienteFinalDto;
import siscove.siscovejava.ClienteFinal.Service.ClienteFinalService;
import siscove.siscovejava.Config.response.BaseController;
import siscove.siscovejava.Config.response.EnvelopeResponse;

@RestController
@RequestMapping(value = "/clienteFinal")
public class ClienteFinalController extends BaseController {

	@Autowired
	private ClienteFinalService clienteFinalService;

	@RequestMapping(value = "/listar/ativos", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<ClienteFinalDto>> getListaClieteFinalAtivos() {
		return clienteFinalService.getListaClienteFinalAtivos();
	}

}
