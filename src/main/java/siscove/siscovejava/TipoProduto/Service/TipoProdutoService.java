package siscove.siscovejava.TipoProduto.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.TipoProduto.Dto.TipoProdutoDto;
import siscove.siscovejava.TipoProduto.Entity.TipoProduto;
import siscove.siscovejava.TipoProduto.Repository.TipoProdutoDao;
import siscove.siscovejava.Token.Dto.TokenDto;
import siscove.siscovejava.Token.Service.TokenService;

@Service
public class TipoProdutoService {

	@Autowired
	private TipoProdutoDao tipoProdutoDao;
	
	@Autowired
	private TokenService tokenService;  
	
	public EnvelopeResponse<TipoProdutoDto> salvar(TipoProdutoDto tipoProdutoDto, String token) {
		
		TokenDto tokenDto = tokenService.getByToken(token).getObjeto();
		
		tipoProdutoDto.setCodClienteFinal(tokenDto.getCodClienteFinal());
		
		TipoProduto tipoProduto = tipoProdutoDao.save(TipoProdutoDto.parse(tipoProdutoDto));
		
		
		tipoProdutoDto = TipoProdutoDto.build(tipoProduto);


		return new EnvelopeResponse<TipoProdutoDto>(tipoProdutoDto);
	}
	
	public EnvelopeResponse<List<TipoProdutoDto>> getListarTipoProduto(){
		List<TipoProduto> listarTipoProduto = (List<TipoProduto>) tipoProdutoDao.findAll();
		
		List<TipoProdutoDto> listarTipoProdutoDto = new ArrayList<TipoProdutoDto>();
		for (TipoProduto tipoProduto : listarTipoProduto) {
			listarTipoProdutoDto.add(TipoProdutoDto.build(tipoProduto));
		}
		return new EnvelopeResponse<List<TipoProdutoDto>>(listarTipoProdutoDto);
	}
	
	public EnvelopeResponse<List<TipoProdutoDto>> getListarAtivos(){
		List<TipoProduto> listarAtivos = (List<TipoProduto>) tipoProdutoDao.findAll();
		
		List <TipoProdutoDto> listarAtivosDto = new ArrayList<TipoProdutoDto>();
		for (TipoProduto tipoProduto : listarAtivos) {
			if (tipoProduto.getIndAtivo().equals("S")) 
			    listarAtivosDto.add(TipoProdutoDto.build(tipoProduto));
		}
		return new EnvelopeResponse<List<TipoProdutoDto>>(listarAtivosDto);
	}

	public EnvelopeResponse<List<TipoProdutoDto>> ListarTipoProduto(Integer codTipoProduto) {
		TipoProduto tipoProduto = tipoProdutoDao.findById(codTipoProduto).get();

		List<TipoProdutoDto> listarTipoProdutoDto = new ArrayList<TipoProdutoDto>();
			listarTipoProdutoDto.add(TipoProdutoDto.build(tipoProduto));
		
		return new EnvelopeResponse<List<TipoProdutoDto>>(listarTipoProdutoDto);
	}
	
}
 
