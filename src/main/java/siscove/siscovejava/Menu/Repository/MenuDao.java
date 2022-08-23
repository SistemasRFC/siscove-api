package siscove.siscovejava.Menu.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import siscove.siscovejava.Menu.Entity.Menu;

@Repository(value = "MenuDao")
public interface MenuDao extends CrudRepository<Menu, Integer>{


}
