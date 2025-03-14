package system; //Pacote criado
import java.util.Scanner; //Classe Scanner importada para ler entradas do usuario
import java.util.List; //Interface List importada para usar listas
import java.util.ArrayList; //Classe importada para usar arrays dinâmicos

public class Biblioteca  extends Livros implements IBiblioteca{ //Classe Biblioteca (pública)

    Scanner sc = new Scanner(System.in); //Lê entradas do usuario através do teclado
    List<Livros> listaLivros = new ArrayList<>(); //Lista criada para armazenar objetos da classe Livros
    List<Leitor> listaLeitores = new ArrayList<>(); //Lista criada para armazenar objetos da classe Leitor
    List<Emprestimo> livrosEmprestados = new ArrayList<>(); //Lista criada para armazenar objetos da classe Emprestimo

    public void addLivro() { //Metodo para adicionar livros à biblioteca
        Livros novoLivro = new Livros(); //Novo objeto da classe Livros
        boolean controle = false; //Variável para controle do loop que continua até que o livro seja adicionado corretamente

        while(!controle) { //Enquanto a variável for falsa, o loop continua pedindo informações do livro
            System.out.print("Nome: "); //Imprime no console
            novoLivro.setTitulo(sc.nextLine()); //Armazena o nome do livro

            System.out.print("Autor: "); //Imprime no console
            novoLivro.setAutor(sc.nextLine()); //Armazena o valor digitado pelo usuario no atributo
            if(novoLivro.getAutor().matches("[a-zA-Z\\s]+")) {

                System.out.print("Gênero: "); //Imprime no console
                novoLivro.setGenero(sc.nextLine()); //Lê o gênero do livro e armazena no atributo
                if(novoLivro.getGenero().matches("[a-zA-Z\\s]+")) {

                    System.out.print("Ano de publicação: "); //Imprime no console
                    novoLivro.setAnoPublicacao(sc.nextLine()); //Lê o ano de publicação e armazena no atributo

                    if(novoLivro.anoPublicacao.length() == 4 && novoLivro.anoPublicacao.matches("\\d{4}")) {
                        novoLivro.setStatus(Status.DISPONIVEL); //O livro está disponível ao ser adicionado

                        listaLivros.add(novoLivro); //Adiciona o livro que o usuário preencheu na biblioteca
                        System.out.println("Livro adicionado com sucesso!"); //Imprime no console

                        controle = true;

                    }else{
                        System.out.println("\tAno inválido! Digite um ano com 4 dígitos."); //Imprime no console

                    }
                }else{
                    System.out.println("\tGênero invalido!"); //Imprime no console
                }
            }else{
                System.out.println("\tNome do autor inválido!"); //Imprime no console
            }


        }
    }

    public void cadastrarLeitor() { //Metodo para cadastrar um novo leitor
        Leitor novoLeitor = new Leitor(); //Novo objeto da classe Leitor

        System.out.print("Nome do leitor: "); //Imprime no console
        novoLeitor.setNome(sc.nextLine()); //Armazena no objeto o nome do leitor
        if(novoLeitor.getNome().matches("[a-zA-Z\\s]+")){ //Verifica se o nome contém apenas letras e espaços
            System.out.print("CPF do leitor: "); //Imprime no console
            novoLeitor.setCpf(sc.nextLine()); //Armazena no objeto o CPF do leitor

            String cpfNumerico = novoLeitor.getCpf().replaceAll("[^0-9]", ""); //Remove pontos e traços do CPF

            if(cpfNumerico.length() != 11) { //Verifica se o CPF tem exatamente 11 dígitod
                System.out.println("CPF inválido! Deve conter 11 dígitos."); //Imprime no console
            }else{ //Verifica se já existe um leitor com o mesmo CPF na lista
                for(Leitor leitor : listaLeitores) { //Percorre a lista de leitores
                    if(leitor.getCpf().replaceAll("[^0-9]", "").equals(cpfNumerico)) { //Se já existir um leitor com o mesmo CPF, mostra na tela e sai do metodo
                        System.out.println("\tJá existe um leitor com esse CPF!"); //Imprime no console
                        return; //Sai do metodo sem adicionar o novo leitor
                    }
                }
                listaLeitores.add(novoLeitor); //Caso não haja conflitos de CPF, adiciona o novo leitor na lista
                System.out.println("\tLeitor cadastrado com sucesso!"); //Imprime no console
            }
        }else{
            System.out.println("\tNome invalido!"); //Imprime no console
        }
    }

    public void listarEmprestimos() { //Metodo para listar todos os empréstimos realizados

        if(livrosEmprestados.isEmpty()) {
            System.out.println("\n=================================" +"\n  Não há livros emprestados para devolver!" + "\n=================================" );
        }else {
            for (Emprestimo emp : livrosEmprestados) { //Percorre sobre a lista de empréstimos e mostra os detalhes de cada um
                System.out.println("Livro: " + emp.getLivro().getTitulo()); //Título do livro
                System.out.println("Leitor: " + emp.getLeitor().getNome()); //Nome do livro
            }
        }
    }

    public void registrarEmprestimo() { //Metodo para registrar um empréstimo


        if (listaLivros.isEmpty()) {
            System.out.println("\n=================================" + "\n\tNão há livros cadastrados!" + "\n=================================" );
        } else {
            listarLivros(); //Mostra a lista de livros disponíveis

            System.out.print("Digite o título do livro: "); //imprime no console
            String tituloLivro = sc.nextLine(); //Lê o título do livro

            Livros livroEmprestado = null;
            for (Livros livro : listaLivros) {
                if (livro.getTitulo().equalsIgnoreCase(tituloLivro)) { //Verifica se o livro está na lista de livros e se está disponível
                    livroEmprestado = livro; //Encontra o livro correspondente
                    break;
                }
            }

            if (livroEmprestado == null || Status.INDISPONIVEL.equals(livroEmprestado.getStatus())) { //verifica se o livro não foi encontrado ou não está disponível
                System.out.println("\n=================================" + "Livro não encontrado ou não disponível para empréstimo." + "\n================================="); //Imprime no console
                return; //Retorna sem fazer nada se o livro não estiver disponível
            }

            System.out.print("Digite o nome do leitor: "); //Imprime no console
            String nomeLeitor = sc.nextLine(); //Lê o nome do leitor
            System.out.println("Digite o CPF do leitor: ");
            String cpfLeitor = sc.nextLine();

            Leitor leitor = null;
            Leitor cpf = null;
            for (Leitor l : listaLeitores) { //Verifica se o leitor está cadastrado
                if (l.getNome().equalsIgnoreCase(nomeLeitor) && l.getCpf().equalsIgnoreCase(cpfLeitor)) {
                    leitor = l; //Encontra o leitor correspondente
                    cpf = l;
                    break;

                }

                if (leitor == null ) { //Verifica se o leitor não foi encontrado
                    System.out.println("Leitor não cadastrado ou incorreto."); //Imprime no console
                    return; //Retorna sem fazer nada se o leitor não estiver cadastrado
                } else {

                    Emprestimo emprestimo = new Emprestimo(leitor, livroEmprestado, Status.INDISPONIVEL); //Cria um objeto Emprestimo e registra o empréstimo
                    livrosEmprestados.add(emprestimo); //Adiciona o empréstimo na lista
                    leitor.solicitarEmprestimo(emprestimo); //Registra o empréstimo no leitor
                    emprestimo.registrarEmprestimo(); //Registra o empréstimo
                }
            }
        }
    }

    public void devolverEmprestimo() { //Metodo para devolver um livro emprestado

        if(livrosEmprestados.isEmpty()) {
            System.out.println("\tNão há livros emprestados para devolver!");
        }else {
            //Mostra a lista de livros disponíveis para a devolução
            for (Emprestimo emprestimo : livrosEmprestados) {
                Livros livro = emprestimo.getLivro(); // Obtém o livro dentro do empréstimo
                System.out.println("\tTitulo: " + livro.getTitulo()
                        + "\n\tAutor: " + livro.getAutor()
                        + "\n\tGerenero: " + livro.getGenero()
                        + "\n\tAno de publicação: " + livro.getAnoPublicacao()
                        + "\n\t" + livro.getStatus());
            }
            System.out.print("Digite o título do livro que deseja devolver: "); //Imprime no console
            String tituloLivro = sc.nextLine(); //Lê o título do livro

            for (Emprestimo emp : livrosEmprestados) { //Encontra o empréstimo correspondente e registra a devolução
                if (emp.getLivro().getTitulo().equalsIgnoreCase(tituloLivro)) {
                    emp.registrarDevolucao(); //Registra a devolução do livro
                    livrosEmprestados.remove(emp); //Remove o empréstimo da lista
                    break;
                }
            }
        }
    }

    public void listarLeitores() { //Metodo para listar todos os leitores cadastrados
        System.out.println("\n\n----------------------------\n\tLeitores cadastrados!\n----------------------------"); //Título
        listaLeitores.forEach(System.out::println); //Mostra todos os leitores cadastrados
    }

    public void listarLivros() { //Metodo para listar todos os livros cadastrados
        System.out.println("\n\n----------------------------\n\tLivros cadastrados!\n----------------------------"); //Título
        listaLivros.forEach(System.out::println); //Mostra todos os livros cadastrados
    }
}