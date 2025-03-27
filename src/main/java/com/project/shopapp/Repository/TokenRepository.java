package com.project.shopapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.shopapp.Model.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

}
