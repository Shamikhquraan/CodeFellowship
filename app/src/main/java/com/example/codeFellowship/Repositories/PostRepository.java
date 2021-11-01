package com.example.codeFellowship.Repositories;

import com.example.codeFellowship.Models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Integer> {
}