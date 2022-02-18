package questao3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Questao03Test {

    @Test
    void anagrama() {

        assertEquals(2, Questao03.anagrama("ovo"));
        assertEquals(3, Questao03.anagrama("ifailuhkqq"));

    }
}