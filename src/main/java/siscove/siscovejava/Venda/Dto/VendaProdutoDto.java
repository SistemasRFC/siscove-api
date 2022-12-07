package siscove.siscovejava.Venda.Dto;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Produto.Dto.ProdutoDto;
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
	private float vlrTotalProduto;
	
	public static VendaProdutoDto build(VendaProduto vendaProduto) {
		ProdutoDto produtoDto = new ProdutoDto();
		UsuarioDto funcionarioDto = new UsuarioDto();
		
		if (null!=vendaProduto) {
			if (null!=vendaProduto.getProduto()) {
				produtoDto = ProdutoDto.build(vendaProduto.getProduto());
			}
			
			if (null!=vendaProduto.getFuncionario()) {
				funcionarioDto = UsuarioDto.build(vendaProduto.getFuncionario());
			}
		}
		float vlrTotalProduto = (vendaProduto.getVlrVenda()*vendaProduto.getQtdVendida())-vendaProduto.getVlrDesconto();
		VendaProdutoDto vendaProdutoDto = new VendaProdutoDto(
			vendaProduto.getId().getCodVenda(),
			vendaProduto.getId().getNroSequencial(),
			vendaProduto.getId().getCodProduto(),
			produtoDto,
			vendaProduto.getVlrVenda(),
			vendaProduto.getQtdVendida(),
			vendaProduto.getVlrDesconto(),
			vendaProduto.getCodFuncionario(),
			funcionarioDto,
			vendaProduto.getIndEstoque(),
			vendaProduto.getDtaVendaProduto(),
			vendaProduto.getTxtObservacao(),
			vlrTotalProduto
		);
		
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
