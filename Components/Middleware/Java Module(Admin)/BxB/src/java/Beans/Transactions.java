/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Vash
 */
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Transactions implements Convertable {
    private int idTransaction;
    private Timestamp transDate;
    private int appointmentNo;

    public Transactions() {
    }

    public Transactions(int idTransaction, Timestamp transDate, int appointmentNo) {
        this.idTransaction = idTransaction;
        this.transDate = transDate;
        this.appointmentNo = appointmentNo;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public void setTransDate(Timestamp transDate) {
        this.transDate = transDate;
    }

    public void setAppointmentNo(int appointmentNo) {
        this.appointmentNo = appointmentNo;
    }

    public int getIdTransaction() {
        return idTransaction;
    }

    public Timestamp getTransDate() {
        return transDate;
    }

    public int getAppointmentNo() {
        return appointmentNo;
    }

    @Override
    public String toString() {
        return "Transactions{" + "idTransaction=" + idTransaction + ", transDate=" + transDate + ", appointmentNo=" + appointmentNo + '}';
    }

    @Override
    public ArrayList<Transactions> toArrayList(ResultSet results) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
