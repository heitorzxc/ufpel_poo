package LembretesApp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.List;

public class GUI_Menu extends JFrame {

    private AnotacoesApp blocoNotas;
    private JTable tabelaAnotacoes;
    private JButton btnNovaAnotacao;
    private JButton btnOrdenarPorData;
    private JButton btnOrdenarPorTitulo;
    private DefaultListModel<String> modeloLista;
    private JList<String> listaAnotacoes;

    public GUI_Menu() {

        blocoNotas = new AnotacoesApp();
        setTitle("Aplicativo de Anotações");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);

    }

    private void initComponents() {
        // Inicializa os componentes
        tabelaAnotacoes = new JTable();
        btnNovaAnotacao = new JButton("Nova Anotação");
        btnOrdenarPorData = new JButton("Ordenar por Data");
        btnOrdenarPorTitulo = new JButton("Ordenar por Título");
        modeloLista = new DefaultListModel<>();
        listaAnotacoes = new JList<>(modeloLista);

        // Usando o JPanel
        setLayout(new BorderLayout());
        add(new JScrollPane(tabelaAnotacoes), BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnNovaAnotacao);
        painelBotoes.add(btnOrdenarPorData);
        painelBotoes.add(btnOrdenarPorTitulo);

        add(painelBotoes, BorderLayout.SOUTH);

        // Eventos para cada botão
        btnNovaAnotacao.addActionListener((ActionEvent e) -> {
            abrirAdicionarAnotacao();
        });

        btnOrdenarPorData.addActionListener((ActionEvent e) -> {
            ordenarAnotacoesPorData();
        });

        btnOrdenarPorTitulo.addActionListener((ActionEvent e) -> {
            ordenarAnotacoesPorTitulo();
        });

        // Aqui to usando um contador pra que se for clicado 2x eu abro a anotação
        tabelaAnotacoes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    abrirExibirAnotacao();
                }
            }
        });

        // Carrega a lista inicial de anotações
        atualizarListaAnotacoes(blocoNotas.listarAnotacoes());
    }

    private void abrirAdicionarAnotacao() {
        this.setVisible(false);
        GUI_AdicionarAnotacao adicionarAnotacao = new GUI_AdicionarAnotacao(blocoNotas, listaAnotacoes, modeloLista);
        adicionarAnotacao.setVisible(true);
        adicionarAnotacao.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                GUI_Menu.this.setVisible(true);
                atualizarListaAnotacoes();
            }
        });
    }

    private void ordenarAnotacoesPorData() {
        // Atualizo por data usando a lógica do console
        List<Anotacao> anotacoesOrdenadas = blocoNotas.ordenarPorData();
        atualizarListaAnotacoes(anotacoesOrdenadas);
    }

    private void ordenarAnotacoesPorTitulo() {
        // Atualizo por título usando a lógica do console
        List<Anotacao> anotacoesOrdenadas = blocoNotas.ordenarPorTitulo();
        atualizarListaAnotacoes(anotacoesOrdenadas);
    }

    private void abrirExibirAnotacao() {
        // Aqui eu tenho que transportar pro novo JPanel a anotação quando clico 2x
        int linhaSelecionada = tabelaAnotacoes.getSelectedRow();
        if (linhaSelecionada >= 0) {
            this.setVisible(false);
            Anotacao anotacaoAtual = blocoNotas.listarAnotacoes().get(linhaSelecionada);
            // Chamo GUI_ExibirAnotacao com a anotação
            GUI_ExibirAnotacao exibirAnotacao = new GUI_ExibirAnotacao(blocoNotas, anotacaoAtual, listaAnotacoes, modeloLista);
            exibirAnotacao.setVisible(true);
            exibirAnotacao.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    GUI_Menu.this.setVisible(true);
                    atualizarListaAnotacoes();
                }
            });
        }
    }

    private void atualizarListaAnotacoes() {
        atualizarListaAnotacoes(blocoNotas.listarAnotacoes());
    }

    private void atualizarListaAnotacoes(List<Anotacao> anotacoes) {
        // Aqui eu tenho que fazer na mão obter o get de cada um
        // Pra isso eu tenho que converter a variável do tipo Calendar pra dia, mês, ano usando variáveis
        // E faço um laço pra preencher o painel com os títulos e as datas obtidas pelos gets
        // Reaproveito pedaço da lógica do console também!
        String[][] data = new String[anotacoes.size()][2];
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < anotacoes.size(); i++) {
            Anotacao anotacao = anotacoes.get(i);
            data[i][0] = anotacao.getTitulo();
            data[i][1] = dateFormat.format(anotacao.getData().getTime());
        }
        // Atualiza a tabela com os novos dados
        tabelaAnotacoes.setModel(new DefaultTableModel(data, new String[]{"Título", "Data"}) {
            @Override
            // Aqui se não tornar falso a edição do JTable não consigo clicar 2x pra gerar a janela de edição
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
    }

    public static void main(String[] args) {
        // Aqui fica o main caso eu queira executar por interface gráfica
        GUI_Menu janela = new GUI_Menu();
    }
}
