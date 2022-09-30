package siscove.siscovejava.TipoPagamento.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.TipoPagamento.Dto.TipoPagamentoDto;
import siscove.siscovejava.TipoPagamento.Entity.TipoPagamento;
import siscove.siscovejava.TipoPagamento.Repository.TipoPagamentoDao;

@Service
public class TipoPagamentoService {

	@Autowired
	private TipoPagamentoDao tipoPagamentoDao;

	public EnvelopeResponse<TipoPagamentoDto> salvar(TipoPagamentoDto tipoPagamentoDto) {

		TipoPagamento tipoPagamento = tipoPagamentoDao.save(TipoPagamentoDto.parse(tipoPagamentoDto));

		tipoPagamentoDto = TipoPagamentoDto.build(tipoPagamento);

		return new EnvelopeResponse<TipoPagamentoDto>(tipoPagamentoDto);
	}

	public EnvelopeResponse<List<TipoPagamentoDto>> getListarTipoPagamento() {
		List<TipoPagamento> listarTipoPagamento = (List<TipoPagamento>) tipoPagamentoDao.findAll();

		List<TipoPagamentoDto> listarTipoPagamentoDto = new ArrayList<TipoPagamentoDto>();
		for (TipoPagamento tipoPagamento : listarTipoPagamento) {

				listarTipoPagamentoDto.add(TipoPagamentoDto.build(tipoPagamento));
			
		}
		return new EnvelopeResponse<List<TipoPagamentoDto>>(listarTipoPagamentoDto);
	}

	public EnvelopeResponse<List<TipoPagamentoDto>> getListarAtivos() {
		List<TipoPagamento> listarAtivos = (List<TipoPagamento>) tipoPagamentoDao.findAll();

		List<TipoPagamentoDto> listarAtivosDto = new ArrayList<TipoPagamentoDto>();
		for (TipoPagamento tipoPagamento : listarAtivos) {
			if (tipoPagamento.getIndAtivo().equals("S"))
				listarAtivosDto.add(TipoPagamentoDto.build(tipoPagamento));
		}
		return new EnvelopeResponse<List<TipoPagamentoDto>>(listarAtivosDto);
	}

}