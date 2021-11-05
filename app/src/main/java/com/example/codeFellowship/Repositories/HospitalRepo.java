package com.example.codeFellowship.Repositories;

import com.example.codeFellowship.Models.Hospital;
import org.springframework.data.repository.CrudRepository;

public interface HospitalRepo extends CrudRepository<Hospital,Long> {
    Hospital findByPlaceName(String placeName);
    Hospital findByUserName(String userName);
}