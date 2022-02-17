package questao2;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Questao02 {

    public static void verificarSenha(String senha) {
        Pattern letterLower = Pattern.compile("[a-z]");
        Pattern letterUpper = Pattern.compile("[A-Z]");
        Pattern number = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile("[!@#$%^&*()-+]");
        int missingCharacterCount = checkMissingPattern(senha, letterLower, letterUpper, number, special);
        int result = senha.length() + missingCharacterCount >= 6 ? missingCharacterCount : 6 - (senha.length() + missingCharacterCount) + missingCharacterCount;
        System.out.println(result);
    }

    private static int checkMissingPattern(String test, Pattern... patterns) {
        return (int) Arrays.stream(patterns).filter(pattern -> !pattern.matcher(test).find()).count();
    }
}
