package siscove.siscovejava.Usuario.Dto;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Base64;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import siscove.siscovejava.Perfil.Dto.PerfilDto;
import siscove.siscovejava.Perfil.Entity.Perfil;
import siscove.siscovejava.Usuario.Entity.Usuario;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioDto {

	private Integer codUsuario;
	private String nmeUsuario;
	private String txtSenhaW;
	private String nmeUsuarioCompleto;
	private String indLogado;
	private LocalDate dataLogado;
	private String nroTelCelular;
	private String txtEmail;
	private LocalDate dtaInativo;
	private Integer codDeposito;
	private Float vlrPorcentagemServico;
	private Float vlrPorcentagemVenda;
	private Float vlrPorcentagemGerencia;
	private String indAtivo;
	private PerfilDto perfilDto;

	public static Usuario parse(UsuarioDto usuarioDto) {
		Usuario usuario = new Usuario();
		usuario.setCodUsuario(usuarioDto.getCodUsuario());
		usuario.setNmeUsuario(usuarioDto.getNmeUsuario());

		try {
			if (usuarioDto.getTxtSenhaW()!=null) {
				byte[] decodedValue = Base64.getEncoder().encode(usuarioDto.getTxtSenhaW().getBytes());
				String senhaEncriptada = new String(decodedValue, StandardCharsets.UTF_8.toString());
				usuario.setTxtSenhaW(senhaEncriptada);
			}else {
				if(usuarioDto.getCodUsuario()==null || usuarioDto.getCodUsuario()==0) {
					byte[] decodedValue = Base64.getEncoder().encode("123459".getBytes());
					String senhaEncriptada = new String(decodedValue, StandardCharsets.UTF_8.toString());
					usuario.setTxtSenhaW(senhaEncriptada);
				}
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		usuario.setNmeUsuarioCompleto(usuarioDto.getNmeUsuarioCompleto());
		usuario.setIndLogado(usuarioDto.getIndLogado());
		usuario.setDataLogado(usuarioDto.getDataLogado());
		usuario.setNroTelCelular(usuarioDto.getNroTelCelular());
		usuario.setTxtEmail(usuarioDto.getTxtEmail());
		usuario.setDtaInativo(usuarioDto.getDtaInativo());
		usuario.setCodDeposito(usuarioDto.getCodDeposito());
		usuario.setVlrPorcentagemServico(usuarioDto.getVlrPorcentagemServico());
		usuario.setVlrPorcentagemVenda(usuarioDto.getVlrPorcentagemVenda());
		usuario.setVlrPorcentagemGerencia(usuarioDto.getVlrPorcentagemGerencia());
		usuario.setIndAtivo(usuarioDto.getIndAtivo());
		
		Perfil perfil= new Perfil();
		perfil.setCodPerfilW(usuarioDto.getPerfilDto().getCodPerfilW());
		usuario.setPerfil(perfil);
		return usuario;
	}

	public static UsuarioDto build(Usuario usuario) {
		UsuarioDto usuarioDto = new UsuarioDto(
		usuario.getCodUsuario(),
		usuario.getNmeUsuario(),
		usuario.getTxtSenhaW(),
		usuario.getNmeUsuarioCompleto(),
		usuario.getIndLogado(),
		usuario.getDataLogado(),
		usuario.getNroTelCelular(),
		usuario.getTxtEmail(),
		usuario.getDtaInativo(),
		usuario.getCodDeposito(),
		usuario.getVlrPorcentagemServico(),
		usuario.getVlrPorcentagemVenda(),
		usuario.getVlrPorcentagemGerencia(),
		usuario.getIndAtivo(),
		PerfilDto.build(usuario.getPerfil()));
		return usuarioDto;
	}
}