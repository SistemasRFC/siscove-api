package siscove.siscovejava.Cliente.Dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Cliente.Entity.Cliente;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteDto {

	private Integer codCliente;
	private String dscCliente;
	private String indTipoCliente;
	private String nroCep;
	private String txtLogradouro;
	private String txtComplemento;
	private String nmeBairro;
	private String txtLocalidade;
	private String sglUf;
	private String txtUnidade;
	private String codIbge;
	private String codGia;
	private String nroTelefoneContato;
	private String nroTelefoneCelular;
	private String nroCpf;
	private String nroCnpj;
	private String nroIe;
	private Integer codClienteFinal;
	private LocalDate dtaNascimento;
	private String txtEmail;

	public static ClienteDto build(Cliente cliente) {
		ClienteDto clienteDto = new ClienteDto(

				cliente.getCodCliente(), 
				cliente.getDscCliente(), 
				cliente.getIndTipoCliente(), 
				cliente.getNroCep(), 
				cliente.getTxtLogradouro(), 
				cliente.getTxtComplemento(), 
				cliente.getNmeBairro(), 
				cliente.getTxtLocalidade(), 
				cliente.getSglUf(), 
				cliente.getTxtUnidade(), 
				cliente.getCodIbge(), 
				cliente.getCodGia(), 
				cliente.getNroTelefoneContato(), 
				cliente.getNroTelefoneCelular(), 
				cliente.getNroCpf(), 
				cliente.getNroCnpj(), 
				cliente.getNroIe(), 
				cliente.getCodClienteFinal(), 
				cliente.getDtaNascimento(),
				cliente.getTxtEmail()); 
				
				
		return clienteDto;
	}

	public static Cliente parse(ClienteDto clienteDto) {
		Cliente cliente = new Cliente();
		cliente.setCodCliente(clienteDto.getCodCliente());
		cliente.setDscCliente(clienteDto.getDscCliente());
		cliente.setIndTipoCliente(clienteDto.getIndTipoCliente());
		cliente.setNroCep(clienteDto.getNroCep());
		cliente.setTxtLocalidade(clienteDto.getTxtLocalidade());
		cliente.setTxtLogradouro(clienteDto.getTxtLogradouro());
		cliente.setTxtComplemento(clienteDto.getTxtComplemento());
		cliente.setNmeBairro(clienteDto.getNmeBairro());
		cliente.setSglUf(clienteDto.getSglUf());
		cliente.setTxtUnidade(clienteDto.getTxtUnidade());
		cliente.setCodIbge(clienteDto.getCodIbge());
		cliente.setCodGia(clienteDto.getCodGia());
		cliente.setNroTelefoneContato(clienteDto.getNroTelefoneContato());
		cliente.setNroTelefoneCelular(clienteDto.getNroTelefoneCelular());
		cliente.setNroCpf(clienteDto.getNroCpf());
		cliente.setNroCnpj(clienteDto.getNroCnpj());
		cliente.setNroIe(clienteDto.getNroIe());
		cliente.setCodClienteFinal(clienteDto.getCodClienteFinal());
		cliente.setDtaNascimento(clienteDto.getDtaNascimento());
		cliente.setTxtEmail(clienteDto.getTxtEmail());
		
		return cliente;
	}
}