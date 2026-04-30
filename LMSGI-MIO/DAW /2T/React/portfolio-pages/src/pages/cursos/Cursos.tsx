import type { ICurso } from "@/model/interfaces/ICurso"
import { CursosCard } from "@/components/main/cursos/CursosCard"
import { getCursos } from "@/model/api/main/apiCursos"
import { useEffect, useState } from "react"
import { BookOpen } from "lucide-react"

export const Cursos = () => {
    /*
     - hook es una funcion interna de React
     - El hook useState para almacenar los cursos que se van a mostrar en la página
    */

    //variable de estado para controlar la variable cursos
    const [cursos, setCursos] = useState<ICurso[]>([])
    // . cursos = []
    // cursos.push(curso)

    /*
     - El hook useEffect se usa para ejecutar una función cuando el componente se monta por pri
     - se usa para ejecutar la función fetchCursos cuando el componente se monta por primera ve
     - El parametro [] se usa para indicar que la función se debe ejecutar solo una vez, cuando
    */

    const obtenerCursos = async () => {
        const data = await getCursos()
        setCursos(data)
        //cursos = data
    }

    useEffect(() => {
        //se espera la creacion del componente (return) a obtener los cursos desde supabase y alma
        obtenerCursos()
    }, [])

    // obtenerCursos()

    return (
        <div className="min-h-screen">
            {cursos.length > 0 ? (
                <CursosCard cursos={cursos} />
            ) : (
                <div className="flex flex-col gap-16 py-12 text-center">
                    <div className="space-y-4 text-left">
                        <h1 className="text-4xl md:text-5xl font-bold tracking-tight text-white">
                            Mis <span className="bg-gradient-to-r from-emerald-400 to-teal-400 bg-clip-text text-transparent">Cursos y Formaciones</span>
                        </h1>
                    </div>
                    <div className="flex flex-col items-center justify-center py-20 rounded-3xl border border-dashed border-slate-800 bg-slate-900/20">
                        <BookOpen className="h-12 w-12 text-slate-600 mb-4" />
                        <p className="text-slate-500 text-lg">No hay cursos disponibles en este momento.</p>
                    </div>
                </div>
            )}
        </div>
    )
}