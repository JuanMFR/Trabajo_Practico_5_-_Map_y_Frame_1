
package Funciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author JuanmaPC
 */
public class Directorio {
    
    private TreeMap<Long, Contacto> telefono_contactos = new TreeMap<>();
    private Set<String> ciudadesDisponibles = new HashSet<>();
    
    public void agregarCiudad(String ciudad) {
        ciudadesDisponibles.add(ciudad);
    }
    
    public Set<String> getCiudadesDisponibles() {
        return ciudadesDisponibles;
    }    
    
    public TreeMap<Long, Contacto> getTelefonoContactos() {
        return telefono_contactos;
    }
    
    public void agregarContacto(long telefono, Contacto contacto){
        telefono_contactos.put(telefono, contacto);
    }
    
    public Contacto buscarContacto(long telefono){
        if(telefono_contactos.containsKey(telefono)){
            return telefono_contactos.get(telefono);
        }
        return null;
    }
    

    public Map.Entry buscarContactoPorDNI(long buscarDNI){
        Map.Entry<Long, Contacto> foundEntry = null;
        for (Map.Entry<Long, Contacto> entry : telefono_contactos.entrySet()) {
            if (entry.getValue().getDNI() == buscarDNI) {
                foundEntry = entry;
                break;
            }
        }                    
        return foundEntry;
    }   
    
    public Set<Long> buscarTelefono(String apellido){
        Set<Long> telefonosEncontrados = new HashSet<>();
        Iterator<Map.Entry<Long, Contacto>> iter = telefono_contactos.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<Long, Contacto> entry = iter.next();
            if(entry.getValue().getApellido().equals(apellido)){
                telefonosEncontrados.add(entry.getKey());
            }
        }
        return telefonosEncontrados;
    }

    public ArrayList<Contacto> buscarContactosPorCiudad(String ciudad){
        ArrayList<Contacto> contactosEncontrados = new ArrayList<>();
        Iterator<Contacto> iter = telefono_contactos.values().iterator();
        while (iter.hasNext()){
            Contacto contacto = iter.next();
            if(contacto.getCiudad().equals(ciudad)){
                contactosEncontrados.add(contacto);
            }
        }
        return contactosEncontrados;
    }
    
    public ArrayList<Contacto> buscarContactosPorApellido(String apellido){
        ArrayList<Contacto> contactosEncontrados = new ArrayList<>();
        Iterator<Contacto> iter = telefono_contactos.values().iterator();
        while (iter.hasNext()){
            Contacto contacto = iter.next();
            if(contacto.getApellido().equals(apellido)){
                contactosEncontrados.add(contacto);
            }
        }
        return contactosEncontrados;
    }
    
    public Contacto borrarContacto(long telefono){
        return telefono_contactos.remove(telefono);
    }
    
    public Set<String> obtenerCiudades() {
        
        Set<String> ciudadesUnicas = new HashSet<>();
        Collection<Contacto> todosLosContactos = telefono_contactos.values();
        for (Contacto contacto : todosLosContactos) {
            ciudadesUnicas.add(contacto.getCiudad());
        }
        
        return ciudadesUnicas;
    }
    
    public Set<String> obtenerApellidosUnicos() {
        Set<String> apellidosUnicos = new HashSet<>();
        Collection<Contacto> todosLosContactos = telefono_contactos.values();
        
        for (Contacto contacto : todosLosContactos) {
            apellidosUnicos.add(contacto.getApellido());
        }
        return apellidosUnicos;
    }
}
