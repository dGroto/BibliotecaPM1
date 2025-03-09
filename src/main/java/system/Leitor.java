package system;
import java.util.List;
import java.util.ArrayList;

public class Leitor {

  private String nome;
  private String cpf; // Adicionei um CPF para o cadastro
  private List<Emprestimo> emprestimos;

  //Construtor
  public Leitor(String nome, String cpf) {
    this.nome = nome;
    this.cpf = cpf;
    this.emprestimos = new ArrayList<>();
  }

  public Leitor() {
    this.emprestimos = new ArrayList<>();
  }

  //Getters e Setters
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public List<Emprestimo> getEmprestimos() {
    return emprestimos;
  }

  public void setEmprestimos(List<Emprestimo> emprestimos) {
    this.emprestimos = emprestimos;
  }

  //Método para atualizar cadastro
  public void atualizarCadastro(String nome, String cpf) {
    setNome(nome);
    setCpf(cpf);
  }

  //Método para solicitar empréstimo
  public void solicitarEmprestimo(Emprestimo emprestimo) {
    emprestimos.add(emprestimo);
  }

  @Override
  public String toString() {
    return "\tNome: " + nome + "\n\tCPF: " + cpf + "\n----------------------------";
  }
}