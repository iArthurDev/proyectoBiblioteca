/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.Date;

/**
 *
 * @author ldoar
 */
public class Prestamo {
    private int idPrestamo;
    private Usuario idUsuario;
    private Date fechaPrestamo;
    private Date fechaEntrega;
    private String estado;
    private int aumentoFecha;
    private double multa;
    private int cantidadLibros;

    public Prestamo() {
    }

    public Prestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Prestamo(Usuario idUsuario, Date fechaPrestamo, Date fechaEntrega, String estado, int aumentoFecha, double multa, int cantidadLibros) {
        this.idUsuario = idUsuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.aumentoFecha = aumentoFecha;
        this.multa = multa;
        this.cantidadLibros = cantidadLibros;
    }

    public Prestamo(int idPrestamo, Usuario idUsuario, Date fechaPrestamo, Date fechaEntrega, String estado, int aumentoFecha, double multa, int cantidadLibros) {
        this.idPrestamo = idPrestamo;
        this.idUsuario = idUsuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.aumentoFecha = aumentoFecha;
        this.multa = multa;
        this.cantidadLibros = cantidadLibros;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getAumentoFecha() {
        return aumentoFecha;
    }

    public void setAumentoFecha(int aumentoFecha) {
        this.aumentoFecha = aumentoFecha;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public int getCantidadLibros() {
        return cantidadLibros;
    }

    public void setCantidadLibros(int cantidadLibros) {
        this.cantidadLibros = cantidadLibros;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "idPrestamo=" + idPrestamo + ", idUsuario=" + idUsuario + ", fechaPrestamo=" + fechaPrestamo + ", fechaEntrega=" + fechaEntrega + ", estado=" + estado + ", aumentoFecha=" + aumentoFecha + ", multa=" + multa + ", cantidadLibros=" + cantidadLibros + '}';
    }
 
}
