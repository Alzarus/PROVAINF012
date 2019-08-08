/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DAOSQL;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import negocio.Formulario;

/**
 *
 * @author Pedro
 */
@ManagedBean(name = "controleCadastrados")
@ViewScoped
public class ControleCadastrados {

    private ArrayList<Formulario> formularios = new ArrayList<Formulario>();
    private DAOSQL sql;
    private String id;

    public ControleCadastrados() {
        try {
            connect();
            this.formularios = this.sql.getAllResults();
        } catch (SQLException ex) {
            Logger.getLogger(ControleCadastrados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ControleCadastrados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connect() throws Exception {
        this.sql = DAOSQL.getInstance();
    }

    public void excluir() {
        try {
            connect();
            FacesContext context = FacesContext.getCurrentInstance();
            if (this.sql.deleteRow(this.getId())) {
                context.addMessage(null, new FacesMessage("Sucesso ao remover o formulario!"));
            } else {
                context.addMessage(null, new FacesMessage("Falha ao remover o formulario!"));
            }
        } catch (Exception ex) {
            Logger.getLogger(ControleFormulario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editar(){
        
    }

    public ArrayList<Formulario> getFormularios() {
        return formularios;
    }

    public void setFormularios(ArrayList<Formulario> formularios) {
        this.formularios = formularios;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
