package siscove.siscovejava.LogVendaPagamento.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.LogVendaPagamento.Entity.LogVendaPagamento;
import siscove.siscovejava.LogVendaPagamento.Repository.LogVendaPagamentoRepository;
import siscove.siscovejava.Venda.Enum.TipoOperacaoEnum;

@Service
public class LogVendaPagamentoService {
	
	@Autowired
	private LogVendaPagamentoRepository logVendaPagamentoRepository;

	public void salvar(Integer codVenda, Integer codUsuario,Integer codPagamento,Integer codTipoPagamento, TipoOperacaoEnum tipoOperacao) {		
		LogVendaPagamento logVendaPagamento = new LogVendaPagamento();
		logVendaPagamento.setCodVenda(codVenda);
		logVendaPagamento.setCodUsuario(codUsuario);
		logVendaPagamento.setCodPagamento(codPagamento);
		logVendaPagamento.setCodTipoPagamento(codTipoPagamento);
		logVendaPagamento.setDtaOperacao(LocalDateTime.now());
		logVendaPagamento.setTipoOperacao(tipoOperacao.getDscOperacao());
		
		logVendaPagamentoRepository.save(logVendaPagamento);
	}

}
