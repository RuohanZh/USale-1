package com.L.USale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.L.USale.dao.ProductMapper;
import com.L.USale.dao.UserMapper;
import com.L.USale.entity.Product;
import com.L.USale.entity.User;
@Service
public class AsyncTransactionImpl implements AsyncTransaction{
	@Autowired
	ProductMapper productMapper;
	
	@Autowired
	UserMapper userMapper;
	
	
	public synchronized void buyProduct (int userId, int productId) throws InterruptedException, Exception{
		Product product = productMapper.selectByPrimaryKey(productId);
		User buyer = userMapper.selectByPrimaryKey(userId);
		User seller = userMapper.selectByPrimaryKey(product.getUserId());
		double balance = buyer.getBalance();
		double price = product.getPrice();
		if(balance >= price) {
			buyer.setBalance(buyer.getBalance() - price);
			seller.setBalance(seller.getBalance() + price);
			productMapper.deleteByPrimaryKey(product.getId());
			userMapper.updateByPrimaryKey(buyer);
			userMapper.updateByPrimaryKey(seller);
		}else {
			throw new Exception("Not enough money");
		}
	}
}
