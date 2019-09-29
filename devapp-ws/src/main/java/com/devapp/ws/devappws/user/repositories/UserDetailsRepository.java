package com.devapp.ws.devappws.user.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.devapp.ws.devappws.user.entity.User;

@Repository
public interface UserDetailsRepository extends PagingAndSortingRepository<User, Long> {
	
	User findByUserId(String userId);
	User findByEmail(String email);

}
