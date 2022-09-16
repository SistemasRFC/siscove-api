package Produto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ProdutoDao")
public interface ProdutoDao extends CrudRepository<Produto, Integer> {
	
}	