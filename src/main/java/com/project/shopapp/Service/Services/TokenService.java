package com.project.shopapp.Service.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.shopapp.DTO.TokenDTO;
import com.project.shopapp.Model.Token;
import com.project.shopapp.Repository.TokenRepository;
import com.project.shopapp.Repository.UserRepository;
import com.project.shopapp.Service.Impl.ITokenService;

@Service
public class TokenService implements ITokenService {
    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Token> getAllToken() {
        return tokenRepository.findAll();
    }

    @Override
    public void deleteToken(long id) throws Exception {
        try {
            Token token = tokenRepository.findById(id)
                    .orElseThrow(() -> new Exception("Không có id token này để xóa"));
            tokenRepository.delete(token);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Token getByTokenId(long id) throws Exception {
        try {
            return tokenRepository.findById(id)
                    .orElseThrow(() -> new Exception("Không có id token này để lấy"));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Token createToken(TokenDTO tokenDTO) throws Exception {
        try {
            userRepository.findById(tokenDTO.getUserId())
                    .orElseThrow(() -> new Exception("user id nay không tồn tại"));
            Token token = Token.builder()
                    .token(tokenDTO.getToken())
                    .tokenType(tokenDTO.getTokenType())
                    .expirationDate(tokenDTO.getExpirationDate())
                    .expired(false)
                    .revoked(false)
                    .userId(tokenDTO.getUserId())
                    .build();
            return tokenRepository.save(token);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Token updateToken(TokenDTO tokenDTO, long id) throws Exception {
        try {
            Token token = tokenRepository.findById(id)
                    .orElseThrow(() -> new Exception("Không có id token này để sửa"));
            userRepository.findById(tokenDTO.getUserId())
                    .orElseThrow(() -> new Exception("user id nay không tồn tại"));
            token.setToken(tokenDTO.getToken());
            token.setTokenType(tokenDTO.getTokenType());
            token.setExpirationDate(tokenDTO.getExpirationDate());
            token.setExpired(false);
            token.setRevoked(false);
            token.setUserId(tokenDTO.getUserId());
            return tokenRepository.save(token);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
