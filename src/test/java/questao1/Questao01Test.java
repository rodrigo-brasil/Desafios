package questao1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class Questao01Test {

    @BeforeAll
    static void setUp() {
        System.out.println("Running Questão 01 tests");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("Teste finalizado");
    }

    @Test
    void imprimirEscada() {

        //Case n = Inteiro positivo > 0
        assertEquals(
                "     *\n" +
                        "    **\n" +
                        "   ***\n" +
                        "  ****\n" +
                        " *****\n" +
                        "******", Questao01.imprimirEscada(6));

        assertEquals("*", Questao01.imprimirEscada(1));

        //Case n = 0
        assertEquals(
                "", Questao01.imprimirEscada(0)
        );

        //Case n = Inteiro negativo
        assertEquals(
                "", Questao01.imprimirEscada(-1)
        );
    }
}