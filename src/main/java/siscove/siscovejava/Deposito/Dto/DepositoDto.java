package siscove.siscovejava.Deposito.Dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Deposito.Entity.Deposito;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepositoDto {
	
	private Integer codDeposito;
	private String dscDeposito;
	private Integer codClienteFinal;
	private String dscClienteFinal;
	private String indAtivo;

	public DepositoDto(Integer codDeposito, String dscDeposito, Integer codClienteFinal, String indAtivo) {
		this.codDeposito = codDeposito;
		this.dscDeposito = dscDeposito;
		this.codClienteFinal = codClienteFinal;
		this.indAtivo = indAtivo;
	}
	
	public static DepositoDto build(Deposito deposito) {
		DepositoDto depositoDto = new DepositoDto(
				
				deposito.getCodDeposito(), 
				deposito.getDscDeposito(), 
				deposito.getCodClienteFinal(), 
				deposito.getIndAtivo());
		return depositoDto;
	}
	
	public static Deposito parse(DepositoDto depositoDto) {
		Deposito deposito = new Deposito();
		deposito.setCodDeposito(depositoDto.getCodDeposito());
		deposito.setDscDeposito(depositoDto.getDscDeposito());
		deposito.setCodClienteFinal(depositoDto.getCodClienteFinal());
		deposito.setIndAtivo(depositoDto.getIndAtivo());
		return deposito;
	}
}
