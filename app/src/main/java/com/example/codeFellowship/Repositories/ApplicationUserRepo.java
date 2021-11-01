package com.example.codeFellowship.Repositories;

import com.example.codeFellowship.Models.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationUserRepo extends CrudRepository<AppUser,Integer> {

    AppUser findByUsername(String username);

}