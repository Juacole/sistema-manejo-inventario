import { Routes } from '@angular/router';
import { ProductoLista } from './producto-lista/producto-lista';
import { AgregarProducto } from './agregar-producto/agregar-producto';

export const routes: Routes = [
    { path: 'productos', component: ProductoLista }, //redefinimos la ruta de nuestra app
    { path: '', redirectTo: 'productos', pathMatch: 'full' }, //redireccionamos a productos si no se especifica una ruta
    { path: 'agregar-producto', component: AgregarProducto }, //ruta para agregar un producto
];
