package siscove.siscovejava.TipoPagamento.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.TipoPagamento.Dto.TipoPagamentoDto;
import siscove.siscovejava.TipoPagamento.Entity.TipoPagamento;
import siscove.siscovejava.TipoPagamento.Repository.TipoPagamentoDao;
import siscove.siscovejava.TipoProduto.Dto.TipoProdutoDto;
import siscove.siscovejava.TipoProduto.Entity.TipoProduto;

@Service
public class TipoPagamentoService {

	@Autowired
	private TipoPagamentoDao tipoPagamentoDao;

	public EnvelopeResponse<TipoPagamentoDto> salvar(TipoPagamentoDto tipoPagamentoDto, String token) {

		TipoPagamento tipoPagamento = tipoPagamentoDao.save(TipoPagamentoDto.parse(tipoPagamentoDto));

		tipoPagamentoDto = TipoPagamentoDto.build(tipoPagamento);

		return new EnvelopeResponse<TipoPagamentoDto>(tipoPagamentoDto);
	}
	
	public EnvelopeResponse<List<TipoPagamentoDto>> getListarTipoPagamento(){
		List<TipoPagamento> listarTipoPagamento = (List<TipoPagamento>) tipoPagamentoDao.findAll();
		
		List<TipoPagamentoDto> listarTipoPagamentoDto = new ArrayList<TipoPagamentoDto>();
		for (TipoProduto tipoProduto : listarTipoPagamento) {
			listarTipoPagamentoDto.add(TipoProdutoDto.build(tipoProduto));
		}
		return new EnvelopeResponse<List<TipoProdutoDto>>(listarTipoProdutoDto);
	}
	
	public EnvelopeResponse<List<TipoProdutoDto>> getListarAtivos(){
		List<TipoProduto> listarAtivos = (List<TipoProduto>) tipoProdutoDao.findAll();
		
		List <TipoProdutoDto> listarAtivosDto = new ArrayList<TipoProdutoDto>();
		for (TipoProduto tipoProduto : listarAtivos) {
			if (tipoProduto.getIndAtivo().equals("S")) 
			    listarAtivosDto.add(TipoProdutoDto.build(tipoProduto));
		}
		return new EnvelopeResponse<List<TipoProdutoDto>>(listarAtivosDto);
	}

	public EnvelopeResponse<List<TipoProdutoDto>> ListarTipoProduto(Integer codTipoProduto) {
		TipoProduto tipoProduto = tipoProdutoDao.findById(codTipoProduto).get();

		List<TipoProdutoDto> listarTipoProdutoDto = new ArrayList<TipoProdutoDto>();
			listarTipoProdutoDto.add(TipoProdutoDto.build(tipoProduto));
		
		return new EnvelopeResponse<List<TipoProdutoDto>>(listarTipoProdutoDto);
	}
	
}