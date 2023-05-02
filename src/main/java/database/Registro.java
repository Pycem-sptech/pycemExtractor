/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.util.Date;

/**
 *
 * @author Usuário
 */
public class Registro {
    
    private Integer idRegistro;
    private String usoProcessador;
    private String usoRAM;
    private String usoHD;
    private String cpuStatus;
    private String ramStatus;
    private String hdStatus;
    private Date dataRegistro;
    private Integer fkTotem;

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getUsoProcessador() {
        return usoProcessador;
    }

    public void setUsoProcessador(String usoProcessador) {
        this.usoProcessador = usoProcessador;
    }

    public String getUsoRAM() {
        return usoRAM;
    }

    public void setUsoRAM(String usoRAM) {
        this.usoRAM = usoRAM;
    }

    public String getUsoHD() {
        return usoHD;
    }

    public void setUsoHD(String usoHD) {
        this.usoHD = usoHD;
    }

    public String getCpuStatus() {
        return cpuStatus;
    }

    public void setCpuStatus(String cpuStatus) {
        this.cpuStatus = cpuStatus;
    }

    public String getRamStatus() {
        return ramStatus;
    }

    public void setRamStatus(String ramStatus) {
        this.ramStatus = ramStatus;
    }

    public String getHdStatus() {
        return hdStatus;
    }

    public void setHdStatus(String hdStatus) {
        this.hdStatus = hdStatus;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Integer getFkTotem() {
        return fkTotem;
    }

    public void setFkTotem(Integer fkTotem) {
        this.fkTotem = fkTotem;
    }
    
    
}
