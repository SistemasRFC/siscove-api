package siscove.siscovejava.Venda.Dto;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Cliente.Entity.Cliente;
import siscove.siscovejava.Usuario.Entity.Usuario;
import siscove.siscovejava.Venda.Entity.Venda;


	@Component
	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	public class VendaDto {

		private Integer codVenda;
		private LocalDateTime dtaVenda;
		private String nroStatusVenda;
		private Cliente cliente;
		private Usuario vendedor;
		private Float vlrDesconto;
		private String dscVeiculo;
		private String nroPlaca;
		private LocalDateTime dtaFechamento;
		private Integer codVeiculo;
		private String txtObservacao;
		private String txtJustificativa;
		private Integer codClienteFinal;
		private Float vlrImpostoProduto;
		private Float vlrImpostoServico;
		private Integer vlrKmRodado;
		private Integer codUsuarioFechamento;

		public static VendaDto build(Venda venda) {
			VendaDto vendaDto = new VendaDto(

					venda.getCodVenda(), 
					venda.getDtaVenda(), 
					venda.getNroStatusVenda(), 
					venda.getCliente(), 
					venda.getVendedor(), 
					venda.getVlrDesconto(), 
					venda.getDscVeiculo(), 
					venda.getNroPlaca(), 
					venda.getDtaFechamento(), 
					venda.getCodVeiculo(), 
					venda.getTxtObservacao(), 
					venda.getTxtJustificativa(), 
					venda.getCodClienteFinal(), 
					venda.getVlrImpostoProduto(), 
					venda.getVlrImpostoServico(), 
					venda.getVlrKmRodado(), 
					venda.getCodUsuarioFechamento()); 
					 
					
					
			return vendaDto;
		}

		public static Venda parse(VendaDto vendaDto) {
			Venda venda = new Venda();
			venda.setCodCliente(vendaDto.getCliente().getCodCliente());
			venda.setDtaVenda(vendaDto.getDtaVenda());
			venda.setNroStatusVenda(vendaDto.getNroStatusVenda());
			venda.setCodVendedor(vendaDto.getVendedor().getCodUsuario());
			venda.setVlrDesconto(vendaDto.getVlrDesconto());
			venda.setDscVeiculo(vendaDto.getDscVeiculo());
			venda.setNroPlaca(vendaDto.getNroPlaca());
			venda.setDtaFechamento(vendaDto.getDtaFechamento());
			venda.setCodVeiculo(vendaDto.getCodVeiculo());
			venda.setTxtObservacao(vendaDto.getTxtObservacao());
			venda.setTxtJustificativa(vendaDto.getTxtJustificativa());
			venda.setCodClienteFinal(vendaDto.getCodClienteFinal());
			venda.setVlrImpostoProduto(vendaDto.getVlrImpostoProduto());
			venda.setVlrImpostoServico(vendaDto.getVlrImpostoServico());
			venda.setVlrKmRodado(vendaDto.getVlrKmRodado());
			venda.setCodUsuarioFechamento (vendaDto.getCodUsuarioFechamento());
			
			return venda;
		}
	}

