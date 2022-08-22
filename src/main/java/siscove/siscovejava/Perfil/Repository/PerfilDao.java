package siscove.siscovejava.Perfil.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Perfil.Entity.Perfil;

@Repository(value = "PerfilDao")
public interface PerfilDao extends CrudRepository<Perfil, Integer> {
	
	@Query(value="SELECT u.* FROM SE_PERFIL u WHERE COD_PERFIL_W = ?1 AND DSC_PERFIL_W = ?2", nativeQuery=true)
	public Perfil perfilLogin(Integer codPerfilW , String dscPerfilW);
	
}
