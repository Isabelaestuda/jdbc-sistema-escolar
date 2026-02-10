package org.example;

import org.example.aluno.Aluno;
import org.example.dao.AlunoDao;
import org.example.dao.TurmaDao;
import org.example.turma.Turma;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {


        Scanner teclado = new Scanner(System.in);
        TurmaDao turmaDao = new TurmaDao();
        AlunoDao alunoDao = new AlunoDao();

        int opcao = 1;

        while (opcao != 0) {

            System.out.println("\n--- SISTEMA ESCOLAR ---");
            System.out.println("1 - Cadastrar Turma");
            System.out.println("2 - Listar Turmas");
            System.out.println("3 - Atualizar Turmas");
            System.out.println("4 - Excluir Turmas");
            System.out.println("5 - Cadastrar Aluno");
            System.out.println("6 - Listar Alunos");
            System.out.println("7 - Atualizar Aluno");
            System.out.println("8 - Excluir Aluno");

            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("--- CADASTRO DE SISTEMA ESCOLAR ---");

                    System.out.print("Digite o nome da Turma (ex: Java Backend): ");
                    String nomeT = teclado.nextLine();

                    System.out.print("Digite o período (Manhã, Tarde ou Noite): ");
                    String periodoT = teclado.nextLine();

                    Turma novaTurma = new Turma(nomeT, periodoT);
                    turmaDao.cadastrarTurma(novaTurma);
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE TURMAS ---");
                    for (Turma t : turmaDao.listarTurmas()) {
                        System.out.println("ID: " + t.getId() + " | Nome: " + t.getNomeTurma() + " | Periodo: " + t.getPeriodo());
                    }
                    break;

                case 3:
                    System.out.print("Digite o ID da turma que deseja atualizar: ");
                    int idAtualizar = teclado.nextInt();
                    teclado.nextLine();
                    System.out.print("Nova Turma: ");
                    String novoP = teclado.nextLine();
                    System.out.print("Novo Periodo: ");
                    String novoPeriodo = teclado.nextLine();

                    Turma turmaAlt = new Turma(novoP, novoPeriodo);
                    turmaAlt.setId(idAtualizar);
                    turmaDao.atualizarTurma(turmaAlt);
                    break;

                case 4:
                    System.out.print("Digite o ID da turma que deseja excluir: ");
                    int idExcluir = teclado.nextInt();
                    turmaDao.excluirTurma(idExcluir);
                    break;

                case 5:
                    System.out.println("\n--- Agora, vamos cadastrar um aluno para essa turma ---");

                    System.out.println("Nome do Aluno ");
                    String nomeA = teclado.nextLine();

                    System.out.print("Email do Aluno: ");
                    String emailA = teclado.nextLine();

                    System.out.print("Digite o ID da turma que você acabou de criar: ");
                    int idT = teclado.nextInt();

                    Aluno novoAluno = new Aluno(nomeA, emailA, idT);
                    alunoDao.cadastrarAluno(novoAluno);

                    System.out.println("\nCadrasto realizado com sucesso!");
                    break;

                case 6:
                    System.out.println("\n--- LISTA DE ALUNOS ---");
                    for (Aluno a : alunoDao.listarAlunos()) {
                        System.out.println("ID: " + a.getId() + " | Nome: " + a.getNomeAluno() + " | Email: " + a.getEmail());
                    }
                    break;

                case 7:
                    System.out.print("Digite o ID do aluno que deseja atualizar: ");
                    int idAlt = teclado.nextInt();
                    teclado.nextLine();
                    System.out.print("Novo Nome: ");
                    String novoNome = teclado.nextLine();
                    System.out.print("Novo Email: ");
                    String novoEmail = teclado.nextLine();

                    Aluno alunoAlt = new Aluno(novoNome, novoEmail, 0);
                    alunoAlt.setId(idAlt);
                    alunoDao.atualizarAluno(alunoAlt);
                    break;

                case 8:
                    System.out.print("Digite o ID do aluno que deseja excluir: ");
                    int idExc = teclado.nextInt();
                    alunoDao.excluirAluno(idExc);
                    break;



                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        teclado.close();
    }

}

