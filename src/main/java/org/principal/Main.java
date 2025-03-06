package org.principal;
import system.Biblioteca;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n\t1. Adicionar Livro"
           +  "\n\t2. Cadastrar Leitor"
           + "\n\t3. Registrar Empréstimo"
           + "\n\t4. Listar Empréstimos"
           + "\n\t5. Listar Leitores"
           + "\n\t6. Sair"
           + "\n Escolha uma opção: ");
            int escolha = sc.nextInt();
            sc.nextLine(); //Consumir a linha em branco após o número

            switch (escolha) {
                case 1:
                    biblioteca.addLivro();
                    break;
                case 2:
                    biblioteca.cadastrarLeitor();
                    break;
                case 3:
                    biblioteca.registrarEmprestimo();
                    break;
                case 4:
                    biblioteca.listarEmprestimos();
                    break;
                case 5:
                    biblioteca.listarLeitores();
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        sc.close();
    }
}