package system; //Pacote criado
import java.util.List;
import java.util.ArrayList;

public class Leitor { //Classe leitor com atributos privados
  private String nome;
  private String cpf;
  private List<Emprestimo> emprestimos; //Lista de empréstimos realizados pelo leitor

  //Construtor que inicializa o nome, CPF e a lista de empréstimos
  public Leitor(String nome, String cpf) {
    this.nome = nome;
    this.cpf = cpf;
    this.emprestimos = new ArrayList<>(); //Inicializa a lista de empréstimos como uma nova ArrayList
  }

  public Leitor() { //onstrutor vazio que também inicializa a lista de empréstimos
    this.emprestimos = new ArrayList<>();
  }

  //Getter e setter para o nome do leitor
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  //Getter e setter para o CPF do leitor
  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  //Getter e setter para a lista de empréstimos do leitor
  public List<Emprestimo> getEmprestimos() {
    return emprestimos;
  }

  public void setEmprestimos(List<Emprestimo> emprestimos) {
    this.emprestimos = emprestimos;
  }

  //Metodo para atualizar os dados do cadastro do leitor
  public void atualizarCadastro(String nome, String cpf) { //Atualiza o nome e CPF do leitor
    setNome(nome);
    setCpf(cpf);
  }

  //Metodo para solicitar um empréstimo de livro
  public void solicitarEmprestimo(Emprestimo emprestimo) {
    emprestimos.add(emprestimo); //Adiciona um empréstimo na lista de empréstimos do leitor
  }

  //Metodo toString para retornar como uma string
  @Override
  public String toString() {
    return "\tNome: " + nome + "\n\tCPF: " + cpf + "\n----------------------------";
  }
}