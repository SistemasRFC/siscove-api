package siscove.siscovejava.Usuario.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Usuario.Entity.Usuario;

@Repository(value = "UsuarioDao")
public interface UsuarioDao extends CrudRepository<Usuario, Integer> {
	
	@Query(value="SELECT u.* FROM SE_USUARIO u WHERE NME_USUARIO = ?1 AND TXT_SENHA_W = ?2", nativeQuery=true)
	public Usuario usuarioLogin(String nmeUsuario, String txtSenha);
	
	@Query(value="SELECT u.* FROM SE_USUARIO u WHERE COD_PERFIL_W = 4 AND IND_ATIVO = 'S' ORDER BY u.NME_USUARIO_COMPLETO", nativeQuery=true)
	public List<Usuario> getListaVendedores();
	

}