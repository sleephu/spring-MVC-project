package edu.neu.coe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.coe.dao.OrderedFoodDAO;
import edu.neu.coe.domain.OrderedFood;
import edu.neu.coe.service.OrderedFoodService;

@Service  
@Transactional 
public class OrderedFoodServiceImpl implements OrderedFoodService {

	@Autowired 
    private OrderedFoodDAO orderFoodDAO;
	
	@Override
	@Transactional  
	public void create(OrderedFood food) {
		  orderFoodDAO.create(food);
	}

	@Override
	@Transactional  
	public OrderedFood find(Integer id) {
		return orderFoodDAO.find(id);
	}

	@Override
	@Transactional  
	public void update(OrderedFood food) {
		orderFoodDAO.update(food);

	}

	@Override
	@Transactional  
	public void delete(Integer id) {
		orderFoodDAO.delete(id);

	}

	@Override
	@Transactional  
	public List<OrderedFood> listFood() {
		 return orderFoodDAO.listFood();
	}

}
