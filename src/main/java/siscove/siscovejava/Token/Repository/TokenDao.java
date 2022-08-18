package siscove.siscovejava.Token.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Token.Entity.Token;



@Repository(value = "TokenDao")
public interface TokenDao extends CrudRepository<Token, Integer> {

}