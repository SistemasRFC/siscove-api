package siscove.siscovejava.EntradaEstoque.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.EntradaEstoque.Dto.EntradaEstoqueDto;
import siscove.siscovejava.EntradaEstoque.Entity.EntradaEstoque;
import siscove.siscovejava.EntradaEstoque.Entity.EntradaEstoqueId;
import siscove.siscovejava.EntradaEstoque.Repository.EntradaEstoqueDao;
import siscove.siscovejava.Produto.Entity.Produto;

@Service
public class EntradaEstoqueService {

	@Autowired
	private EntradaEstoqueDao entradaEstoqueDao;

	public EnvelopeResponse<List<EntradaEstoqueDto>> getListarEntradaEstoque() {
		List<EntradaEstoque> listarEntradaEstoque = (List<EntradaEstoque>) entradaEstoqueDao.findAll();

		List<EntradaEstoqueDto> listarEntradaEstoqueDto = new ArrayList<EntradaEstoqueDto>();
		for (EntradaEstoque entradaEstoque : listarEntradaEstoque) {

			listarEntradaEstoqueDto.add(EntradaEstoqueDto.build(entradaEstoque));
		}
		return new EnvelopeResponse<List<EntradaEstoqueDto>>(listarEntradaEstoqueDto);

	}

	public EnvelopeResponse<List<EntradaEstoqueDto>> getCalcular() {
		List<EntradaEstoque> listarEntradaEstoque = (List<EntradaEstoque>) entradaEstoqueDao.findAll();

		List<EntradaEstoqueDto> listarEntradaEstoqueDto = new ArrayList<EntradaEstoqueDto>();
		float vlrTotal = 0;
		for (EntradaEstoque entradaEstoque : listarEntradaEstoque) {
			vlrTotal += entradaEstoque.getVlrUnitario() * entradaEstoque.getVlrMinimo();
			listarEntradaEstoqueDto.add(EntradaEstoqueDto.build(entradaEstoque));

		}
		return new EnvelopeResponse<List<EntradaEstoqueDto>>(listarEntradaEstoqueDto);
	}

	public EnvelopeResponse<List<EntradaEstoqueDto>> getListaEntradaEstoqueByNroSequencial(Integer nroSequencial) {
		List<EntradaEstoque> listarEntradaEstoque = entradaEstoqueDao
				.getListaEntradaEstoqueByNroSequencial(nroSequencial);

		List<EntradaEstoqueDto> listarEntradaEstoqueDto = new ArrayList<EntradaEstoqueDto>();
		for (EntradaEstoque entradaEstoque : listarEntradaEstoque) {

			listarEntradaEstoqueDto.add(EntradaEstoqueDto.build(entradaEstoque));
		}
		return new EnvelopeResponse<List<EntradaEstoqueDto>>(listarEntradaEstoqueDto);

	}

	public EnvelopeResponse<EntradaEstoqueDto> salvar(EntradaEstoqueDto entradaEstoqueDto) {

		EntradaEstoque entradaEstoque = entradaEstoqueDao.save(EntradaEstoqueDto.parse(entradaEstoqueDto));

		entradaEstoqueDto = EntradaEstoqueDto.build(entradaEstoque);

		return new EnvelopeResponse<EntradaEstoqueDto>(entradaEstoqueDto);
	}

	public EnvelopeResponse<List<EntradaEstoqueDto>> removerProduto(Integer nroSequencial,Integer codProduto) {
		Produto produto = new Produto();
		produto.setCodProduto(codProduto);
		EntradaEstoqueId entradaEstoqueId = new EntradaEstoqueId();
		entradaEstoqueId.setNroSequencial(nroSequencial);
		entradaEstoqueId.setProduto(produto);
		Optional<EntradaEstoque> entradaEstoque = entradaEstoqueDao.findById(entradaEstoqueId);
		entradaEstoqueDao.delete(entradaEstoque.get());
		return this.getListaEntradaEstoqueByNroSequencial(nroSequencial);
	}
}