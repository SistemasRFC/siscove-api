package siscove.siscovejava.Venda.Service;

import org.springframework.beans.factory.annotation.Autowired;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Venda.Dto.VendaProdutoDto;
import siscove.siscovejava.Venda.Entity.VendaProduto;
import siscove.siscovejava.Venda.Repository.VendaProdutoDao;

public class VendaProdutoService {
	
	@Autowired
	private VendaProdutoDao vendaProdutoDao;

	public EnvelopeResponse<VendaProdutoDto> salvar(VendaProdutoDto vendaProdutoDto) {		
		VendaProduto vendaProduto = vendaProdutoDao.save(VendaProdutoDto.parse(vendaProdutoDto));
		
		vendaProdutoDto = VendaProdutoDto.build(vendaProduto);

	return new EnvelopeResponse<VendaProdutoDto>(vendaProdutoDto);
	
	}

}
