/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author rbenvenuto
 */
public class Funcionario {
    public SimpleIntegerProperty idFuncionario = new SimpleIntegerProperty();
    public SimpleStringProperty nomeFuncionario = new SimpleStringProperty();
    public SimpleStringProperty cpfFuncionario = new SimpleStringProperty();
    public SimpleIntegerProperty idDepto = new SimpleIntegerProperty();
    
    //get/set ID
    public int getID() {
        return idFuncionario.get();
    }
    
    public void setID(int id) {
        idFuncionario.set(id);
    }
    
    // get/set NOME
    public String getNome() {
        return nomeFuncionario.get();
    }
    
    public void setNome(String nome) {
        nomeFuncionario.set(nome);
    }
    
    // get/set CPF
    public String getCPF() {
        return cpfFuncionario.get();
    }
    
    public void setCPF(String cpf) {
        cpfFuncionario.set(cpf);
    }
    
    // get/set ID_DEPTO
    public int getDEPTO() {
        return idDepto.get();
    }
    
    public void setDEPTO(int id) {
        idDepto.set(id);
    }
}
