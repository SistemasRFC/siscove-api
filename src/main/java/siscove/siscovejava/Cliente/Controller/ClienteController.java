package siscove.siscovejava.Cliente.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import siscove.siscovejava.Cliente.Dto.ClienteDto;
import siscove.siscovejava.Cliente.Service.ClienteService;
import siscove.siscovejava.Config.response.BaseController;
import siscove.siscovejava.Config.response.EnvelopeResponse;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController extends BaseController {

	@Autowired
	private ClienteService clienteService;

	
	@RequestMapping(value = "/listar/ativos", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<ClienteDto>> getListaClienteAtivos() {
		return clienteService.getListaClienteAtivos();
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<ClienteDto>> ListarCliente() {
		return clienteService.getListaCliente();
	}
	
	@RequestMapping(value="/salvar", method = RequestMethod.POST, consumes = {"*/*"})
	public EnvelopeResponse<ClienteDto> salvarCliente(@RequestBody ClienteDto clienteDto){
		EnvelopeResponse<ClienteDto> retorno = clienteService.salvar(clienteDto);
		return retorno;
	}
}