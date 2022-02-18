package questao2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Questao02 {

    private static final Pattern letterLower = Pattern.compile("[a-z]");
    private static final Pattern letterUpper = Pattern.compile("[A-Z]");
    private static final Pattern number = Pattern.compile("[0-9]");
    private static final Pattern special = Pattern.compile("[!@#$%^&*()-+]");
    private static final List<Pattern> patternList = new ArrayList<>(Arrays.asList(letterLower, letterUpper, number, special));

    private Questao02() {
        throw new IllegalStateException("Utility class");
    }


    /**
     * Adiciona uma nova regra para validar senhas
     *
     * @param pattern regex
     * @return True se adicionado com sucesso
     */
    public static Boolean addPattern(Pattern pattern) {
        if (Objects.isNull(pattern) || patternList.stream().anyMatch(p -> p.toString().equals(pattern.toString())))
            return false;
        return patternList.add(pattern);
    }

    /**
     * Informe qual é o número mínimo de caracteres que devem ser adicionados para uma String qualquer ser considerada segura.
     *
     * @param senha a ser testada
     * @return um inteiro que informa a quantidade de carateres que faltam para a senha ser segura
     */
    public static int verificarSenha(String senha) {
        int missingCharacterCount = checkMissingPattern(senha, patternList);
        return senha.length() + missingCharacterCount >= 6 ? missingCharacterCount : 6 - (senha.length() + missingCharacterCount) + missingCharacterCount;
    }

    /**
     * @param test     String a ser testada pelas regras cadastradas
     * @param patterns Lista de patterns regex
     * @return Inteiro com a quantidade de regras que a string não passou
     */
    private static int checkMissingPattern(String test, List<Pattern> patterns) {
        return (int) patterns.stream().filter(pattern -> !pattern.matcher(test).find()).count();
    }

    /**
     * Extra devolve uma lista com a string informando as regras que faltam
     *
     * @param senha String a ser testada pelas regras cadastradas
     * @return lista de string informando as regras que faltam
     */
    public static String getListOfErros(String senha) {
        List<String> erros = patternList.stream().filter(pattern -> !pattern.matcher(senha).find()).map(pattern -> {
            if (pattern.toString().equals("[A-Z]")) return "Falta uma letra em maiúsculo";
            if (pattern.toString().equals("[a-z]")) return "Falta uma letra em minúsculo";
            if (pattern.toString().equals("[0-9]")) return "falta um número";
            if (pattern.toString().equals("[!@#$%^&*()-+]")) return "falta um caractere especial ";
            return "";
        }).collect(Collectors.toList());
        if (senha.length() < 6)
            erros.add("Tem que ter no mínimo 6 caracteres.");
        return erros.stream().filter(s -> !s.equals("")).map(String::valueOf).collect(Collectors.joining("\n"));
    }

}
