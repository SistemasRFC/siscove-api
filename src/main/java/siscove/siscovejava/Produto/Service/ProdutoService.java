package siscove.siscovejava.Produto.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Marca.Dto.MarcaDto;
import siscove.siscovejava.Marca.Service.MarcaService;
import siscove.siscovejava.Produto.Dto.ProdutoDto;
import siscove.siscovejava.Produto.Entity.Produto;
import siscove.siscovejava.Produto.Repository.ProdutoDao;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoDao produtoDao;

	@Autowired
	private MarcaService marcaSerivce;

	public EnvelopeResponse<List<ProdutoDto>> getListarProdutos(String txtTermo) {
		List<Produto> listaProdutos = (List<Produto>) produtoDao.findBydscProduto(txtTermo);

		List<ProdutoDto> listarProdutosDto = new ArrayList<ProdutoDto>();
		for (Produto produto : listaProdutos) {
			ProdutoDto produtoDto = ProdutoDto.build(produto);

			if (null != produto.getCodMarca()) {
				MarcaDto marcaDto = marcaSerivce.findByCodMarca(produto.getCodMarca());
				if (null != marcaDto) {
					produtoDto.setMarca(marcaDto);
				}
			}
			if (null != produtoDto.getMarca()) {
				produtoDto.setDscProduto(produtoDto.getDscProduto()+" Marca: "+produtoDto.getMarca().getDscMarca());
			}
			listarProdutosDto.add(produtoDto);
		}

		return new EnvelopeResponse<List<ProdutoDto>>(listarProdutosDto);
	}
	
	public EnvelopeResponse<List<ProdutoDto>> getListaProdutoByPoduto(String dscProduto) {
		List<Produto> listarProdutos = produtoDao.findBydscProduto(dscProduto);

		List<ProdutoDto> listarProdutoDto = new ArrayList<ProdutoDto>();
		for (Produto produto : listarProdutos) {
			ProdutoDto produtoDto = ProdutoDto.build(produto);
			listarProdutoDto.add(produtoDto);
		}
		
		return new EnvelopeResponse<List<ProdutoDto>>(listarProdutoDto);
	}
	

	public EnvelopeResponse<ProdutoDto> salvar(ProdutoDto produtoDto) {
		Produto produto = ProdutoDto.parse(produtoDto);

		produto = produtoDao.save(produto);

		produtoDto.setCodProduto(produto.getCodProduto());

		return new EnvelopeResponse<ProdutoDto>(produtoDto);
	}
}
