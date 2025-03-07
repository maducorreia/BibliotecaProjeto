import java.util.InputMismatchException;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
       Biblioteca biblioteca = new Biblioteca();
       Scanner sc = new Scanner(System.in);

       //add livros e usuários
       biblioteca.adicionarLivro(new Livro("O Hobbit", "J.R.R. Tolkien"));
       biblioteca.adicionarLivro(new Livro("1984", "George Orwell"));
       biblioteca.adicionarUsuarios(new Usuario("Alice"));
       biblioteca.adicionarUsuarios(new Usuario("Luiz"));

       // adicionar revistas
       biblioteca.adicionarItem(new Revista("Science", "Editora Nature"));

       //menu
       while (true) {
        try {
            System.out.println("1 - Alugar item");
            System.out.println("2 - Devolver item");
            System.out.println("3 - Sair");
            System.out.println("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine(); // consumir nova linha

            if (opcao == 1) {
                System.out.println("Digite o nome do usuário: ");
                String nomeUsuario = sc.nextLine();
                Usuario usuario = biblioteca.buscarUsuario(nomeUsuario);

                if (usuario != null) {
                    System.out.println("Digite o nome do livro: ");
                    String tituloLivro = sc.nextLine();
                    Livro livro = biblioteca.buscarLivro(tituloLivro);

                    if (livro != null) {
                        usuario.alugarLivro(livro);
                    } else {
                        System.out.println("Livro indisponível!");
                    }
                } else {
                    System.out.println("Usuário não encontrado!");
                }
            } else if (opcao == 2) {
                System.out.println("Digite o nome do usuário: ");
                String nomeUsuario = sc.nextLine();
                Usuario usuario = biblioteca.buscarUsuario(nomeUsuario);

                if (usuario != null) {
                    usuario.devolverLivro();
                } else {
                    System.out.println("Usuário não encontrado!");
                }
            } else if (opcao == 3) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Por favor, insira um número.");
            sc.nextLine(); // consumir a entrada inválida
        } 
        catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }
    sc.close();
    }
}
