package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Merchant;

@Repository
public interface MerchantRepo extends JpaRepository<Merchant, Integer> {
	
	public Optional<Merchant> findByEmail(String email);
}
