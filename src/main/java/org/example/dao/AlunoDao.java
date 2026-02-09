package org.example.dao;

import org.example.aluno.Aluno;
import org.example.conexao.ConexaoBanco;

import java.sql.PreparedStatement;

public class AlunoDao {


    public void cadastrarAluno(Aluno aluno) {
        String sql = "INSERT INTO alunos (nome_aluno, email, id_turma) VALUES (?,?,?)";

        PreparedStatement ps = null;

        try {
            ps = ConexaoBanco.getConnection().prepareStatement(sql);
            ps.setString(1, aluno.getNomeAluno());
            ps.setString(2, aluno.getEmail());
            ps.setInt(3, aluno.getIdTurma());
            ps.execute();
            ps.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
