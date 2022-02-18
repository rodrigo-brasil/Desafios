package view;

import questao1.Questao01;

import javax.swing.*;
import java.awt.*;

public class Questao1Panel extends JPanel {
    public Questao1Panel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));


        JPanel groupInput = new JPanel();
        FlowLayout insideLayout = new FlowLayout(FlowLayout.LEADING, 5, 5);
        groupInput.setLayout(insideLayout);

        JLabel label = new JLabel("Entre com o tamanho da escada:");
        JTextField input = new JTextField();
        input.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        input.setPreferredSize(new Dimension(150,25));
        JButton button = new JButton("ok");
        Dimension d = button.getPreferredSize();
        d.height = 25;
        button.setPreferredSize(d);

        groupInput.add(label);
        groupInput.add(input);
        groupInput.add(button);

        JTextArea result = new JTextArea();
        result.setRows(15);
        result.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        result.setEditable(false);
        JScrollPane sp = new JScrollPane(result);
        button.addActionListener(e -> {
            try {
                Integer value;
                value = Integer.parseInt(input.getText());
                String text = Questao01.imprimirEscada(value);
                result.setText(text);
                result.setRows(value);

            } catch (Exception exception) {
                result.setText("Valor inválido, Digite algum numero inteiro positivo");
            }

        });


        add(groupInput);
        add(sp);
    }
}
