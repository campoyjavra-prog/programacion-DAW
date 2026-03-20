import { NavLink } from "react-router-dom"
import type { IServicio } from "@/model/interfaces/IServicio"

interface Props {
    servicio: IServicio;
}

export const ServicioCard = ({ servicio }: Props) => {
    return (
        <NavLink 
            to={`/servicios/${servicio.id}`}
            className="flex max-w-xl flex-col items-start justify-between rounded-md border-2 border-gray-700 p-3 hover:bg-gray-800 hover:border-blue-500 transition-all duration-300 overflow-hidden group cursor-pointer"
        >
            <div className="flex items-center gap-x-4 text-xs">
                <span className="relative z-10 rounded-full bg-gray-800/60 px-3 py-1.5 font-medium text-gray-300">
                    {servicio.categoria}
                </span>
            </div>
            <div className="relative grow">
                <h3 className="mt-3 text-lg font-semibold leading-6 text-white group-hover:text-blue-400 transition-colors">
                    {servicio.titulo}
                </h3>
                <p className="mt-5 line-clamp-3 text-sm leading-6 text-gray-400 group-hover:text-gray-300 transition-colors">
                    {servicio.descripcion}
                </p>
            </div>
            {servicio.imagen && (
                <div className="w-full mt-4 rounded-lg overflow-hidden">
                    <img
                        src={servicio.imagen}
                        alt={servicio.titulo}
                        className="w-full h-40 object-cover rounded-lg group-hover:scale-105 transition-transform duration-500"
                    />
                </div>
            )}
            <div className="mt-4 flex flex-wrap gap-2">
                {servicio.tecnologias.map((tech, index) => (
                    <span key={index} className="text-xs text-blue-400 group-hover:text-blue-300 transition-colors">
                        #{tech}
                    </span>
                ))}
            </div>
        </NavLink>
    )
}

export default ServicioCard