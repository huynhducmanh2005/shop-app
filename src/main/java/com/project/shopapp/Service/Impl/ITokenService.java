package com.project.shopapp.Service.Impl;

import java.util.List;

import com.project.shopapp.DTO.TokenDTO;
import com.project.shopapp.Model.Token;

public interface ITokenService {
    List<Token> getAllToken();

    void deleteToken(long id) throws Exception;

    Token getByTokenId(long id) throws Exception;

    Token createToken(TokenDTO tokenDTO) throws Exception;

    Token updateToken(TokenDTO tokenDTO, long id) throws Exception;
}
