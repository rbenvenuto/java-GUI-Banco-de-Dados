/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static adw.AdwRootFrameController.olClientes;
import static adw.AdwRootFrameController.olProjetos;
import java.time.LocalDate;

/**
 *
 * @author rbenvenuto
 */
public class BancoDados {
    public static String hostame = "5dac0d0a-c9bf-46d9-83a4-a82a00ffaa9f.mysql.sequelizer.com";
    public static String dbName = "db5dac0d0ac9bf46d983a4a82a00ffaa9f";
    public static String url = "jdbc:mysql://" + hostame + "/" + dbName;
    public static Connection conexao = null;
    
    public static PreparedStatement ps;
    public static ResultSet rs;
    
    public static String user = "gdwphleizgdfozse";
    public static String password = "yvPeH2sbS6u2eXaHm4PHEhRfhiCGiT2EcT8yy3RvW32ufrqfpGbNpjMqMJ6ywTZ7";
    
    static void testeDoDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Driver instalado corretamente.");
        } catch (Exception e) {
            System.out.println("Falha no teste do driver!");
            e.printStackTrace();
        }
    }
    
    // MÉTODOS PARA CLIENTES
    public void inserirCliente(int id, String cpf, String nome, String telefone, String email) {
        try {
            conexao = DriverManager.getConnection(url, user, password);
            ps = conexao.prepareStatement("INSERT INTO CLIENTE (ID_CLIENTE, NOME, CPF, TELEFONE, EMAIL) VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, id);
            ps.setString(2, nome);
            ps.setString(3, cpf);
            ps.setString(4, telefone);
            ps.setString(5, email);

            ps.executeUpdate();
            System.out.println("Sucesso na inserção de Cliente");
        } catch (SQLException e) {
            System.out.println("Deu merda na inserção de Cliente");
            e.printStackTrace();
        } finally {
            try {
                if (conexao != null) conexao.close();
                System.out.println("Conexão com MySQL encerrada com sucesso");
            } catch (SQLException ex) {
                System.out.println("Não deu pra fechar a conexão com o Banco");
            }
        }
    }
    
    public void deletarCliente(int idCliente) {
        try {
            conexao = DriverManager.getConnection(url, user, password);
            ps = conexao.prepareStatement("DELETE FROM CLIENTE WHERE ID_CLIENTE = ?");
            
            ps.setInt(1, idCliente);
            
            ps.executeUpdate();
            
            System.out.println("Cliente deletado com sucesso");
        } catch (SQLException ex) {
            System.out.println("Falha ao tentar excluir o cliente");
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (conexao != null) conexao.close();
                System.out.println("Conexão com MySQL encerrada com sucesso");
            } catch (SQLException ex) {
                System.out.println("Não deu pra fechar a conexão com o Banco");
            }
        }
    }   
    
    // MÉTODOS PARA PROJETOS
    public void inserirProjeto(int idProjeto, String titulo, String descricao, String cpfCliente, LocalDate inicio, LocalDate fim) {
        try {
            conexao = DriverManager.getConnection(url, user, password);
            ps = conexao.prepareStatement("INSERT INTO PROJETO (ID_PROJETO, TITULO, DESCRICAO, CPF, INICIO, FIM) VALUES (?, ?, ?, ?, ?, ?)");
            
            ps.setInt(1, idProjeto);
            ps.setString(2, titulo);
            ps.setString(3, descricao);
            ps.setString(4, cpfCliente);
            ps.setDate(5, java.sql.Date.valueOf(inicio));
            ps.setDate(6, java.sql.Date.valueOf(fim));

            ps.executeUpdate();
            
            System.out.print(inicio);
            System.out.println("Sucesso na inserção de Projeto");
            
        } catch (SQLException e) {
            System.out.println("Deu merda na inserção de Projeto");
            e.printStackTrace();
        } finally {
            try {
                if (conexao != null) conexao.close();
                System.out.println("Conexão com MySQL encerrada com sucesso");
            } catch (SQLException ex) {
                System.out.println("Não deu pra fechar a conexão com o Banco");
            }
        }
    }
    
    public void deletarProjeto(int idProjeto) {
        try {
            conexao = DriverManager.getConnection(url, user, password);
            ps = conexao.prepareStatement("DELETE FROM PROJETO WHERE ID_PROJETO = ?");
            
            ps.setInt(1, idProjeto);
            
            ps.executeUpdate();
            
            System.out.println("Projeto deletado com sucesso");
            
        } catch (SQLException ex) {
            System.out.println("Falha ao tentar excluir o projeto");
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (conexao != null) conexao.close();
                System.out.println("Conexão com MySQL encerrada com sucesso");
            } catch (SQLException ex) {
                System.out.println("Não deu pra fechar a conexão com o Banco");
            }
        }
    }
    
    //MÉTODOS PARA DEPARTAMENTOS
    public void inserirDepartamento(int idDepartamento, String nomeDepto, String descricao) {
        try {
            conexao = DriverManager.getConnection(url, user, password);
            ps = conexao.prepareStatement("INSERT INTO DEPARTAMENTO (ID_DEPTO, DEPARTAMENTO, DESCRICAO) VALUES (?, ?, ?)");
            
            ps.setInt(1, idDepartamento);
            ps.setString(2, nomeDepto);
            ps.setString(3, descricao);

            ps.executeUpdate();
            
            System.out.println("Sucesso na inserção de Departamento");
            
        } catch (SQLException e) {
            System.out.println("Deu merda na inserção de Departamento");
            e.printStackTrace();
        } finally {
            try {
                if (conexao != null) conexao.close();
                System.out.println("Conexão com MySQL encerrada com sucesso");
            } catch (SQLException ex) {
                System.out.println("Não deu pra fechar a conexão com o Banco");
            }
        }
    }
    
    public void deletarDepto(int idDepto) {
        try {
            conexao = DriverManager.getConnection(url, user, password);
            ps = conexao.prepareStatement("DELETE FROM DEPARTAMENTO WHERE ID_DEPTO = ?");
            
            ps.setInt(1, idDepto);
            
            ps.executeUpdate();
            
            System.out.println("Departamento deletado com sucesso");
            
        } catch (SQLException ex) {
            System.out.println("Falha ao tentar excluir o Departamento");
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (conexao != null) conexao.close();
                System.out.println("Conexão com MySQL encerrada com sucesso");
            } catch (SQLException ex) {
                System.out.println("Não deu pra fechar a conexão com o Banco");
            }
        }
    }
    
    // MÉTODOS PARA FUNCIONÁRIOS
    public void inserirFuncionario(int idFuncionario, String nome, String cpf, int idDepto) {
        try {
            conexao = DriverManager.getConnection(url, user, password);
            ps = conexao.prepareStatement("INSERT INTO FUNCIONARIO (ID_FUNCIONARIO, NOME, CPF, ID_DEPTO) VALUES (?, ?, ?, ?)");
            
            ps.setInt(1, idFuncionario);
            ps.setString(2, nome);
            ps.setString(3, cpf);
            ps.setInt(4, idDepto);
            
            ps.executeUpdate();
            
            System.out.println("Sucesso na inserção de Funcionário");
            
        } catch (SQLException e) {
            System.out.println("Deu merda na inserção de Funcionário");
            e.printStackTrace();
        } finally {
            try {
                if (conexao != null) conexao.close();
                System.out.println("Conexão com MySQL encerrada com sucesso");
            } catch (SQLException ex) {
                System.out.println("Não deu pra fechar a conexão com o Banco");
            }
        }
    }
    
    public void deletarFuncionario(int idFuncionario) {
        try {
            conexao = DriverManager.getConnection(url, user, password);
            ps = conexao.prepareStatement("DELETE FROM FUNCIONARIO WHERE ID_FUNCIONARIO = ?");
            
            ps.setInt(1, idFuncionario);
            
            ps.executeUpdate();
            
            System.out.println("Funcionário deletado com sucesso");
            
        } catch (SQLException ex) {
            System.out.println("Falha ao tentar excluir o Funcionário");
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (conexao != null) conexao.close();
                System.out.println("Conexão com MySQL encerrada com sucesso");
            } catch (SQLException ex) {
                System.out.println("Não deu pra fechar a conexão com o Banco");
            }
        }
    }
}
