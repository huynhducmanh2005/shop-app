package com.project.shopapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.shopapp.DTO.TokenDTO;
import com.project.shopapp.Model.Token;
import com.project.shopapp.Service.Services.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/tokens")
public class TokenController {
    @Autowired
    private TokenService tokenService;

    @GetMapping("/")
    public ResponseEntity<?> getAllTokens() {
        List<Token> listToken = tokenService.getAllToken();
        return ResponseEntity.ok(listToken);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByTokenId(@PathVariable long id) {
        try {
            Token token = tokenService.getByTokenId(id);
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTokens(@PathVariable long id) {
        try {
            tokenService.deleteToken(id);
            return ResponseEntity.ok(String.format("Đã xóa thành công token có id = %d", id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> createTokens(@Valid @RequestBody TokenDTO tokenDTO) {
        try {
            Token token = tokenService.createToken(tokenDTO);
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> createTokens(@Valid @RequestBody TokenDTO tokenDTO, @PathVariable long id) {
        try {
            Token token = tokenService.updateToken(tokenDTO, id);
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
