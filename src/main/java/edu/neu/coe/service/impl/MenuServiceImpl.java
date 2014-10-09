package edu.neu.coe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.coe.dao.FoodDAO;
import edu.neu.coe.dao.MenuDAO;
import edu.neu.coe.domain.Menu;
import edu.neu.coe.service.MenuService;

@Service  
@Transactional  
public class MenuServiceImpl implements MenuService {

    @Autowired  
    private MenuDAO menuDAO;  
    
    @Autowired 
    private FoodDAO foodDAO;
  
    @Override
	@Transactional
	public void createMenu(Menu menu) {
		menuDAO.createMenu(menu);

	}

    @Override
	@Transactional
	public void updateMenu(Menu menu) {
		menuDAO.updateMenu(menu);

	}

    @Override
	@Transactional
	public Menu getMenu(Integer id) {
	return menuDAO.getMenu(id);
	}

    @Override
	@Transactional
	public void deleteMenu(Integer id) {
		menuDAO.deleteMenu(id);

	}

    @Override
	@Transactional
	public List<Menu> listMenu() {
		return menuDAO.listMenu();
	}

	
}
