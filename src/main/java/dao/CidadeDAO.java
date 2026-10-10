package dao;

import model.Cidade;
import model.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeDAO {
    public List<Cidade> listarTodas() {
        List<Cidade> lista = new ArrayList<>();

        String sql = "SELECT c.nome cidade, e.nome estado, e.sigla sigla FROM cidade c INNER JOIN estado e on e.id = c.id_estado;";
        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Estado est = new Estado();
                est.setNome(rs.getString("estado"));
                est.setSigla(rs.getString("sigla"));
                Cidade cid = new Cidade();
                cid.setNome(rs.getString("cidade"));
                cid.setEstado(est);
                lista.add(cid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}