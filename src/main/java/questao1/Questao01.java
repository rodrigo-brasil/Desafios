package questao1;

import java.util.Collections;
import java.util.List;

public class Questao01 {

    public static void imprimirEscada(int n){
        if(n <= 0 ) return;
        StringBuilder line = new StringBuilder(" ".repeat(n));
        for (int i = n-1; i>=0 ; i--) {
            line.setCharAt(i,'*');
            System.out.println(line);
        }
    }

}
