package siscove.siscovejava.Venda.Dto;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VendaClienteDto {
	
	private Integer codVenda;
	private String dscCliente;
	private String nmeUsuarioCompleto;
	private LocalDateTime dtaVenda;
	private Float vlrVenda;
	private String nroCpf;
	private String nroCnpj;
	private String dscVeiculo;

}
