/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.Date;

/**
 *
 * @author Pedro
 */
public class Formulario {

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getTelefaxDestinatario() {
        return telefaxDestinatario;
    }

    public void setTelefaxDestinatario(String telefaxDestinatario) {
        this.telefaxDestinatario = telefaxDestinatario;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getTelefaxRemetente() {
        return telefaxRemetente;
    }

    public void setTelefaxRemetente(String telefaxRemetente) {
        this.telefaxRemetente = telefaxRemetente;
    }

    public String getEmailRemetente() {
        return emailRemetente;
    }

    public void setEmailRemetente(String emailRemetente) {
        this.emailRemetente = emailRemetente;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String destinatario;
    private String telefaxDestinatario;
    private String emailDestinatario;

    private String remetente;
    private String telefaxRemetente;
    private String emailRemetente;
    private String id;


    private Date dataEnvio;
}
