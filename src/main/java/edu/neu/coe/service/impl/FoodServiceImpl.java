package edu.neu.coe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.coe.dao.FoodDAO;
import edu.neu.coe.domain.Food;
import edu.neu.coe.service.FoodService;

@Service  
@Transactional
public class FoodServiceImpl implements FoodService {

	 @Autowired  
	 private FoodDAO foodDAO;      

	@Override
	@Transactional  
	public void create(Food food) {
		foodDAO.create(food);
		
	}

	@Override
	@Transactional  
	public Food find(Integer id) {
		return foodDAO.find(id);
	}

	@Override
	@Transactional  
	public void update(Food food) {
	foodDAO.update(food);
	}

	
	@Override
	@Transactional  
	public void delete(Integer id) {
		foodDAO.delete(id);
		
	}


	@Override
	@Transactional  
	public List<Food> listFood() {
		return foodDAO.listFood();
	}

}
