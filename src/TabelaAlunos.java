// Alunos : Maria Eduarda Silva Viana, Lucas Neves Souza
// Turma: ESN3 | Professor: Ricardo Vilaverde | Matéria: Estrutura de Dados I

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TabelaAluno {

    static class Aluno {
        String nome;
        ArrayList<Double> notas;

        Aluno(String nome) {
            this.nome = nome;
            this.notas = new ArrayList<>();
        }

        double calcularMedia() {
            if (notas.isEmpty()) {
                return 0.0;
            }
            double soma = 0;
            for (double nota : notas) {
                soma += nota;
            }
            return soma / notas.size();
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Stack<Aluno> pilhaAlunos = new Stack<>();
        int op;

        do {
            System.out.println("\nMENU");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Cadastrar nota");
            System.out.println("3 - Calcular média de um aluno");
            System.out.println("4 - Listar os nomes dos alunos sem notas");
            System.out.println("5 - Excluir aluno do topo");
            System.out.println("6 - Excluir nota de um aluno");
            System.out.println("7 - Sair");
            System.out.print("Digite sua opção: ");
            op = entrada.nextInt();
            entrada.nextLine(); // Limpa o buffer do scanner

            String nome; // Declarar a variável 'nome' fora do switch

            switch (op) {
                case 1:
                    System.out.print("Digite o nome do Aluno que será cadastrado: ");
                    nome = entrada.nextLine();
                    pilhaAlunos.push(new Aluno(nome));
                    System.out.println("Aluno cadastrado no topo da pilha.");
                    break;
                case 2:
                    if (pilhaAlunos.isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado.");
                        break;
                    }
                    System.out.print("Digite o nome do Aluno que receberá a nota: ");
                    nome = entrada.nextLine();
                    Aluno alunoParaNota = encontrarAluno(pilhaAlunos, nome);
                    if (alunoParaNota != null) {
                        System.out.print("Digite a nota do Aluno: ");
                        double nota = entrada.nextDouble();
                        alunoParaNota.notas.add(nota);
                        System.out.println("Nota cadastrada.");
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;
                case 3:
                    if (pilhaAlunos.isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado.");
                        break;
                    }
                    System.out.print("Digite o nome do Aluno para calcular a média: ");
                    nome = entrada.nextLine();
                    Aluno alunoParaMedia = encontrarAluno(pilhaAlunos, nome);
                    if (alunoParaMedia != null) {
                        double media = alunoParaMedia.calcularMedia();
                        System.out.println("Média do aluno " + nome + ": " + media);
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;
                case 4:
                    if (pilhaAlunos.isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado.");
                        break;
                    }
                    System.out.println("Lista de alunos sem notas:");
                    for (Aluno aluno : pilhaAlunos) {
                        if (aluno.notas.isEmpty()) {
                            System.out.println(aluno.nome);
                        }
                    }
                    break;
                case 5:
                    if (!pilhaAlunos.isEmpty()) {
                        Aluno alunoExcluido = pilhaAlunos.pop();
                        System.out.println("Aluno " + alunoExcluido.nome + " excluído do topo da pilha.");
                    } else {
                        System.out.println("Nenhum aluno para excluir.");
                    }
                    break;
                case 6:
                    if (pilhaAlunos.isEmpty()) {
                        System.out.println("Nenhum aluno cadastrado.");
                        break;
                    }
                    System.out.print("Digite o nome do Aluno que terá uma nota excluída: ");
                    nome = entrada.nextLine();
                    Aluno alunoParaExcluirNota = encontrarAluno(pilhaAlunos, nome);
                    if (alunoParaExcluirNota != null) {
                        System.out.println("Notas do aluno:");
                        for (int i = 0; i < alunoParaExcluirNota.notas.size(); i++) {
                            System.out.println((i + 1) + ": " + alunoParaExcluirNota.notas.get(i));
                        }
                        System.out.print("Digite o número da nota a ser excluída: ");
                        int indiceNota = entrada.nextInt();
                        if (indiceNota > 0 && indiceNota <= alunoParaExcluirNota.notas.size()) {
                            alunoParaExcluirNota.notas.remove(indiceNota - 1);
                            System.out.println("Nota excluída.");
                        } else {
                            System.out.println("Nota inválida.");
                        }
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!!");
                    break;
            }
        } while (op != 7);

        entrada.close();
    }

    private static Aluno encontrarAluno(Stack<Aluno> pilhaAlunos, String nome) {
        for (Aluno aluno : pilhaAlunos) {
            if (aluno.nome.equalsIgnoreCase(nome)) {
                return aluno;
            }
        }
        return null;
    }
}
