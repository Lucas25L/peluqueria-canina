package logica;

import java.util.List;
import persistencia.ControladoraPersistencia;


public class ControladoraLogica {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String razaMasco,
        String colorMasco, String obsMasco, String alergicoMasco, String atencionEspecial,
        String nombreDue, String celuDue) {
        
        // creamos el objeto duenio y le asignamos los valores
        Duenio duenio = new Duenio();
        duenio.setNombreDuenio(nombreDue);
        duenio.setNumCelular(celuDue);
        
        // creamos el objeto mascota y le asignamos los valores
        Mascota mascota = new Mascota();
        mascota.setNombre(nombreMasco);
        mascota.setRaza(razaMasco);
        mascota.setColor(colorMasco);
        mascota.setObservacion(obsMasco);
        mascota.setAlergico(alergicoMasco);
        mascota.setAtencionEspecial(atencionEspecial);
        mascota.setDuenio(duenio);
        
        
        controlPersis.guardar(duenio, mascota);
    }

    public List<Mascota> traerMascotaList() {
        return controlPersis.traerMascotas();
    }

    public void borrarMascota(int num_cliente) {
        controlPersis.borrarMascota(num_cliente);
    }

    // ESTE METODO RECIBE LOS DATOS DE LA ControladoraPersistencia Y LO PASA A ModificarDatos
    public Mascota traerMascota(int num_cliente) {
        return controlPersis.traerMascotas(num_cliente);
    }

    // MODIFICA LA BD
    public void modificarMascota(Mascota masco, String nombreMasco, String razaMasco,
            String colorMasco, String obsMasco, String alergicoMasco, String atencionEspecial,
            String nombreDue, String celuDue) {
        
        // seteo los valores de mascota
        masco.setNombre(nombreMasco);
        masco.setRaza(razaMasco);
        masco.setColor(colorMasco);
        masco.setObservacion(obsMasco);
        masco.setAlergico(alergicoMasco);
        masco.setAtencionEspecial(atencionEspecial);
        
        // MODIFICO LOS DATOS DE MASCOTA
        controlPersis.modificarMascota(masco);
        
        Duenio duenio = this.buscarDuenio(masco.getDuenio().getIdDuenio());
        
        // seteo los valores de dueñO
        duenio.setNombreDuenio(nombreDue);
        duenio.setNumCelular(celuDue);
        
        this.modificarDuenio(duenio);
    }

    private Duenio buscarDuenio(Integer idDuenio) {
        return controlPersis.traerDuenio(idDuenio);
    }

    private void modificarDuenio(Duenio duenio) {
        controlPersis.modificarDuenio(duenio);
    }
}