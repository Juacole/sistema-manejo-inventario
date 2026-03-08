package cp.inventarios.repositorio;

import cp.inventarios.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

//Clase DAO (data access object)
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
}
