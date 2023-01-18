package siscove.siscovejava.Venda.Dto;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Venda.Entity.Venda;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VendaBuscaDto {
	
	private Integer codVenda;
	private String nmeCliente;
	private String nroDocumentoCliente;
	private String nmeVendedor;
	private LocalDateTime dtaVenda;
	private Double vlrVenda;
	private String dscVeiculo;


	public static VendaBuscaDto build(Venda venda) {
		VendaBuscaDto dto = new VendaBuscaDto();
		dto.setCodVenda(venda.getCodVenda());
		dto.setDtaVenda(venda.getDtaVenda());
		dto.setDscVeiculo(venda.getDscVeiculo());
		if (null != venda.getCliente()) {
			dto.setNmeCliente(venda.getCliente().getDscCliente());
			if(null != venda.getCliente().getNroCpf()) {
				dto.setNroDocumentoCliente(venda.getCliente().getNroCpf());
			} else {
				dto.setNroDocumentoCliente(venda.getCliente().getNroCnpj());	
			}
		}
		if (null != venda.getVendedor()) {
			dto.setNmeVendedor(venda.getVendedor().getNmeUsuarioCompleto());
		}
		return dto;
	}
}
