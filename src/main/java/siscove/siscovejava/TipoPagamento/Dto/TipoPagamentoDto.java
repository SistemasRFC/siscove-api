package siscove.siscovejava.TipoPagamento.Dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.TipoPagamento.Entity.TipoPagamento;
import siscove.siscovejava.TipoProduto.Dto.TipoProdutoDto;
import siscove.siscovejava.TipoProduto.Entity.TipoProduto;

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
		tipoPagamento.setCodTipoProduto(tipoPagamentoDto.getCodTipoProduto());
		tipoPagamento.setDscTipoProduto(tipoPagamentoDto.getDscTipoProduto());
		tipoPagamento.setCodClienteFinal(tipoPagamentoDto.getCodClienteFinal());
		tipoPagamento.setIndAtivo(tipoPagamentoDto.getIndAtivo());
		return tipoPagamento;
	}

	public static TipoProdutoDto build(TipoProduto tipoProduto) {
		TipoProdutoDto tipoProdutoDto = new TipoProdutoDto(
		tipoProduto.getCodTipoProduto(), 
		tipoProduto.getDscTipoProduto(),
		tipoProduto.getCodClienteFinal(),
		tipoProduto.getIndAtivo());
		return tipoProdutoDto;
	}
}
