package siscove.siscovejava.Venda.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Venda.Dto.VendaProdutoDto;
import siscove.siscovejava.Venda.Entity.VendaProduto;
import siscove.siscovejava.Venda.Repository.VendaProdutoDao;

@Service
public class VendaProdutoService {
	
	@Autowired
	private VendaProdutoDao vendaProdutoDao;

	public EnvelopeResponse<VendaProdutoDto> salvar(VendaProdutoDto vendaProdutoDto) {
		if (vendaProdutoDto.getCodProduto()==null) {
			return new EnvelopeResponse<VendaProdutoDto>(null, false, "Código do produto não informado!");
		}
		
		if (vendaProdutoDto.getNroSequencial()==null) {
			return new EnvelopeResponse<VendaProdutoDto>(null, false, "Número Sequencial não informado!");
		}
		
		if (vendaProdutoDto.getCodVenda()==null) {
			return new EnvelopeResponse<VendaProdutoDto>(null, false, "Código da venda não informado!");
		}
		
		VendaProduto vendaProduto = VendaProdutoDto.parse(vendaProdutoDto);
		
		vendaProduto = vendaProdutoDao.save(vendaProduto);
		
		vendaProdutoDto = VendaProdutoDto.build(vendaProduto);

		return new EnvelopeResponse<VendaProdutoDto>(vendaProdutoDto);
	
	}
	
	public EnvelopeResponse<List<VendaProdutoDto>> getListaProdutosVenda(Integer codVenda) {
		List<VendaProduto> listaProdutosVenda = vendaProdutoDao.findByIdCodVenda(codVenda);
		
		List<VendaProdutoDto> listaVendasProdutoDto = new ArrayList<VendaProdutoDto>();
		for (VendaProduto venda : listaProdutosVenda) {
			listaVendasProdutoDto.add(VendaProdutoDto.build(venda));
		}
		
		return new EnvelopeResponse<List<VendaProdutoDto>>(listaVendasProdutoDto);
	}

}
