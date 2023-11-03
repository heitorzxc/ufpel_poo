package LembretesApp;

import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultListModel;

public class GUI_AdicionarAnotacao extends JFrame {

    private AnotacoesApp bloco;
    private JList<String> listaAnotacoes;
    private DefaultListModel<String> modeloLista;

    public GUI_AdicionarAnotacao(AnotacoesApp bloco, JList<String> listaAnotacoes, DefaultListModel<String> modeloLista) {
        this.bloco = bloco;
        this.listaAnotacoes = listaAnotacoes;
        this.modeloLista = modeloLista;

        setTitle("Adicionar Anotação");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        colocarComponentesNoPainel(panel);
    }

    private void colocarComponentesNoPainel(JPanel panel) {
        panel.setLayout(null);

        JLabel labelTitulo = new JLabel("Título:");
        labelTitulo.setBounds(10, 20, 80, 25);
        panel.add(labelTitulo);

        JTextField campoTitulo = new JTextField(20);
        campoTitulo.setBounds(100, 20, 165, 25);
        panel.add(campoTitulo);

        JLabel labelDescricao = new JLabel("Descrição:");
        labelDescricao.setBounds(10, 50, 80, 25);
        panel.add(labelDescricao);

        JTextField campoDescricao = new JTextField(20);
        campoDescricao.setBounds(100, 50, 165, 25);
        panel.add(campoDescricao);

        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.setBounds(10, 130, 80, 25);
        botaoSalvar.addActionListener((ActionEvent e) -> {
            String titulo = campoTitulo.getText();
            String descricao = campoDescricao.getText();
            Calendar data = Calendar.getInstance();
            bloco.adicionarAnotacao(new Anotacao(data, titulo, descricao));
            atualizarListaAnotacoes(bloco.listarAnotacoes());
            dispose();
        });
        panel.add(botaoSalvar);

        JButton botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setBounds(180, 130, 100, 25);
        botaoCancelar.addActionListener((ActionEvent e) -> {
            dispose();
        });
        panel.add(botaoCancelar);
    }

    private void atualizarListaAnotacoes(List<Anotacao> anotacoes) {
        modeloLista.clear();
        for (Anotacao anotacao : anotacoes) {
            modeloLista.addElement(anotacao.getTitulo());
        }
    }
}
