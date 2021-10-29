package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class PesquisaCandidato extends JFrame implements ActionListener {

    protected JPanel painel;
    protected JLabel header, info;
    protected JTextField estado, cidade, cursoArea;
    protected String state, city, carrearArea;
    protected JButton cadastrar, voltar;
    protected JTable tabela;

    PesquisaCandidato() {
        // Criando objeto imagem
        ImageIcon icone = new ImageIcon("D:\\trabalhoFinal\\Work-for-me\\src\\Assets\\logo.png");
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

        // Botão para cadastrar
        cadastrar = new JButton("Cadastrar");
        cadastrar.setBounds(400, 250, 100, 30);
        cadastrar.setFocusable(false); // tirar caixa pontilhada que ficava em volta da palavra dentro do botão
        painel.add(cadastrar);
        cadastrar.addActionListener(this);

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
        JPanel panelResultado = new JPanel();
        panelResultado.setBackground(Color.DARK_GRAY);
        panelResultado.setBounds(190, 221, 594, 239);
        painel.add(panelResultado);

        JScrollPane scroll = new JScrollPane();
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(10, 11, 574, 217);
        panelResultado.add(scroll);
        scroll.setViewportView(tabela);

        // Tornando tudo visivel
        this.setVisible(true);
        painel.setVisible(true);
        header.setVisible(true);
        estado.setVisible(true);
        cidade.setVisible(true);
        cursoArea.setVisible(true);
        cadastrar.setVisible(true);
        voltar.setVisible(true);
        tabela.setVisible(true);
        info.setVisible(true);
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

        if (Objects.equals(e.getSource(), cadastrar)) {
            TelaInicial.boundx = this.getX();
            TelaInicial.boundy = this.getY();
            state = estado.getText();
            city = cidade.getText();
            carrearArea = cursoArea.getText();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
        }
    }
}
