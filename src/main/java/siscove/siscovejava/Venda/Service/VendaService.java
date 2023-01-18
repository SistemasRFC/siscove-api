package siscove.siscovejava.Venda.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.LogVenda.Service.LogVendaService;
import siscove.siscovejava.Token.Dto.TokenDto;
import siscove.siscovejava.Token.Service.TokenService;
import siscove.siscovejava.Venda.Dao.VendaDao;
import siscove.siscovejava.Venda.Dto.VendaBuscaDto;
import siscove.siscovejava.Venda.Dto.VendaDto;
import siscove.siscovejava.Venda.Entity.Venda;
import siscove.siscovejava.Venda.Enum.TipoOperacaoEnum;
import siscove.siscovejava.Venda.Repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;

	@Autowired
	private VendaDao vendaDao;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private LogVendaService logVendaService;

	public EnvelopeResponse<VendaDto> salvar(VendaDto vendaDto, String token) {
		Venda venda = vendaRepository.save(VendaDto.parse(vendaDto));

		TipoOperacaoEnum operacao = TipoOperacaoEnum.ALTERACAO;
		if (vendaDto.getCodVenda() == null) {
			operacao = TipoOperacaoEnum.INCLUSAO;
		}

		venda = vendaRepository.save(venda);

		TokenDto tokenDto = tokenService.getByToken(token).getObjeto();

		logVendaService.salvar(venda.getCodVenda(), tokenDto.getCodUsuario(), operacao);

		vendaDto.setCodVenda(venda.getCodVenda());

		return new EnvelopeResponse<VendaDto>(vendaDto);

	}

	public EnvelopeResponse<List<VendaBuscaDto>> getListaVendasAbertas() {
		List<VendaBuscaDto> listaVendasAbertasDto = vendaDao.getListaVendasPorStatus("A");

//		List<VendaBuscaDto> listaVendasAbertasDto = new ArrayList<VendaBuscaDto>();
//		for (Venda vendas : listaVendasAbertas) {
//			listaVendasAbertasDto.add(VendaBuscaDto.build(vendas));
//		}

		return new EnvelopeResponse<List<VendaBuscaDto>>(listaVendasAbertasDto);
	}

	public EnvelopeResponse<List<VendaDto>> getListaVendasFechadas() {
		List<Venda> listaVendasFechadas = vendaRepository.findByNroStatusVenda("F");

		List<VendaDto> listaVendasFechadasDto = new ArrayList<VendaDto>();
		for (Venda vendas : listaVendasFechadas) {
			listaVendasFechadasDto.add(VendaDto.build(vendas));
		}

		return new EnvelopeResponse<List<VendaDto>>(listaVendasFechadasDto);
	}

}
