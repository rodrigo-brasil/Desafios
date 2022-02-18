package view;

import questao2.Questao02;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class Questao2Panel extends JPanel {
    public Questao2Panel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 15, 5));

        JPanel groupInput = new JPanel(new GridLayout(0, 1, 5, 5));

        JLabel label = new JLabel("Digite a senha:");
        JTextField input = new JTextField();
        input.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        groupInput.add(label);
        groupInput.add(input);

        JLabel result = new JLabel("Faltam 6 caracteres");
        result.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));

        JTextArea hint = new JTextArea();
        hint.setEditable(false);
        hint.setRows(6);
        hint.setFont(new Font(Font.SERIF, Font.PLAIN, 12));

        add(groupInput);
        add(result);
        add(hint);

        input.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setOutput(input, result, hint);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setOutput(input, result, hint);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                setOutput(input, result, hint);
            }
        });
    }

    private void setOutput(JTextField input, JLabel result, JTextArea hint) {
        int missingCharacter = Questao02.verificarSenha(input.getText());
        if (missingCharacter == 0)
            result.setText("Senha Segura");
        else
            result.setText("Falta " + missingCharacter + " caracteres");
        String erros = Questao02.getListOfErros(input.getText());
        hint.setText(erros);
    }


}
