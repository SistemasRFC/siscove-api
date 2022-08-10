package siscove.siscovejava.Login.Respositry;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Login.Entity.Usuario.Usuario;

@Repository(value = "UsuarioDao")
public interface UsuarioDao extends CrudRepository<Usuario, Integer> {
	
	@Query(value="SELECT u.* FROM SE_USUARIO u WHERE NME_USUARIO = ?1 AND TXT_SENHA_W = ?2", nativeQuery=true)
	public Usuario usuarioLogin(String nmeUsuario, String txtSenha);
	
}