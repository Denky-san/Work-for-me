package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class CadastroAluno extends JFrame implements ActionListener {

    protected JPanel painel;
    protected JLabel header;
    protected JTextField nome, matricula,dataNascimento, anoIngresso, situacao;
    protected String name, registration, birthDate, entryYear, situation;
    protected JButton cadastrar, voltar;
    protected  JComboBox<String> listaFaculdades, listaCursos;

    CadastroAluno() {
        // Criando objeto imagem
        ImageIcon icone = new ImageIcon("src\\Assets\\logo.png");
        this.setIconImage(icone.getImage()); // Tornando objeto imagem o icone

        this.setBounds(TelaInicial.boundx,TelaInicial.boundy, 800, 600); //Definir tamanho da janela
        this.setResizable(false); // Proibir redimensionamento
        this.setTitle("Work For Me"); //Nome da janela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Para realmente fechar a aplicação
        this.getContentPane().setBackground(new Color(18, 18, 18)); //Colorindo background
        this.getContentPane().setLayout(null); //configurando o layout para nulo, assim podemos usar o metodo setBounds

        // Painel
        painel = new JPanel();
        painel.setBackground(new Color(18, 18, 18));
        painel.setBounds(0, 0, 800, 600); // metodo para escolher local do componente na tela
        getContentPane().add(painel);
        painel.setLayout(null);

        // Header da página
        header = new JLabel();
        header.setText("Cadastrar aluno");
        header.setForeground(Color.lightGray); // cor do texto
        header.setFont(new Font(Font.SERIF, Font.BOLD, 40));
        header.setVerticalAlignment(JLabel.TOP);
        header.setHorizontalAlignment(JLabel.CENTER);
        header.setBounds(0, 0, 800, 600);
        header.setBorder(new EmptyBorder(10, 0, 0, 0)); // adicionando bordas
        painel.add(header);

        //Campo nome
        nome = new JTextField();
        nome.setText("Nome");
        nome.setBounds(300, 100, 200, 30);
        nome.setFont(new Font("Arial", Font.PLAIN, 20));
        nome.setBackground(Color.LIGHT_GRAY); // cor da caixa de texto
        nome.addActionListener(this);
        painel.add(nome);

        //Campo matricula
        matricula = new JTextField();
        matricula.setText("Matrícula");
        matricula.setBounds(300, 150, 200, 30);
        matricula.setFont(new Font("Arial", Font.PLAIN, 20));
        matricula.setBackground(Color.LIGHT_GRAY); // cor da caixa de texto
        matricula.addActionListener(this);
        painel.add(matricula);

        //Campo dataNascimento
        dataNascimento = new JTextField();
        dataNascimento.setText("Data de nascimento");
        dataNascimento.setBounds(300, 200, 200, 30);
        dataNascimento.setFont(new Font("Arial", Font.PLAIN, 20));
        dataNascimento.setBackground(Color.LIGHT_GRAY); // cor da caixa de texto
        dataNascimento.addActionListener(this);
        painel.add(dataNascimento);

        //Campo anoIngresso
        anoIngresso = new JTextField();
        anoIngresso.setText("Ano de ingresso");
        anoIngresso.setBounds(300, 250, 200, 30);
        anoIngresso.setFont(new Font("Arial", Font.PLAIN, 20));
        anoIngresso.setBackground(Color.LIGHT_GRAY); // cor da caixa de texto
        anoIngresso.addActionListener(this);
        painel.add(anoIngresso);

        //Campo situacao
        situacao = new JTextField();
        situacao.setText("Situação");
        situacao.setBounds(300, 300, 200, 30);
        situacao.setFont(new Font("Arial", Font.PLAIN, 20));
        situacao.setBackground(Color.LIGHT_GRAY); // cor da caixa de texto
        situacao.addActionListener(this);
        painel.add(situacao);

        //Campo faculdade
        listaFaculdades = new JComboBox<String>();
        listaFaculdades.setFont(new Font("Arial", Font.PLAIN, 20));
        listaFaculdades.setModel(new DefaultComboBoxModel<String>(new String[] {"Teste", "Teste", "Teste", "Não cadastrado"}));
        listaFaculdades.setBounds(300, 350, 200, 30);
        painel.add(listaFaculdades);

        //Campo cursos
        listaCursos = new JComboBox<String>();
        listaCursos.setFont(new Font("Arial", Font.PLAIN, 20));
        listaCursos.setModel(new DefaultComboBoxModel<String>(new String[] {"Teste", "Teste", "Teste", "Não cadastrado"}));
        listaCursos.setBounds(300, 400, 200, 30);
        painel.add(listaCursos);

        // Botão para voltar
        voltar = new JButton("Voltar");
        voltar.setBounds(300, 450, 70, 30);
        voltar.setFocusable(false); // tirar caixa pontilhada que ficava em volta da palavra dentro do botão
        painel.add(voltar);
        voltar.addActionListener(this);

        // Botão para cadastrar
        cadastrar = new JButton("Cadastrar");
        cadastrar.setBounds(400, 450, 100, 30);
        cadastrar.setFocusable(false); // tirar caixa pontilhada que ficava em volta da palavra dentro do botão
        painel.add(cadastrar);
        cadastrar.addActionListener(this);

        // Tornando tudo visivel
        this.setVisible(true);
        painel.setVisible(true);
        header.setVisible(true);
        nome.setVisible(true);
        matricula.setVisible(true);
        dataNascimento.setVisible(true);
        anoIngresso.setVisible(true);
        situacao.setVisible(true);
        listaFaculdades.setVisible(true);
        listaCursos.setVisible(true);
        cadastrar.setVisible(true);
        voltar.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TelaInicial.boundx = this.getX();
        TelaInicial.boundy = this.getY();
        if (Objects.equals(e.getSource(),voltar)){
            TelaInicial ini = new TelaInicial();
            ini.setVisible(true);
            dispose();
        }

        if (Objects.equals(e.getSource(),cadastrar)){
            TelaInicial.boundx = this.getX();
            TelaInicial.boundy = this.getY();
            name = nome.getText();
            registration = matricula.getText();
            birthDate = dataNascimento.getText();
            entryYear = anoIngresso.getText();
            situation = situacao.getText();

            JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso!");
        }
    }
}
