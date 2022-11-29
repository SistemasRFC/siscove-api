package siscove.siscovejava.Produto.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Marca.Dto.MarcaDto;
import siscove.siscovejava.Marca.Service.MarcaService;
import siscove.siscovejava.Produto.Dao.ProdutoDao;
import siscove.siscovejava.Produto.Dto.ProdutoAutoDto;
import siscove.siscovejava.Produto.Dto.ProdutoDto;
import siscove.siscovejava.Produto.Entity.Produto;
import siscove.siscovejava.Produto.Repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoDao produtoDao;
	@Autowired
	private ProdutoRepository produtoRepo;
	
	@Autowired
	private MarcaService marcaSerivce;

	public EnvelopeResponse<List<ProdutoDto>> getListaProdutos(String txtTermo) {
		List<Produto> listaProdutos = produtoDao.findByDscProduto(txtTermo);

		List<ProdutoDto> listarProdutosDto = new ArrayList<ProdutoDto>();
		for (Produto produto : listaProdutos) {
			ProdutoDto produtoDto = ProdutoDto.build(produto);

			if (null != produto.getCodMarca()) {
				MarcaDto marcaDto = marcaSerivce.findByCodMarca(produto.getCodMarca()).getObjeto();
				if (null != marcaDto) {
					produtoDto.setDscProduto(marcaDto.getDscMarca());
				}
			}
			listarProdutosDto.add(produtoDto);
		}

		return new EnvelopeResponse<List<ProdutoDto>>(listarProdutosDto);
	}
	
	public EnvelopeResponse<List<ProdutoAutoDto>> getListaProdutoByDscProduto(String dscProduto) {
		List<ProdutoAutoDto> listarProdutos = produtoDao.getListaProdutosAuto(dscProduto);
		
		return new EnvelopeResponse<List<ProdutoAutoDto>>(listarProdutos);
	}
	

	public EnvelopeResponse<ProdutoDto> salvar(ProdutoDto produtoDto) {
		Produto produto = ProdutoDto.parse(produtoDto);

		produto = produtoRepo.save(produto);

		produtoDto.setCodProduto(produto.getCodProduto());

		return new EnvelopeResponse<ProdutoDto>(produtoDto);
	}
}
