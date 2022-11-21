package siscove.siscovejava.Veiculo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Veiculo.Entity.Veiculo;
	
	@Repository(value = "VeiculoDao")
	public interface VeiculoDao extends CrudRepository<Veiculo, Integer> {

		@Query(value="SELECT * FROM EN_VEICULOS  WHERE DSC_VEICULO like %?1%", nativeQuery=true)
		public List<Veiculo> findBydscVeiculo(String dscVeiculo);

	}


