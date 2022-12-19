package siscove.siscovejava.Venda.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.LogVendaPagamento.Service.LogVendaPagamentoService;
import siscove.siscovejava.Token.Dto.TokenDto;
import siscove.siscovejava.Token.Service.TokenService;
import siscove.siscovejava.Venda.Dto.VendaPagamentoDto;
import siscove.siscovejava.Venda.Entity.VendaPagamento;
import siscove.siscovejava.Venda.Enum.TipoOperacaoEnum;
import siscove.siscovejava.Venda.Repository.VendaPagamentoDao;

@Service
public class VendaPagamentoService {
	
	@Autowired
	private VendaPagamentoDao vendaPagamentoDao;

	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private LogVendaPagamentoService logVendaPagamentoService;
	
	public EnvelopeResponse<VendaPagamentoDto> salvar(VendaPagamentoDto vendaPagamentoDto, String token) {		
		VendaPagamento vendaPagamento = vendaPagamentoDao.save(VendaPagamentoDto.parse(vendaPagamentoDto));
	
		TipoOperacaoEnum operacao = TipoOperacaoEnum.ALTERACAO;
		if (vendaPagamentoDto.getCodVenda ()==null) {
			operacao = TipoOperacaoEnum.INCLUSAO;
		}
		
		vendaPagamento = vendaPagamentoDao.save(vendaPagamento);

		TokenDto tokenDto = tokenService.getByToken(token).getObjeto();
		
		logVendaPagamentoService.salvar(vendaPagamento.getCodVenda(),vendaPagamento.getNroSequencial(),vendaPagamento.getCodTipoPagamento(), tokenDto.getCodUsuario(), operacao);
		;
		vendaPagamentoDto.setCodVenda(vendaPagamento.getCodVenda());
		vendaPagamentoDto.setNroSequencial(vendaPagamento.getNroSequencial());
		vendaPagamentoDto.setCodTipoPagamento(vendaPagamento.getCodTipoPagamento ());
		

	return new EnvelopeResponse<VendaPagamentoDto>(vendaPagamentoDto);
	
	}

}
