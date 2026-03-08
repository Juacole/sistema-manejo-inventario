import { Component, inject } from '@angular/core';
import { Producto } from '../producto.model';
import { ProductoService } from '../producto.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-editar-producto',
  imports: [FormsModule],
  templateUrl: './editar-producto.html',
  styleUrl: './editar-producto.css'
})
export class EditarProducto {
  producto: Producto = new Producto();
  id!: number;

  private productoServicio = inject(ProductoService);
  private ruta = inject(ActivatedRoute);
  private enrutador = inject(Router);

  ngOnInit() {
    this.id = this.ruta.snapshot.params['id'];
    this.productoServicio.obtenerProductoPorId(this.id).subscribe({
      next: (data) => {
        this.producto = data;
      },
      error: (error: any) => {
        console.error('Error al obtener el producto:', error);
      }
    });
  }

  onSubmit() {
    this.guardarProducto();
  }

  private guardarProducto() {
    this.productoServicio.editarProducto(this.id, this.producto).subscribe({
      next: (data) => {
        this.irProductoLista();
      },
      error: (error: any) => {
        console.error('Error al actualizar el producto:', error);
      }
    });
  }

  private irProductoLista() {
    this.enrutador.navigate(['/productos']);
  }
}
