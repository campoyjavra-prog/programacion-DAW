import { useState, useEffect } from 'react';
import { getCursos } from '../../../model/api/main/apiCursos';
import type { ICurso } from '../../../model/interfaces/ICurso';
import NewCurso from '../../../components/admin/cursos/NewCurso';
import { Button } from '@/components/ui/button';

export const AdminCursosHome = () => {
    const [cursos, setCursos] = useState<ICurso[]>([]);
    const [loading, setLoading] = useState<boolean>(true);

    const fetchCursos = async () => {
        setLoading(true);
        try {
            const data = await getCursos();
            setCursos(data);
        } catch (error) {
            console.error("Error al obtener los cursos:", error);
        } finally {
            setLoading(false);
        }
    };

    useEffect(() => {
        fetchCursos();
    }, []);

    return (
        <div className="container mx-auto p-8 max-w-7xl flex flex-col gap-10">
            <h1 className="text-3xl font-bold !text-slate-900">
                Administración de la Sección de Mis Cursos
            </h1>
            
            <section>
                <NewCurso onCursoAñadido={fetchCursos} />
            </section>

            <section className="flex flex-col gap-4 mt-4">
                <div>
                    <Button>+ Nuevo curso</Button>
                </div>

                {loading ? (
                    <div className="text-center py-10">
                        <p className="text-xl text-gray-600 dark:text-gray-300">Cargando cursos...</p>
                    </div>
                ) : (
                    <div className="overflow-x-auto bg-white dark:bg-gray-800 rounded-lg shadow">
                        <table className="min-w-full divide-y divide-gray-200 dark:divide-gray-700">
                            <thead className="bg-gray-50 dark:bg-gray-900">
                                <tr>
                                    <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-400 uppercase tracking-wider">Título</th>
                                    <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-400 uppercase tracking-wider">Academia</th>
                                    <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-400 uppercase tracking-wider">Categoría</th>
                                    <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-400 uppercase tracking-wider">Precio</th>
                                    <th className="px-6 py-3 text-left text-xs font-medium text-gray-500 dark:text-gray-400 uppercase tracking-wider">Imagen</th>
                                </tr>
                            </thead>
                            <tbody className="bg-white dark:bg-gray-800 divide-y divide-gray-200 dark:divide-gray-700">
                                {cursos.map((curso) => (
                                    <tr key={curso.idCurso} className="hover:bg-gray-50 dark:hover:bg-gray-700">
                                        <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-900 dark:text-gray-200">{curso.titulo}</td>
                                        <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-900 dark:text-gray-200">{curso.academia}</td>
                                        <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-900 dark:text-gray-200">{curso.categoria}</td>
                                        <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-900 dark:text-gray-200">{curso.precio} €</td>
                                        <td className="px-6 py-4 whitespace-nowrap text-sm text-gray-900 dark:text-gray-200">
                                            {curso.imagenUrl ? (
                                                <img src={curso.imagenUrl} alt={curso.titulo} className="h-10 w-10 object-cover rounded-md" />
                                            ) : (
                                                <span className="text-gray-400 italic">Sin imagen</span>
                                            )}
                                        </td>
                                    </tr>
                                ))}
                                {cursos.length === 0 && (
                                    <tr>
                                        <td colSpan={5} className="px-6 py-4 text-center text-sm text-gray-500 dark:text-gray-400">
                                            No hay cursos disponibles.
                                        </td>
                                    </tr>
                                )}
                            </tbody>
                        </table>
                    </div>
                )}
            </section>
        </div>
    );
};

export default AdminCursosHome;
