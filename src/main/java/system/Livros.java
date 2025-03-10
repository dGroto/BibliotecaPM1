package system;

public class Livros {

    private String titulo;
    private String autor;
    private String genero;
    protected String anoPublicacao;
    protected Status status;

    //CONSTRUTOR
    public Livros (String titulo, String autor, String genero, String anoPublicacao, Status status) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anoPublicacao = anoPublicacao;
        this.status = status;
    }

    public Livros(){
    }

    //GET E SET

    //TITULO
    //GETTERS RETORNAM INFORMAÇOES
    public String getTitulo(){
        return titulo;
    }
    //SETTERS ATRIBUEM
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    //AUTOR
    public String getAutor(){
        return autor;
    }
    public void setAutor (String autor){
        this.autor = autor;
    }

    //GENERO
    public String getGenero(){
        return genero;
    }
    public void setGenero(String genero){
        this.genero = genero;
    }

    //ANO DE  PUBLICAÇÃO
    public String getAnoPublicacao(){
        return anoPublicacao;
    }
    public void setAnoPublicacao(String anoPublicacao){
        this.anoPublicacao = anoPublicacao;
    }

    //STATUS
    public void setStatus(Status status){
        this.status = status;
    }
    public Status getStatus(){
        return status;
    }

    //  METODOS/FUNÇÕES
    public void exibirInfos(){
        System.out.println("T\n\titulo: " + titulo
                            + "\n\tAutor: " + autor
                            + "\n\tGênero: " + genero
                            + "\n\tAno de Publicação: " + anoPublicacao);
    }


    public void emprestar(){

    }

    public void devolver(){

    }

    public String toString() {
        return "\tTitulo: " + titulo + "\n\tAutor: " + autor + "\n\tGenero: " + genero
        + "\n\tAno de Publicacao: " + anoPublicacao + "\n\t" + status + "\n----------------------------";
    }


}
