public class Embarque implements Repositorio, Pessoa {
    private static Pessoa[] repositorio = new Pessoa[10];
    private static int tamanho = 0;
    private static int indiceAtual = 0;
    private String cpf;
    private String nome;
    private boolean primeiraClasse;

    private Embarque(String cpf, String nome, boolean primeiraClasse) {
        this.cpf = cpf;
        this.nome = nome;
        this.primeiraClasse = primeiraClasse;
    }

    public static Embarque criarEmbarque(String cpf, String nome, boolean primeiraClasse) {
        return new Embarque(cpf, nome, primeiraClasse);
    }

    @Override
    public Pessoa[] guarda(Pessoa pessoa) {
        if(tamanho == repositorio.length) {
            Pessoa[] novoRepositorio = new Pessoa[repositorio.length * 2];
            System.arraycopy(repositorio, 0, novoRepositorio, 0, repositorio.length);
            repositorio = novoRepositorio;
        }
        repositorio[tamanho++] = pessoa;
        return repositorio;
    }

    @Override
    public Pessoa recupera() {
        for (Pessoa pessoa : repositorio) {
            if (pessoa != null && pessoa.getCPF().equals(this.cpf)) {
                return pessoa;
            }
        }
        return null;
    }

    @Override
    public Pessoa primeiro() {
        indiceAtual = 0;
        return repositorio.length > 0 ? repositorio[indiceAtual] : null;
    }

    @Override
    public Pessoa proximo() {
        if (indiceAtual + 1 < tamanho) {
            indiceAtual++;
            return repositorio[indiceAtual];
        }
        return null;
    }

    @Override
    public String getCPF() {
        return this.cpf;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public boolean vip() {
        return this.primeiraClasse;
    }

    public static void processaEmbarque(AviaoPremium aviao, Repositorio repositorio) {
        Pessoa passageiro = repositorio.primeiro();
        while (passageiro != null) {
            if (passageiro.vip()) {
                int poltrona = aviao.proximoPremiumLivre();
                if (poltrona != -1) {
                    aviao.ocupa(poltrona);
                }
            } else {
                int poltrona = aviao.proximoLivre();
                if (poltrona != -1) {
                    aviao.ocupa(poltrona);
                }
            }
            passageiro = repositorio.proximo();
        }
    }
}
