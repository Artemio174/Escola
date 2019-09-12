/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Escola;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Administrador
 */
public class DaoEscola {
     public static boolean inserir(Escola objeto) {
        String sql = "INSERT INTO Escola (nome, endereco, sigla, nr_aluno, area) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            ps.setString(2, objeto.getEndereco());
            ps.setString(3, objeto.getSigla());
            ps.setInt(4, objeto.getNr_aluno());
            ps.setDouble(5, objeto.getArea());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
     public static void main(String[] args) {
        Escola objeto = new Escola();
        objeto.setNome("Sinodal");
        objeto.setEndereco("Ibirubá");
        objeto.setSigla("CSI");
        objeto.setNr_aluno(321);
        objeto.setArea(14.3);
        
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
     public static List<Escola> consultar() {
        List<Escola> resultados = new ArrayList<>();
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, nome, endereco, sigla, nr_aluno, area FROM Escola";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Escola objeto = new Escola();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setNome(rs.getString("nome"));
                objeto.setEndereco(rs.getString("endereco"));
                objeto.setSigla(rs.getString("sigla"));
                objeto.setNr_aluno(rs.getInt("nr_aluno"));
                objeto.setArea(rs.getDouble("area"));
                
                resultados.add(objeto);//não mexa nesse, ele adiciona o objeto na lista
            }
            return resultados;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
}
}
