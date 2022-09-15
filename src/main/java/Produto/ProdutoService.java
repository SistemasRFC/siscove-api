package Produto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import siscove.siscovejava.Config.response.EnvelopeResponse;

public class ProdutoService {
	
	@Autowired
	private ProdutoDao produtoDao;
	
	public EnvelopeResponse<ProdutoDto> salvar(ProdutoDto produtoDto) {

		Produto produto = produtoDao.save(ProdutoDto.parse(produtoDto));
		
		produtoDto = ProdutoDto.build(produto);


		return new EnvelopeResponse<ProdutoDto>(produtoDto);
	}
	
	public EnvelopeResponse<List<ProdutoDto>> getListarProduto(){
		List<Object[]> listarProduto = (List<Object[]>) produtoDao.getListarProduto();
		
		List<ProdutoDto> listarMenuDto = new ArrayList<ProdutoDto>();
		for (Object[] produto : listarProduto) {
			listarProdutoDto.add(new ProdutoDto(
					Integer.valueOf(produto[0].toString()), 
					null==produto[1]?"":produto[1].toString(), 
					produto[2].toString(), 
					produto[3].toString(), 
					Integer.valueOf(null==produto[4]?"0":produto[4].toString()),  
		}
		return new EnvelopeResponse<List<ProdutoDto>>(listaProdutoDto);
	}
	
	public EnvelopeResponse<List<ProdutoDto>> getListarAtivos(){
		List<Produto> listarAtivos = (List<Produto>) produtoDao.findAll();
		
		List <ProdutoDto> listarAtivosDto = new ArrayList<produtoDto>();
		for (Produto produto : listarAtivos) {
			if (produto.getIndAtivo().equals("S")) 
			    listarAtivosDto.add(ProdutoDto.build(produto));
		}
		return new EnvelopeResponse<List<ProdutoDto>>(listarAtivosDto);
	}

	public EnvelopeResponse<List<ProdutoDto>> ListarProduto(Integer codTipoProduto) {
		Produto produto = produtoDao.findById(codTipoProduto).get();

		List<ProdutoDto> listaProdutoDto = new ArrayList<ProdutoDto>();
			listaProdutoDto.add(ProdutoDto.build(produto));
		
		return new EnvelopeResponse<List<ProdutoDto>>(listaProdutoDto);
	}

}
