import { useParams, Link } from "react-router-dom";
import dataServicios from "@/model/data/servicios.json";
import type { IServicio } from "@/model/interfaces/IServicio";

const ServicioDetalle = () => {
    const { cod } = useParams();
    const servicio: IServicio | undefined = dataServicios.find(
        (serv) => serv.id === Number(cod)
    );

    if (!servicio) {
        return (
            <div className="w-full py-8 text-center">
                <h1 className="text-2xl font-bold text-red-400 mb-4">Servicio no encontrado</h1>
                <Link to="/servicios" className="text-blue-400 hover:underline">
                    ← Volver a Servicios
                </Link>
            </div>
        );
    }

    return (
        <div className="w-full py-8">
            <Link to="/servicios" className="text-blue-400 hover:underline mb-6 inline-block">
                ← Volver a Servicios
            </Link>
            <article className="rounded-lg border border-gray-700 p-6 mt-4">
                <div className="flex items-center gap-x-4 text-xs mb-4">
                    <span className="rounded-full bg-gray-800/60 px-3 py-1.5 font-medium text-gray-300">
                        {servicio.categoria}
                    </span>
                </div>
                <h1 className="text-3xl font-bold mb-4">{servicio.titulo}</h1>
                <p className="text-gray-400 leading-7 mb-6">{servicio.descripcion}</p>
                {servicio.imagen && (
                    <div className="w-full rounded-lg overflow-hidden mb-6">
                        <img
                            src={servicio.imagen}
                            alt={servicio.titulo}
                            className="w-full h-64 object-cover rounded-lg"
                        />
                    </div>
                )}
                <div className="flex flex-wrap gap-2">
                    {servicio.tecnologias.map((tech, index) => (
                        <span key={index} className="text-sm text-blue-400 bg-blue-400/10 px-3 py-1 rounded-full">
                            #{tech}
                        </span>
                    ))}
                </div>
            </article>
        </div>
    );
};

export default ServicioDetalle;
