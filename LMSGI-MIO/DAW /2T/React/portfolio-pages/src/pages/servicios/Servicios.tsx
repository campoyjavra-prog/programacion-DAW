import { ServiciosCard } from "./ServiciosCard";
import dataServicios from "@/model/data/servicios.json"
import { Link } from "react-router-dom";

const Servicios = () => {
    return (
        <div className="w-full py-8">
            <div className="flex justify-between items-center mb-8">
                <h1 className="text-3xl font-bold">Servicios Ofrecidos</h1>
                <Link
                    to="/servicios/new"
                    className="bg-blue-600 hover:bg-blue-700 text-white px-4 py-2 rounded-lg transition-colors"
                >
                    + Nuevo Servicio
                </Link>
            </div>
            <ServiciosCard servicios={dataServicios} />
        </div>
    )
}

export default Servicios