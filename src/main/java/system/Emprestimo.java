package system;

public class Emprestimo {
    private String dataEmprestimo;
    private String dataDevolucao;
    private Leitor leitor;
    private Livros livro;

    // POLYANA

    // CONSTRUTOR
    public Emprestimo(String dataEmprestimo, Leitor leitor, Livros livro) {
        this.dataEmprestimo = dataEmprestimo;
        this.leitor = leitor;
        this.livro = livro;
    }

    // METODOS
    public void registrarEmprestimo() {


        if (livro.getDisponivel()) {
            livro.setDisponivel(false); //Marcar o livro como emprestado
            System.out.println("Emprestimo registrado com sucesso!");
        } else {
            System.out.println("O livro não está disponível.");
        }
    }

    public void registrarDevolucao() {
        livro.setDisponivel(true); //Marcar o livro como devolvido
        System.out.println("Devolução registrada com sucesso!");
    }

    // GETTERS E SETTERS
    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    public Livros getLivro() {
        return livro;
    }

    public void setLivro(Livros livro) {
        this.livro = livro;
    }


}