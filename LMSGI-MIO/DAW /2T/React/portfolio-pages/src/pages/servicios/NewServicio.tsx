import { useState } from "react";
import { Link } from "react-router-dom";
import type { IServicio } from "@/model/interfaces/IServicio";

const NewServicio = () => {
    const [servicio, setServicio] = useState<Omit<IServicio, "id">>({
        titulo: "",
        categoria: "",
        descripcion: "",
        imagen: "",
        tecnologias: [],
    });

    const [techInput, setTechInput] = useState("");

    const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement | HTMLSelectElement>) => {
        const { name, value } = e.target;
        setServicio((prev) => ({ ...prev, [name]: value }));
    };

    const addTech = () => {
        if (techInput.trim()) {
            setServicio((prev) => ({
                ...prev,
                tecnologias: [...prev.tecnologias, techInput.trim()],
            }));
            setTechInput("");
        }
    };

    const removeTech = (index: number) => {
        setServicio((prev) => ({
            ...prev,
            tecnologias: prev.tecnologias.filter((_, i) => i !== index),
        }));
    };

    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        console.log("Nuevo servicio:", servicio);
        alert("Servicio creado (mock). Ver consola para los datos.");
    };

    return (
        <div className="w-full py-8">
            <Link to="/servicios" className="text-blue-400 hover:underline mb-6 inline-block">
                ← Volver a Servicios
            </Link>
            <h1 className="text-3xl font-bold mb-8">Nuevo Servicio</h1>
            <form onSubmit={handleSubmit} className="space-y-6 max-w-2xl">
                <div>
                    <label className="block text-sm font-medium text-gray-300 mb-2">Título</label>
                    <input
                        type="text"
                        name="titulo"
                        value={servicio.titulo}
                        onChange={handleChange}
                        required
                        className="w-full bg-gray-800 border border-gray-700 rounded-lg px-4 py-2 text-white focus:outline-none focus:border-blue-500"
                    />
                </div>
                <div>
                    <label className="block text-sm font-medium text-gray-300 mb-2">Categoría</label>
                    <select
                        name="categoria"
                        value={servicio.categoria}
                        onChange={handleChange}
                        required
                        className="w-full bg-gray-800 border border-gray-700 rounded-lg px-4 py-2 text-white focus:outline-none focus:border-blue-500"
                    >
                        <option value="">Seleccionar categoría</option>
                        <option value="Redes de Comunuicaciones">Redes de Comunicaciones</option>
                        <option value="Desarrollo de Software">Desarrollo de Software</option>
                        <option value="Despliegue de Aplicaciones">Despliegue de Aplicaciones</option>
                    </select>
                </div>
                <div>
                    <label className="block text-sm font-medium text-gray-300 mb-2">Descripción</label>
                    <textarea
                        name="descripcion"
                        value={servicio.descripcion}
                        onChange={handleChange}
                        required
                        rows={4}
                        className="w-full bg-gray-800 border border-gray-700 rounded-lg px-4 py-2 text-white focus:outline-none focus:border-blue-500"
                    />
                </div>
                <div>
                    <label className="block text-sm font-medium text-gray-300 mb-2">URL de Imagen</label>
                    <input
                        type="text"
                        name="imagen"
                        value={servicio.imagen}
                        onChange={handleChange}
                        className="w-full bg-gray-800 border border-gray-700 rounded-lg px-4 py-2 text-white focus:outline-none focus:border-blue-500"
                        placeholder="/images/servicios/nombre.png"
                    />
                </div>
                <div>
                    <label className="block text-sm font-medium text-gray-300 mb-2">Tecnologías</label>
                    <div className="flex gap-2 mb-3">
                        <input
                            type="text"
                            value={techInput}
                            onChange={(e) => setTechInput(e.target.value)}
                            onKeyDown={(e) => { if (e.key === "Enter") { e.preventDefault(); addTech(); } }}
                            className="flex-grow bg-gray-800 border border-gray-700 rounded-lg px-4 py-2 text-white focus:outline-none focus:border-blue-500"
                            placeholder="Añadir tecnología..."
                        />
                        <button
                            type="button"
                            onClick={addTech}
                            className="bg-gray-700 hover:bg-gray-600 text-white px-4 py-2 rounded-lg transition-colors"
                        >
                            Añadir
                        </button>
                    </div>
                    <div className="flex flex-wrap gap-2">
                        {servicio.tecnologias.map((tech, index) => (
                            <span
                                key={index}
                                className="text-sm text-blue-400 bg-blue-400/10 px-3 py-1 rounded-full flex items-center gap-2"
                            >
                                #{tech}
                                <button
                                    type="button"
                                    onClick={() => removeTech(index)}
                                    className="text-red-400 hover:text-red-300"
                                >
                                    ×
                                </button>
                            </span>
                        ))}
                    </div>
                </div>
                <button
                    type="submit"
                    className="bg-blue-600 hover:bg-blue-700 text-white px-6 py-3 rounded-lg transition-colors font-medium"
                >
                    Crear Servicio
                </button>
            </form>
        </div>
    );
};

export default NewServicio;
