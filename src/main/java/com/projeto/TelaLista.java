package com.projeto;

import javax.swing.*;

import com.google.gson.Gson;

import java.awt.GridBagLayout;
import java.io.FileReader;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;

public class TelaLista extends JDialog {
    
    private JPanel jPanel = new JPanel(new GridBagLayout());
    JLabel labeltitulo = new JLabel("Lista com contatos:");
    JButton buttonfechar = new JButton("Fechar");

    public TelaLista() {
        setSize(480, 480);
        setLocationRelativeTo(null);
        
        GridBagConstraints gridBagConstains = new GridBagConstraints();
        gridBagConstains.gridx = 0;
        gridBagConstains.gridy = 0;
        gridBagConstains.anchor = GridBagConstraints.CENTER;

        labeltitulo.setPreferredSize(new Dimension(112,25));
        jPanel.add(labeltitulo, gridBagConstains);

        try {
            FileReader reader = new FileReader("E:\\Programação\\Mavenprojeto\\projeto-simples\\src\\main\\java\\com\\projeto\\cadastros.json");
            Cadastro cadastro =new Gson().fromJson(reader, Cadastro.class);
            JLabel labelcadastro = new JLabel("<html>" + cadastro.getNome() + "<br>" + cadastro.getPeso() + "<br>" + cadastro.getIdade() + "</html>");
            labelcadastro.setPreferredSize(new Dimension(77,50));
            gridBagConstains.gridy ++;
            jPanel.add(labelcadastro, gridBagConstains);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        buttonfechar.setPreferredSize(new Dimension(200,25));
        gridBagConstains.gridy ++;
        jPanel.add(buttonfechar, gridBagConstains);

        buttonfechar.addActionListener(acao -> {
            TelaLista.this.dispose();
        });

        add(jPanel, BorderLayout.NORTH);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
     
}
