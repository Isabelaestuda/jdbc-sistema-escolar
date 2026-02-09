package org.example.dao;

import org.example.conexao.ConexaoBanco;
import org.example.turma.Turma;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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


}
