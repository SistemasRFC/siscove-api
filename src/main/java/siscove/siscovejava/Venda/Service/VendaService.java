package siscove.siscovejava.Venda.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.LogVenda.Service.LogVendaService;
import siscove.siscovejava.Token.Dto.TokenDto;
import siscove.siscovejava.Token.Service.TokenService;
import siscove.siscovejava.Venda.Dto.VendaDto;
import siscove.siscovejava.Venda.Entity.Venda;
import siscove.siscovejava.Venda.Enum.TipoOperacaoEnum;
import siscove.siscovejava.Venda.Repository.VendaDao;

@Service
public class VendaService {
	
	@Autowired
	private VendaDao vendaDao;

	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private LogVendaService logVendaService;
	
	public EnvelopeResponse<VendaDto> salvar(VendaDto vendaDto, String token) {		
		Venda venda = vendaDao.save(VendaDto.parse(vendaDto));
	
		TipoOperacaoEnum operacao = TipoOperacaoEnum.ALTERACAO;
		if (vendaDto.getCodVenda()==null) {
			operacao = TipoOperacaoEnum.INCLUSAO;
		}
		
		venda = vendaDao.save(venda);

		TokenDto tokenDto = tokenService.getByToken(token).getObjeto();
		
		logVendaService.salvar(venda.getCodVenda(), tokenDto.getCodUsuario(), operacao);
		
		vendaDto.setCodVenda(venda.getCodVenda());

	return new EnvelopeResponse<VendaDto>(vendaDto);
	
	}
	
	public EnvelopeResponse<List<VendaDto>> getListaVendasAbertas() {
		List<Venda> listaVendasAbertas = vendaDao.findByNroStatusVenda("A");
		
		List<VendaDto> listaVendasAbertasDto = new ArrayList<VendaDto>();
		for (Venda vendas : listaVendasAbertas) {
			listaVendasAbertasDto.add(VendaDto.build(vendas));
		}
		
		return new EnvelopeResponse<List<VendaDto>>(listaVendasAbertasDto);
	}
	
	
	public EnvelopeResponse<List<VendaDto>> getListaVendasFechadas() {
		List<Venda> listaVendasFechadas = vendaDao.findByNroStatusVenda("F");
		
		List<VendaDto> listaVendasFechadasDto = new ArrayList<VendaDto>();
		for (Venda vendas : listaVendasFechadas) {
			listaVendasFechadasDto.add(VendaDto.build(vendas));
		}
		
		return new EnvelopeResponse<List<VendaDto>>(listaVendasFechadasDto);
	}

}
