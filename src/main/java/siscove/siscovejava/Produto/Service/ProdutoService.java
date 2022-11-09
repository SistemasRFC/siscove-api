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
				MarcaDto marcaDto = marcaSerivce.findByCodMarca(produto.getCodMarca()).getObjeto();
				if (null != marcaDto) {
					produtoDto.setDscMarca(marcaDto.getDscMarca());
				}
			}
			listarProdutosDto.add(produtoDto);
		}

		return new EnvelopeResponse<List<ProdutoDto>>(listarProdutosDto);
	}
	
	public EnvelopeResponse<List<ProdutoDto>> getListaProdutoByPesquisaDinamica(String dscProduto) {
		List<Produto> listarProdutos = produtoDao.findByDscProduto(dscProduto);

		List<ProdutoDto> listarProdutosDto = new ArrayList<ProdutoDto>();
		for (Produto produto : listarProdutos) {
			ProdutoDto ProdutoDto = ProdutoDto.build(produto);
			listarProdutosDto.add(ProdutoDto);
		}
		
		return new EnvelopeResponse<List<ProdutoDto>>(listarProdutosDto);
	}

	public EnvelopeResponse<ProdutoDto> salvar(ProdutoDto produtoDto) {
		Produto produto = ProdutoDto.parse(produtoDto);

		produto = produtoDao.save(produto);

		produtoDto.setCodProduto(produto.getCodProduto());

		return new EnvelopeResponse<ProdutoDto>(produtoDto);
	}
}
