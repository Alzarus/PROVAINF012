/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import negocio.Formulario;

/**
 *
 * @author Pedro
 */
public class DAOSQL {

    private static DAOSQL INSTANCE = null;
    private static final String DRIVER_NAME = "org.sqlite.JDBC";
    private static final String DB_URL = "jdbc:sqlite:C:\\Users\\Administrador\\Documents\\PROVAINF012\\barril.db";
    private static final String DB_USER = "teste";
    private static final String DB_PWD = "teste";
    private static final String GET_LAST_ID = "SELECT MAX(ID) FROM FORMULARIO";
    private static final String INSERT_FORM = "INSERT INTO FORMULARIO "
            + "(DESTINATARIO, TELEFAXDESTINATARIO, EMAILDESTINATARIO,"
            + "REMETENTE, TELEFAXREMETENTE, EMAILREMETENTE, DATAENVIO) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_ALL_ROWS = "SELECT * FROM FORMULARIO";
//    private static final String DELETE_ROW = "DELETE FORMULARIO WHERE ";
    private Connection con = null;
    private int id;

    private DAOSQL() throws SQLException, ClassNotFoundException {
        Class.forName(DAOSQL.DRIVER_NAME);
        this.con = this.getConnection();
    }

    public static DAOSQL getInstance() {
        if (INSTANCE == null) {
            try {
                INSTANCE = new DAOSQL();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                Logger.getLogger(DAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return INSTANCE;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DAOSQL.DB_URL, DAOSQL.DB_USER, DAOSQL.DB_PWD);
    }

    public boolean insertForm(Formulario formulario) {
        try {
//            PreparedStatement stmt = this.con.prepareStatement(DAOSQL.GET_LAST_ID);
//            ResultSet rs = stmt.executeQuery();

//            this.id = ((Number) rs.getObject(1)).intValue() + 1;
//            this.id = 1;
            String destinatario = formulario.getDestinatario();
            String telefaxDestinatario = formulario.getTelefaxDestinatario();
            String emailDestinatario = formulario.getEmailDestinatario();
            String remetente = formulario.getRemetente();
            String telefaxRemetente = formulario.getTelefaxRemetente();
            String emailRemetente = formulario.getEmailRemetente();
            Date dataEnvio = formulario.getDataEnvio();
            PreparedStatement stmt;
            stmt = this.con.prepareStatement(DAOSQL.INSERT_FORM);
//            stmt.setInt(1, id);
            stmt.setString(1, destinatario);
            stmt.setString(2, telefaxDestinatario);
            stmt.setString(3, emailDestinatario);
            stmt.setString(4, remetente);
            stmt.setString(5, telefaxRemetente);
            stmt.setString(6, emailRemetente);
            stmt.setString(7, dataEnvio.toString());
//            stmt.setDate(8, (java.sql.Date) dataEnvio);

            boolean rSet = stmt.execute();
            stmt.close();
//            this.con.close();

//            if(rSet.rowInserted()){
//                return true;
//            }
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ArrayList<Formulario> getAllResults() throws SQLException {
        Statement stmt = null;
        Formulario formulario = new Formulario();
        ArrayList<Formulario> formularios = new ArrayList<>();
        Date data = null;

        try {
            stmt = this.con.createStatement();
            ResultSet rs = stmt.executeQuery(DAOSQL.GET_ALL_ROWS);
            while (rs.next()) {
                formulario.setDestinatario(rs.getString("DESTINATARIO"));
                formulario.setTelefaxDestinatario(rs.getString("TELEFAXDESTINATARIO"));
                formulario.setEmailDestinatario(rs.getString("EMAILDESTINATARIO"));
                formulario.setRemetente(rs.getString("REMETENTE"));
                formulario.setTelefaxRemetente(rs.getString("TELEFAXREMETENTE"));
                formulario.setEmailRemetente(rs.getString("EMAILREMETENTE"));
                try { 
                    data = new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString("DATAENVIO"));
                    formulario.setDataEnvio(data);
                } catch (ParseException ex) {
                    Logger.getLogger(DAOSQL.class.getName()).log(Level.SEVERE, null, ex);
                }
                formularios.add(formulario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

        return formularios;
    }
    
    public boolean deleteRow(){
        
        
        return false;
    }
    
    public boolean editRow(){
        
        return false;
    }
}
