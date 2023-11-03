package LembretesApp;

import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.DefaultListModel;

public class GUI_ExibirAnotacao extends JFrame {

    private AnotacoesApp bloco;
    private Anotacao anotacaoAtual;
    private JList<String> listaAnotacoes;
    private DefaultListModel<String> modeloLista;

    public GUI_ExibirAnotacao(AnotacoesApp bloco, Anotacao anotacaoAtual, JList<String> listaAnotacoes, DefaultListModel<String> modeloLista) {
        this.bloco = bloco;
        this.anotacaoAtual = anotacaoAtual;
        this.listaAnotacoes = listaAnotacoes;
        this.modeloLista = modeloLista;

        setTitle("Exibir Anotação");
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
        campoTitulo.setText(anotacaoAtual.getTitulo());
        panel.add(campoTitulo);

        JLabel labelDescricao = new JLabel("Descrição:");
        labelDescricao.setBounds(10, 50, 80, 25);
        panel.add(labelDescricao);

        JTextField campoDescricao = new JTextField(20);
        campoDescricao.setBounds(100, 50, 165, 25);
        campoDescricao.setText(anotacaoAtual.getDescricao());
        panel.add(campoDescricao);

        JLabel labelData = new JLabel("Data:");
        labelData.setBounds(10, 80, 80, 25);
        panel.add(labelData);

        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        JLabel campoData = new JLabel(formatoData.format(anotacaoAtual.getData().getTime()));
        campoData.setBounds(100, 80, 165, 25);
        panel.add(campoData);

        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.setBounds(10, 130, 80, 25);
        botaoSalvar.addActionListener((ActionEvent e) -> {
            String novoTitulo = campoTitulo.getText();
            String novaDescricao = campoDescricao.getText();
            Anotacao anotacaoNova = new Anotacao(anotacaoAtual.getData(), novoTitulo, novaDescricao);
            bloco.editarAnotacao(anotacaoAtual, anotacaoNova);
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

        JButton botaoExcluir = new JButton("Excluir");
        botaoExcluir.setBounds(95, 130, 80, 25);
        botaoExcluir.addActionListener((ActionEvent e) -> {
            bloco.removerAnotacao(anotacaoAtual);
            atualizarListaAnotacoes(bloco.listarAnotacoes());
            dispose();
        });
        panel.add(botaoExcluir);

    }

    private void atualizarListaAnotacoes(List<Anotacao> anotacoes) {
        modeloLista.clear();
        for (Anotacao anotacao : anotacoes) {
            modeloLista.addElement(anotacao.getTitulo());
        }
    }

}
