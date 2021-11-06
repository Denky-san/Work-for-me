package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class CadastroCurso extends JFrame implements ActionListener {

    protected JPanel painel;
    protected JLabel header;
    protected JTextField nome, sigla, area;
    protected JButton cadastrar, voltar;
    protected JComboBox<String> listaFaculdades;

    protected static Universidade uniEscolhida;

    protected static ArrayList<Cursos> CursosArray = new ArrayList<>();  //Criando uma ArrayList para armazenar as universidades
    protected static int aumentarNumCursos = -1; // Contador de quantidade de Cursos (começa em -1 para evitar problemas de IndexOutOfBoundsException)


    // Criando um modelo especifico do ComboBoxModel para não usar o default com ComboBoxModel com Strings inicializadas.
    protected static DefaultComboBoxModel modelUniver = new DefaultComboBoxModel();

    protected static DefaultComboBoxModel modelCursos = new DefaultComboBoxModel();

    CadastroCurso() {
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
        header.setText("Cadastrar curso");
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
        nome.setBounds(300, 170, 200, 30);
        nome.setFont(new Font("Arial", Font.PLAIN, 20));
        nome.setBackground(Color.LIGHT_GRAY); // cor da caixa de texto
        nome.addActionListener(this);
        painel.add(nome);

        // Campo sigla
        sigla = new JTextField();
        sigla.setText("Sigla");
        sigla.setBounds(300, 220, 200, 30);
        sigla.setFont(new Font("Arial", Font.PLAIN, 20));
        sigla.setBackground(Color.LIGHT_GRAY); // cor da caixa de texto
        sigla.addActionListener(this);
        painel.add(sigla);

        // Campo area
        area = new JTextField();
        area.setText("Area");
        area.setBounds(300, 270, 200, 30);
        area.setFont(new Font("Arial", Font.PLAIN, 20));
        area.setBackground(Color.LIGHT_GRAY); // cor da caixa de texto
        area.addActionListener(this);
        painel.add(area);

        // Campo faculdade
        listaFaculdades = new JComboBox<>();
        listaFaculdades.setFont(new Font("Arial", Font.PLAIN, 20));

        if (CadastroUniversidade.aumentarNumUniver < 0)
        {
            modelUniver.addElement("Não cadastrado");
        }
        else
        {
            modelUniver.removeElement("Não cadastrado");
        }
        listaFaculdades.setModel(modelUniver); // Só faltar settar aqui o modelo.
        listaFaculdades.setBounds(300, 320, 200, 30);
        painel.add(listaFaculdades);

        // Botão para voltar
        voltar = new JButton("Voltar");
        voltar.setBounds(300, 370, 70, 30);
        voltar.setFocusable(false); // tirar caixa pontilhada que ficava em volta da palavra dentro do botão
        painel.add(voltar);
        voltar.addActionListener(this);

        // Botão para cadastrar
        cadastrar = new JButton("Cadastrar");
        cadastrar.setBounds(400, 370, 100, 30);
        cadastrar.setFocusable(false); // tirar caixa pontilhada que ficava em volta da palavra dentro do botão
        painel.add(cadastrar);
        cadastrar.addActionListener(this);

        // Tornando tudo visivel
        this.setVisible(true);
        painel.setVisible(true);
        header.setVisible(true);
        nome.setVisible(true);
        sigla.setVisible(true);
        area.setVisible(true);
        listaFaculdades.setVisible(true);
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

            String temp = (String) modelUniver.getSelectedItem();

            System.out.println(temp);

            for (int i = 0; i < CadastroUniversidade.aumentarNumUniver + 1; i++)
            {
                if (temp.equals(CadastroUniversidade.UniversidadesArr.get(i).getNome()))
                {
                    uniEscolhida = CadastroUniversidade.UniversidadesArr.get(i);
                }
            }

            // Criando um array de cursos passando os devidos parâmetros.
            Cursos Cur = new Cursos(nome.getText(), sigla.getText(), area.getText(), uniEscolhida);

            CursosArray.add(Cur); // Adicionando a universidade criada para a ArrayList

            aumentarNumCursos++;

            modelCursos.addElement(CursosArray.get(aumentarNumCursos).getNome());

            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
        }
    }
}
