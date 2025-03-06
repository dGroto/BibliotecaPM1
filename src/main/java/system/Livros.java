package system;

public class Livros {

    private String titulo;
    private String autor;
    private String genero;
    private String anoPublicacao;
    private boolean disponivel;

    //CONSTRUTOR
    public Livros (String titulo, String autor, String genero, String anoPublicacao, boolean disponivel) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anoPublicacao = anoPublicacao;
        this.disponivel = disponivel;
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

    //DISPONIVEL
    public boolean getDisponivel(){
        return disponivel;
    }
    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }

    //  METODOS/FUNÇÕES
    public void exibirInfos(){
        System.out.println("T\n\titulo: " + titulo
                            + "\n\tAutor: " + autor
                            + "\n\tGênero: " + genero
                            + "\n\tAno de Publicação: " + anoPublicacao
                            + "\n\tDisponivel : " + disponivel);
    }


    public void emprestar(){

    }

    public void devolver(){

    }

    @Override
    public String toString() {
        return "\tTitulo: " + titulo + "\n\tAutor: " + autor + "\n\tGenero: " + genero
        + "\n\tAno de Publicacao: " + anoPublicacao + "\n\tDisponivel: " + disponivel + "\n----------------------------";
    }


}
