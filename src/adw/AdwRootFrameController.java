/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adw;

import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.DatePicker;
import javafx.util.Callback;

import persistencia.*;
import static persistencia.BancoDados.*;

/**
 * FXML Controller class
 *
 * @author rbenvenuto
 */
public class AdwRootFrameController implements Initializable {
    
    public static ObservableList <Cliente> olClientes = FXCollections.observableArrayList();
    public static ObservableList <Projeto> olProjetos = FXCollections.observableArrayList();
    public static ObservableList <Departamento> olDepartamentos = FXCollections.observableArrayList();
    public static ObservableList <Funcionario> olFuncionarios = FXCollections.observableArrayList();
    
    @FXML private TableView<Cliente> tvConsultaClientes;
    @FXML private TableView<Projeto> tvConsultaProjetos;
    @FXML private TableView<Departamento> tvConsultaDepartamentos;
    @FXML private TableView<Funcionario> tvConsultaFuncionarios;
    
    @FXML private TableColumn<Cliente, String> tcNome = new TableColumn<Cliente, String>("Nome");
    @FXML private TableColumn<Cliente, String> tcCPF = new TableColumn<Cliente, String>("CPF");
    @FXML private TableColumn<Cliente, String> tcTelefone = new TableColumn<Cliente, String>("Telefone");
    @FXML private TableColumn<Cliente, String> tcEmail = new TableColumn<Cliente, String>("E-mail");
    
    @FXML private TableColumn<Projeto, String> tcTituloProjeto = new TableColumn<Projeto, String>("Titulo");
    @FXML private TableColumn<Projeto, String> tcDescricaoProjeto = new TableColumn<Projeto, String>("Descricao");
    @FXML private TableColumn<Projeto, String> tcCPFProjeto = new TableColumn<Projeto, String>("CPF");
    @FXML private TableColumn<Projeto, Date> tcInicioProjeto = new TableColumn<Projeto, Date>("Inicio");
    @FXML private TableColumn<Projeto, Date> tcFimProjeto = new TableColumn<Projeto, Date>("Fim");
    
    @FXML private TableColumn<Departamento, String> tcDepartamento = new TableColumn<Departamento, String>("Departamento");
    @FXML private TableColumn<Departamento, String> tcDescricao = new TableColumn<Departamento, String>("Descricao");
    
    @FXML private TableColumn<Funcionario, String> tcNomeFuncionario = new TableColumn<Funcionario, String>("Nome");
    @FXML private TableColumn<Funcionario, String> tcCPFFuncionario = new TableColumn<Funcionario, String>("CPF");
    @FXML private TableColumn<Funcionario, Integer> tcIDDepto = new TableColumn<Funcionario, Integer>("DEPTO");
    
    // CLIENTES
    @FXML
    private Tab tabClientes;
    
    @FXML
    private Label lblNome;
    
    @FXML
    private TextField fieldNome;
    
    @FXML
    private Label lblCPF;
    
    @FXML
    private TextField fieldCPF;
    
    @FXML
    private Label lblTelefone;
    
    @FXML
    private TextField fieldTelefone;
    
    @FXML
    private Label lblEmail;
    
    @FXML
    private TextField fieldEmail;
    
    @FXML
    private Button btnCadastrar;
    
    @FXML
    private Button btnAtualizar;
    
    @FXML
    private Button btnApagarCliente;
    
    // PROJETOS
    @FXML
    private Tab tabProjetos;
    
    @FXML
    private Label lblNomeProjeto;
    
    @FXML
    private TextField fieldNomeProjeto;
    
    @FXML
    private Label lblDescProjeto;
    
    @FXML
    private TextField fieldDescProjeto;
    
    @FXML
    private Label lblCPFClienteProjeto;
    
    @FXML
    private TextField fieldCPFClienteProjeto;
    
    @FXML
    private Label lblDTInicio;
    
    @FXML
    private DatePicker fieldDTInicio;
    
    @FXML
    private Label lblDTFim;
    
    @FXML
    private DatePicker fieldDTFim;
    
    @FXML
    private Button btnAtualizarProjetos;
    
    @FXML
    private Button btnDeletarProjeto;
    
    // DEPARTAMENTOS
    @FXML
    private Tab tabDepartamentos;
    
    @FXML
    private Label lblNomeDepto;
    
    @FXML
    private TextField fieldNomeDepto;
    
    @FXML
    private Label lblDescricaoDepto;
    
    @FXML
    private TextField fieldDescricaoDepto;
    
    @FXML
    private Button btnCadastrarDepartamento;
    
    @FXML
    private Button btnAtualizarDepartamentos;
    
    @FXML
    private Button btnDeletarDepartamento;
    
    // FUNCIONARIOS
    @FXML
    private Tab tabFuncionarios;
    
    @FXML
    private Label lblNomeFuncionario;
    
    @FXML
    private TextField fieldNomeFuncionario;
    
    @FXML
    private Label lblCPFFuncionario;
    
    @FXML
    private TextField fieldCPFFuncionario;
    
    @FXML
    private Label lblIDDepto;
    
    @FXML
    private TextField fieldIDDepto;
    
    @FXML
    private Button btnCadastrarFuncionario;
    
    @FXML
    private Button btnDeletarFuncionario;
    
    @FXML
    private Button btnAtualizarFuncionarios;
    
    // MÉTODOS PARA CLIENTES
    @FXML
    public void cadastrarCliente() {
        BancoDados bd = new BancoDados();
        Random random = new Random();
        
        bd.inserirCliente(
                random.nextInt() & Integer.MAX_VALUE, //evitar números negativos
                fieldCPF.getText(),
                fieldNome.getText(),                
                fieldTelefone.getText(),
                fieldEmail.getText()
            );
        fieldNome.clear();
        fieldCPF.clear();
        fieldTelefone.clear();
        fieldEmail.clear();
        this.atualizarClientes();
    }
    
    @FXML
    public void excluirCliente() {
        BancoDados bd = new BancoDados();
        
        bd.deletarCliente(
                tvConsultaClientes.getSelectionModel().getSelectedItem().getIDCliente()
        );
        
        this.atualizarClientes();
    }
    
    @FXML
    public void atualizarClientes() {
        olClientes.clear();
        buildClientes();
    }
    
    public void buildClientes() {
        try {
            conexao = DriverManager.getConnection(url, user, password);
            ps = conexao.prepareStatement("SELECT * FROM CLIENTE;");
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                Cliente rowCliente = new Cliente();
                
                rowCliente.setIDCliente(rs.getInt("ID_CLIENTE"));
                rowCliente.setNome(rs.getString("NOME"));
                rowCliente.setCPF(rs.getString("CPF"));
                rowCliente.setTelefone(rs.getString("TELEFONE"));
                rowCliente.setEmail(rs.getString("EMAIL"));
              
                olClientes.add(rowCliente);
                System.out.print(olClientes.get(i).getNome() + "\n");
                i++;
            }
            
            tvConsultaClientes.setItems(olClientes);
            
        } catch (SQLException ex) {
            System.out.println("Falha na conexão com o Banco para consultar Clientes!");
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (conexao != null) conexao.close();
                System.out.println("A conexão com o MySQL foi encerrada.");
            } catch (SQLException ex) {
                System.out.println("Deu merda pra encerrar a conexão");
                System.out.println(ex.getMessage());
            }
        }
    }
    
    // MÉTODOS PARA PROJETOS
    public void cadastrarProjeto() {
        BancoDados bd = new BancoDados();
        Random random = new Random();
        
        bd.inserirProjeto(
                random.nextInt() & Integer.MAX_VALUE, //evitar números negativos
                fieldNomeProjeto.getText(),
                fieldDescProjeto.getText(),
                fieldCPFClienteProjeto.getText(),
                fieldDTInicio.getValue(),
                fieldDTFim.getValue()
            );
        fieldNomeProjeto.clear();
        fieldDescProjeto.clear();
        fieldCPFClienteProjeto.clear();
        
        this.atualizarProjetos();
    }
    
    @FXML
    public void excluirProjeto() {
        BancoDados bd = new BancoDados();
        
        bd.deletarProjeto(
              tvConsultaProjetos.getSelectionModel().getSelectedItem().getID_PROJETO()
        );
        
        this.atualizarProjetos();
    }
    
    @FXML
    void atualizarProjetos() {
        olProjetos.clear();
        buildProjetos();
    }
    
    public void buildProjetos() {
        try {
            conexao = DriverManager.getConnection(url, user, password);
            ps = conexao.prepareStatement("SELECT * FROM PROJETO;");
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                Projeto rowProjeto = new Projeto();
                
                rowProjeto.setID_PROJETO(rs.getInt("ID_PROJETO"));
                rowProjeto.setTitulo(rs.getString("TITULO"));
                rowProjeto.setDescricao(rs.getString("DESCRICAO"));
                rowProjeto.setCPF(rs.getString("CPF"));
                rowProjeto.setInicio(rs.getDate("INICIO"));
                rowProjeto.setFim(rs.getDate("FIM"));
              
                olProjetos.add(rowProjeto);
                //System.out.print(olProjetos.get(i).getTitulo() + " - " + olProjetos.get(i).getDescricao() + " - " + olProjetos.get(i).getCPFCliente() + " - " + olProjetos.get(i).getDataInicioProjeto() + "\n");
                i++;
            }
            
            tvConsultaProjetos.setItems(olProjetos);
            
        } catch (SQLException ex) {
            System.out.println("Falha na conexão com o Banco para consultar Clientes!");
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (conexao != null) conexao.close();
                System.out.println("A conexão com o MySQL foi encerrada.");
            } catch (SQLException ex) {
                System.out.println("Deu merda pra encerrar a conexão");
                System.out.println(ex.getMessage());
            }
        }
    }
    
    // MÉTODOS PARA DEPARTAMENTOS
    @FXML
    public void cadastrarDepartamento() {
        BancoDados bd = new BancoDados();
        Random random = new Random();
        
        bd.inserirDepartamento(
                random.nextInt() & Integer.MAX_VALUE, //evitar números negativos
                fieldNomeDepto.getText(),
                fieldDescricaoDepto.getText()
            );
        fieldNomeDepto.clear();
        fieldDescricaoDepto.clear();
        this.atualizarDepartamentos();
    }
    
    @FXML
    public void excluirDepto() {
        BancoDados bd = new BancoDados();
        
        bd.deletarDepto(
              tvConsultaDepartamentos.getSelectionModel().getSelectedItem().getID()
        );
        
        this.atualizarDepartamentos();
    }
    
    @FXML
    void atualizarDepartamentos() {
        olDepartamentos.clear();
        buildDepartamentos();
    }
    
    public void buildDepartamentos() {
        try {
            conexao = DriverManager.getConnection(url, user, password);
            ps = conexao.prepareStatement("SELECT * FROM DEPARTAMENTO;");
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                Departamento rowDepartamento = new Departamento();
                
                rowDepartamento.setID(rs.getInt("ID_DEPTO"));
                rowDepartamento.setDepartamento(rs.getString("DEPARTAMENTO"));
                rowDepartamento.setDescricao(rs.getString("DESCRICAO"));
              
                olDepartamentos.add(rowDepartamento);
                //System.out.print(olProjetos.get(i).getTitulo() + " - " + olProjetos.get(i).getDescricao() + " - " + olProjetos.get(i).getCPFCliente() + " - " + olProjetos.get(i).getDataInicioProjeto() + "\n");
                i++;
            }
            
            tvConsultaDepartamentos.setItems(olDepartamentos);
            
        } catch (SQLException ex) {
            System.out.println("Falha na conexão com o Banco para consultar Departamentos!");
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (conexao != null) conexao.close();
                System.out.println("A conexão com o MySQL foi encerrada.");
            } catch (SQLException ex) {
                System.out.println("Deu merda pra encerrar a conexão");
                System.out.println(ex.getMessage());
            }
        }
    }
    
    // MÉTODOS PARA FUNCIONÁRIOS
    @FXML
    public void cadastrarFuncionario() {
        BancoDados bd = new BancoDados();
        Random random = new Random();
        
        bd.inserirFuncionario(
                random.nextInt() & Integer.MAX_VALUE, //evitar números negativos
                fieldNomeFuncionario.getText(),
                fieldCPFFuncionario.getText(),
                Integer.parseInt(fieldIDDepto.getText())
            );
        fieldNomeFuncionario.clear();
        fieldCPFFuncionario.clear();
        fieldIDDepto.clear();
        
        this.atualizarFuncionarios();
    }
    
    @FXML
    public void excluirFuncionario() {
        BancoDados bd = new BancoDados();
        
        bd.deletarFuncionario(
              tvConsultaFuncionarios.getSelectionModel().getSelectedItem().getID()
        );
        
        this.atualizarFuncionarios();
    }
    
    @FXML
    void atualizarFuncionarios() {
        olFuncionarios.clear();
        buildFuncionarios();
    }
    
    public void buildFuncionarios() {
        try {
            conexao = DriverManager.getConnection(url, user, password);
            ps = conexao.prepareStatement("SELECT * FROM FUNCIONARIO;");
            rs = ps.executeQuery();
            int i = 0;
            while (rs.next()) {
                Funcionario rowFuncionario = new Funcionario();
                
                rowFuncionario.setID(rs.getInt("ID_DEPTO"));
                rowFuncionario.setNome(rs.getString("NOME"));
                rowFuncionario.setCPF(rs.getString("CPF"));
                rowFuncionario.setDEPTO(rs.getInt("ID_DEPTO"));
              
                olFuncionarios.add(rowFuncionario);
                //System.out.print(olProjetos.get(i).getTitulo() + " - " + olProjetos.get(i).getDescricao() + " - " + olProjetos.get(i).getCPFCliente() + " - " + olProjetos.get(i).getDataInicioProjeto() + "\n");
                i++;
            }
            
            tvConsultaFuncionarios.setItems(olFuncionarios);
            
        } catch (SQLException ex) {
            System.out.println("Falha na conexão com o Banco para consultar Funcionários!");
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (conexao != null) conexao.close();
                System.out.println("A conexão com o MySQL foi encerrada.");
            } catch (SQLException ex) {
                System.out.println("Deu merda pra encerrar a conexão");
                System.out.println(ex.getMessage());
            }
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //olClientes = observableArrayList();
        
        tcNome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("Nome"));
        tcCPF.setCellValueFactory(new PropertyValueFactory<Cliente, String>("CPF"));
        tcTelefone.setCellValueFactory(new PropertyValueFactory<Cliente, String>("Telefone"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<Cliente, String>("Email"));
        
        tcTituloProjeto.setCellValueFactory(new PropertyValueFactory<Projeto, String>("Titulo"));
        tcDescricaoProjeto.setCellValueFactory(new PropertyValueFactory<Projeto, String>("Descricao"));
        tcCPFProjeto.setCellValueFactory(new PropertyValueFactory<Projeto, String>("CPF"));
        tcInicioProjeto.setCellValueFactory(new PropertyValueFactory<Projeto, Date>("Inicio"));
        tcFimProjeto.setCellValueFactory(new PropertyValueFactory<Projeto, Date>("Fim"));
        
        tcDepartamento.setCellValueFactory(new PropertyValueFactory<Departamento, String>("Departamento"));
        tcDescricao.setCellValueFactory(new PropertyValueFactory<Departamento, String>("Descricao"));
        
        tcNomeFuncionario.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("Nome"));
        tcCPFFuncionario.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("CPF"));
        tcIDDepto.setCellValueFactory(new PropertyValueFactory<Funcionario, Integer>("DEPTO"));
        
        this.atualizarClientes();
        this.atualizarProjetos();
        this.atualizarDepartamentos();
        this.atualizarFuncionarios();
    }
}
