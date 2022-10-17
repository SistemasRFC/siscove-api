package siscove.siscovejava.Entrada.Dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Deposito.Entity.Deposito;
import siscove.siscovejava.Entrada.Entity.Entrada;
import siscove.siscovejava.Fornecedor.Entity.Fornecedor;

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
				entrada.getFornecedor().getCodFornecedor(),
				entrada.getDeposito().getCodDeposito(),
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
		entrada.setCodUsuario(entradaDto.getCodUsuario());
		entrada.setTxtObservacao(entradaDto.getTxtObservacao());
		entrada.setIndEntrada(entradaDto.getIndEntrada());
		entrada.setCodClienteFinal(entradaDto.getCodClienteFinal());
		
		Fornecedor fornecedor= new Fornecedor();
		fornecedor.setCodFornecedor(entradaDto.getCodFornecedor());
		entrada.setFornecedor(fornecedor);
		
		Deposito deposito= new Deposito();
		deposito.setCodDeposito(entradaDto.getCodDeposito());
		entrada.setDeposito(deposito);

		return entrada;
	}
}