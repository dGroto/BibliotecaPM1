package system; //Pacote criado

public class Livros { //Classe Livros com atributos privados
    private String titulo;
    private String autor;
    private String genero;
    protected String anoPublicacao;
    protected Status status; //Status do livro, se está disponível ou indisponível para empréstimo

    //Construtor da classe Livros, cria um objeto com todas as informações
    public Livros (String titulo, String autor, String genero, String anoPublicacao, Status status) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anoPublicacao = anoPublicacao;
        this.status = status;
    }

    public Livros(){ //Construtor vazio
    }

    //Metodos Getters e Setters
    public String getTitulo(){ //Get para o título do livro
        return titulo;
    }

    public void setTitulo(String titulo){ //Set para atribuir valor
        this.titulo = titulo;
    }

    public String getAutor(){ //Get e Set para o autor do livro
        return autor;
    }
    public void setAutor (String autor){
        this.autor = autor;
    }

    public String getGenero(){ //Get e Set para o gênero do livro
        return genero;
    }
    public void setGenero(String genero){
        this.genero = genero;
    }

    public String getAnoPublicacao(){ //Get e Set para o ano de publicação do livro
        return anoPublicacao;
    }
    public void setAnoPublicacao(String anoPublicacao){
        this.anoPublicacao = anoPublicacao;
    }

    public void setStatus(Status status){ //Get e Set para status do livro
        this.status = status;
    }
    public Status getStatus(){
        return status;
    }

    public void exibirInfos(){ //Metodo para mostrar as informações do livro
        System.out.println("T\n\titulo: " + titulo
                + "\n\tAutor: " + autor
                + "\n\tGênero: " + genero
                + "\n\tAno de Publicação: " + anoPublicacao); //Imprime no console
    }

    public void emprestar(){ //Metodo para emprestar um livro

    }

    public void devolver(){ //Metodo para devolver um livro

    }

    public String toString() { //Metodo toString para retornar informações do livro como uma string formatada
        return "\tTitulo: " + titulo + "\n\tAutor: " + autor + "\n\tGenero: " + genero
                + "\n\tAno de Publicacao: " + anoPublicacao + "\n\t" + status + "\n----------------------------";
    }
}