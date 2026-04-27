import React from 'react';

const CV = () => {
  // Datos completos de la persona
  const persona = {
    nombre: "Rafael",
    apellidos: "Campoy Javier",
    profesion: "Senior Full Stack Developer",
    sobreMi: "Desarrollador Passionate por crear experiencias digitales excepcionales. Experto en React, Tailwind CSS y arquitectura de microservicios. Me enfoco en escribir código limpio, escalable y en diseñar interfaces que cautiven al usuario desde el primer segundo.",
    contacto: {
      email: "campoyjavra@gmail.com",
      telefono: "+34 681 055 562",
      ubicacion: "Huercal-Overa, Almeria",
      github: "github.com/campoyjavra-prog"
    },
    habilidades: [
      "React",
      "Tailwind CSS",
      "JavaScript (ES6+)",
      "Node.js",
      "TypeScript",
      "Git & GitHub",
      "RESTful APIs",
      "UI/UX Design",
      "Spring Boot",
      "Testing (Jest/Cypress)"
    ],
    experiencia: [
      {
        puesto: "Senior Frontend Developer",
        empresa: "Tech Innovators SL",
        fecha: "2022 - Presente",
        descripcion: "Liderazgo de equipo frontend, migración de arquitecturas legacy a React moderno y optimización de rendimiento web reduciendo el tiempo de carga en un 40%."
      },
      {
        puesto: "Full Stack Developer",
        empresa: "Digital Solutions Inc",
        fecha: "2019 - 2022",
        descripcion: "Desarrollo de aplicaciones robustas usando el stack MERN y despliegue en AWS. Implementación de sistemas de autenticación y pasarelas de pago."
      },
      {
        puesto: "Junior Web Developer",
        empresa: "StartUp Genesis",
        fecha: "2017 - 2019",
        descripcion: "Creación de interfaces responsive y mantenimiento de bases de datos SQL. Colaboración estrecha con diseñadores UI/UX."
      }
    ],
    educacion: [
      {
        titulo: "Máster en Desarrollo Web Avanzado",
        institucion: "Universidad Tecnológica",
        fecha: "2017"
      },
      {
        titulo: "Grado en Ingeniería Informática",
        institucion: "Universidad Complutense de Madrid",
        fecha: "2016"
      }
    ]
  };

  return (
    <div className="min-h-screen bg-gray-100 py-10 px-4">
      {/* Contenedor Principal (Simulación A4) */}
      <div className="max-w-5xl mx-auto bg-white shadow-2xl rounded-lg overflow-hidden border border-gray-200">

        {/* CABECERA (Header) */}
        <header className="bg-indigo-700 text-white p-10">
          <div className="flex flex-col md:flex-row justify-between items-start md:items-end gap-6">
            <div>
              <h1 className="text-5xl font-black tracking-tight mb-2 uppercase">
                {persona.nombre} <span className="text-indigo-200">{persona.apellidos}</span>
              </h1>
              <p className="text-2xl font-medium text-indigo-100 tracking-wide">
                {persona.profesion}
              </p>
            </div>

            {/* Información de Contacto */}
            <div className="text-base space-y-1 text-indigo-100 border-l-0 md:border-l md:pl-10 border-indigo-500 flex-shrink-0">
              <div className="flex items-center gap-2">
                <span className="opacity-75">📧</span> {persona.contacto.email}
              </div>
              <div className="flex items-center gap-2">
                <span className="opacity-75">📱</span> {persona.contacto.telefono}
              </div>
              <div className="flex items-center gap-2">
                <span className="opacity-75">📍</span> {persona.contacto.ubicacion}
              </div>
              <div className="flex items-center gap-2 font-mono whitespace-nowrap">
                <span className="opacity-75">🌐</span> {persona.contacto.github}
              </div>
            </div>
          </div>
        </header>

        {/* CUERPO DEL CV */}
        <div className="grid md:grid-cols-3">

          {/* COLUMNA IZQUIERDA (1 fracción) */}
          <aside className="bg-gray-50 p-8 border-r border-gray-100">
            {/* Sobre Mí */}
            <section className="mb-10">
              <h2 className="text-gray-800 text-lg font-bold uppercase tracking-widest mb-4 pb-2 border-b-2 border-indigo-600 inline-block">
                Sobre mí
              </h2>
              <p className="text-gray-600 leading-relaxed text-base">
                {persona.sobreMi}
              </p>
            </section>

            {/* Habilidades */}
            <section>
              <h2 className="text-gray-800 text-lg font-bold uppercase tracking-widest mb-4 pb-2 border-b-2 border-indigo-600 inline-block">
                Habilidades
              </h2>
              <div className="flex flex-wrap gap-2">
                {persona.habilidades.map((habilidad, index) => (
                  <span
                    key={index}
                    className="px-3 py-1 bg-indigo-50 text-indigo-700 text-sm font-bold rounded-full border border-indigo-100 uppercase tracking-tighter"
                  >
                    {habilidad}
                  </span>
                ))}
              </div>
            </section>
          </aside>

          {/* COLUMNA DERECHA (2 fracciones) */}
          <main className="md:col-span-2 p-8">

            {/* Experiencia Laboral */}
            <section className="mb-10">
              <h2 className="text-gray-800 text-3xl font-bold mb-6 flex items-center gap-3">
                <span className="w-8 h-8 bg-indigo-400 text-white rounded-md flex items-center justify-center text-sm">💼</span>
                Experiencia Laboral
              </h2>

              <div className="space-y-8">
                {persona.experiencia.map((exp, index) => (
                  <div key={index} className="relative pl-4 border-l-2 border-gray-100 pb-2">
                    <div className="absolute w-3 h-3 bg-indigo-500 rounded-full -left-[7px] top-1.5 border-2 border-white shadow-sm"></div>
                    <div className="flex justify-between items-start mb-1">
                      <h3 className="text-gray-800 font-bold text-xl leading-none">
                        {exp.puesto}
                      </h3>
                      <span className="text-xs font-bold text-indigo-600 bg-indigo-50 px-2 py-1 rounded">
                        {exp.fecha}
                      </span>
                    </div>
                    <p className="text-indigo-800 font-semibold text-sm mb-2 uppercase tracking-wide">
                      {exp.empresa}
                    </p>
                    <p className="text-gray-600 text-base leading-relaxed">
                      {exp.descripcion}
                    </p>
                  </div>
                ))}
              </div>
            </section>

            {/* Educación */}
            <section>
              <h2 className="text-gray-800 text-2xl font-bold mb-6 flex items-center gap-3">
                <span className="w-8 h-8 bg-indigo-400 text-white rounded-md flex items-center justify-center text-sm">🎓</span>
                Educación
              </h2>

              <div className="grid gap-6">
                {persona.educacion.map((edu, index) => (
                  <div key={index} className="border-b border-gray-100 last:border-0 pb-4">
                    <div className="flex justify-between items-start mb-1">
                      <h3 className="text-gray-800 font-bold">
                        {edu.titulo}
                      </h3>
                      <span className="text-xs font-medium text-gray-500 italic">
                        {edu.fecha}
                      </span>
                    </div>
                    <p className="text-gray-600 text-sm">
                      {edu.institucion}
                    </p>
                  </div>
                ))}
              </div>
            </section>
          </main>

        </div>

        {/* Footer simple */}
        <footer className="bg-gray-50 py-4 px-8 border-t border-gray-100 text-center text-[10px] text-gray-400 uppercase tracking-widest font-medium">
          Este currículum vitae ha sido generado con React y Tailwind CSS - 2026
        </footer>
      </div>
    </div>
  );
};

export default CV;

