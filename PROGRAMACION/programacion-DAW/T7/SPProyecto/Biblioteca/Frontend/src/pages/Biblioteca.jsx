import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';

// Página principal del catálogo de libros.
const Biblioteca = () => {
  // 'Memoria' para guardar la lista de libros. Empieza vacía.
  const [libros, setLibros] = useState([]);
  
  // 'Memorias' para guardar lo que escribes en los filtros de búsqueda.
  const [busquedaTitulo, setBusquedaTitulo] = useState('');
  const [busquedaAutor, setBusquedaAutor] = useState('');
  const [anioMin, setAnioMin] = useState('');
  const [anioMax, setAnioMax] = useState('');

  // Borra un libro de la base de datos.
  const borrarLibro = async (id) => {
    // Preguntamos antes de borrar para evitar accidentes.
    if (window.confirm('¿Estás seguro de que quieres borrar este libro?')) {
      try {
        // Le decimos al servidor que elimine este ID ('DELETE').
        const response = await fetch(`http://localhost:8080/api/libros/${id}`, {
          method: 'DELETE',
        });
        
        if (response.ok) {
          // Quitamos el libro de la pantalla sin recargar la página.
          setLibros(libros.filter((libro) => libro.id !== id));
        } else {
          console.error('Error al borrar el libro');
        }
      } catch (error) {
        console.error('Error de red al borrar:', error);
      }
    }
  };

  // Al abrir la página, pedimos los libros al servidor.
  useEffect(() => {
    fetch('http://localhost:8080/api/libros')
      .then((response) => response.json()) // Traducimos la respuesta.
      .then((data) => setLibros(data)) // Guardamos los libros en nuestra 'memoria'.
      .catch((error) => {
        console.error('Error al obtener los libros:', error);
      });
  }, []);

  // Aquí empieza el diseño visual de la página.
  return (
    <div className="min-h-screen bg-gradient-to-br from-slate-50 to-slate-100 py-12 px-4 sm:px-6 lg:px-8">
      <div className="max-w-7xl mx-auto">
        {/* Título de la página */}
        <div className="text-center mb-16">
          <h1 className="text-4xl md:text-5xl font-extrabold text-slate-900 tracking-tight mb-4">
            Catálogo de <span className="text-indigo-600">Libros</span>
          </h1>
          <div className="h-1.5 w-24 bg-indigo-600 mx-auto rounded-full mb-6"></div>
        </div>

        {/* Buscador Multi-filtro: agrupa las cajas en una cuadrícula */}
        <div className="max-w-6xl mx-auto mb-12 grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-4">
          
          {/* Buscar por Título */}
          <div className="relative group">
            <div className="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
              {/* Icono de lupa */}
              <svg className="h-5 w-5 text-slate-400 group-focus-within:text-indigo-600 transition-colors" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z" />
              </svg>
            </div>
            {/* Al escribir, actualizamos la memoria de 'busquedaTitulo' */}
            <input
              type="text"
              placeholder="Buscar por título..."
              value={busquedaTitulo}
              onChange={(e) => setBusquedaTitulo(e.target.value)}
              className="block w-full pl-10 pr-3 py-3 border border-slate-200 rounded-xl leading-5 bg-white placeholder-slate-400 focus:outline-none focus:ring-2 focus:ring-indigo-600 focus:border-indigo-600 transition-all shadow-sm"
            />
          </div>

          {/* Buscar por Autor */}
          <div className="relative group">
            <div className="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
              <svg className="h-5 w-5 text-slate-400 group-focus-within:text-indigo-600 transition-colors" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M16 7a4 4 0 11-8 0 4 4 0 018 0zM12 14a7 7 0 00-7 7h14a7 7 0 00-7-7z" />
              </svg>
            </div>
            <input
              type="text"
              placeholder="Buscar por autor..."
              value={busquedaAutor}
              onChange={(e) => setBusquedaAutor(e.target.value)}
              className="block w-full pl-10 pr-3 py-3 border border-slate-200 rounded-xl leading-5 bg-white placeholder-slate-400 focus:outline-none focus:ring-2 focus:ring-indigo-600 focus:border-indigo-600 transition-all shadow-sm"
            />
          </div>

          {/* Buscar por Año desde */}
          <div className="relative group">
            <div className="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
              <svg className="h-5 w-5 text-slate-400 group-focus-within:text-indigo-600 transition-colors" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M8 7V3m8 4V3m-9 8h10M5 21h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v12a2 2 0 002 2z" />
              </svg>
            </div>
            <input
              type="number"
              placeholder="Año desde..."
              value={anioMin}
              onChange={(e) => setAnioMin(e.target.value)}
              className="block w-full pl-10 pr-3 py-3 border border-slate-200 rounded-xl leading-5 bg-white placeholder-slate-400 focus:outline-none focus:ring-2 focus:ring-indigo-600 focus:border-indigo-600 transition-all shadow-sm"
            />
          </div>

          {/* Buscar por Año hasta */}
          <div className="relative group">
            <div className="absolute inset-y-0 left-0 pl-3 flex items-center pointer-events-none">
              <svg className="h-5 w-5 text-slate-400 group-focus-within:text-indigo-600 transition-colors" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M8 7V3m8 4V3m-9 8h10M5 21h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v12a2 2 0 002 2z" />
              </svg>
            </div>
            <input
              type="number"
              placeholder="Año hasta..."
              value={anioMax}
              onChange={(e) => setAnioMax(e.target.value)}
              className="block w-full pl-10 pr-3 py-3 border border-slate-200 rounded-xl leading-5 bg-white placeholder-slate-400 focus:outline-none focus:ring-2 focus:ring-indigo-600 focus:border-indigo-600 transition-all shadow-sm"
            />
          </div>
        </div>

        {/* Lista de libros (Cuadrícula adaptable) */}
        <div className="grid grid-cols-1 md:grid-cols-3 lg:grid-cols-4 gap-8">
          {/* Pasamos los libros por un "colador" (filter) antes de mostrarlos */}
          {libros
            .filter((libro) => {
              // Ignoramos mayúsculas/minúsculas al buscar.
              const coincideTitulo = libro.titulo.toLowerCase().includes(busquedaTitulo.toLowerCase());
              const coincideAutor = libro.autor.toLowerCase().includes(busquedaAutor.toLowerCase());
              
              // Si no hay año puesto, pasa cualquiera. Si lo hay, filtramos.
              const coincideMin = anioMin === '' || libro.anio >= parseInt(anioMin);
              const coincideMax = anioMax === '' || libro.anio <= parseInt(anioMax);

              // Debe cumplir todas las condiciones para mostrarse.
              return coincideTitulo && coincideAutor && coincideMin && coincideMax;
            })
            // Convertimos cada libro filtrado en una tarjeta visual.
            .map((libro) => (
              <div
                key={libro.id} // Identificador único para React.
                className="group bg-white rounded-2xl shadow-sm border border-slate-200 overflow-hidden hover:shadow-2xl transition-all duration-300 transform hover:-translate-y-2 flex flex-col"
              >
                {/* Contenedor de la Imagen */}
                <div className="aspect-[3/4] bg-slate-200 relative overflow-hidden">
                  {/* Si hay imagen la mostramos, si no, un icono por defecto */}
                  {libro.imagen ? (
                    <img
                      src={libro.imagen}
                      alt={libro.titulo}
                      className="w-full h-full object-cover transition-transform duration-500 group-hover:scale-110"
                    />
                  ) : (
                    <div className="w-full h-full flex items-center justify-center bg-gradient-to-tr from-slate-100 to-slate-200">
                      <svg
                        className="w-16 h-16 text-slate-300 opacity-50"
                        fill="none"
                        stroke="currentColor"
                        viewBox="0 0 24 24"
                      >
                        <path
                          strokeLinecap="round"
                          strokeLinejoin="round"
                          strokeWidth={1.5}
                          d="M12 6.253v13m0-13C10.832 5.477 9.246 5 7.5 5S4.168 5.477 3 6.253v13C4.168 18.477 5.754 18 7.5 18s3.332.477 4.5 1.253m0-13C13.168 5.477 14.754 5 16.5 5c1.747 0 3.332.477 4.5 1.253v13C19.832 18.477 18.247 18 16.5 18c-1.746 0-3.332.477-4.5 1.253"
                        />
                      </svg>
                    </div>
                  )}
                  {/* Precio flotante (aparece al pasar el ratón) */}
                  <div className="absolute top-4 right-4 translate-y-2 opacity-0 group-hover:translate-y-0 group-hover:opacity-100 transition-all duration-300">
                    <span className="bg-indigo-600 text-white px-3 py-1 rounded-full text-xs font-bold shadow-lg">
                      {/* Redondeamos a 2 decimales y protegemos con '?' por si falta el precio */}
                      {libro.precio?.toFixed(2)}€
                    </span>
                  </div>
                </div>

                {/* Información del Libro */}
                <div className="p-6 flex-grow flex flex-col">
                  <h3 className="text-2xl font-bold text-slate-900 mb-2 line-clamp-2 group-hover:text-indigo-600 transition-colors">
                    {libro.titulo}
                  </h3>
                  <p className="text-lg text-slate-600 font-semibold mb-1 line-clamp-1">
                    {libro.autor}
                  </p>
                  <p className="text-slate-400 text-base mb-4">
                    {libro.anio}
                  </p>

                  <div className="mt-auto pt-4 border-t border-slate-100 flex items-center justify-between">
                    <span className="text-xl font-bold text-slate-900">
                      {/* Formateamos el precio en Euros (€) */}
                      {libro.precio?.toLocaleString('es-ES', { style: 'currency', currency: 'EUR' })}
                    </span>
                    <div className="flex gap-2">
                      {/* Botón Editar: vamos a la ruta de edición con su ID */}
                      <Link 
                        to={`/editar/${libro.id}`}
                        className="flex items-center gap-1 text-amber-500 hover:text-amber-700 font-semibold text-sm transition-colors uppercase tracking-wider"
                      >
                        <svg className="w-4 h-4" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                          <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M11 5H6a2 2 0 00-2 2v11a2 2 0 002 2h11a2 2 0 002-2v-5m-1.414-9.414a2 2 0 112.828 2.828L11.828 15H9v-2.828l8.586-8.586z" />
                        </svg>
                        Editar
                      </Link>
                      {/* Botón Borrar: llama a nuestra función con el ID */}
                      <button
                        onClick={() => borrarLibro(libro.id)}
                        className="flex items-center gap-1 text-red-500 hover:text-red-700 font-semibold text-sm transition-colors uppercase tracking-wider"
                      >
                        <svg className="w-4 h-4" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                          <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M19 7l-.867 12.142A2 2 0 0116.138 21H7.862a2 2 0 01-1.995-1.858L5 7m5 4v6m4-6v6m1-10V4a1 1 0 00-1-1h-4a1 1 0 00-1 1v3M4 7h16" />
                        </svg>
                        Borrar
                      </button>
                    </div>
                  </div>
                </div>
              </div>
            ))}
        </div>

        {/* Si no hay libros, mostramos este mensaje */}
        {libros.length === 0 && (
          <div className="text-center py-20 bg-white/50 rounded-3xl border-2 border-dashed border-slate-200">
            <p className="text-slate-400 text-xl font-medium">Buscando joyas literarias...</p>
          </div>
        )}
      </div>
    </div>
  );
};

export default Biblioteca;
