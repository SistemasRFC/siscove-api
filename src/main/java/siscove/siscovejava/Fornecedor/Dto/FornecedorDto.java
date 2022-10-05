package siscove.siscovejava.Fornecedor.Dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Fornecedor.Entity.Fornecedor;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FornecedorDto {

	private Integer codFornecedor;
	private String dscFornecedor;
	private String nroTelefone;
	private String txtObs;
	private Integer codClienteFinal;
	private String indAtivo;
	private String nroCnpj;
	private String nroIe;
	private String txtLogradouro;
	private String txtComplemento;
	private String nmeBairro;
	private String txtLocalidade;
	private String sglUf;
	private String nroCep;

	public static FornecedorDto build(Fornecedor fornecedor) {
		FornecedorDto fornecedorDto = new FornecedorDto(
				fornecedor.getCodFornecedor(),  
				fornecedor.getDscFornecedor(),
				fornecedor.getNroTelefone(),
				fornecedor.getTxtObs(),
				fornecedor.getCodClienteFinal(),
				fornecedor.getIndAtivo(),
				fornecedor.getNroCnpj(),
				fornecedor.getNroIe(),
				fornecedor.getTxtLogradouro(),
				fornecedor.getTxtComplemento(),
				fornecedor.getNmeBairro(),
				fornecedor.getTxtLocalidade(),
				fornecedor.getSglUf(), 
				fornecedor.getNroCep());
		
		
		return fornecedorDto;
	}
	
	public static Fornecedor parse(FornecedorDto fornecedorDto) {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setCodFornecedor(fornecedorDto.getCodFornecedor());
		fornecedor.setDscFornecedor(fornecedorDto.getDscFornecedor());
		fornecedor.setNroTelefone(fornecedorDto.getNroTelefone());
		fornecedor.setTxtObs(fornecedorDto.getTxtObs());
		fornecedor.setCodClienteFinal(fornecedorDto.getCodClienteFinal());
		fornecedor.setIndAtivo(fornecedorDto.getIndAtivo());
		fornecedor.setNroCnpj(fornecedorDto.getNroCnpj());
		fornecedor.setTxtLogradouro(fornecedorDto.getTxtLogradouro());
		fornecedor.setNmeBairro(fornecedorDto.getNmeBairro());
		fornecedor.setTxtLocalidade(fornecedorDto.getTxtLocalidade());
		fornecedor.setSglUf(fornecedorDto.getSglUf());
		fornecedor.setNroCep(fornecedorDto.getNroCep());
		
		return fornecedor;
	}

}
