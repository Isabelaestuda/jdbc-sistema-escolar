package org.example.dao;

import org.example.aluno.Aluno;
import org.example.conexao.ConexaoBanco;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

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

    public List<Aluno> listarAlunos() {
        String sql = "SELECT * FROM alunos";
        List<Aluno> lista = new ArrayList<>();
        try (PreparedStatement ps = ConexaoBanco.getConnection().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Aluno a = new Aluno(rs.getString("nome_aluno"), rs.getString("email"), rs.getInt("id_turma"));
                a.setId(rs.getInt("id"));
                lista.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void atualizarAluno(Aluno aluno) {
        String sql = "UPDATE alunos SET nome_aluno = ?, email = ? WHERE id = ?";
        try (PreparedStatement ps = ConexaoBanco.getConnection().prepareStatement(sql)) {
            ps.setString(1, aluno.getNomeAluno());
            ps.setString(2, aluno.getEmail());
            ps.setInt(3, aluno.getId());

            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Aluno com ID " + aluno.getId() + " Atualizado com sucesso!");
            } else {
                System.out.println("Aviso: O ID " + aluno.getId() + " não existe no banco de dados.");
            }

        } catch (Exception e) {
            System.err.println("Erro ao acessar o banco: " + e.getMessage());
        }
    }

    public void excluirAluno(int id) {
        String sql = "DELETE FROM alunos WHERE id = ?";
        try (PreparedStatement ps = ConexaoBanco.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);

            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Aluno com ID " + id + " deletado com sucesso!");
            } else {
                System.out.println("Aviso: O ID " + id + " não existe no banco de dados.");
            }

        } catch (Exception e) {
            System.err.println("Erro ao acessar o banco: " + e.getMessage());        }
    }
}