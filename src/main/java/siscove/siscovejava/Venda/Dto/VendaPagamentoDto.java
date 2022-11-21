package siscove.siscovejava.Venda.Dto;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Venda.Entity.VendaPagamento;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VendaPagamentoDto {
	
	private Integer nroSequencial;
	private Integer codVenda;
	private LocalDateTime dtaPagamento;
	private Float valorPagamento;
	private Integer nroCheque;
	private Integer nroBanco;
	private String nmeProprietario;
	private Integer codTipoPagamento;
	private String dscMercadoria;
	private Integer nroSequencialEntrada;
	private LocalDateTime txtObservacao;
	private Integer codUsuario;
	
	public static VendaPagamentoDto build(VendaPagamento vendaPagamento) {
		VendaPagamentoDto vendaPagamentoDto = new VendaPagamentoDto(

				vendaPagamento.getNroSequencial(), 
				vendaPagamento.getCodVenda(), 
				vendaPagamento.getDtaPagamento(), 
				vendaPagamento.getValorPagamento(), 
				vendaPagamento.getNroCheque(), 
				vendaPagamento.getNroBanco(), 
				vendaPagamento.getNmeProprietario(), 
				vendaPagamento.getCodTipoPagamento(), 
				vendaPagamento.getDscMercadoria(), 
				vendaPagamento.getNroSequencialEntrada(), 
				vendaPagamento.getTxtObservacao(),
				vendaPagamento.getCodUsuario());  
				
		return vendaPagamentoDto;
	}

	public static VendaPagamento parse(VendaPagamentoDto vendaPagamentoDto) {
		VendaPagamento vendaPagamento = new VendaPagamento();
		vendaPagamento.setNroSequencial(vendaPagamentoDto.getNroSequencial());
		vendaPagamento.setCodVenda(vendaPagamentoDto.getCodVenda());
		vendaPagamento.setDtaPagamento(vendaPagamentoDto.getDtaPagamento());
		vendaPagamento.setValorPagamento(vendaPagamentoDto.getValorPagamento());
		vendaPagamento.setNroCheque(vendaPagamentoDto.getNroCheque());
		vendaPagamento.setNroBanco(vendaPagamentoDto.getNroBanco());
		vendaPagamento.setNmeProprietario(vendaPagamentoDto.getNmeProprietario());
		vendaPagamento.setCodTipoPagamento(vendaPagamentoDto.getCodTipoPagamento());
		vendaPagamento.setDscMercadoria(vendaPagamentoDto.getDscMercadoria());
		vendaPagamento.setNroSequencialEntrada(vendaPagamentoDto.getNroSequencialEntrada());
		vendaPagamento.setTxtObservacao(vendaPagamentoDto.getTxtObservacao());
		vendaPagamento.setCodUsuario(vendaPagamentoDto.getCodUsuario());
		
		return vendaPagamento;
	}

}
