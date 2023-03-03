package com.masai.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.exception.MerchantException;
import com.masai.exception.ProductException;
import com.masai.model.Merchant;
import com.masai.model.Product;

@Service
public class MerchantServiceImpl implements MerchantService {

	@Override
	public Merchant registerMerchant(Merchant meechant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Merchant getMerchentByEmail(String email) throws MerchantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Merchant signIn() throws MerchantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Merchant> getAllMerchant() throws MerchantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product addProdcut(Product product, Integer merchantId) throws MerchantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAllProdcutOfMerchant(Integer merchantId) throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

}
