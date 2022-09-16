package Produto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Deposito.Dto.DepositoDto;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoDao produtoDao;

	public EnvelopeResponse<List<ProdutoDto>> getListaProduto() {
		List<Produto> listaProduto = (List<Produto>) produtoDao.findAll();

		List<ProdutoDto> listaProdutoDto = new ArrayList<ProdutoDto>();
		for (Produto produto : listaProduto) {
			if (null!=produto.getIndAtivo() && produto.getIndAtivo().equals("S")) {
				listaProdutoDto.add(DepositoDto.build(produto));
			}
		}
		return new EnvelopeResponse<List<ProdutoDto>>(listaProdutoDto);
	}
}
