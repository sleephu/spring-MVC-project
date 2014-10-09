package edu.neu.coe.dao;

import java.util.List;

import edu.neu.coe.domain.Menu;

public interface MenuDAO {

	void createMenu(Menu menu);
	void updateMenu(Menu menu);
	Menu getMenu( Integer id);
	void deleteMenu(Integer id);
	
	List<Menu> listMenu();
	
}
