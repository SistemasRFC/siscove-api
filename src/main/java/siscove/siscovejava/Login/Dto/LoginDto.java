package siscove.siscovejava.Login.Dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginDto {

	private int codUsuario;
	private String nmeUsuario;
	private String txtSenha;
	private String txtToken;
	
	
}
