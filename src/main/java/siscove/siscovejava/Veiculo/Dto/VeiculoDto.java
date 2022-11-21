package siscove.siscovejava.Veiculo.Dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Veiculo.Entity.Veiculo;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VeiculoDto {

	private Integer codVeiculo;
	private String dscVeiculo;
	private String indAtivo;
	
	public static VeiculoDto build(Veiculo veiculo) {
		VeiculoDto veiculoDto = new VeiculoDto(

				veiculo.getCodVeiculo(), 
				veiculo.getDscVeiculo(), 
				veiculo.getIndAtivo()); 
		
		return veiculoDto;
	}
	

	public static Veiculo parse(VeiculoDto veiculoDto) {
		Veiculo veiculo = new Veiculo();
		veiculo.setCodVeiculo(veiculoDto.getCodVeiculo());
		veiculo.setDscVeiculo(veiculoDto.getDscVeiculo());
		veiculo.setIndAtivo(veiculoDto.getIndAtivo());
		
		return veiculo;
}
	}
