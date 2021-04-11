package com.AuthServer.repository;
import com.AuthServer.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
//import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//public interface UserRepository extends MongoRepository<User, String>, QuerydslPredicateExecutor<User> {

public interface UserRepository extends MongoRepository<User, String> {

    User findUsersByUsername(String username);
}
