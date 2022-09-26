package siscove.siscovejava.TipoPagamento.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.TipoPagamento.Dto.TipoPagamentoDto;
import siscove.siscovejava.TipoPagamento.Entity.TipoPagamento;
import siscove.siscovejava.TipoPagamento.Repository.TipoPagamentoDao;
import siscove.siscovejava.Token.Dto.TokenDto;
import siscove.siscovejava.Token.Service.TokenService;

@Service
public class TipoPagamentoService {

	@Autowired
	private TipoPagamentoDao tipoPagamentoDao;

	public EnvelopeResponse<TipoPagamentoDto> salvar(TipoPagamentoDto tipoPagamentoDto, String token) {

		TipoPagamento tipoPagamento = tipoPagamentoDao.save(TipoPagamentoDto.parse(tipoPagamentoDto));

		tipoPagamentoDto = TipoPagamentoDto.build(tipoPagamento);

		return new EnvelopeResponse<TipoPagamentoDto>(tipoPagamentoDto);
	}
}
