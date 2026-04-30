import type { ICurso } from "@/model/interfaces/ICurso"
import { supabase } from "@/model/utils/supabase"

/* Una promesa que cuando se resuelva devolverá un array de IProd
   Algo que no tienes aún, pero tendrás en el futuro
   Voy a devolverte una lista de productos... pero no ahora, sino e
*/
export const getCursos = async (): Promise<ICurso[]> => {
    const { data, error } = await supabase
        .from('cursos')
        .select()

    console.log('Respuesta Supabase:', data, error)

    if (error) {
        console.error(error)
        return []
    }

    return data as ICurso[]
}

// getCurso(id:number) => devuelve un curso por su id

// getFilterCursos(precio, academia, categoria)

export const insertarCurso = async (curso: any) => {
    const { data, error } = await supabase
        .from('cursos')
        .insert([curso])
    
    if (error) {
        console.error("Error al insertar curso:", error)
        throw error
    }
    return data
}