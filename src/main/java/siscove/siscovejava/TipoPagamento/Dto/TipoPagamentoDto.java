package siscove.siscovejava.TipoPagamento.Dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.TipoPagamento.Entity.TipoPagamento;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TipoPagamentoDto {

	private Integer codTipoPagamento;
	private String dscTipoPagamento;
	private String indAtivo;
	private Float vlrPorcentagem;

	public static TipoPagamento parse(TipoPagamentoDto tipoPagamentoDto) {
		TipoPagamento tipoPagamento = new TipoPagamento();
		tipoPagamento.setCodTipoPagamento(tipoPagamentoDto.getCodTipoPagamento());
		tipoPagamento.setDscTipoPagamento(tipoPagamentoDto.getDscTipoPagamento());
		tipoPagamento.setVlrPorcentagem(tipoPagamentoDto.getVlrPorcentagem());
		tipoPagamento.setIndAtivo(tipoPagamentoDto.getIndAtivo());
		return tipoPagamento;
	}

	public static TipoPagamentoDto build(TipoPagamento tipoPagamento) {
		TipoPagamentoDto tipoPagamentoDto = new TipoPagamentoDto(
		tipoPagamento.getCodTipoPagamento(), 
		tipoPagamento.getDscTipoPagamento(),
		tipoPagamento.getIndAtivo(),
		tipoPagamento.getVlrPorcentagem());
		return tipoPagamentoDto;
	}
}

