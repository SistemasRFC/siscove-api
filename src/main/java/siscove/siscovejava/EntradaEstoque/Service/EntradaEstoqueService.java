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
import siscove.siscovejava.EntradaEstoque.Repository.EntradaEstoqueRepository;
import siscove.siscovejava.Produto.Entity.Produto;

@Service
public class EntradaEstoqueService {

	@Autowired
	private EntradaEstoqueRepository entradaEstoqueRepository;

	public EnvelopeResponse<List<EntradaEstoqueDto>> getListarEntradaEstoque() {
		List<EntradaEstoque> listarEntradaEstoque = (List<EntradaEstoque>) entradaEstoqueRepository.findAll();

		List<EntradaEstoqueDto> listarEntradaEstoqueDto = new ArrayList<EntradaEstoqueDto>();
		for (EntradaEstoque entradaEstoque : listarEntradaEstoque) {

			listarEntradaEstoqueDto.add(EntradaEstoqueDto.build(entradaEstoque));
		}
		return new EnvelopeResponse<List<EntradaEstoqueDto>>(listarEntradaEstoqueDto);

	}

	public EnvelopeResponse<List<EntradaEstoqueDto>> getCalcular() {
		List<EntradaEstoque> listarEntradaEstoque = (List<EntradaEstoque>) entradaEstoqueRepository.findAll();

		List<EntradaEstoqueDto> listarEntradaEstoqueDto = new ArrayList<EntradaEstoqueDto>();
		float vlrTotal = 0;
		for (EntradaEstoque entradaEstoque : listarEntradaEstoque) {
			vlrTotal += entradaEstoque.getVlrUnitario() * entradaEstoque.getVlrMinimo();
			listarEntradaEstoqueDto.add(EntradaEstoqueDto.build(entradaEstoque));

		}
		return new EnvelopeResponse<List<EntradaEstoqueDto>>(listarEntradaEstoqueDto);
	}

	public EnvelopeResponse<List<EntradaEstoqueDto>> getListaEntradaEstoqueByNroSequencial(Integer nroSequencial) {
		List<EntradaEstoque> listaEntradaEstoque = new ArrayList<EntradaEstoque>();
		listaEntradaEstoque = entradaEstoqueRepository.getListaEntradaEstoqueByNroSequencial(nroSequencial);

		List<EntradaEstoqueDto> listarEntradaEstoqueDto = new ArrayList<EntradaEstoqueDto>();
		for (EntradaEstoque entradaEstoque : listaEntradaEstoque) {

			listarEntradaEstoqueDto.add(EntradaEstoqueDto.build(entradaEstoque));
		}
		return new EnvelopeResponse<List<EntradaEstoqueDto>>(listarEntradaEstoqueDto);

	}

	public EnvelopeResponse<List<EntradaEstoqueDto>> salvar(EntradaEstoqueDto entradaEstoqueDto) {

		entradaEstoqueRepository.saveAndFlush(EntradaEstoqueDto.parse(entradaEstoqueDto));

		return this.getListaEntradaEstoqueByNroSequencial(entradaEstoqueDto.getNroSequencial());
	}

	public EnvelopeResponse<List<EntradaEstoqueDto>> removerProduto(Integer nroSequencial,Integer codProduto) {
		Produto produto = new Produto();
		produto.setCodProduto(codProduto);
		EntradaEstoqueId entradaEstoqueId = new EntradaEstoqueId();
		entradaEstoqueId.setNroSequencial(nroSequencial);
		entradaEstoqueId.setCodProduto(codProduto);
		Optional<EntradaEstoque> entradaEstoque = entradaEstoqueRepository.findById(entradaEstoqueId);
		entradaEstoqueRepository.delete(entradaEstoque.get());
		return this.getListaEntradaEstoqueByNroSequencial(nroSequencial);
	}
}