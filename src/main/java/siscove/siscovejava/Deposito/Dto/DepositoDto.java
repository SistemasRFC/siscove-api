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
	private String indAtivo;

	public static DepositoDto build(Deposito deposito) {
		DepositoDto depositoDto = new DepositoDto(
				
				deposito.getCodDeposito(),
				deposito.getDscDeposito(),
				deposito.getCodClienteFinal(),
				deposito.getIndAtivo());
				return depositoDto;
	}
}
