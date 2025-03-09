package org.principal;
import system.Biblioteca;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        boolean continuar = true;
        int opcao;

        // POLYANA

        while (continuar) {
            System.out.println("\n\t1. Cadastros"
           + "\n\t2. Registrar Empréstimo"
           + "\n\t3. Listas"
           + "\n\t4. Sair"
           + "\n Escolha uma opção: ");
            int escolha = sc.nextInt();
            sc.nextLine(); //Consumir a linha em branco após o número

            switch (escolha) {
                case 1:
                    System.out.println("\t1. Cadastrar Leitores"
                                    + "\n\t2. Adicionar Livros"
                         + "\n Escolha uma opção: ");
                    opcao = sc.nextInt();
                    sc.nextLine(); //Consumir a linha em branco após o número
                    if(opcao == 1) {
                        biblioteca.cadastrarLeitor();
                    }
                    else if(opcao == 2) {
                        biblioteca.addLivro();
                    }else
                        System.out.println("\tOpcao invalida!");
                    break;
                case 2:
                    biblioteca.registrarEmprestimo();
                    break;
                case 3:
                    System.out.println("\t1. Listar Leitores"
                            +  "\n\t2. Listar Livro"
                            + "\n\t3. Listar Emprestimos"
                            + "\n Escolha uma opção: ");
                    opcao = sc.nextInt();
                    sc.nextLine(); //Consumir a linha em branco após o número
                    if(opcao == 1) {
                        biblioteca.listarLeitores();
                    } else if(opcao == 2) {
                        biblioteca.listarLivros();
                    } else if (opcao == 3) {
                        biblioteca.listarEmprestimos();
                    } else
                        System.out.println("\tOpcao invalida!");
                    break;
                    case 4:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        sc.close();
    }
}