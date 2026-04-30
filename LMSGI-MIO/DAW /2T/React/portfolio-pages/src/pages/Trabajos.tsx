import proyectos from '../model/data/trabajos.json'
import { ExternalLink, Github } from 'lucide-react'

export default function Trabajos() {
    return (
        <div className="flex flex-col gap-16 py-8">
            {/* Encabezado */}
            <div className="space-y-4">
                <h1 className="text-4xl md:text-5xl font-bold tracking-tight text-white">
                    Mis <span className="bg-gradient-to-r from-blue-400 to-cyan-400 bg-clip-text text-transparent">Proyectos</span>
                </h1>
                <p className="text-slate-400 max-w-2xl text-lg leading-relaxed">
                    Una colección de soluciones digitales donde combino diseño intuitivo con código sólido. 
                    Enfocado siempre en el rendimiento y la experiencia del usuario.
                </p>
            </div>

            {/* Grid de Tarjetas */}
            <div className="grid grid-cols-1 md:grid-cols-2 gap-8">
                {proyectos.map((proyecto) => (
                    <div
                        key={proyecto.id}
                        className="group relative flex flex-col rounded-3xl border border-slate-800 bg-slate-900/40 transition-all duration-500 hover:border-blue-500/50 hover:bg-slate-900/60 hover:shadow-[0_20px_50px_rgba(59,130,246,0.1)]"
                    >
                        {/* Contenedor de la Imagen */}
                        <div className="aspect-video overflow-hidden rounded-t-[calc(1.5rem-1px)] relative">
                            <div className="absolute inset-0 bg-gradient-to-t from-slate-950/80 to-transparent opacity-0 group-hover:opacity-100 transition-opacity duration-500 z-10 flex items-end p-6">
                                <div className="flex gap-3 translate-y-4 group-hover:translate-y-0 transition-transform duration-500">
                                    <button className="p-2 rounded-full bg-white/10 backdrop-blur-md text-white hover:bg-white/20 transition-colors">
                                        <Github className="w-5 h-5" />
                                    </button>
                                    <button className="p-2 rounded-full bg-blue-600 text-white hover:bg-blue-500 transition-colors shadow-lg shadow-blue-600/30">
                                        <ExternalLink className="w-5 h-5" />
                                    </button>
                                </div>
                            </div>
                            <img
                                src={proyecto.imagen}
                                alt={proyecto.titulo}
                                className="w-full h-full object-cover transition-transform duration-700 group-hover:scale-110"
                            />
                        </div>

                        {/* Contenido de la tarjeta */}
                        <div className="p-8 flex-1 flex flex-col gap-4">
                            <div className="flex justify-between items-start">
                                <h3 className="text-2xl font-bold text-white group-hover:text-blue-400 transition-colors">
                                    {proyecto.titulo}
                                </h3>
                                <span className="text-xs font-mono text-slate-500">0{proyecto.id}</span>
                            </div>

                            <p className="text-slate-400 leading-relaxed flex-1">
                                {proyecto.descripcion}
                            </p>

                            {/* Tags de Tecnologías */}
                            <div className="flex flex-wrap gap-2 pt-2">
                                {proyecto.tecnologias.map((tech, index) => (
                                    <span
                                        key={index}
                                        className="px-3 py-1 text-xs font-medium text-blue-400 bg-blue-400/10 rounded-lg border border-blue-400/20"
                                    >
                                        {tech}
                                    </span>
                                ))}
                            </div>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
}