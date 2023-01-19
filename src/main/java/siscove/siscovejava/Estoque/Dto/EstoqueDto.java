package siscove.siscovejava.Estoque.Dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EstoqueDto {

	private Integer codEstoque;
	private Integer nroSequencial;
	private String qtdEstoque;
	
}
