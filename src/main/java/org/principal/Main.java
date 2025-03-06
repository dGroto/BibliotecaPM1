package org.principal;
import system.Biblioteca;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Permite ler dados inseridos pelo usuário através do teclado
        Biblioteca biblioteca = new Biblioteca(); //Criado uma instância de um objeto da Classe chamada "Biblioteca"
        boolean continuar = true; //Variável inicializada com valor booleano para rodar o "while"

        while (continuar) { //Continuará o loop se a variável for true
            System.out.println("\n\t1. Adicionar Livro"
           +  "\n\t2. Cadastrar Leitor"
           + "\n\t3. Registrar Empréstimo"
           + "\n\t4. Listar Empréstimos"
           + "\n\t5. Listar Leitores"
           + "\n\t6. Sair"
           + "\n Escolha uma opção: "); //Imprime no console
            int escolha = sc.nextInt(); //Armazena na variável a opção digitada pelo usuário
            sc.nextLine(); //Lê uma linha de texto inserida pelo usuário e retorna, mesmo tendo espaços

            switch (escolha) { //Executa o bloco de código de acordo com a escolha do usuário
                case 1:
                    biblioteca.addLivro(); //Chama o metodo para adicionar um livro
                    break;
                case 2:
                    biblioteca.cadastrarLeitor(); //Chama o metodo para cadastrar um leitor
                    break;
                case 3:
                    biblioteca.registrarEmprestimo(); //Chama o metodo para registrar um empréstimo de livro
                    break;
                case 4:
                    biblioteca.listarEmprestimos(); //Chama o metodo para mostrar todos os empréstimos registrados
                    break;
                case 5:
                    biblioteca.listarLeitores(); //Chama o metodo para listar todos os leitores cadastrados
                    break;
                case 6:
                    continuar = false; //O loop continua até o usuário escolher a opção 6 para sair, pois a variável é definida como "false"
                    break;
                default:
                    System.out.println("Opção inválida."); //Imprime no console
                    break;
            }
        }
        sc.close(); //Fecha o Scanner após o uso
    }
}