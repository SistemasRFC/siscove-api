package siscove.siscovejava.Venda.Dto;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Produto.Dto.ProdutoDto;
import siscove.siscovejava.TipoProduto.Dto.TipoProdutoDto;
import siscove.siscovejava.Usuario.Dto.UsuarioDto;
import siscove.siscovejava.Venda.Entity.VendaProduto;
import siscove.siscovejava.Venda.Entity.VendaProdutoId;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VendaProdutoDto {
	
	private Integer codVenda;
	private Integer nroSequencial;
	private Integer codProduto;
	private ProdutoDto produto;
	private Float vlrVenda;
	private Integer qtdVendida;
	private Float vlrDesconto;
	private Integer codFuncionario;
	private UsuarioDto funcionario;
	private String indEstoque;
	private LocalDateTime dtaVendaProduto;
	private String txtObservacao;

	public static VendaProdutoDto build(VendaProduto vendaProduto) {
		VendaProdutoDto vendaProdutoDto = new VendaProdutoDto();
				vendaProduto.getId().getCodVenda();
				vendaProduto.getId().getNroSequencial(); 
				vendaProduto.getId().getCodProduto();  
				vendaProduto.getVlrVenda(); 
				vendaProduto.getQtdVendida(); 
				vendaProduto.setCodFuncionario(vendaProduto.getCodFuncionario());
				if(vendaProduto.getFuncionario() != null && !vendaProduto.getFuncionario().getCodUsuario().equals(0)) {
					vendaProduto .setFuncionario(UsuarioDto.build(vendaProduto.getFuncionario()));			
				}
				vendaProduto.getVlrDesconto();
				VendaProduto.setProduto(vendaProduto.getProduto());
				if(vendaProduto.getProduto() != null && !vendaProduto.getProduto().getCodProduto().equals(0)) {
					vendaProdutoDto.setProduto(ProdutoDto.build(vendaProduto.getProduto()));
				}
				vendaProduto.getCodFuncionario(); 
				vendaProduto.getIndEstoque(); 
				vendaProduto.getDtaVendaProduto(); 
				vendaProduto.getTxtObservacao();
		return vendaProdutoDto;    
	}

	public static VendaProduto parse(VendaProdutoDto vendaProdutoDto) {
		VendaProduto vendaProduto = new VendaProduto();
		VendaProdutoId vendaProdutoId = new VendaProdutoId();
		vendaProdutoId.setCodVenda(vendaProdutoDto.getCodVenda());
		vendaProdutoId.setNroSequencial(vendaProdutoDto.getNroSequencial());
		vendaProdutoId.setCodProduto(vendaProdutoDto.getCodProduto());
		vendaProduto.setId(vendaProdutoId);
		vendaProduto.setVlrVenda(vendaProdutoDto.getVlrVenda());
		vendaProduto.setQtdVendida(vendaProdutoDto.getQtdVendida());
		vendaProduto.setVlrDesconto(vendaProdutoDto.getVlrDesconto());
		vendaProduto.setCodFuncionario(vendaProdutoDto.getCodFuncionario());
		vendaProduto.setIndEstoque(vendaProdutoDto.getIndEstoque());
		vendaProduto.setDtaVendaProduto(vendaProdutoDto.getDtaVendaProduto());
		vendaProduto.setTxtObservacao(vendaProdutoDto.getTxtObservacao());
		
		return vendaProduto;
	}
	

}
