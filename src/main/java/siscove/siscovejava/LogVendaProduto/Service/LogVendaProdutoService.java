package siscove.siscovejava.LogVendaProduto.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.LogVendaProduto.Entity.LogVendaProduto;
import siscove.siscovejava.LogVendaProduto.Repository.LogVendaProdutoRepository;
import siscove.siscovejava.Venda.Enum.TipoOperacaoEnum;

@Service
public class LogVendaProdutoService {

	@Autowired
	private LogVendaProdutoRepository logVendaProdutoRepository;

	public void salvar(Integer codOperacao, Integer codVenda,Integer codProduto, TipoOperacaoEnum tpoOperacao) {		
		LogVendaProduto logVendaProduto = new LogVendaProduto();
		logVendaProduto.setCodOperacao(codOperacao);
		logVendaProduto.setCodVenda(codVenda);
		logVendaProduto.setCodProduto(codProduto);
		logVendaProduto.setDtaOperacao(LocalDateTime.now());
		logVendaProduto.setTipoOperacao(tpoOperacao.getDscOperacao());
		
		logVendaProdutoRepository.save(logVendaProduto);
	}
}
