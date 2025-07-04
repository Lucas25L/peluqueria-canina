package logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Duenio implements Serializable {
    // atributos del dueño
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idDuenio;
    private String nombreDuenio;
    private String numCelular;

    // constructores
    public Duenio() {
    }

    public Duenio(int idDuenio, String nombreDuenio, String numCelular) {
        this.idDuenio = idDuenio;
        this.nombreDuenio = nombreDuenio;
        this.numCelular = numCelular;
    }

    // GETTERS AND SETTERS
    public int getIdDuenio() {
        return idDuenio;
    }

    public void setIdDuenio(int idDueño) {
        this.idDuenio = idDueño;
    }

    public String getNombreDuenio() {
        return nombreDuenio;
    }

    public void setNombreDuenio(String nombreDueño) {
        this.nombreDuenio = nombreDueño;
    }

    public String getNumCelular() {
        return numCelular;
    }

    public void setNumCelular(String numCelular) {
        this.numCelular = numCelular;
    }
}