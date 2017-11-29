/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author rbenvenuto
 */
public class Cliente {
    public SimpleIntegerProperty idCliente = new SimpleIntegerProperty();
    public SimpleStringProperty cpf = new SimpleStringProperty();
    public SimpleStringProperty nome = new SimpleStringProperty();
    public SimpleStringProperty telefone = new SimpleStringProperty();
    public SimpleStringProperty email = new SimpleStringProperty();
    
    // get/set ID_CLIENTE
    public int getIDCliente() {
        return idCliente.get();
    }
    
    public void setIDCliente(int id) {
        this.idCliente.set(id);
    }
    
    // get/set CPF
    public String getCPF() {
        return cpf.get();
    }
    
    public void setCPF(String cpf) {
        this.cpf.set(cpf);
    }
    
    // get/set Nome
    public String getNome() {
        return nome.get();
    }
    
    public void setNome(String nome) {
        this.nome.set(nome);
    }
    
    // get/set Telefone
    public String getTelefone() {
        return this.telefone.get();
    }
    
    public void setTelefone(String telefone) {
        this.telefone.set(telefone);
    }
    
    // get/set Email
    public String getEmail() {
        return this.email.get();
    }
    
    public void setEmail(String email) {
        this.email.set(email);
    }
}