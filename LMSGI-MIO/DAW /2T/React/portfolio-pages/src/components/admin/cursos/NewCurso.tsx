import { cn } from "@/lib/utils"
import { Button } from "@/components/ui/button"
import {
    Card,
    CardContent,
    CardDescription,
    CardHeader,
    CardTitle,
    CardFooter,
} from "@/components/ui/card"
import {
    Field,
    FieldGroup,
    FieldLabel,
} from "@/components/ui/field"
import { Input } from "@/components/ui/input"
import { useForm } from "react-hook-form"
import { insertarCurso } from "@/model/api/main/apiCursos"

interface ICursoForm {
    titulo: string;
    academia: string;
    categoria: string;
    precio: number;
    imagenUrl: string;
}

export function NewCurso({
    className,
    onCursoAñadido,
    ...props
}: React.ComponentProps<"div"> & { onCursoAñadido?: () => void }) {
    const { register, handleSubmit, reset } = useForm<ICursoForm>();

    const onSubmit = async (data: ICursoForm) => {
        try {
            await insertarCurso(data);
            reset();
            if (onCursoAñadido) {
                onCursoAñadido();
            }
        } catch (error) {
            console.error("Error al insertar el curso:", error);
            alert("No se pudo insertar el curso. Revisa la consola.");
        }
    };

    return (
        <div className={cn("flex flex-col gap-6 max-w-3xl mx-auto w-full", className)} {...props}>
            <Card>
                <CardHeader>
                    <CardTitle>Insertar Nuevo Curso</CardTitle>
                    <CardDescription>
                        Rellena el formulario con los detalles del curso para agregarlo al sistema.
                    </CardDescription>
                </CardHeader>
                <form onSubmit={handleSubmit(onSubmit)}>
                    <CardContent className="pb-8">
                        <FieldGroup className="grid grid-cols-1 md:grid-cols-2 gap-6">
                             {/* Campo 1: Título */}
                            <Field>
                                <FieldLabel htmlFor="titulo">Título</FieldLabel>
                                <Input
                                    id="titulo"
                                    type="text"
                                    placeholder="Titulo del curso"
                                    {...register("titulo", { required: true })}
                                />
                            </Field>

                            {/* Campo 2: Academia */}
                            <Field>
                                <FieldLabel htmlFor="academia">Academia</FieldLabel>
                                <Input
                                    id="academia"
                                    type="text"
                                    placeholder="Academia del curso"
                                    {...register("academia", { required: true })}
                                />
                            </Field>

                            {/* Campo 3: Categoría */}
                            <Field>
                                <FieldLabel htmlFor="categoria">Categoría</FieldLabel>
                                <Input
                                    id="categoria"
                                    type="text"
                                    placeholder="Categoria del curso"
                                    {...register("categoria", { required: true })}
                                />
                            </Field>

                            {/* Campo 4: Precio */}
                            <Field>
                                <FieldLabel htmlFor="precio">Precio</FieldLabel>
                                <Input
                                    id="precio"
                                    type="number"
                                    step="0.01"
                                    placeholder="Precio del curso"
                                    {...register("precio", { required: true, valueAsNumber: true })}
                                />
                            </Field>

                            {/* Campo 5: URL de la imagen (ocupa todo el ancho) */}
                            <Field className="md:col-span-2">
                                <FieldLabel htmlFor="imagenUrl">URL de la imagen</FieldLabel>
                                <Input
                                    id="imagenUrl"
                                    type="text"
                                    placeholder="URL de la imagen"
                                    {...register("imagenUrl", { required: true })}
                                />
                            </Field>

                        </FieldGroup>
                    </CardContent>
                    <CardFooter className="pt-6">
                        <Button type="submit" className="w-full">
                            Insertar Curso
                        </Button>
                    </CardFooter>
                </form>
            </Card>
        </div>
    )
}

export default NewCurso;
