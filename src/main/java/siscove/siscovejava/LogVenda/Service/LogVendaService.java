package siscove.siscovejava.LogVenda.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.LogVenda.Entity.LogVenda;
import siscove.siscovejava.LogVenda.Repository.LogVendaRepository;
import siscove.siscovejava.Venda.Enum.TipoOperacaoEnum;

@Service
public class LogVendaService {
	
	@Autowired
	private LogVendaRepository logVendaRepository;

	public void salvar(Integer codVenda, Integer codUsuario, TipoOperacaoEnum tipoOperacao) {		
		LogVenda logVenda = new LogVenda();
		logVenda.setCodVenda(codVenda);
		logVenda.setCodUsuario(codUsuario);
		logVenda.setDtaOperacao(LocalDateTime.now());
		logVenda.setTipoOperacao(tipoOperacao.getDscOperacao());
		
		logVendaRepository.save(logVenda);
	}

}
