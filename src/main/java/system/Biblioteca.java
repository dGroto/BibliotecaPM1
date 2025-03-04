package system;
import java.util.Scanner;

public class Biblioteca extends Livros{

    Scanner sc = new Scanner(System.in);
    Livros cadLivros = new Livros();

    public void addLivro(){

        System.out.println("\n\tNome: ");
        sc.nextLine();
        // FAZER UMA VERIFICAÇÃO PRA SABER SE JA TEM UM LIVRO EXISTENTE
        cadLivros.setTitulo(sc.nextLine());
        System.out.println("\n\tAutor: ");
        sc.nextLine();
        cadLivros.setAutor(sc.nextLine());
        System.out.println("\n\tGenero: ");
        sc.nextLine();
        cadLivros.setGenero(sc.nextLine());
        System.out.println("\n\tAno de publicação: ");
        sc.nextLine();
        cadLivros.setAnoPublicacao(sc.nextLine());
        cadLivros.setDisponivel(true);

    }

}
