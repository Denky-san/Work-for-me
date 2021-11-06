package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class CadastroAluno extends JFrame implements ActionListener {

    protected JPanel painel;
    protected JLabel header;
    protected JTextField nome, matricula, dataNascimento, anoIngresso, situacao;
    protected JButton cadastrar, voltar;
    protected JComboBox<String> listaFaculdades, listaCursos;

    protected ArrayList<Alunos> AlunosArr = new ArrayList<>();

    protected static Universidade uniDoAluno;
    protected static Cursos cursoDoAluno;

    CadastroAluno() {
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
        header.setText("Cadastrar aluno");
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
        nome.setBounds(300, 100, 200, 30);
        nome.setFont(new Font("Arial", Font.PLAIN, 20));
        nome.setBackground(Color.LIGHT_GRAY); // cor da caixa de texto
        nome.addActionListener(this);
        painel.add(nome);

        // Campo matricula
        matricula = new JTextField();
        matricula.setText("Matrícula");
        matricula.setBounds(300, 150, 200, 30);
        matricula.setFont(new Font("Arial", Font.PLAIN, 20));
        matricula.setBackground(Color.LIGHT_GRAY); // cor da caixa de texto
        matricula.addActionListener(this);
        painel.add(matricula);

        // Campo dataNascimento
        dataNascimento = new JTextField();
        dataNascimento.setText("Data de nascimento");
        dataNascimento.setBounds(300, 200, 200, 30);
        dataNascimento.setFont(new Font("Arial", Font.PLAIN, 20));
        dataNascimento.setBackground(Color.LIGHT_GRAY); // cor da caixa de texto
        dataNascimento.addActionListener(this);
        painel.add(dataNascimento);

        // Campo anoIngresso
        anoIngresso = new JTextField();
        anoIngresso.setText("Ano de ingresso");
        anoIngresso.setBounds(300, 250, 200, 30);
        anoIngresso.setFont(new Font("Arial", Font.PLAIN, 20));
        anoIngresso.setBackground(Color.LIGHT_GRAY); // cor da caixa de texto
        anoIngresso.addActionListener(this);
        painel.add(anoIngresso);

        // Campo situacao
        situacao = new JTextField();
        situacao.setText("Situação");
        situacao.setBounds(300, 300, 200, 30);
        situacao.setFont(new Font("Arial", Font.PLAIN, 20));
        situacao.setBackground(Color.LIGHT_GRAY); // cor da caixa de texto
        situacao.addActionListener(this);
        painel.add(situacao);

        // Campo faculdade
        listaFaculdades = new JComboBox<>();
        listaFaculdades.setFont(new Font("Arial", Font.PLAIN, 20));

        /*
            Adicionando TODOS os elementos (faculdades cadastradas) novamente ao modelo para exibir.
            Para mais info ler CadastroUniversidade.java, linha 149
         */

        if (CadastroUniversidade.aumentarNumUniver < 0)
        {
            CadastroCurso.modelUniver.addElement("Não cadastrado");
        }
        else
        {
            CadastroCurso.modelUniver.removeElement("Não cadastrado");
        }

        listaFaculdades.setModel(CadastroCurso.modelUniver);
        listaFaculdades.setBounds(300, 350, 200, 30);
        painel.add(listaFaculdades);

        // Campo cursos
        listaCursos = new JComboBox<>();
        listaCursos.setFont(new Font("Arial", Font.PLAIN, 20));

        if (CadastroCurso.aumentarNumCursos < 0)
        {
            CadastroCurso.modelCursos.addElement("Não cadastrado");
        }
        else
        {
            CadastroCurso.modelCursos.removeElement("Não cadastrado");
        }

        listaCursos.setModel(CadastroCurso.modelCursos);
        listaCursos.setBounds(300, 400, 200, 30);
        painel.add(listaCursos);

        // Botão para voltar
        voltar = new JButton("Voltar");
        voltar.setBounds(300, 450, 70, 30);
        voltar.setFocusable(false); // tirar caixa pontilhada que ficava em volta da palavra no botão
        painel.add(voltar);
        voltar.addActionListener(this);

        // Botão para cadastrar
        cadastrar = new JButton("Cadastrar");
        cadastrar.setBounds(400, 450, 100, 30);
        cadastrar.setFocusable(false); // tirar caixa pontilhada que ficava em volta da palavra no botão
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
        if (Objects.equals(e.getSource(), voltar)) {
            TelaInicial ini = new TelaInicial();
            ini.setVisible(true);
            dispose();
            CadastroCurso.modelUniver.removeElement("Não cadastrado");
            CadastroCurso.modelCursos.removeElement("Não cadastrado");
        }

        if (Objects.equals(e.getSource(), cadastrar)) {
            TelaInicial.boundx = this.getX();
            TelaInicial.boundy = this.getY();

            String temp = (String) CadastroCurso.modelUniver.getSelectedItem();

            for (int i = 0; i < CadastroUniversidade.aumentarNumUniver + 1; i++)
            {
                if (temp.equals(CadastroUniversidade.UniversidadesArr.get(i).getNome()))
                {
                    uniDoAluno = CadastroUniversidade.UniversidadesArr.get(i);
                }
            }

            String temp2 = (String) CadastroCurso.modelCursos.getSelectedItem();

            for (int i = 0; i < CadastroCurso.aumentarNumCursos + 1; i++)
            {
                if(temp2.equals(CadastroCurso.CursosArray.get(i).getNome()))
                {
                    cursoDoAluno = CadastroCurso.CursosArray.get(i);
                }
            }

            Alunos Alun = new Alunos(nome.getText(), matricula.getText(), dataNascimento.getText(), anoIngresso.getText(), situacao.getText(), uniDoAluno, cursoDoAluno);

            AlunosArr.add(Alun);

            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
        }
    }
}
