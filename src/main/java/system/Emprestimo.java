package system;

import java.time.LocalDate;

public class Emprestimo extends Livros {

    private Leitor leitor;
    private Livros livro;
    protected Status status;
    private LocalDate dataEmprestimo; //Nova variável para ser a data de empréstimo

    // CONSTRUTOR
    public Emprestimo(Leitor leitor, Livros livro, Status status, LocalDate dataEmprestimo) {
        this.leitor = leitor;
        this.livro = livro;
        this.status = status;
        this.dataEmprestimo = dataEmprestimo;
    }

    // METODOS
    public void registrarEmprestimo() {


        if (livro.getStatus() == Status.DISPONIVEL) {
            livro.setStatus(Status.INDISPONIVEL); //Marcar o livro como emprestado
            System.out.println("Emprestimo registrado com sucesso!");
        } else {
            System.out.println("O livro não está disponível.");
        }
    }

    public void registrarDevolucao() {
        livro.setStatus(Status.DISPONIVEL); //Marcar o livro como devolvido
        System.out.println("Devolução registrada com sucesso!");
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

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
    }
}