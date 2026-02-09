package org.example;

import org.example.aluno.Aluno;
import org.example.dao.AlunoDao;
import org.example.dao.TurmaDao;
import org.example.turma.Turma;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {


        Scanner teclado = new Scanner(System.in);
        TurmaDao turmaDao = new TurmaDao();
        AlunoDao alunoDao = new AlunoDao();

        int opcao = 1;

        while (opcao != 0) {

            System.out.println("\n--- SISTEMA ESCOLAR ---");
            System.out.println("1 - Cadastrar Turma");
            System.out.println("2 - Cadastrar Aluno");
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

