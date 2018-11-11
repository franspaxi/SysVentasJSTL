/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.syscenterlife.servicio.inventario;

import java.util.List;
import pe.com.syscenterlife.modelo.GloAlmacen;

/**
 *
 * @author Student
 */
public interface AlmacenServicioI {
    public List<GloAlmacen> listarEntidad();
    public List<GloAlmacen> listarEntidadDato(String dato);
    public GloAlmacen buscarEntidadId(int id);
    public void guardarEntidad(GloAlmacen almacen);
    public void eliminarEntidad(int id);
    public void modificarEntidad(GloAlmacen almacen);
}
