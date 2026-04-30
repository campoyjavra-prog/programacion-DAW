import type { ICurso } from "@/model/interfaces/ICurso";
import { GraduationCap, BookOpen, Award, Terminal, Cpu, Globe } from "lucide-react";

interface Props {
    cursos: ICurso[];
}

// Función para asignar un icono basado en el título del curso (improvisación)
const getIconForCurso = (titulo: string) => {
    const t = titulo.toLowerCase();
    if (t.includes("programacion") || t.includes("cisco") || t.includes("dev")) return <Terminal className="h-6 w-6" />;
    if (t.includes("datos") || t.includes("inteligencia") || t.includes("ia")) return <Cpu className="h-6 w-6" />;
    if (t.includes("ciber") || t.includes("seguridad")) return <Award className="h-6 w-6" />;
    if (t.includes("web") || t.includes("desarrollo")) return <Globe className="h-6 w-6" />;
    return <BookOpen className="h-6 w-6" />;
};

export const CursosCard = ({ cursos }: Props) => {
    return (
        <div className="flex flex-col gap-16 py-12">
            {/* Encabezado al estilo de Contacto.tsx */}
            <div className="space-y-4">
                <h1 className="text-4xl md:text-5xl font-bold tracking-tight text-white">
                    Mis <span className="bg-gradient-to-r from-emerald-400 to-teal-400 bg-clip-text text-transparent">Cursos y Formaciones</span>
                </h1>
                <p className="text-slate-400 max-w-2xl text-lg leading-relaxed">
                    Una recopilación de mi aprendizaje continuo y especializaciones en el mundo de la tecnología.
                </p>
            </div>

            {/* Grid de Tarjetas */}
            <div className="grid gap-6 sm:grid-cols-2 lg:grid-cols-3">
                {cursos.map((curso) => (
                    <article
                        key={curso.idCurso}
                        className="group relative flex flex-col gap-6 rounded-3xl border border-slate-800 bg-slate-900/40 p-8 transition-all hover:border-emerald-500/30 hover:bg-slate-800/60"
                    >
                        {/* Decoración de fondo */}
                        <div className="absolute -right-4 -top-4 h-24 w-24 rounded-full bg-emerald-500/5 blur-2xl group-hover:bg-emerald-500/10 transition-colors" />

                        <div className="flex items-start justify-between">
                            <div className={`flex h-12 w-12 items-center justify-center rounded-xl bg-emerald-500/10 text-emerald-400 group-hover:scale-110 transition-transform shadow-inner ${curso.imagenUrl ? 'overflow-hidden' : ''}`}>
                                {curso.imagenUrl ? (
                                    <img src={curso.imagenUrl} alt={curso.titulo} className="h-full w-full object-cover" />
                                ) : (
                                    getIconForCurso(curso.titulo)
                                )}
                            </div>
                            <div className="text-right">
                                <p className="text-[10px] font-bold uppercase tracking-[0.2em] text-slate-500">Inversión</p>
                                <p className="text-2xl font-black text-emerald-400 drop-shadow-[0_0_10px_rgba(52,211,153,0.3)]">
                                    {curso.precio}€
                                </p>
                            </div>
                        </div>

                        <div className="space-y-2">
                            <h3 className="text-xl font-bold text-white group-hover:text-emerald-400 transition-colors">
                                {curso.titulo}
                            </h3>
                            <div className="flex items-center gap-2">
                                <GraduationCap className="h-4 w-4 text-slate-500" />
                                <p className="text-sm font-medium text-slate-400">
                                    {curso.academia}
                                </p>
                            </div>
                            {curso.categoria && (
                                <div className="mt-3 inline-flex items-center rounded-full border border-emerald-500/30 bg-emerald-500/10 px-2.5 py-0.5 text-xs font-semibold text-emerald-400 transition-colors hover:bg-emerald-500/20">
                                    {curso.categoria}
                                </div>
                            )}
                        </div>

                        {/* Línea decorativa al final */}
                        <div className="mt-auto pt-4">
                            <div className="h-1 w-12 rounded-full bg-slate-800 group-hover:w-full group-hover:bg-gradient-to-r group-hover:from-emerald-500 group-hover:to-teal-500 transition-all duration-500" />
                        </div>
                    </article>
                ))}
            </div>
        </div>
    );
};