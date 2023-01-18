package siscove.siscovejava.Venda.Dto;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Venda.Entity.Venda;


	@Component
	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	public class VendaDto {

		private Integer codVenda;
		private LocalDateTime dtaVenda;
		private String nroStatusVenda;
		private Integer codCliente;
		private String dscCliente;
		private String nroDocumentoCliente;
		private Integer codVendedor;
		private String dscVendedor;
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
			VendaDto vendaDto = new VendaDto();
			vendaDto.setCodVenda(venda.getCodVenda());
			vendaDto.setDtaVenda(venda.getDtaVenda());
			vendaDto.setNroStatusVenda(venda.getNroStatusVenda());
			vendaDto.setVlrDesconto(venda.getVlrDesconto());
			vendaDto.setDscVeiculo(venda.getDscVeiculo());
			vendaDto.setNroPlaca(venda.getNroPlaca());
			vendaDto.setDtaFechamento(venda.getDtaFechamento());
			vendaDto.setCodVeiculo(venda.getCodVeiculo());
			vendaDto.setTxtObservacao(venda.getTxtObservacao());
			vendaDto.setTxtJustificativa(venda.getTxtJustificativa());
			vendaDto.setCodClienteFinal(venda.getCodClienteFinal());
			vendaDto.setVlrImpostoProduto(venda.getVlrImpostoProduto());
			vendaDto.setVlrImpostoServico(venda.getVlrImpostoServico());
			vendaDto.setVlrKmRodado(venda.getVlrKmRodado());
			vendaDto.setCodUsuarioFechamento(venda.getCodUsuarioFechamento());
			if (null != venda.getCliente()) {
				vendaDto.setCodCliente(venda.getCliente().getCodCliente());
				vendaDto.setDscCliente(venda.getCliente().getDscCliente());
				if(null != venda.getCliente().getNroCpf()) {
					vendaDto.setNroDocumentoCliente(venda.getCliente().getNroCpf());
				} else {
					vendaDto.setNroDocumentoCliente(venda.getCliente().getNroCnpj());	
				}
			}
			if (null != venda.getVendedor()) {
				vendaDto.setCodVendedor(venda.getVendedor().getCodUsuario());
				vendaDto.setDscVendedor(venda.getVendedor().getNmeUsuarioCompleto());
			}

			return vendaDto;
		}

		public static Venda parse(VendaDto vendaDto) {
			Venda venda = new Venda();
			venda.setCodCliente(vendaDto.getCodCliente());
			venda.setDtaVenda(vendaDto.getDtaVenda());
			venda.setNroStatusVenda(vendaDto.getNroStatusVenda());
			venda.setCodVendedor(vendaDto.getCodVendedor());
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

