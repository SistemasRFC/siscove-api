package siscove.siscovejava.Venda.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Venda.Dto.VendaDto;
import siscove.siscovejava.Venda.Service.VendaService;

@RestController
@RequestMapping(value = "/venda")
public class VendaController {
	
	@Autowired
	private VendaService vendaService;
	
	@RequestMapping(value="/salvar", method = RequestMethod.POST, consumes = {"*/*"})
	public EnvelopeResponse<VendaDto> salvarVenda(@RequestBody VendaDto vendaDto){
		EnvelopeResponse<VendaDto> retorno = vendaService.salvar(vendaDto);
		return retorno;
	}
	
	@RequestMapping(value = "/listar/venda/aberta", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<VendaDto>> ListaVendaAberta() {
		return vendaService.getListaVendasAbertas();
	}
	
	@RequestMapping(value = "/listar/venda/fechada", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<VendaDto>> ListaVendaFechadas() {
		return vendaService.getListaVendasFechadas();
	}

}
