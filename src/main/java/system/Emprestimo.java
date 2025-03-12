package system; //Pacote criado

public class Emprestimo extends Livros { //Classe Emprestimo herda da Classe Livros

   //ATRIBUSTOS
    private Leitor leitor;
    private Livros livro;
    protected Status status;

    //Construtor que inicializa os atributos da Classe Emprestimo
    public Emprestimo(Leitor leitor, Livros livro, Status status) {
        this.leitor = leitor;
        this.livro = livro;
        this.status = status;
    }

    public void registrarEmprestimo() { //Metodo que registra o empréstimo do livro
        if(livro.getStatus() == Status.DISPONIVEL) { //Verifica se o livro está disponível para empréstimo
            livro.setStatus(Status.INDISPONIVEL); //Marcar o livro como emprestado
            System.out.println("Emprestimo registrado com sucesso!"); //Imprime no console
        }else{ //Caso o livro não esteja disponível, mostra a mensagem de erro no console
            System.out.println("O livro não está disponível.");
        }
    }

    public void registrarDevolucao() { //Metodo que registra a devolução do livro
        livro.setStatus(Status.DISPONIVEL); //Marcar o livro como devolvido
        System.out.println("Devolução registrada com sucesso!"); //Imprime no console
    }

    public Leitor getLeitor() { //Getter para o leitor que realizou o empréstimo
        return leitor;
    }

    public void setLeitor(Leitor leitor) { //Setter para o leitor que realizou o empréstimo
        this.leitor = leitor;
    }

    public Livros getLivro() { //Getter para o livro que foi emprestado
        return livro;
    }

    public void setLivro(Livros livro) { //Setter para o livro que foi emprestado
        this.livro = livro;
    }

    @Override
    public Status getStatus() { //Getter para o status do empréstimo
        return status;
    }

    @Override
    public void setStatus(Status status) { //Setter para o status do empréstimo
        this.status = status;
    }
}