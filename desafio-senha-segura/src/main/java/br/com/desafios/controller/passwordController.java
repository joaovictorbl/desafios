package br.com.desafios.controller;

import br.com.desafios.dto.PasswordRequest;
import br.com.desafios.service.PassWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/validation")
public class passwordController {

    @Autowired
    private PassWordService service;

    @PostMapping
    public ResponseEntity<List<String>> passwordValid(@RequestBody PasswordRequest passWordRequest){


        List<String> msgReturn = service.checkPassWord(passWordRequest.getPassword());

        if (msgReturn.isEmpty()) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().body(new ArrayList<>(msgReturn));
    }
}
