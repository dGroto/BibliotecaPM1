package system;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Biblioteca {

    Scanner sc = new Scanner(System.in);
    List<Livros> listaLivros = new ArrayList<>();
    List<Leitor> listaLeitores = new ArrayList<>();
    List<Emprestimo> livrosEmprestados = new ArrayList<>();

    //Adicionar livro à biblioteca
    public void addLivro() {
        Livros novoLivro = new Livros();

        System.out.print("Nome: ");
        novoLivro.setTitulo(sc.nextLine());

        System.out.print("Autor: ");
        novoLivro.setAutor(sc.nextLine());

        System.out.print("Gênero: ");
        novoLivro.setGenero(sc.nextLine());

        System.out.print("Ano de publicação: ");
        novoLivro.setAnoPublicacao(sc.nextLine());

        novoLivro.setDisponivel(true); //O livro está disponível ao ser adicionado

        listaLivros.add(novoLivro);
        System.out.println("Livro adicionado com sucesso!");
    }

    // POLYANA

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
            System.out.println("Data do Empréstimo: " + emp.getDataEmprestimo());
            System.out.println("Data de Devolução: " + emp.getDataDevolucao());
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

        if (livroEmprestado == null || !livroEmprestado.getDisponivel()) {
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

        System.out.print("Digite a data do empréstimo: ");
        String dataEmprestimo = sc.nextLine();

        System.out.print("Digite a data de devolução: ");
        String dataDevolucao = sc.nextLine();

        Emprestimo emprestimo = new Emprestimo(dataEmprestimo, leitor, livroEmprestado);
        emprestimo.setDataDevolucao(dataDevolucao);
        livrosEmprestados.add(emprestimo);
        leitor.solicitarEmprestimo(emprestimo);
        emprestimo.registrarEmprestimo();
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