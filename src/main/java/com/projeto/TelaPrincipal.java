package com.projeto;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;

public class TelaPrincipal extends JDialog{

    JFrame frame = new JFrame();
    private JPanel jPanel = new JPanel(new GridBagLayout());
    JLabel labeltitulo = new JLabel("Tela Principal");
    JButton Cadastro = new JButton("Cadastro");
    JButton Lista = new JButton("Lista");

    public TelaPrincipal() {
        setTitle("Tela Princial");
        setSize(480, 480);
        setLocationRelativeTo(null);

        GridBagConstraints gridBagConstains = new GridBagConstraints();
        //alinhando a tabela
        gridBagConstains.gridx = 0;
        gridBagConstains.gridy = 0;
        //quanto cada celula vai ocupar no caso 2
        gridBagConstains.gridwidth = 2;
        //margem entre os itens
        gridBagConstains.insets = new Insets(25,0,0,0);
        //alinhamento
        gridBagConstains.anchor = GridBagConstraints.CENTER;
        
        labeltitulo.setPreferredSize(new Dimension(77,25));
        jPanel.add(labeltitulo, gridBagConstains);
        //volta a ocupar 1 celula
        gridBagConstains.gridwidth = 1;

        Cadastro.setPreferredSize(new Dimension(200,50));
        gridBagConstains.gridy ++;
        jPanel.add(Cadastro, gridBagConstains);

        Lista.setPreferredSize(new Dimension(200,50));
        gridBagConstains.gridy ++;
        jPanel.add(Lista, gridBagConstains);
            
        Cadastro.addActionListener(acao -> {
            TelaCadastro telacadastro = new TelaCadastro();
        });
        Lista.addActionListener(acao -> {
            TelaLista telalista = new TelaLista();
        });

        add(jPanel, BorderLayout.NORTH);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
