

import dataServicios from "../components/data/servicios.json";

const Servicios = () => {
    return (
        <section id="servicios" className="min-h-screen flex items-center justify-center flex-col">
            <h1 className="text-4xl font-bold">
                Servicios
                <ul>
                    {
                        dataServicios.map((servicio) => (
                            <li key={(servicio.id)}>{servicio.titulo}</li>
                        ))
                    }
                </ul>
            </h1>
        </section>
    );
};

export default Servicios;