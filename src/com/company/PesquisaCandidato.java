package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.TableModel;
import javax.xml.stream.events.EndDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Objects;

public class PesquisaCandidato extends JFrame implements ActionListener {

    protected JPanel painel, painelResultado;
    protected JLabel header, info;
    protected JTextField estado, cidade, cursoArea;
    protected String state, city, carrearArea;
    protected JButton pesquisar, voltar;
    protected JTable tabela;
    protected JScrollPane scroll;

    protected static File bancoDados = new File("src\\banco_dados.txt");

    protected static TableModel model_test;

    static int counter2 = 0;

    Object [][] dados =
    {
            {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
            {"João da Silva", "48 8890-3345", "joaosilva@hotmail.com"},
            {"Pedro Cascades", "48 9870-5634", "pedrinho@gmail.com"}
    };


    PesquisaCandidato() {
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
        header.setText("Pesquisar candidato");
        header.setForeground(Color.lightGray); // cor do texto
        header.setFont(new Font(Font.SERIF, Font.BOLD, 40));
        header.setVerticalAlignment(JLabel.TOP);
        header.setHorizontalAlignment(JLabel.CENTER);
        header.setBounds(0, 0, 800, 600);
        header.setBorder(new EmptyBorder(10, 0, 0, 0)); // adicionando bordas
        painel.add(header);

        // Campo estado
        estado = new JTextField();
        estado.setText("Estado");
        estado.setBounds(300, 100, 200, 30);
        estado.setFont(new Font("Arial", Font.PLAIN, 20));
        estado.setBackground(Color.LIGHT_GRAY); // cor da caixa de texto
        estado.addActionListener(this);
        painel.add(estado);

        // Campo cidade
        cidade = new JTextField();
        cidade.setText("Cidade");
        cidade.setBounds(300, 150, 200, 30);
        cidade.setFont(new Font("Arial", Font.PLAIN, 20));
        cidade.setBackground(Color.LIGHT_GRAY); // cor da caixa de texto
        cidade.addActionListener(this);
        painel.add(cidade);

        // Campo cursoArea
        cursoArea = new JTextField();
        cursoArea.setText("Curso/Area");
        cursoArea.setBounds(300, 200, 200, 30);
        cursoArea.setFont(new Font("Arial", Font.PLAIN, 20));
        cursoArea.setBackground(Color.LIGHT_GRAY); // cor da caixa de texto
        cursoArea.addActionListener(this);
        painel.add(cursoArea);

        // Botão para voltar
        voltar = new JButton("Voltar");
        voltar.setBounds(300, 250, 70, 30);
        voltar.setFocusable(false); // tirar caixa pontilhada que ficava em volta da palavra dentro do botão
        painel.add(voltar);
        voltar.addActionListener(this);

        // Botão para pesquisar
        pesquisar = new JButton("Pesquisar");
        pesquisar.setBounds(400, 250, 100, 30);
        pesquisar.setFocusable(false); // tirar caixa pontilhada que ficava em volta da palavra dentro do botão
        painel.add(pesquisar);
        pesquisar.addActionListener(this);

        // Info da página
        info = new JLabel();
        info.setText("Para excluir ou alterar qualquer informação clique 2x no campo desejado.");
        info.setForeground(Color.lightGray); // cor do texto
        info.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        info.setHorizontalAlignment(JLabel.CENTER);
        info.setBounds(0, 280, 800, 30);
        info.setBorder(new EmptyBorder(10, 0, 0, 0)); // adicionando bordas
        painel.add(info);

        // Tabela
        tabela = new JTable();
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 11));
        tabela.setCellSelectionEnabled(true);
        tabela.setBorder(new LineBorder(Color.black));
        tabela.setGridColor(Color.black);
        tabela.setShowGrid(true);

        painelResultado = new JPanel();
        painelResultado.setBackground(new Color(18, 18, 18));
        painelResultado.setBounds(0, 310, 800, 280);
        painelResultado.setLayout(null);
        painel.add(painelResultado);

        //Scroll
        scroll = new JScrollPane();
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(43, 0, 700, 250);
        painelResultado.add(scroll);
        scroll.setViewportView(tabela);

        // Tornando tudo visível
        this.setVisible(true);
        painel.setVisible(true);
        header.setVisible(true);
        estado.setVisible(true);
        cidade.setVisible(true);
        cursoArea.setVisible(true);
        pesquisar.setVisible(true);
        voltar.setVisible(true);
        info.setVisible(true);
        tabela.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Objects.equals(e.getSource(), voltar)) {
            TelaInicial.boundx = this.getX();
            TelaInicial.boundy = this.getY();
            TelaInicial ini = new TelaInicial();
            ini.setVisible(true);
            dispose();
        }

        if (Objects.equals(e.getSource(), pesquisar)) {
            TelaInicial.boundx = this.getX();
            TelaInicial.boundy = this.getY();
            state = estado.getText();
            city = cidade.getText();
            carrearArea = cursoArea.getText();

            // Criando arquivo para armazenar os dados

            try
            {
                if (bancoDados.createNewFile())
                {
                    System.out.println("Arquivo criado: " + bancoDados.getName());
                }
                else
                {
                    System.out.println("Arquivo ja existe.");
                }
            }
            catch (IOException ev)
            {
                System.out.println("Um erro ocorreu.");
                ev.printStackTrace();
            }

            // Escrevendo os dados das universidades.

            try
            {
                OutputStream os = new FileOutputStream(bancoDados);
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);

                for (int i = 0; i < CadastroCurso.aumentarNumCursos + 1; i++)
                {
                    bw.write(CadastroCurso.CursosArray.get(i).universidade.getEstado() + "," +
                            CadastroCurso.CursosArray.get(i).universidade.getCidade() + "," +
                            CadastroCurso.CursosArray.get(i).getNome() + "#" + "\n");

                    bw.write(CadastroCurso.CursosArray.get(i).universidade.getEstado() + "," +
                            CadastroCurso.CursosArray.get(i).universidade.getCidade() + "," +
                            CadastroCurso.CursosArray.get(i).getArea() + "#" + "\n");
                }

                bw.close();

                counter2++;

                System.out.println("Arquivo escrito com sucesso.");
            }
            catch (IOException ev)
            {
                System.out.println("Um erro ocorreu.");
                ev.printStackTrace();
            }

            //Criando um reader e evitando problemas adversos.

            BufferedReader reader = null;
            try
            {
                reader = new BufferedReader(new FileReader(bancoDados));
            }
            catch (FileNotFoundException ex)
            {
                ex.printStackTrace();
            }

            //Mecanismo de pesquisa através de um .txt criado

            try {
                assert reader != null;
                String[] currentLine = new String[100];

                int counter = 0;

                System.out.println(bancoDados.length());

                for (counter = 0; counter < counter2; counter++)
                {
                    currentLine[counter] = reader.readLine();
                }

                for (int i = 0; i < counter; i++)
                {
                    if (currentLine[i].equals(estado.getText() + "," + cidade.getText() + "," + cursoArea.getText() + "#"))
                    {
                        System.out.println("oi");


                        //model_test.
                    }
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }

            try {
                reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }
}
