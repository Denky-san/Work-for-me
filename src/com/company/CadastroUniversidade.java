package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class CadastroUniversidade extends JFrame implements ActionListener {

    protected JPanel painel;
    protected JLabel header;
    protected JTextField nome, endereco, bairro, cidade, estado;
    protected JButton cadastrar, voltar;

    protected static ArrayList<Universidade> UniversidadesArr = new ArrayList<>();  //Criando uma ArrayList para armazenar as universidades
    protected static int aumentarNumUniver = -1; // Contador de quantidade de Universidades (começa em -1 para evitar problemas de IndexOutOfBoundsException)

    CadastroUniversidade() {
        // Criando objeto imagem
        ImageIcon icone = new ImageIcon("src\\Assets\\logo.png");
        this.setIconImage(icone.getImage()); // Tornando objeto imagem o icone

        this.setBounds(TelaInicial.boundx, TelaInicial.boundy, 800, 600); // Definir tamanho da janela
        this.setResizable(false); // Proibir redimensionamento
        this.setTitle("Work For Me"); // Nome da janela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Para realmente fechar a aplicação
        this.getContentPane().setBackground(new Color(18, 18, 18)); // Colorindo background
        this.getContentPane().setLayout(null); // configurando o layout para nulo, assim podemos usar o metodo setBounds

        // Painel
        painel = new JPanel();
        painel.setBackground(new Color(18, 18, 18));
        painel.setBounds(0, 0, 800, 600); // metodo para escolher local do componente na tela
        getContentPane().add(painel);
        painel.setLayout(null);

        // Header da página
        header = new JLabel();
        header.setText("Cadastrar universidade");
        header.setForeground(Color.lightGray); // cor do texto
        header.setFont(new Font(Font.SERIF, Font.BOLD, 40));
        header.setVerticalAlignment(JLabel.TOP);
        header.setHorizontalAlignment(JLabel.CENTER);
        header.setBounds(0, 0, 800, 600);
        header.setBorder(new EmptyBorder(10, 0, 0, 0)); // adicionando bordas
        painel.add(header);

        // Campo nome
        nome = new JTextField();
        nome.setText("Nome");
        nome.setBounds(300, 150, 200, 30);
        nome.setFont(new Font("Arial", Font.PLAIN, 20));
        nome.setBackground(Color.LIGHT_GRAY); // cor da caixa de texto
        nome.addActionListener(this);
        painel.add(nome);

        // Campo endereço
        endereco = new JTextField();
        endereco.setText("Endereço");
        endereco.setBounds(300, 200, 200, 30);
        endereco.setFont(new Font("Arial", Font.PLAIN, 20));
        endereco.setBackground(Color.LIGHT_GRAY); // cor da caixa de texto
        endereco.addActionListener(this);
        painel.add(endereco);

        // Campo bairro
        bairro = new JTextField();
        bairro.setText("Bairro");
        bairro.setBounds(300, 250, 200, 30);
        bairro.setFont(new Font("Arial", Font.PLAIN, 20));
        bairro.setBackground(Color.LIGHT_GRAY); // cor da caixa de texto
        bairro.addActionListener(this);
        painel.add(bairro);

        // Campo cidade
        cidade = new JTextField();
        cidade.setText("Cidade");
        cidade.setBounds(300, 300, 200, 30);
        cidade.setFont(new Font("Arial", Font.PLAIN, 20));
        cidade.setBackground(Color.LIGHT_GRAY); // cor da caixa de texto
        cidade.addActionListener(this);
        painel.add(cidade);

        // Campo estado
        estado = new JTextField();
        estado.setText("Estado");
        estado.setBounds(300, 350, 200, 30);
        estado.setFont(new Font("Arial", Font.PLAIN, 20));
        estado.setBackground(Color.LIGHT_GRAY); // cor da caixa de texto
        estado.addActionListener(this);
        painel.add(estado);

        // Botão para voltar
        voltar = new JButton("Voltar");
        voltar.setBounds(300, 400, 70, 30);
        voltar.setFocusable(false); // tirar caixa pontilhada que ficava em volta da palavra dentro do botão
        painel.add(voltar);
        voltar.addActionListener(this);

        // Botão para cadastrar
        cadastrar = new JButton("Cadastrar");
        cadastrar.setBounds(400, 400, 100, 30);
        cadastrar.setFocusable(false); // tirar caixa pontilhada que ficava em volta da palavra dentro do botão
        painel.add(cadastrar);
        cadastrar.addActionListener(this);

        // Tornando tudo visível
        this.setVisible(true);
        painel.setVisible(true);
        header.setVisible(true);
        nome.setVisible(true);
        endereco.setVisible(true);
        bairro.setVisible(true);
        cidade.setVisible(true);
        estado.setVisible(true);
        cadastrar.setVisible(true);
        voltar.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (Objects.equals(e.getSource(), voltar)) {
            TelaInicial.boundx = this.getX();
            TelaInicial.boundy = this.getY();
            TelaInicial ini = new TelaInicial();
            ini.setVisible(true);
            dispose();
            CadastroCurso.modelUniver.removeElement("Não cadastrado");
        }

        if (Objects.equals(e.getSource(), cadastrar)) {
            TelaInicial.boundx = this.getX();
            TelaInicial.boundy = this.getY();

            // Criando uma universidade passando os devidos parâmetros.
            Universidade Uni = new Universidade(nome.getText(), endereco.getText(), bairro.getText(), cidade.getText(), estado.getText());

            UniversidadesArr.add(Uni); // Adicionando a universidade criada para a ArrayList

            aumentarNumUniver++;

            // Adicionando os nomes para aparecer no cadastro de cursos

            CadastroCurso.modelUniver.addElement(CadastroUniversidade.UniversidadesArr.get(aumentarNumUniver).getNome());









            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
        }
    }
}
