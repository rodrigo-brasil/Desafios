package view;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {

    public App() {
        setTitle("Desafio capgemini 2022 - Rodrigo Sousa Brasil");
        ImageIcon icon = new ImageIcon("src/main/resources/logo-capgemini.png");
        setIconImage(icon.getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setMinimumSize(new Dimension(500, 500));
        setLocationRelativeTo(null);
        setVisible(true);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel,BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPanel.add(createTitledPanel(new Questao1Panel(),"Questão 01"));
        contentPanel.add(createTitledPanel(new Questao2Panel(),"Questão 02"));
        contentPanel.add(createTitledPanel(new Questao3Panel(),"Questão 03"));

        setContentPane(contentPanel);
        pack();

    }

    private JPanel createTitledPanel(JComponent content, String title) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(content);
        panel.setBorder(BorderFactory.createTitledBorder(title));
        return panel;
    }

}
