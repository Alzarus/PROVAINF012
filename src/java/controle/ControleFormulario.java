/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DAOSQL;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.Dependent;

import javax.inject.Named;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import negocio.Formulario;

/**
 *
 * @author Pedro
 */
@ManagedBean(name = "controleformulario")
@SessionScoped
public class ControleFormulario {

    public ControleFormulario() {
        this.formulario = new Formulario();
    }

    public void enviar() {
        try {
            connect();
            FacesContext context = FacesContext.getCurrentInstance();
            if(this.sql.insertForm(this.formulario)){
                context.addMessage(null, new FacesMessage("Sucesso ao inserir o formulário!"));
            } else {
                context.addMessage(null, new FacesMessage("Falha ao inserir o formulário!"));
            }
        } catch (Exception ex) {
            Logger.getLogger(ControleFormulario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connect() throws Exception {
        this.sql = DAOSQL.getInstance();
    }

    public Formulario getFormulario() {
        return formulario;
    }

    private DAOSQL sql;
    private Formulario formulario;

}
