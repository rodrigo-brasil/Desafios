package questao1;

public class Questao01 {

    private Questao01() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * @param n quantidade de degraus, número inteiro positivo maior que 0
     * @return String com uma escada de tamanho n utilizando o caractere * e espaços.
     */
    public static String imprimirEscada(int n) {
        StringBuilder result =  new StringBuilder("");
        if (n <= 0) return result.toString();
        StringBuilder line = new StringBuilder(" ".repeat(n));
        for (int i = n - 1; i >= 0; i--) {
            line.setCharAt(i, '*');
            result.append(line + (i == 0 ? "" : "\n"));
        }
        return result.toString();
    }

}
