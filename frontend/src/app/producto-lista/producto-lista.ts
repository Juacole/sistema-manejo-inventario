import { Component, inject } from '@angular/core';
import { Producto } from '../producto.model';
import { ProductoService } from '../producto.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-producto-lista',
  imports: [],
  templateUrl: './producto-lista.html',
  styleUrl: './producto-lista.css'
})
export class ProductoLista {
  productos!: Producto[];
  private productoServicio = inject(ProductoService);
  private enrutador = inject(Router);

  //Metodo que se ejecuta al inicializar el componente, pero siempre despues del constructor
  ngOnInit() {
    this.obtenerProductos();
  }

  private obtenerProductos(): void {
    this.productoServicio.obtenerProductosLista().subscribe(
      {
        next: (datos) => {
          this.productos = datos;
        },
        error: (error) => {
          console.error("Error al obtener los productos", error);
        }
      }
    )
  }

  editarProducto(idProducto: number): void {
    this.enrutador.navigate(['/editar-producto', idProducto]);
  }

  eliminarProducto(idProducto: number): void {
    this.productoServicio.eliminarProducto(idProducto).subscribe(
      {
        next: (data) => {
          this.obtenerProductos(); // Actualizar la lista de productos
        },
        error: (error) => {
          console.error("Error al eliminar el producto", error);
        }
      }
    );
  }
}
