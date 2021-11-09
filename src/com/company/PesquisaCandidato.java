package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.stream.events.EndDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

public class PesquisaCandidato extends JFrame implements ActionListener {

    protected JPanel painel, painelResultado;
    protected JLabel header, info;
    protected JTextField estado, cidade, cursoArea;
    protected String state, city, carrearArea;
    protected JButton pesquisar, voltar;
    protected JTable tabela;
    protected JScrollPane scroll;
    protected static DefaultTableModel model;
    // static int counter2 = 0;

    protected static boolean jaLeu = false;

    int counter3 = 0;
    int counterErros = 0;
    int counterAlunos = 0;

    protected static File bancoDados = new File("src\\banco_dados.txt");

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
        model = new DefaultTableModel();
        Object[] coluna = { "Nome", "Matricula", "Data de Nascimento", "Ano de ingresso", "Situação", "Universidade",
                "Curso" };
        // Object[] fileira = new Object[0];
        model.setColumnIdentifiers(coluna);
        tabela.setModel(model);
        // tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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

        // Scroll
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


            try {
                boolean pedro;

                if (!bancoDados.exists()) {
                    pedro = bancoDados.createNewFile();
                    System.out.println("Arquivo criado: " + bancoDados.getName());
                } else {
                    System.out.println("Arquivo ja existe.");
                }
            } catch (IOException ev) {
                System.out.println("Um erro ocorreu.");
                ev.printStackTrace();
            }

            // Escrevendo os dados das universidades.

            try {
               // OutputStream os = new FileOutputStream(bancoDados);
               // OutputStreamWriter osw = new OutputStreamWriter(os);
                //BufferedWriter bw = new BufferedWriter(osw);

                Path p = Paths.get("src\\banco_dados.txt");
                String s = System.lineSeparator();

                BufferedWriter writer = Files.newBufferedWriter(p, StandardOpenOption.APPEND);

                //Writer output;
                //output = new BufferedWriter(new FileWriter(bancoDados, true));

                for (int i = 0; i < CadastroAluno.AlunosArr.size(); i++) {

                    writer.write(CadastroAluno.AlunosArr.get(i).universidadeDoAluno.getEstado() + ","
                                   + CadastroAluno.AlunosArr.get(i).universidadeDoAluno.getCidade() + ","
                                   + CadastroAluno.AlunosArr.get(i).cursoDoAluno.getNome() + "#" + "\n"
                                   + CadastroAluno.AlunosArr.get(i).universidadeDoAluno.getEstado() + ","
                                   + CadastroAluno.AlunosArr.get(i).universidadeDoAluno.getCidade() + ","
                                   + CadastroAluno.AlunosArr.get(i).cursoDoAluno.getArea() + "#" + "\n");

                    //output.write(CadastroAluno.AlunosArr.get(i).universidadeDoAluno.getEstado() + ","
                    //        + CadastroAluno.AlunosArr.get(i).universidadeDoAluno.getCidade() + ","
                     //       + CadastroAluno.AlunosArr.get(i).cursoDoAluno.getNome() + "#" + "\n");

                    //output.write(CadastroAluno.AlunosArr.get(i).universidadeDoAluno.getEstado() + ","
                    //        + CadastroAluno.AlunosArr.get(i).universidadeDoAluno.getCidade() + ","
                     //       + CadastroAluno.AlunosArr.get(i).cursoDoAluno.getArea() + "#" + "\n");
                }

                writer.close();

                System.out.println("Arquivo escrito com sucesso.");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            // Criando um reader e evitando problemas adversos.

            BufferedReader reader = null;

            try {
                reader = new BufferedReader(new FileReader(bancoDados));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

            // Mecanismo de pesquisa através de um .txt criado

            try {
                assert reader != null;
                String[] currentLine = new String[100];

                int counter = 0;

                // System.out.println(bancoDados.length());

                for (counter = 0; counter < CadastroAluno.counterNumLinhas; counter++) {

                    currentLine[counter] = reader.readLine();

                    if (currentLine[counter] == null) {
                        JOptionPane.showMessageDialog(null, "Não há dado para se pesquisar.");
                        break;
                    }
                }

                final Object[] fileira = new Object[7];

                System.out.println(CadastroAluno.counterNumLinhas);

                counterErros = 0;

                model.setRowCount(0);

                for (int i = 0; i < CadastroAluno.counterNumLinhas; i++) {
                    // if(currentLine[counter] == null)
                    // break;

                    System.out.println(currentLine[i]);
                    System.out.println(CadastroAluno.counterNumLinhas);

                    if (currentLine[i].equals(estado.getText() + "," + cidade.getText() + "," + cursoArea.getText() + "#")) {
                        System.out.println("oi");

                        // Object[] coluna = { "Nome", "Matricula", "Data de Nascimento", "Ano de
                        // ingresso", "Situação", "Universidade",
                        // "Curso" };

                        fileira[0] = (CadastroAluno.AlunosArr.get(i / 2).getNome());
                        fileira[1] = (CadastroAluno.AlunosArr.get(i / 2).getMatricula());
                        fileira[2] = (CadastroAluno.AlunosArr.get(i / 2).getDataNascimento());
                        fileira[3] = (CadastroAluno.AlunosArr.get(i / 2).getAnoIngresso());
                        fileira[4] = (CadastroAluno.AlunosArr.get(i / 2).getSituacao());
                        fileira[5] = (CadastroAluno.AlunosArr.get(i / 2).universidadeDoAluno.getNome());
                        fileira[6] = (CadastroAluno.AlunosArr.get(i / 2).cursoDoAluno.getNome());

                        model.addRow(fileira);
                        counter3++;

                    } else {
                        counterErros++;
                    }
                }

                if (counterErros == CadastroAluno.counterNumLinhas)
                {
                    JOptionPane.showMessageDialog(null, "Nenhum aluno encontrado com esses dados.");
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
