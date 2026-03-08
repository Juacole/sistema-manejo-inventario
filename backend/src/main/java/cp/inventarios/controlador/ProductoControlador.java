package cp.inventarios.controlador;

import cp.inventarios.excepcion.RecursoNoEncontrado;
import cp.inventarios.modelo.Producto;
import cp.inventarios.servicio.ProductoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("inventario-app") //Nuestra aplicacion
@CrossOrigin(value = "http://localhost:4200") //Puerto por defecto de Angular, obligatorio para realizar peticiones http
public class ProductoControlador {
    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping("/productos") //Ruta donde se desplegaran los productos
    public List<Producto> obtenerProductos(){
        List<Producto> productos = this.productoServicio.listarProductos();
        logger.info("Listado de productos de la lista:");
        productos.forEach(producto -> logger.info(producto.toString()));
        return productos;
    }

    @PostMapping("/productos")
    public Producto guardarProducto(@RequestBody Producto producto) {
        logger.info("Producto a agregar: " + producto.toString());
        return this.productoServicio.guardarProducto(producto);
    }

    @GetMapping("productos/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Integer id){
        Producto producto = this.productoServicio.buscarProductoPorId(id);
        if(producto != null){
            return ResponseEntity.ok(producto);
        }else{
            throw new RecursoNoEncontrado("No se encontro el id: " + id);
        }
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> actualizarProductoPorId(
            @PathVariable Integer id,
            @RequestBody Producto productoRecibido
    ){
        Producto producto = this.productoServicio.buscarProductoPorId(id);
        producto.setDescripcion(productoRecibido.getDescripcion());
        producto.setPrecio(productoRecibido.getPrecio());
        producto.setExistencias(productoRecibido.getExistencias());

        this.productoServicio.guardarProducto(producto);
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarProductoPorId(@PathVariable Integer id){
        Producto producto = this.productoServicio.buscarProductoPorId(id);
        if(producto == null){
            throw new RecursoNoEncontrado("No se encontro el id: " + id);
        }

        this.productoServicio.eliminarProductoPorId(producto.getIdProducto());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
