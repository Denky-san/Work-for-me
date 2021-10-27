package com.company;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class TelaInicial extends JFrame implements ActionListener {

    protected JButton cadastrarUniversidade, cadastrarCurso, cadastrarAluno, pesquisarCandidato;
    protected JPanel painel;
    protected JLabel header, footer;

    TelaInicial(){
        // Criando objeto imagem
        ImageIcon icone = new ImageIcon("D:\\trabalhoFinal\\Work-for-me\\src\\Assets\\logo.png");
        this.setIconImage(icone.getImage()); // Tornando objeto imagem o icone

        this.setBounds(0,0,800,600); //Definir tamanho da janela
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
        header.setText("Work For Me");
        header.setIcon(icone);
        header.setForeground(Color.lightGray); // cor do texto
        header.setFont(new Font(Font.SERIF,Font.BOLD, 40));
        header.setVerticalAlignment(JLabel.TOP);
        header.setHorizontalAlignment(JLabel.CENTER);
        header.setBounds(0,0,800,600);
        header.setBorder(new EmptyBorder(10,0,0,0)); // adicionando bordas
        painel.add(header);

        // Botão para cadastrar universidade
        cadastrarUniversidade = new JButton("Cadastrar Universidade");
        cadastrarUniversidade.setBounds(300,140,200,50);
        cadastrarUniversidade.setFocusable(false); // tirar caixa pontilhada que ficava em volta da palavra dentro do botão
        painel.add(cadastrarUniversidade);
        cadastrarUniversidade.addActionListener(this);

        // Botão para cadastrar curso
        cadastrarCurso = new JButton("Cadastrar Curso");
        cadastrarCurso.setBounds(300,240,200,50);
        cadastrarCurso.setFocusable(false); // tirar caixa pontilhada que ficava em volta da palavra dentro do botão
        painel.add(cadastrarCurso);
        cadastrarCurso.addActionListener(this);

        // Botão para cadastrar aluno
        cadastrarAluno = new JButton("Cadastrar Aluno");
        cadastrarAluno.setBounds(300,340,200,50);
        cadastrarAluno.setFocusable(false); // tirar caixa pontilhada que ficava em volta da palavra dentro do botão
        painel.add(cadastrarAluno);
        cadastrarAluno.addActionListener(this);

        // Botão para pesquisar candidado
        ImageIcon lupa = new ImageIcon("D:\\trabalhoFinal\\Work-for-me\\src\\Assets\\lupa.png");
        pesquisarCandidato = new JButton("Pesquisar candidato");
        pesquisarCandidato.setIcon(lupa);
        pesquisarCandidato.setIconTextGap(10);
        pesquisarCandidato.setBackground(Color.gray);
        pesquisarCandidato.setBounds(300,440,200,50);
        pesquisarCandidato.setFocusable(false); // tirar caixa pontilhada que ficava em volta da palavra dentro do botão
        painel.add(pesquisarCandidato);
        pesquisarCandidato.addActionListener(this);

        // Footer
        footer = new JLabel();
        footer.setText("Feito por © Pedro Junqueira e Matheus de Moura.");
        footer.setForeground(Color.lightGray); // cor do texto
        footer.setFont(new Font(Font.SERIF,Font.BOLD, 12));
        footer.setVerticalAlignment(JLabel.TOP);
        footer.setHorizontalAlignment(JLabel.CENTER);
        footer.setBounds(257, 540, 280, 16);
        painel.add(footer);

        // Tornando tudo visivel
        this.setVisible(true);
        painel.setVisible(true);
        header.setVisible(true);
        cadastrarUniversidade.setVisible(true);
        cadastrarCurso.setVisible(true);
        cadastrarAluno.setVisible(true);
        pesquisarCandidato.setVisible(true);
        footer.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Objects.equals(e.getSource(),cadastrarUniversidade)){
            CadastroUniversidade uni = new CadastroUniversidade();
            uni.setVisible(true);
            dispose();
        }

        if (Objects.equals(e.getSource(),cadastrarCurso)){
            CadastroCurso cur = new CadastroCurso();
            cur.setVisible(true);
            dispose();
        }

        if (Objects.equals(e.getSource(),cadastrarAluno)){
            CadastroAluno alu = new CadastroAluno();
            alu.setVisible(true);
            dispose();
        }

        if (Objects.equals(e.getSource(),pesquisarCandidato)){
            PesquisaCandidato pes = new PesquisaCandidato();
            pes.setVisible(true);
            dispose();
        }
    }
}