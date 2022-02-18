package questao2;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class Questao02Test {

    @Test
    void addPattern() {
        // Caso pattern seja null
        assertFalse(Questao02.addPattern(null), "null");

        //Caso já tenha um regex igual na lista
        Pattern repitido = Pattern.compile("[a-z]");
        assertFalse(Questao02.addPattern(repitido));

        // Caso seja um novo regex
        Pattern novo = Pattern.compile("^[0-9]{2}-([0-9]{8}|[0-9]{9})");
        assertTrue(Questao02.addPattern(novo));
    }

    @Test
    void verificarSenha() {

        // Caso senha seja forte
        assertEquals(0, Questao02.verificarSenha("Ah5*fl23f"));

        // Caso esteja faltando Letra Maiúscula
        assertEquals(1, Questao02.verificarSenha("ah5*fl"));

        // Caso esteja faltando Letra Minúscula
        assertEquals(1, Questao02.verificarSenha("H5%HHH"));

        // Caso esteja faltando caracter especial
        assertEquals(1, Questao02.verificarSenha("H5aHHH"));

        // Caso esteja faltando no minimo 6 letras
        assertEquals(1, Questao02.verificarSenha("Aa12#"));

        // Caso tenha 6 porem falta o resto
        assertEquals(3, Questao02.verificarSenha("AAAAAA"));

        // Caso esteja vazia
        assertEquals(6, Questao02.verificarSenha(""));

    }

}