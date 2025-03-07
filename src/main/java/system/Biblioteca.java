package system; //Pacote criado
import java.util.Scanner; //Classe Scanner importada para ler entradas do usuário
import java.util.List; //Interface List importada para usar listas
import java.util.ArrayList; //Classe importada para usar arrays dinâmicos

public class Biblioteca  implements IBiblioteca{ //Classe Biblioteca (pública)

    Scanner sc = new Scanner(System.in); //Lê entradas do usuário através do teclado
    List<Livros> listaLivros = new ArrayList<>(); //Lista criada para armazenar objetos da classe Livros
    List<Leitor> listaLeitores = new ArrayList<>(); //Lista criada para armazenar objetos da classe Leitor
    List<Emprestimo> livrosEmprestados = new ArrayList<>(); //Lista criada para armazenar objetos da classe Emprestimo

    public void addLivro() { //Metodo para adicionar livros à biblioteca
        Livros novoLivro = new Livros(); //Novo objeto

        System.out.print("Nome: "); //Imprime no console
        novoLivro.setTitulo(sc.nextLine()); //Armazena o nome do livro

        System.out.print("Autor: "); //Imprime no console
        novoLivro.setAutor(sc.nextLine()); //Armazena o valor digitado pelo usuário no atributo

        System.out.print("Gênero: "); //Imprime no console
        novoLivro.setGenero(sc.nextLine()); //Lê o gênero do livro e armazena no atributo

        System.out.print("Ano de publicação: "); //Imprime no console
        novoLivro.setAnoPublicacao(sc.nextLine()); //Lê o ano de publicação e armazena no atributo

        novoLivro.setStatus(Status.DISPONIVEL); //O livro está disponível ao ser adicionado

        listaLivros.add(novoLivro); //Adiciona o livro que o usuário preencheu na biblioteca
        System.out.println("Livro adicionado com sucesso!"); //Imprime no console
    }


    //Cadastrar leitor
    public void cadastrarLeitor() {
        Leitor novoLeitor = new Leitor();

        System.out.print("Nome do leitor: ");
        novoLeitor.setNome(sc.nextLine());

        System.out.print("CPF do leitor: ");
        novoLeitor.setCpf(sc.nextLine());

        listaLeitores.add(novoLeitor);
        System.out.println("Leitor cadastrado com sucesso!");
    }

    //Listar todos os empréstimos
    public void listarEmprestimos() {
        for (Emprestimo emp : livrosEmprestados) {
            System.out.println("Livro: " + emp.getLivro().getTitulo());
            System.out.println("Leitor: " + emp.getLeitor().getNome());
        }
    }

    //Registrar um empréstimo
    public void registrarEmprestimo() {

        listarLivros();

        System.out.print("Digite o título do livro: ");
        String tituloLivro = sc.nextLine();

        Livros livroEmprestado = null;
        for (Livros livro : listaLivros) {
            if (livro.getTitulo().equalsIgnoreCase(tituloLivro)) {
                livroEmprestado = livro;
                break;
            }
        }

        if (livroEmprestado == null || Status.INDISPONIVEL.equals(livroEmprestado.getStatus()) ) {
            System.out.println("Livro não encontrado ou não disponível para empréstimo.");
            return;
        }

        System.out.print("Digite o nome do leitor: ");
        String nomeLeitor = sc.nextLine();

        Leitor leitor = null;
        for (Leitor l : listaLeitores) {
            if (l.getNome().equalsIgnoreCase(nomeLeitor)) {
                leitor = l;
                break;
            }
        }

        if (leitor == null) {
            System.out.println("Leitor não cadastrado.");
            return;
        }

        Emprestimo emprestimo = new Emprestimo(leitor, livroEmprestado);
        livrosEmprestados.add(emprestimo);
        leitor.solicitarEmprestimo(emprestimo);
        emprestimo.registrarEmprestimo();


    }

    public void devolverEmprestimo() {

        listarLivros();

        System.out.print("Digite o título do livro que deseja devolver: ");
        String tituloLivro = sc.nextLine();


    }

    public void listarLeitores() {

        System.out.println("\n\n----------------------------\n\tLeitores cadastrados!\n----------------------------");
        listaLeitores.forEach(System.out::println);
    }

    public void listarLivros() {

        System.out.println("\n\n----------------------------\n\tLivros cadastrados!\n----------------------------");
        listaLivros.forEach(System.out::println);
    }
}