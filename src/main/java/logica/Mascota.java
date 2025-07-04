package logica;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Mascota {
    // atributos de las mascotas
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idMascota;
    private String nombre;
    private String raza;
    private String color;
    private String observacion;
    private String alergico;
    private String atencionEspecial;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Duenio duenio;
    
    // constructores
    public Mascota() {
    }

    public Mascota(int idMascota, String nombre, String raza, String color,
            String observacion, String alergico, String atencionEspecial, Duenio duenio) {
        this.idMascota = idMascota;
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
        this.observacion = observacion;
        this.alergico = alergico;
        this.atencionEspecial = atencionEspecial;
        this.duenio = duenio;
    }
    
    // GETTERS AND SETTERS
    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String Raza) {
        this.raza = Raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getAlergico() {
        return alergico;
    }

    public void setAlergico(String alergico) {
        this.alergico = alergico;
    }

    public String getAtencionEspecial() {
        return atencionEspecial;
    }

    public void setAtencionEspecial(String atencionEspeccial) {
        this.atencionEspecial = atencionEspeccial;
    }

    public Duenio getDuenio() {
        return duenio;
    }

    public void setDuenio(Duenio duenio) {
        this.duenio = duenio;
    }
}