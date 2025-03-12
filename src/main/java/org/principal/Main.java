package org.principal; //Pacote criado
import system.Biblioteca; //Importa a classe Biblioteca do pacote ''system''
import java.util.Scanner; //Importa a classe Scanner para ler entradas do usuário através do teclado

public class Main { //Código principal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Cria um espaço para ler entrada do usuário
        Biblioteca biblioteca = new Biblioteca(); //Cria um objeto da classe Biblioteca
        boolean continuar = true; //Variável para o loop principal
        int opcao; //Variável declarada para armazenar a opção escolhida pelo usuário


        while (continuar) { //Loop principal que continua até o usuário escolher a opção de sair
            System.out.println("\n\n----------------------------" + "\n\tMenu Principal"
                    + "\n\t1. Cadastros"
                    + "\n\t2. Empréstimo/Devolução"
                    + "\n\t3. Listas"
                    + "\n\t4. Sair "
                    + "\n Escolha uma opção: "); //Imprime no console o menu de opções
            int escolha = sc.nextInt(); //Lê a opção escolhida pelo usuário
            sc.nextLine(); //Limpa a linha restante no buffer de entrada após o usuário utilizar

            switch (escolha) { //Estrutura de controle para as diferentes opções escolhidas
                case 1:
                    System.out.println("-------------------------------------" +"\n\t Menu de Cadastro: "
                            + "\n\t1. Cadastrar Leitores"
                            + "\n\t2. Adicionar Livros"
                            + "\n\t3. Retornar ao menu principal"
                            + "\n Escolha uma opção: "); //Imprime no console
                    opcao = sc.nextInt(); //Lê a opção escolhida pelo usuario
                    sc.nextLine(); //Limpa a linha restante no buffer de entrada após o usuário utilizar
                    if(opcao == 1) {
                        biblioteca.cadastrarLeitor(); //Chama o metodo para cadastrar leitores
                    }
                    else if(opcao == 2) {
                        biblioteca.addLivro(); //Chama o metodo para adicionar livros à biblioteca
                    }else if(opcao == 3) {
                    }
                    else
                        System.out.println("\tOpcao invalida!"); //Imprime no console
                    break;
                case 2:
                    System.out.println("-------------------------------------" + "\n\tMenu de Registro e Emprestimo: "
                            + "\n\t1. Registrar Emprestimo"
                            + "\n\t2. Devolver Emprestimo"
                            + "\n\t3. Retornar ao menu principal"
                            + "\n Escolha uma opção: ");
                    opcao = sc.nextInt();
                    sc.nextLine();
                    if(opcao == 1) {
                        biblioteca.registrarEmprestimo(); //Chama o metodo que registra os empréstimos de um livro
                    } else if (opcao == 2) {
                        biblioteca.devolverEmprestimo();
                    }else if(opcao == 3) {

                    }
                    else{
                        System.out.println("Opcao invalida!");
                    }
                    break;
                case 3:
                    System.out.println("-------------------------------------" +"\n\tMenu de listas: "
                            + "\n\t1. Listar Leitores"
                            +  "\n\t2. Listar Livro"
                            + "\n\t3. Listar Emprestimos"
                            + "\n\t4. Retornar ao menu principal"
                            + "\n Escolha uma opção: "); //Imprime no consol
                    opcao = sc.nextInt(); //Lê a opção escolhida pelo usuario// e
                    sc.nextLine(); //Limpa a linha restante no buffer de entrada após o usuário utilizar
                    if(opcao == 1) {
                        biblioteca.listarLeitores(); //Chama o metodo para listar os leitores cadastrados
                    } else if(opcao == 2) {
                        biblioteca.listarLivros(); //Chama o metodo para listar os livros cadastrados
                    } else if (opcao == 3) {
                        biblioteca.listarEmprestimos(); //Chama o metodo para listar os empréstimos feitos
                    } else if(opcao == 4) {

                    }else
                        System.out.println("\tOpcao invalida!"); //Imprime no console
                    break;
                case 4:
                    continuar = false; //Modifica a variável "continuar" para "false", saindo do loop
                    break;
                default:
                    System.out.println("Opção inválida."); //Imprime no console
            }
        }
        sc.close(); //Fecha a entrada de leitura através do teclado
    }
}