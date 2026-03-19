
import ServiciosCard from "@/components/main/ServiciosCard"
import dataServicios from "@/model/data/servicios.json"

const Servicios = () => {
    return (
        <section id="servicios" className="min-h-screen py-24 w-full bg-gray-900">
            <div className="mx-auto max-w-screen-2xl px-6 lg:px-12">
            <h1 className="text-3xl font-bold mb-10 text-center">
                Servicios Ofrecidos
            </h1>
            <ServiciosCard servicios={dataServicios} />
            </div>
        </section>
    )
}

export default Servicios;