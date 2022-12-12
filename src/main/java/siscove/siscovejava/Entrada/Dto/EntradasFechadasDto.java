package siscove.siscovejava.Entrada.Dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradasFechadasDto {

	private Integer nroSequencial;
	private String nroNotaFiscal;
	private Date dtaEntrada;
	private Integer codFornecedor;
	private String dscFornecedor;
	private Integer codDeposito;
	private String dscDeposito;
	private Double vlrTotal;
	private String dtaEntradaFormatada;
	private String vlrTotalFormatada;
	private String txtObservacao;
	private String indEntrada="F";
	private Integer codUsuario;
	private Integer codClienteFinal;
}
