package FilaBanco;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BancoGUI extends JFrame {

    private final Container container;
    private final int TAMANHO_MAX;
    private Fila_Array filaBanco;

    private JPanel centralPane, eastPane, westPane, pessoasPane, senhasPane, balcaoPane;
    private JButton btnEntrar, btnRemover, btnLerPrimeiro, btnLimparFila;
    private JScrollPane scrollPane;
    private JLabel lblSenhas, lblBalcao;

    private JMenuBar barraMenus;
    private JMenu menu;
    private JMenuItem limpar;

    private Pessoa pessoa;
    private int senhaNormal;

    public BancoGUI(int TAMANHO_MAX) {
        super("Fila do Banco");
        alterarTema();
        this.TAMANHO_MAX = TAMANHO_MAX;
        container = getContentPane();

        inicializarComponentes();
        addComponentes();

        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pessoa = new Pessoa(++senhaNormal, "nome");
                    filaBanco.inserir(pessoa);
                    pessoasPane.add(new PessoaIMG("" + senhaNormal));
                    lblSenhas.setText("S: 0" + senhaNormal);
                    //JOptionPane.showMessageDialog(null, pessoa + " adicionado com sucesso!");
                } catch (Error erro) {
                    JOptionPane.showMessageDialog(null, erro.toString());
                } finally {
                    pessoasPane.updateUI();
                }
            }
        });

        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    filaBanco.remover();
                    pessoasPane.remove(0);

                    pessoa = (Pessoa) filaBanco.obterPrimeiroElemento();
                    lblBalcao.setText("Atendendo > 0" + pessoa.getSenha());
                    //JOptionPane.showMessageDialog(null, pessoa + " removida com sucesso!");
                } catch (Error erro) {
                    JOptionPane.showMessageDialog(null, erro.toString());
                } finally {
                    pessoasPane.updateUI();
                }
            }
        });

        btnLerPrimeiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pessoa = (Pessoa) filaBanco.obterPrimeiroElemento();
                lblBalcao.setText("Atendendo > 0" + pessoa.getSenha());
            }
        });

        limpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filaBanco.limparFila();
                pessoasPane.removeAll();
                pessoasPane.updateUI();
            }
        });

        this.setJMenuBar(barraMenus);
        this.setVisible(true);
        this.setSize(900, 320);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void inicializarComponentes() {
        container.setLayout(new BorderLayout(20, 20));
        eastPane = new JPanel(new GridLayout(3, 1, 5, 5));
        westPane = new JPanel(new GridLayout(4, 1, 5, 5));

        centralPane = new JPanel(new GridLayout(2, 2, 5, 5));

        senhasPane = new JPanel();
        senhasPane.setBackground(Color.BLACK);
        lblSenhas = new JLabel("S: 00");
        lblSenhas.setFont(new Font(null, Font.BOLD, 20));
        lblSenhas.setForeground(Color.GREEN);

        balcaoPane = new JPanel();
        balcaoPane.setBackground(Color.BLACK);
        lblBalcao = new JLabel("Atendendo> 00");
        lblBalcao.setForeground(Color.RED);

        pessoasPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
        scrollPane = new JScrollPane(pessoasPane);

        filaBanco = new Fila_Array(TAMANHO_MAX);
        senhaNormal = 0;

        barraMenus = new JMenuBar();
        menu = new JMenu("Menu");
        limpar = new JMenuItem("Limpar Fila");

        btnEntrar = new JButton("ENTRAR (add)");
        btnRemover = new JButton("ATENDIDO (remover)");
        btnLerPrimeiro = new JButton("ATENDER (primeiro)");
        btnLimparFila = new JButton("ESVAZIAR (limpar fila)");
    }

    private void addComponentes() {
        senhasPane.add(lblSenhas);
        balcaoPane.add(lblBalcao);

        eastPane.add(senhasPane);
        eastPane.add(btnLerPrimeiro);
        eastPane.add(btnEntrar);

        westPane.add(new JLabel(" B A L C A O"));
        westPane.add(balcaoPane);

        westPane.add(btnLerPrimeiro);
        westPane.add(btnRemover);

        menu.add(limpar);
        barraMenus.add(menu);

        container.add(new JLabel(" "), BorderLayout.NORTH);
        container.add(centralPane, BorderLayout.CENTER);
        container.add(eastPane, BorderLayout.EAST);
        container.add(westPane, BorderLayout.WEST);
        container.add(new JLabel(" "), BorderLayout.SOUTH);
        centralPane.add(scrollPane);
    }

    public void alterarTema() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }
    }

    public static void main(String Args[]) {
        new BancoGUI(10);
    }
}
