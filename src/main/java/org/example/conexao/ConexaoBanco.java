package org.example.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBanco {

    private static final String url = "jdbc:mysql://localhost:3306/db_sistema_escolar";
    private static final String user = System.getenv("DB_USER");
    private static final String password = System.getenv("DB_PASSWORD");
//  private static final String user = "root";
//  private static final String password = "senha$00";

    private static Connection conexao;

    public static Connection getConnection() {
        try {

            if (conexao == null) {
                conexao = DriverManager.getConnection(url, user, password);
                return conexao;

            } else {
                return conexao;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
