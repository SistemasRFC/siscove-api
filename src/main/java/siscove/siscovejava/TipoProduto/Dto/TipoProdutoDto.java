package siscove.siscovejava.TipoProduto.Dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.TipoProduto.Entity.TipoProduto;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TipoProdutoDto {

	private Integer codTipoProduto;
	private String dscTipoProduto;
	private String codClienteFinal;
	private String indAtivo;

	public static TipoProduto parse(TipoProdutoDto tipoProdutoDto) {
		TipoProduto tipoProduto = new TipoProduto();
		tipoProduto.setCodTipoProduto(tipoProdutoDto.getCodTipoProduto());
		tipoProduto.setDscTipoProduto(tipoProdutoDto.getDscTipoProduto());
		tipoProduto.setCodClienteFinal(tipoProdutoDto.getCodClienteFinal());
		tipoProduto.setIndAtivo(tipoProdutoDto.getIndAtivo());
		return tipoProduto;
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
