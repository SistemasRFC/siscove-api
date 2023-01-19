package siscove.siscovejava.Entrada.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Entrada.Dao.EntradaDao;
import siscove.siscovejava.Entrada.Dto.EntradaDto;
import siscove.siscovejava.Entrada.Dto.ListagemEntradasDto;
import siscove.siscovejava.Entrada.Entity.Entrada;
import siscove.siscovejava.Entrada.Repository.EntradaRepository;
import siscove.siscovejava.Token.Dto.TokenDto;
import siscove.siscovejava.Token.Service.TokenService;
import siscove.siscovejava.Util.UtilData;
import siscove.siscovejava.UtilMoeda.UtilMoeda;

@Service
public class EntradaService {

	@Autowired
	private EntradaRepository entradaRepository;

	@Autowired
	private EntradaDao entradaDao;

	@Autowired
	private TokenService tokenService;

	public EnvelopeResponse<List<ListagemEntradasDto>> findEntradasAbertas() {
		List<ListagemEntradasDto> listaEntradasAbertas = entradaDao.getListaEntradasAbertas();

		for (ListagemEntradasDto entrada : listaEntradasAbertas) {
			entrada.setDtaEntradaFormatada(UtilData.formataData(entrada.getDtaEntrada()));
		}

		for (ListagemEntradasDto entrada : listaEntradasAbertas) {
			entrada.setVlrTotalFormatada(UtilMoeda.formataMoeda(entrada.getVlrTotal()));
		}

		return new EnvelopeResponse<List<ListagemEntradasDto>>(listaEntradasAbertas);
	}

	public EnvelopeResponse<List<ListagemEntradasDto>> findEntradasFechadas(Integer codFornecedor) {
		List<ListagemEntradasDto> listaEntradasFechadas = entradaDao.getListaEntradasFechadas(codFornecedor);

		for (ListagemEntradasDto entrada : listaEntradasFechadas) {
			entrada.setDtaEntradaFormatada(UtilData.formataData(entrada.getDtaEntrada()));
		}

		for (ListagemEntradasDto entrada : listaEntradasFechadas) {
			entrada.setVlrTotalFormatada(UtilMoeda.formataMoeda(entrada.getVlrTotal()));
		}

		return new EnvelopeResponse<List<ListagemEntradasDto>>(listaEntradasFechadas);
	}

	public EnvelopeResponse<Boolean> salvar(EntradaDto entradaDto, String token) {
		Entrada entrada = EntradaDto.parse(entradaDto);

		if (entradaDto.getNroSequencial() == null) {
			TokenDto tokenDto = tokenService.getByToken(token).getObjeto();
			entrada.setCodUsuario(tokenDto.getCodUsuario());
		}
		entradaRepository.save(entrada);

		return new EnvelopeResponse<Boolean>(true);
	}

	public EnvelopeResponse<EntradaDto> findByNroSequencial(Integer nroSequencial) {
		Entrada entrada = entradaRepository.findByNroSequencial(nroSequencial);

		return new EnvelopeResponse<EntradaDto>(EntradaDto.build(entrada));
	}

}
