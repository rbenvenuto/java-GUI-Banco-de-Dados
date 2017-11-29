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
public class Departamento {
    SimpleIntegerProperty idDepartamento = new SimpleIntegerProperty();
    SimpleStringProperty nomeDepartamento = new SimpleStringProperty();
    SimpleStringProperty descricaoDepartamento = new SimpleStringProperty();
    
    // get/set ID
    public int getID() {
        return idDepartamento.get();
    }
    
    public void setID(int id) {
        idDepartamento.set(id);
    }
    
    // get/set DEPARTAMENTO
    public String getDepartamento() {
        return nomeDepartamento.get();
    }
    
    public void setDepartamento(String depto) {
        nomeDepartamento.set(depto);
    }
    
    // get/set DESCRICAO
    public String getDescricao() {
        return descricaoDepartamento.get();
    }
    
    public void setDescricao(String descricao) {
        descricaoDepartamento.set(descricao);
    }
}
