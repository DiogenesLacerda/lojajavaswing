/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

import conn.ConexaoMySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

/**
 *
 * @author Aluno
 */
public class RepClientes {
   
    Connection con;

    public boolean inserir(Cliente cliente){
        
        con = ConexaoMySql.getConexao(); 
        
        String sql = "insert into clientes (nome,"
                 + "cpf,rg,telefone,rua,bairro,num,cep,sexo) values "
                 + "(?,?,?,?,?,?,?,?,?)";
         try{
             con.setAutoCommit(false);
             PreparedStatement stmt = con.prepareStatement(sql);
             
             stmt.setString(1, cliente.getNome());
             stmt.setString(2, cliente.getCpf());
             stmt.setString(3, cliente.getRg());
             stmt.setString(4, cliente.getTelefone());
             stmt.setString(5, cliente.getRua());
             stmt.setString(6, cliente.getBairro());
             stmt.setString(7, cliente.getNumero());
             stmt.setString(8, cliente.getCep());
             stmt.setString(9, cliente.getSexo());
             
             stmt.execute();
             con.commit();
             ConexaoMySql.fecharConexao();
             
            return true;
         }catch(Exception ex){
             try{
                 con.rollback();
                 System.err.println(ex.getMessage());
                 return false;
             }catch(SQLException exSql){
                 System.err.println(exSql.getMessage());
             }
         }
         
       return true;
    }
    
  public List<Cliente> retornar(){
      
      con = ConexaoMySql.getConexao();
      List<Cliente> clientes = new ArrayList<>();
      
      String sql = "select * from clientes order by id desc";
      
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          while(rs.next()){
              
              Cliente cliente = new Cliente();
              
              cliente.setId(rs.getInt("id"));
              cliente.setNome(rs.getString("Nome"));
              cliente.setCpf(rs.getString("cpf"));
              cliente.setRg(rs.getString("rg"));
              cliente.setTelefone(rs.getString("telefone"));
              cliente.setRua(rs.getString("rua"));
              cliente.setBairro(rs.getString("Bairro"));
              cliente.setNumero(rs.getString("num"));
              cliente.setCep(rs.getString("cep"));
              cliente.setSexo(rs.getString("sexo"));
             
              
              clientes.add(cliente);
          }            
      }catch(SQLException ex){
          return null;
      }
      
      ConexaoMySql.fecharConexao();
      
      return clientes;
  }  
  
      public boolean atualizar(Cliente cliente) {

        con = ConexaoMySql.getConexao();
        String sql = "update clientes set nome = ? ,"
                 + "cpf = ?,rg = ?,telefone = ?,rua = ?,bairro = ?, cep = ?, num = ?, sexo = ? where id = ?";
        try {
            con.setAutoCommit(false);
            PreparedStatement stmt = con.prepareStatement(sql);

             stmt.setString(1, cliente.getNome());
             stmt.setString(2, cliente.getCpf());
             stmt.setString(3, cliente.getRg());
             stmt.setString(4, cliente.getTelefone());
             stmt.setString(5, cliente.getRua());
             stmt.setString(6, cliente.getBairro());
             stmt.setString(7, cliente.getCep());
             stmt.setString(8, cliente.getNumero());  
             stmt.setString(9, cliente.getSexo());
             stmt.setInt(10, cliente.getId());
             
            stmt.execute();

            con.commit();
            ConexaoMySql.fecharConexao();

            return true;

        } catch (SQLException ex) {
            try {
                con.rollback();
                System.err.println(ex);
                return false;
            } catch (SQLException ex1) {
                System.err.println(ex1);
            }

            return false;
        }

    }  
  
  public List<Cliente> pesquisa(String valor, String tipoPesquisa){
      
      con = ConexaoMySql.getConexao();
      List<Cliente> clientes = new ArrayList<>();
      
      String sql = "";
      
      if(tipoPesquisa.equals("nome")){
       sql = "select * from clientes where nome like '%"+valor+"%'";
      }else if(tipoPesquisa.equals("cpf")){
       sql = "select * from clientes where cpf like '%"+valor+"%'";
      }else if(tipoPesquisa.equals("rg")){
       sql = "select * from clientes where rg = '"+valor+"'";
      }else if(tipoPesquisa.equals("codigo")){
       sql = "select * from clientes where id = '"+valor+"'";
      }   
     
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          while(rs.next()){
              
              Cliente cliente = new Cliente();
              
              cliente.setId(rs.getInt("id"));
              cliente.setNome(rs.getString("Nome"));
              cliente.setCpf(rs.getString("CPF"));
              cliente.setRg(rs.getString("RG"));
              cliente.setTelefone(rs.getString("Telefone"));
              cliente.setRua(rs.getString("Rua"));
              cliente.setBairro(rs.getString("Bairro"));
              cliente.setNumero(rs.getString("Num"));
              cliente.setCep(rs.getString("CEP"));
              cliente.setSexo(rs.getString("Sexo"));
              
              clientes.add(cliente);
          }            
      }catch(SQLException ex){
          return null;
      }
      ConexaoMySql.fecharConexao();
      
      return clientes;
  }  
    
  
  public boolean excluir(int id){
      
      con = ConexaoMySql.getConexao();
      String sql = "delete from clientes where id = ?";
      
      try{
          
          con.setAutoCommit(false);
          PreparedStatement stmt = con.prepareStatement(sql);
          
          stmt.setInt(1, id);
          
          stmt.execute();
          con.commit();
          ConexaoMySql.fecharConexao();
      
          return true;   
      }catch(SQLException ex){
          
          return false;
      }
        
  }
    
  public int retornarTotal(){
      
      con = ConexaoMySql.getConexao();
      int ret =0;
      String sql = "select count(*) as total from clientes";
      
      try{
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery(sql);
          while(rs.next()){
              
              ret = rs.getInt("total");
              
             
          }            
      }catch(SQLException ex){
          return ret;
      }
      
      ConexaoMySql.fecharConexao();
      
      return ret;
  }  
    
}
