package siscove.siscovejava.Entrada.Dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Entrada.Entity.Entrada;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntradaDto {

	private Integer nroSequencial;
	private String nroNotaFiscal;
	private LocalDate dtaEntrada;
	private Integer codFornecedor;
	private Integer codDeposito;
	private Integer codUsuario;
	private String txtObservacao;
	private String indEntrada;
	private Integer codClienteFinal;
	
	public static EntradaDto build(Entrada entrada) {
		EntradaDto entradaDto = new EntradaDto(

				entrada.getNroSequencial(), 
				entrada.getNroNotaFiscal(), 
				entrada.getDtaEntrada(), 
				entrada.getCodFornecedor(), 
				entrada.getCodDeposito(), 
				entrada.getCodUsuario(), 
				entrada.getTxtObservacao(), 
				entrada.getIndEntrada(), 
				entrada.getCodClienteFinal());
				
				return entradaDto;
	}

	public static Entrada parse(EntradaDto entradaDto) {
		Entrada entrada = new Entrada();
		entrada.setNroSequencial(entradaDto.getNroSequencial());
		entrada.setNroNotaFiscal(entradaDto.getNroNotaFiscal());
		entrada.setDtaEntrada(entradaDto.getDtaEntrada());
		entrada.setCodFornecedor(entradaDto.getCodFornecedor());
		entrada.setCodDeposito(entradaDto.getCodDeposito());
		entrada.setCodUsuario(entradaDto.getCodUsuario());
		entrada.setTxtObservacao(entradaDto.getTxtObservacao());
		entrada.setIndEntrada(entradaDto.getIndEntrada());
		entrada.setCodClienteFinal(entradaDto.getCodClienteFinal());

		return entrada;
	}
}