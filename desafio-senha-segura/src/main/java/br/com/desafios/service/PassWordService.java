package br.com.desafios.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class PassWordService {

    public List<String> checkPassWord(String password) {

        List<String> listMensseger = new ArrayList();

        validateLength(listMensseger, password);
        validateUpperCase(listMensseger, password);
        validateLowerCase(listMensseger, password);
        validateNumber(listMensseger, password);
        validateSpecialCharacter(listMensseger, password);

        return listMensseger;
    }

    private void validateLength(List<String> listMensseger, String password) {
        if (password != null && password.length() < 8) {
            listMensseger.add("A senha deve conter pelo menos 8 caracteres");
        }
    }

    private void validateUpperCase(List<String> listMensseger, String password) {
        if (!Pattern.matches(".*[A-Z].*", password)){
            listMensseger.add("A senha deve conter pelo meno uma letra maiuscula.");
        }
    }

    private void validateLowerCase(List<String> listMensseger, String password) {
        if (!Pattern.matches(".*[a-z].*", password)){
            listMensseger.add("A senha deve conter pelo meno uma letra minuscula.");
        }
    }


    private void validateNumber(List<String> listMensseger, String password) {
        if (!Pattern.matches(".*[0-9].*", password)){
            listMensseger.add("A senha deve conter pelo meno um numero.");
        }
    }

    private void validateSpecialCharacter(List<String> listMensseger, String password) {
        if (!Pattern.matches(".*[\\W].*", password)){
            listMensseger.add("A senha deve conter pelo meno um caracter especial(@#$%&).");
        }
    }

}
