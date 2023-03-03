package com.masai.service;

import java.util.List;

import com.masai.exception.MerchantException;
import com.masai.exception.ProductException;
import com.masai.model.Merchant;
import com.masai.model.Product;

public interface MerchantService {

	public Merchant registerMerchant(Merchant meechant);
	
	public Merchant getMerchentByEmail(String email)throws MerchantException;
	
	public Merchant signIn()throws MerchantException;
	
	public List<Merchant> getAllMerchant()throws MerchantException;
	
	public Product addProdcut(Product product, Integer merchantId)throws MerchantException;
	
	public List<Product> getAllProdcutOfMerchant(Integer merchantId)throws ProductException;
}
