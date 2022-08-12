package siscove.siscovejava.Usuario.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Usuario.Entity.Usuario;

@Repository(value = "UsuarioDao")
public interface UsuarioDao extends CrudRepository<Usuario, Integer> {
	
	@Query(value="SELECT u.* FROM SE_USUARIO u WHERE NME_USUARIO = ?1 AND TXT_SENHA_W = ?2", nativeQuery=true)
	public Usuario usuarioLogin(String nmeUsuario, String txtSenha);
	
}