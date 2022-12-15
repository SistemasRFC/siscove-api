package siscove.siscovejava.Venda.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import siscove.siscovejava.Config.response.BaseController;
import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Venda.Dto.VendaPagamentoDto;
import siscove.siscovejava.Venda.Service.VendaPagamentoService;

@RestController
@RequestMapping(value = "/venda/pagamento")
public class VendaPagamentoController extends BaseController {
	
	@Autowired
	private VendaPagamentoService vendaPagamentoService;
	
	@RequestMapping(value="/salvar", method = RequestMethod.POST, consumes = {"*/*"})
	public EnvelopeResponse<VendaPagamentoDto> salvarVendaPagamento(HttpServletRequest request, @RequestBody VendaPagamentoDto vendaPagamentoDto){
		HttpSession session = request.getSession();
		String token = session.getAttribute("token").toString();
		EnvelopeResponse<VendaPagamentoDto> retorno = vendaPagamentoService.salvar(vendaPagamentoDto, token);
		return retorno;
	}
	

}
