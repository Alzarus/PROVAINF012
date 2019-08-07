/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.DAOSQL;
import java.io.Serializable;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import negocio.Formulario;

/**
 *
 * @author Pedro
 */
@ManagedBean(name = "controlecadastrados")
@ViewScoped
public class ControleCadastrados implements Serializable {

    private ArrayList<Formulario> formularios;
    @ManagedProperty("#{DAOSQL}")
    private DAOSQL sql;

    public ControleCadastrados() {
        init();
    }
//    https://www.primefaces.org/showcase/ui/data/dataGrid.xhtml
//https://www.primefaces.org/showcase/ui/data/datatable/basic.xhtml
    @PostConstruct
    public void init() {
        try {
            setSql();
            this.formularios = this.sql.getAllResults();
        } catch (SQLException ex) {
            Logger.getLogger(ControleCadastrados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ControleCadastrados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setSql() throws Exception {
        this.sql = DAOSQL.getInstance();
    }

    public ArrayList<Formulario> getFormularios() {
        return formularios;
    }

    public void setFormularios(ArrayList<Formulario> formularios) {
        this.formularios = formularios;
    }

}
