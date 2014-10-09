package edu.neu.coe.service;

import java.util.List;

import edu.neu.coe.domain.Menu;

public interface MenuService {
	
	void createMenu(Menu menu);
	void updateMenu(Menu menu);
	Menu getMenu( Integer id);
	void deleteMenu(Integer id);
	
	List<Menu> listMenu();
    
	
	
}
