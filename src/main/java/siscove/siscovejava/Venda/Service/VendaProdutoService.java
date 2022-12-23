package siscove.siscovejava.Venda.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.LogVendaProduto.Service.LogVendaProdutoService;
import siscove.siscovejava.Token.Dto.TokenDto;
import siscove.siscovejava.Token.Service.TokenService;
import siscove.siscovejava.Venda.Dto.VendaProdutoDto;
import siscove.siscovejava.Venda.Entity.VendaProduto;
import siscove.siscovejava.Venda.Entity.VendaProdutoId;
import siscove.siscovejava.Venda.Enum.TipoOperacaoEnum;
import siscove.siscovejava.Venda.Repository.VendaProdutoDao;

@Service
public class VendaProdutoService {
	
	@Autowired
	private VendaProdutoDao vendaProdutoDao;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private LogVendaProdutoService logVendaProdutoService;

	public EnvelopeResponse<VendaProdutoDto> salvar(VendaProdutoDto vendaProdutoDto, String token) {
		TokenDto tokenDto = tokenService.getByToken(token).getObjeto();
		VendaProduto vendaProduto = vendaProdutoDao.save(VendaProdutoDto.parse(vendaProdutoDto));
		
		TipoOperacaoEnum operacao = TipoOperacaoEnum.ALTERACAO;
		if (vendaProdutoDto.getCodProduto ()==null) {
			operacao = TipoOperacaoEnum.INCLUSAO;
		}
		
		logVendaProdutoService.salvar(vendaProdutoDto.getCodProduto(),vendaProduto.getCodFuncionario(), tokenDto.getCodUsuario(), operacao);
		;
		vendaProdutoDto.setCodProduto(vendaProdutoDto.getCodProduto());
		vendaProdutoDto.setCodFuncionario(vendaProduto.getCodFuncionario());
		
		vendaProdutoDto.setCodFuncionario(tokenDto.getCodUsuario());
		
		if (vendaProdutoDto.getCodProduto()==null) {
			return new EnvelopeResponse<VendaProdutoDto>(null, false, "Código do produto não informado!");
		}
		
		if (vendaProdutoDto.getNroSequencial()==null) {
			return new EnvelopeResponse<VendaProdutoDto>(null, false, "Número Sequencial não informado!");
		}
		
		if (vendaProdutoDto.getCodVenda()==null) {
			return new EnvelopeResponse<VendaProdutoDto>(null, false, "Código da venda não informado!");
		}
		
		VendaProduto vendaProdutos = VendaProdutoDto.parse(vendaProdutoDto);
		
		vendaProdutos = vendaProdutoDao.save(vendaProdutos);
		
		vendaProdutoDto = VendaProdutoDto.build(vendaProduto);

		return new EnvelopeResponse<VendaProdutoDto>(vendaProdutoDto);
		
		
	
	}
	
	public EnvelopeResponse<List<VendaProdutoDto>> getListaProdutosVenda(Integer codVenda) {
		List<VendaProduto> listaProdutosVenda = vendaProdutoDao.findByIdCodVenda(codVenda);
		
		List<VendaProdutoDto> listaVendasProdutoDto = new ArrayList<VendaProdutoDto>();
		for (VendaProduto venda : listaProdutosVenda) {
			listaVendasProdutoDto.add(VendaProdutoDto.build(venda));
		}
		
		return new EnvelopeResponse<List<VendaProdutoDto>>(listaVendasProdutoDto);
	}
	
	public EnvelopeResponse<List<VendaProdutoDto>> excluirProdutosVenda(
			Integer nroSequencial,
			Integer codVenda,
			Integer codProduto) {
		
		VendaProdutoId id = new VendaProdutoId();
		id.setNroSequencial(nroSequencial);
		id.setCodVenda(codVenda);
		id.setCodProduto(codProduto);
		VendaProduto vendaProduto = new VendaProduto();
		vendaProduto.setId(id);
		
		vendaProduto = vendaProdutoDao.findById(id);
		vendaProdutoDao.delete(vendaProduto);
		
		return this.getListaProdutosVenda(codVenda);
	}
	
}
