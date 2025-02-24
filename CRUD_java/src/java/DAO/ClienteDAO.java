/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import util.FabricaConexao;

/**
 *
 * @author yasmi
 */
public class ClienteDAO {
    public void cadastrar(Cliente clin) throws ClassNotFoundException, SQLException {
        Connection con =  FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement("insert into clientes (nome, cpf, rg, data_nascimento, telefone, cep, endereco,email, genero) values (?,?,?,?,?,?,?,?,?)");
        comando.setString(1, clin.getNome());
        comando.setDouble(2, clin.getCpf());
        comando.setDouble(3, clin.getRg());
        comando.setDouble(4, clin.getData_nascimento());
        comando.setDouble(5, clin.getTelefone());
        comando.setDouble(6, clin.getCep());
        comando.setString(7, clin.getEndereco());
        comando.setString(8, clin.getEmail());
        comando.setString(9, clin.getGenero());
        comando.execute();
        con.close();
    }
    
     public void deletar(Cliente clin) throws ClassNotFoundException, SQLException {
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement("delete from clientes where id = ?");
        comando.setInt(1, clin.getId());
        comando.execute();
        con.close();
    }
     public void atualizar(Cliente clin) throws ClassNotFoundException, SQLException {
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement("UPDATE clientes SET nome = ?, cpf = ?, rg = ?, data_nascimento = ?, telefone = ?, cep = ?, endereco = ?,email = ?, genero = ?  where id = ?");
        comando.setString(1, clin.getNome());
        comando.setDouble(2, clin.getCpf());
        comando.setDouble(3, clin.getRg());
        comando.setDouble(4, clin.getData_nascimento());
        comando.setDouble(5, clin.getTelefone());
        comando.setDouble(6, clin.getCep());
        comando.setString(7, clin.getEndereco());
        comando.setString(8, clin.getEmail());
        comando.setString(9, clin.getGenero());
        comando.setInt(10, clin.getId());
        
        comando.execute();
        con.close();
    }
     
     public Cliente consultarById(Cliente clin) throws ClassNotFoundException, SQLException {
        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from clientes WHERE id=?");
        comando.setInt(1, clin.getId());
        ResultSet rs = comando.executeQuery();

        Cliente c = new Cliente();
        if (rs.next()) {
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setCpf(rs.getDouble("cpf"));
            c.setRg(rs.getDouble("rg"));
            c.setData_nascimento(rs.getDouble("data_nascimento"));
            c.setTelefone(rs.getDouble("telefone"));
            c.setCep(rs.getDouble("cep"));
            c.setEndereco(rs.getString("endereco"));
            c.setEmail(rs.getString("email"));
            c.setGenero(rs.getString("genero"));
        }

        con.close();
        return c;
     }
        
         public List<Cliente> consultarTodos() throws ClassNotFoundException, SQLException {

        Connection con = FabricaConexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from clientes");
        ResultSet rs = comando.executeQuery();
        List<Cliente> lclin = new ArrayList();
        while (rs.next()) {
            Cliente clin = new Cliente();
            clin.setId(rs.getInt("id"));
            clin.setNome(rs.getString("nome"));
            clin.setCpf(rs.getDouble("cpf"));
            clin.setRg(rs.getDouble("rg"));
            clin.setData_nascimento(rs.getDouble("data_nascimento"));
            clin.setTelefone(rs.getDouble("telefone"));
            clin.setCep(rs.getDouble("cep"));
            clin.setEndereco(rs.getString("endereco"));
            clin.setEmail(rs.getString("email"));
            clin.setGenero(rs.getString("genero"));
            lclin.add(clin);
        }
        return lclin;
    }
}
