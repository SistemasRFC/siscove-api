package siscove.siscovejava.Marca.Dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Marca.Entity.Marca;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MarcaDto {

	private Integer codMarca;
	private String dscMarca;
	private Integer codClienteFinal;
	private String indAtiva;
	public static Marca parse(MarcaDto marcaDto) {
		Marca marca = new Marca();
		marca.setCodMarca(marcaDto.getCodMarca());
		marca.setDscMarca(marcaDto.getDscMarca());
		marca.setCodClienteFinal(marcaDto.getCodClienteFinal());
		marca.setIndAtiva(marcaDto.getIndAtiva());
		return marca;
		
	} 

	public static MarcaDto build(Marca marca) {
		MarcaDto marcaDto = new MarcaDto(
				marca.getCodMarca(),
				marca.getDscMarca(),
				marca.getCodClienteFinal(),
				marca.getIndAtiva());
		return marcaDto;
				
	}
}
