package siscove.siscovejava.Venda.Dto;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Venda.Entity.VendaProduto;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VendaProdutoDto {
	
	private Integer codVenda;
	private Integer nroSequencial;
	private Integer codProduto;
	private String indProduto;
	private Float vlrVenda;
	private Integer qtdVendida;
	private Float vlrDesconto;
	private Integer codFuncionario;
	private String indEstoque;
	private LocalDateTime dtaVendaProduto;
	private Integer txtObservacao;

	public static VendaProdutoDto build(VendaProduto vendaProduto) {
		VendaProdutoDto vendaProdutoDto = new VendaProdutoDto(

				vendaProduto.getCodVenda(), 
				vendaProduto.getNroSequencial(), 
				vendaProduto.getCodProduto(), 
				vendaProduto.getIndProduto(), 
				vendaProduto.getVlrVenda(), 
				vendaProduto.getQtdVendida(), 
				vendaProduto.getVlrDesconto(), 
				vendaProduto.getCodFuncionario(), 
				vendaProduto.getIndEstoque(), 
				vendaProduto.getDtaVendaProduto(), 
				vendaProduto.getTxtObservacao()); 
				
				 
				
				
		return vendaProdutoDto;    
	}

	public static VendaProduto parse(VendaProdutoDto vendaProdutoDto) {
		VendaProduto vendaProduto = new VendaProduto();
		vendaProduto.setCodVenda(vendaProdutoDto.getCodVenda());
		vendaProduto.setNroSequencial(vendaProdutoDto.getNroSequencial());
		vendaProduto.setCodProduto(vendaProdutoDto.getCodProduto());
		vendaProduto.setIndProduto(vendaProdutoDto.getIndProduto());
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
