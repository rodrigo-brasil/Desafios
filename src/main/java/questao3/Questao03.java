package questao3;

import java.util.*;

public class Questao03 {

    private Questao03() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Encontra o número de pares de substrings que são anagramas da palavra.
     * @param palavra palavra a ser testada
     * @return  Inteiro com a quantidade de pares de substrings que são anagramas
     */
    public static int anagrama(String palavra) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 1; i < palavra.length(); i++) {
            splitStringBySize(palavra, i).forEach(subStrings -> {
                char[] arrayToSort = subStrings.toCharArray();
                Arrays.sort(arrayToSort);
                String key = new String(arrayToSort);
                if (map.containsKey(key))
                    map.put(key, map.get(key) + 1);
                else
                    map.put(key, 0);
            });
        }
        return map.values().stream().mapToInt(v -> v).sum();
    }

    /**
     * Divide uma string em substrings de tamanho igual
     * @param str String a ser dividida
     * @param size Tamanho das substrings gerada
     * @return Lista com todas substrings gerada
     */
    private static List<String> splitStringBySize(String str, int size) {
        if (size <= 0) return new ArrayList<>();
        List<String> pieces = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (i + size > str.length()) break;
            pieces.add(str.substring(i, Math.min(i + size, str.length())));
        }
        return pieces;
    }
}
