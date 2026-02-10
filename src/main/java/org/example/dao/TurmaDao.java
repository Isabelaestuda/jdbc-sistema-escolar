package org.example.dao;

import org.example.conexao.ConexaoBanco;
import org.example.turma.Turma;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TurmaDao {

    public void cadastrarTurma(Turma turma) {

        String sql = "INSERT INTO turmas (nome_turma, periodo) VALUES (?,?)";

        PreparedStatement ps = null;

        try {

            ps = ConexaoBanco.getConnection().prepareStatement(sql);
            ps.setString(1, turma.getNomeTurma());
            ps.setString(2, turma.getPeriodo());
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Turma> listarTurmas (){
        String sql = "SELECT * FROM turmas";
        List<Turma> lista = new ArrayList<>();

        try(PreparedStatement ps = ConexaoBanco.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Turma a = new Turma(rs.getString("nome_turma"), rs.getString("periodo"));
                a.setId(rs.getInt("id"));
                lista.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void atualizarTurma(Turma turma) {
        String sql = "UPDATE turmas SET nome_turma = ?, periodo = ? WHERE id = ?";
        try (PreparedStatement ps = ConexaoBanco.getConnection().prepareStatement(sql)) {
            ps.setString(1, turma.getNomeTurma());
            ps.setString(2, turma.getPeriodo());
            ps.setInt(3, turma.getId());

            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("ID da turma " + turma.getId() + " atualizado com sucesso!");
            } else {
                System.out.println("Aviso: O ID " + turma.getId() + " não existe no banco de dados.");
            }


        } catch (Exception e) {
            System.out.println("Erro ao acessar ao banco: " +e.getMessage());        }
    }


    public void excluirTurma(int id) {
        String sql = "DELETE FROM turmas WHERE id = ?";
        try (PreparedStatement ps = ConexaoBanco.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);

            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("turma com ID " + id + " deletado com sucesso!");
            } else {
                System.out.println("Aviso: O ID " + id + " não existe no banco de dados.");
            }

        } catch (Exception e) {
            System.err.println("Erro ao acessar o banco: " + e.getMessage());        }
        }
    }
