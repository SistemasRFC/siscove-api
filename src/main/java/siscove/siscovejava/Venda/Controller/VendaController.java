package siscove.siscovejava.Venda.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import siscove.siscovejava.Config.response.BaseController;
import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Venda.Dto.VendaBuscaDto;
import siscove.siscovejava.Venda.Dto.VendaDto;
import siscove.siscovejava.Venda.Service.VendaService;

@RestController
@RequestMapping(value = "/venda")
public class VendaController extends BaseController {
	
	@Autowired
	private VendaService vendaService;
	
	@RequestMapping(value="/salvar", method = RequestMethod.POST, consumes = {"*/*"})
	public EnvelopeResponse<VendaDto> salvarVenda(HttpServletRequest request, @RequestBody VendaDto vendaDto){
		HttpSession session = request.getSession();
		String token = session.getAttribute("token").toString();
		EnvelopeResponse<VendaDto> retorno = vendaService.salvar(vendaDto, token);
		return retorno;
	}
	
	@RequestMapping(value = "/listar/abertas", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<VendaBuscaDto>> ListaVendasAbertas() {
		return vendaService.getListaVendasAbertas();
	}
	
	@RequestMapping(value = "/listar/fechadas", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<VendaDto>> ListaVendasFechadas() {
		return vendaService.getListaVendasFechadas();
	}

}
