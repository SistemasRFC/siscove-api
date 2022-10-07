package siscove.siscovejava.Fornecedor.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import siscove.siscovejava.Config.response.BaseController;
import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Fornecedor.Dto.FornecedorDto;
import siscove.siscovejava.Fornecedor.Service.FornecedorService;

@RestController
@RequestMapping(value = "/fornecedor")
public class FornecedorController extends BaseController {

	@Autowired
	private FornecedorService fornecedorService;

	
	@RequestMapping(value = "/listar", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<FornecedorDto>> ListarFornecedor() {
		return fornecedorService.getListarFornecedor();
	}

	@RequestMapping(value = "/listar/ativos", method = RequestMethod.GET, consumes = { "*/*" })
	public EnvelopeResponse<List<FornecedorDto>> ListarAtivos() {
		return fornecedorService.getListarAtivos();
	}
	
	@RequestMapping(value="/salvar", method = RequestMethod.POST, consumes = {"*/*"})
	public EnvelopeResponse<FornecedorDto> salvarFornecedor(@RequestBody FornecedorDto fornecedorDto){
		EnvelopeResponse<FornecedorDto> retorno = fornecedorService.salvar(fornecedorDto);
		return retorno;
	}
}