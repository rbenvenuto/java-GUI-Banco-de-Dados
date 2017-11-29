/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import java.util.Date;

/**
 *
 * @author rbenvenuto
 */
public class Projeto {
    public SimpleIntegerProperty idProjeto = new SimpleIntegerProperty();
    public SimpleStringProperty tituloProjeto = new SimpleStringProperty();
    public SimpleStringProperty descricaoProjeto = new SimpleStringProperty();
    public SimpleStringProperty cpfClienteProjeto = new SimpleStringProperty();
    public Date dtInicio = new Date();
    public Date dtFim = new Date();
    
    // get/set ID
    public int getID_PROJETO() {
        return idProjeto.get();
    }
    
    public void setID_PROJETO(int id) {
        this.idProjeto.set(id);
    }
    
    // get/set TITULO
    public String getTitulo() {
        return tituloProjeto.get();
    }
    
    public void setTitulo(String titulo) {
        this.tituloProjeto.set(titulo);
    }
    
    // get/set DESCRICAO
    public String getDescricao() {
        return descricaoProjeto.get();
    }
    
    public void setDescricao(String descricao) {
        this.descricaoProjeto.set(descricao);
    }
    
    // get/set CPFCLIENTE
    public String getCPF() {
        return cpfClienteProjeto.get();
    }
    
    public void setCPF(String cpf) {
        this.cpfClienteProjeto.set(cpf);
    }
    
    // get/set INICIO
    public Date getInicio() {
        return this.dtInicio;
    }
    
    public void setInicio(Date dtIni) {
        this.dtInicio = dtIni;
    }
    
    // get/set FIM
    public Date getFim() {
        return this.dtFim;
    }
    
    public void setFim(Date dtFim) {
        this.dtFim = dtFim;
    }
}
