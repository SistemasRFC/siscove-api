 package siscove.siscovejava.ClienteFinal.Dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.ClienteFinal.Entity.ClienteFinal;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteFinalDto {
	
	private Integer codClienteFinal;
	private String nmeClienteFinal;
	private String dscCaminhoLogo;
	private String indTipoCliente;
	private Integer nroCpf;
	private Integer nroCnpj;
	private String indAtivo;

	public static ClienteFinalDto build(ClienteFinal clienteFinal) {
		ClienteFinalDto clienteFinalDto = new ClienteFinalDto(
				
				clienteFinal.getCodClienteFinal(), clienteFinal.getNmeClienteFinal(), clienteFinal.getDscCaminhoLogo(), clienteFinal.getIndTipoCliente(), clienteFinal.getNroCpf(), clienteFinal.getNroCnpj(), clienteFinal.getIndAtivo());
		return clienteFinalDto;
	}
	
	public static ClienteFinal parse(ClienteFinalDto clienteFinalDto) {
		ClienteFinal clienteFinal = new ClienteFinal();
		clienteFinal.setCodClienteFinal(clienteFinalDto.getCodClienteFinal());
		clienteFinal.setNmeClienteFinal(clienteFinalDto.getNmeClienteFinal());
		clienteFinal.setDscCaminhoLogo(clienteFinalDto.getDscCaminhoLogo());
		clienteFinal.setIndTipoCliente(clienteFinalDto.getIndTipoCliente());
		clienteFinal.setNroCpf(clienteFinalDto.getNroCpf());
		clienteFinal.setNroCnpj(clienteFinalDto.getNroCnpj());
		clienteFinal.setIndAtivo(clienteFinalDto.getIndAtivo());
		return clienteFinal;
	}
}
