package siscove.siscovejava.Entrada.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Deposito.Dto.DepositoDto;
import siscove.siscovejava.Entrada.Dao.EntradaDao;
import siscove.siscovejava.Entrada.Dto.EntradaDto;
import siscove.siscovejava.Entrada.Dto.EntradasAbertasDto;
import siscove.siscovejava.Entrada.Entity.Entrada;
import siscove.siscovejava.Entrada.Repository.EntradaRepository;
import siscove.siscovejava.EntradaEstoque.Dto.EntradaEstoqueDto;
import siscove.siscovejava.EntradaEstoque.Entity.EntradaEstoque;
import siscove.siscovejava.Fornecedor.Dto.FornecedorDto;

@Service
public class EntradaService {

	@Autowired
	private EntradaRepository entradaRepository;
	
	@Autowired
	private EntradaDao entradaDao;

	public EnvelopeResponse<List<EntradasAbertasDto>> findEntradasAbertas() {
		List<EntradasAbertasDto> listaEntradasAbertas = entradaDao.getListaEntradasAbertas();

//		List<EntradaDto> listarAtivosDto = new ArrayList<EntradaDto>();
//		for (Entrada entrada : listarAtivos) {
//			
//			List<EntradaEstoqueDto> listarEntradaEstoqueDto = new ArrayList<EntradaEstoqueDto>();
//			float vlrTotal = 0;
//			if (null != entrada.getListaEntradaEstoque()) {
//				for (EntradaEstoque entradaEstoque : entrada.getListaEntradaEstoque()) {
//					vlrTotal += entradaEstoque.getVlrUnitario() * entradaEstoque.getQtdEntrada();
//				}
//
//			}
//			
//			String indEntrada = "";
//			if (null != entrada.getIndEntrada()) {
//				indEntrada = entrada.getIndEntrada();
//			}
//			FornecedorDto fornecedorDto = new FornecedorDto();
//			if (null != entrada.getFornecedor()) {
//				fornecedorDto = FornecedorDto.build(entrada.getFornecedor());
//			}
//			DepositoDto depositoDto = new DepositoDto();
//			if (null != entrada.getDeposito()) {
//				depositoDto = DepositoDto.build(entrada.getDeposito());
//			}
//
//			EntradaDto entradaDto = new EntradaDto(entrada.getNroSequencial(), entrada.getNroNotaFiscal(),
//					entrada.getDtaEntrada(), fornecedorDto, depositoDto, entrada.getCodUsuario(),
//					entrada.getTxtObservacao(), indEntrada, entrada.getCodClienteFinal(), listarEntradaEstoqueDto,
//					vlrTotal);
//			
//			listarAtivosDto.add(entradaDto);
//		}
		return new EnvelopeResponse<List<EntradasAbertasDto>>(listaEntradasAbertas);
	}

	public EnvelopeResponse<List<EntradaDto>> getListarEntrada() {
		List<Entrada> listaEntrada = (List<Entrada>) entradaRepository.findAll();

		List<EntradaDto> listaEntradaDto = new ArrayList<EntradaDto>();
		for (Entrada entrada : listaEntrada) {
			listaEntradaDto.add(EntradaDto.build(entrada));
		}
		return new EnvelopeResponse<List<EntradaDto>>(listaEntradaDto);

	}

	public EnvelopeResponse<EntradaDto> salvar(EntradaDto entradaDto) {
		Entrada entrada = entradaRepository.save(EntradaDto.parse(entradaDto));

		entradaDto = EntradaDto.build(entrada);

		return new EnvelopeResponse<EntradaDto>(entradaDto);
	}

}
