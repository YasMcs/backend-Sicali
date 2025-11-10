package org.sicali.models;

public class Usuario {
    private int id_usuario;
    private String nombre;
    private String ape_p;
    private String ape_m;
    private String curp;
    private String rfc;
    private String sexo;
    private String usuario;
    private String password;
    private String rol;
    private boolean habilitado;

    public Usuario(int id_usuario, String nombre, String ape_p, String ape_m, String curp, String rfc, String sexo, String usuario, String password, String rol, boolean habilitado) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.ape_p = ape_p;
        this.ape_m = ape_m;
        this.curp = curp;
        this.rfc = rfc;
        this.sexo = sexo;
        this.usuario = usuario;
        this.password = password;
        this.rol = rol;
        this.habilitado = habilitado;
    }

    public int getId_usuario() { return id_usuario; }
    public void setId_usuario(int id_usuario) { this.id_usuario = id_usuario; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApe_p() { return ape_p; }
    public void setApe_p(String ape_p) { this.ape_p = ape_p; }

    public String getApe_m() { return ape_m; }
    public void setApe_m(String ape_m) { this.ape_m = ape_m; }

    public String getCurp() { return curp; }
    public void setCurp(String curp) { this.curp = curp; }

    public String getRfc() { return rfc; }
    public void setRfc(String rfc) { this.rfc = rfc; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public boolean isHabilitado() { return habilitado; }
    public void setHabilitado(boolean habilitado) { this.habilitado = habilitado; }
}