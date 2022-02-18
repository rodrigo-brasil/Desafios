package view;

import questao3.Questao03;

import javax.swing.*;
import java.awt.*;

public class Questao3Panel extends JPanel {
    public Questao3Panel() {
        JPanel groupInput = new JPanel();
        FlowLayout insideLayout = new FlowLayout(FlowLayout.LEADING, 5, 5);
        groupInput.setLayout(insideLayout);

        JLabel label = new JLabel("Digite a palavra:");
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

        JLabel result = new JLabel("Número de pares de substrings que são anagramas.");
        result.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));

        button.addActionListener(e -> {
           int qdtAnagramas = Questao03.anagrama(input.getText());
            result.setText(qdtAnagramas+ " de pares de substrings que são anagramas.");
        });

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 15, 5));
        setAlignmentX(LEFT_ALIGNMENT);
        add(groupInput);
        add(Box.createVerticalGlue());
        add(result);

    }
}
