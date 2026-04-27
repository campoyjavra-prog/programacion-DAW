import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

// Página para añadir un libro nuevo al catálogo.
const NuevoLibro = () => {
  // Herramienta para navegar a otra página después de guardar.
  const navigate = useNavigate();
  
  // 'Memoria' del formulario. Empieza con campos vacíos.
  const [formData, setFormData] = useState({
    titulo: '',
    autor: '',
    precio: '',
    anio: '',
    imagen: ''
  });

  // Se activa cada vez que escribes en cualquier caja del formulario.
  const handleChange = (e) => {
    // Averiguamos qué caja cambió (name) y qué escribiste (value).
    const { name, value } = e.target;
    setFormData({
      ...formData, // Mantenemos lo que ya había...
      [name]: value // ...y actualizamos solo la caja que cambió.
    });
  };

  // Se ejecuta al darle al botón de guardar.
  const handleSubmit = async (e) => {
    e.preventDefault(); // Evitamos que la página se recargue de golpe.

    // Convertimos precio a decimal y año a entero por si acaso.
    const libroData = {
      ...formData,
      precio: parseFloat(formData.precio),
      anio: parseInt(formData.anio)
    };

    try {
      // Enviamos los datos nuevos. 'POST' significa "crear nuevo".
      const response = await fetch('http://localhost:8080/api/libros', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(libroData) // Convertimos nuestros datos a texto para enviarlos.
      });

      if (response.ok) {
        navigate('/'); // Si todo fue bien, volvemos a la página principal.
      } else {
        console.error('Error al guardar el libro:', response.statusText);
      }
    } catch (error) {
      console.error('Error de red:', error);
    }
  };

  // Aquí empieza el diseño visual de la página.
  return (
    <div className="min-h-screen bg-gradient-to-br from-slate-50 to-slate-100 py-12 px-4 sm:px-6 lg:px-8">
      <div className="max-w-3xl mx-auto">
        {/* Encabezado */}
        <div className="text-center mb-10">
          <h1 className="text-5xl font-extrabold text-slate-900 mb-2">
            Añadir Nuevo <span className="text-blue-600">Libro</span>
          </h1>
          <p className="text-slate-500 text-lg">Completa la información para registrar una nueva obra en el catálogo.</p>
        </div>

        {/* Card del Formulario */}
        <div className="bg-white rounded-3xl shadow-xl shadow-slate-200/50 border border-slate-100 overflow-hidden">
          {/* El onSubmit conecta el formulario con nuestra función de guardado */}
          <form onSubmit={handleSubmit} className="p-10 space-y-6">
            <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
              {/* Título */}
              <div className="md:col-span-2">
                <label className="block text-base font-semibold text-slate-700 mb-2 ml-1">Título del Libro</label>
                <input
                  type="text"
                  name="titulo"
                  value={formData.titulo} // El valor siempre viene de nuestra memoria
                  onChange={handleChange} // Al escribir, llamamos a handleChange
                  required
                  placeholder="El Quijote"
                  className="w-full px-4 py-3 text-lg rounded-xl border border-slate-200 focus:ring-4 focus:ring-blue-100 focus:border-blue-400 transition-all outline-none bg-slate-50/50"
                />
              </div>

              {/* Autor */}
              <div className="md:col-span-2">
                <label className="block text-base font-semibold text-slate-700 mb-2 ml-1">Autor</label>
                <input
                  type="text"
                  name="autor"
                  value={formData.autor}
                  onChange={handleChange}
                  required
                  placeholder="Miguel de Cervantes"
                  className="w-full px-4 py-3 text-lg rounded-xl border border-slate-200 focus:ring-4 focus:ring-blue-100 focus:border-blue-400 transition-all outline-none bg-slate-50/50"
                />
              </div>

              {/* Precio */}
              <div>
                <label className="block text-base font-semibold text-slate-700 mb-2 ml-1">Precio (€)</label>
                <input
                  type="number"
                  step="0.01"
                  name="precio"
                  value={formData.precio}
                  onChange={handleChange}
                  required
                  placeholder="29.99"
                  className="w-full px-4 py-3 text-lg rounded-xl border border-slate-200 focus:ring-4 focus:ring-blue-100 focus:border-blue-400 transition-all outline-none bg-slate-50/50"
                />
              </div>

              {/* Año */}
              <div>
                <label className="block text-base font-semibold text-slate-700 mb-2 ml-1">Año de Publicación</label>
                <input
                  type="number"
                  name="anio"
                  value={formData.anio}
                  onChange={handleChange}
                  required
                  placeholder="1605"
                  className="w-full px-4 py-3 text-lg rounded-xl border border-slate-200 focus:ring-4 focus:ring-blue-100 focus:border-blue-400 transition-all outline-none bg-slate-50/50"
                />
              </div>

              {/* URL Imagen */}
              <div className="md:col-span-2">
                <label className="block text-base font-semibold text-slate-700 mb-2 ml-1">URL de la Imagen (Portada)</label>
                <input
                  type="text"
                  name="imagen"
                  value={formData.imagen}
                  onChange={handleChange}
                  placeholder="https://ejemplo.com/portada.jpg"
                  className="w-full px-4 py-3 text-lg rounded-xl border border-slate-200 focus:ring-4 focus:ring-blue-100 focus:border-blue-400 transition-all outline-none bg-slate-50/50"
                />
              </div>
            </div>

            {/* Botones de acción */}
            <div className="flex items-center gap-4 pt-4">
              <button
                type="button"
                onClick={() => navigate('/')} // Cancela y nos devuelve al inicio
                className="flex-1 px-6 py-3.5 rounded-xl text-slate-600 text-lg font-semibold hover:bg-slate-100 transition-all active:scale-95"
              >
                Cancelar
              </button>
              <button
                type="submit"
                className="flex-[2] bg-blue-600 hover:bg-blue-500 text-white text-lg font-bold py-3.5 px-6 rounded-xl shadow-lg shadow-blue-500/30 transition-all hover:-translate-y-0.5 active:scale-95"
              >
                Guardar Libro
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};

export default NuevoLibro;
