package siscove.siscovejava.ConsultaCep.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import siscove.siscovejava.Config.response.BaseController;
import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.ConsultaCep.Dto.ConsultaCepDto;
import siscove.siscovejava.ConsultaCep.Service.ConsultaCepService;

@RestController
@RequestMapping(value = "/consulta/cep")
public class ConsultaCepController extends BaseController {

	@Autowired
	private ConsultaCepService consultaCepService;

	@RequestMapping(value = "/{nroCep}", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<ConsultaCepDto> getCep(@PathVariable String nroCep) {
		
		return consultaCepService.getEndereco(nroCep);	
	}	
}
