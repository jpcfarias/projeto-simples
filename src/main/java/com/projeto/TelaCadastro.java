package com.projeto;

import javax.swing.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.awt.*;

import java.io.FileWriter;
import java.io.IOException;

public class TelaCadastro extends JDialog {
    private JPanel jPanel = new JPanel(new GridBagLayout());
    //declarando as label's
    JLabel labelnome = new JLabel("Digite seu Nome: ");
    JLabel labelpeso = new JLabel("Digite seu Peso: ");
    JLabel labelidade = new JLabel("Digite sua Idade: ");
    //declarando os textfild
    JTextField textonome = new JTextField();
    JTextField textopeso = new JTextField();
    JTextField textoidade = new JTextField();
    //declarando os botoes
    JButton ok = new JButton("OK");
    
    
    public TelaCadastro(){
        //Setando configuraçao da janela
        setSize(480, 480);
        setLocationRelativeTo(null);
        
        GridBagConstraints gridBagConstains = new GridBagConstraints();
        gridBagConstains.gridx = 0;
        gridBagConstains.gridy = 0;
        //Label nome
        labelnome.setPreferredSize(new Dimension(200,25));
        jPanel.add(labelnome, gridBagConstains);
        //textfild nome
        textonome.setPreferredSize(new Dimension(200,25));
        gridBagConstains.gridy ++;
        jPanel.add(textonome, gridBagConstains);
        //Label peso
        labelpeso.setPreferredSize(new Dimension(200,25));
        gridBagConstains.gridy ++;
        jPanel.add(labelpeso, gridBagConstains);
        //textfild peso
        textopeso.setPreferredSize(new Dimension(200,25));
        gridBagConstains.gridy ++;
        jPanel.add(textopeso, gridBagConstains);
        //Label idade
        labelidade.setPreferredSize(new Dimension(200,25));
        gridBagConstains.gridy ++;
        jPanel.add(labelidade, gridBagConstains);
        //textfild idade
        textoidade.setPreferredSize(new Dimension(200,25));
        gridBagConstains.gridy ++;
        jPanel.add(textoidade, gridBagConstains);
        //okbutton
        ok.setPreferredSize(new Dimension(200,25));
        gridBagConstains.gridy ++;
        jPanel.add(ok, gridBagConstains);
        
        //action of okbuttion
        ok.addActionListener(acao -> {
                String nome = textonome.getText();
                try{
                    float peso = Float.parseFloat(textopeso.getText());
                    int idade = Integer.parseInt(textoidade.getText());
                    Cadastro cadastro = new Cadastro(nome, peso, idade);
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    String jsonUser = gson.toJson(cadastro);
                    try {
                        FileWriter fileWriter = new FileWriter("E:\\Programação\\Mavenprojeto\\projeto-simples\\src\\main\\java\\com\\projeto\\cadastros.json");
                        fileWriter.write(jsonUser);
                        fileWriter.flush();
                        fileWriter.close();
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(this, "Ocorreu um erro ao gravar o arquivo");
                    }
                    
                    JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso");
                    TelaCadastro.this.dispose();
                }catch(java.lang.NumberFormatException e){
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro");
                }
            }
        );

        add(jPanel, BorderLayout.NORTH);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
    }
}
