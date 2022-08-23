package siscove.siscovejava.Token.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Token.Entity.Token;

@Repository(value = "TokenDao")
public interface TokenDao extends CrudRepository<Token, Integer> {

	@Query(value="SELECT T.* FROM se_token T WHERE T.txt_token = ?1", nativeQuery=true)
	public Token getByTxtToken(String txtToken);
	
	@Query(value="SELECT T.* FROM se_token T WHERE T.cod_usuario = :codUsuario", nativeQuery=true)
	public Token getByCodUsuario(Integer codUsuario);
	
	@Transactional	
	@Modifying
	@Query(value="delete from se_token where  TIMESTAMPDIFF(minute ,dta_token,NOW())> ?1", nativeQuery=true)
	public void excluiTokensInvalidos(Integer tempoLimite);
}