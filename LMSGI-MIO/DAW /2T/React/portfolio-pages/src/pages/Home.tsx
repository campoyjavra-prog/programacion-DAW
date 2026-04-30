import { ArrowRight, Code, Layout, Server, Sparkles } from 'lucide-react'
import { Link } from 'react-router-dom'
import heroBg from '../assets/hero_bg.png'
import avatar from '../assets/avatar.png'

export const Home = () => {
    return (
        <div className="flex flex-col gap-20 py-10">
            {/* Hero Section */}
            <section className="relative overflow-hidden rounded-3xl bg-slate-900 p-8 md:p-16">
                <div className="absolute inset-0 z-0">
                    <img
                        src={heroBg}
                        alt="Background"
                        className="h-full w-full object-cover opacity-40 mix-blend-overlay"
                    />
                    <div className="absolute inset-0 bg-gradient-to-t from-slate-950 via-slate-950/40 to-transparent" />
                </div>

                <div className="relative z-10 flex flex-col items-center gap-8 text-center md:flex-row md:text-left">
                    <div className="flex-1 space-y-6">
                        <div className="inline-flex items-center gap-2 rounded-full bg-purple-500/10 px-4 py-1.5 text-sm font-medium text-purple-400 ring-1 ring-inset ring-purple-500/20">
                            <Sparkles className="h-4 w-4" />
                            <span>Disponible para nuevos proyectos</span>
                        </div>

                        <h1 className="text-5xl font-bold tracking-tight text-white md:text-7xl leading-tight">
                            Transformando <span className="bg-gradient-to-r from-purple-400 to-blue-400 bg-clip-text text-transparent">ideas</span> en experiencias digitales.
                        </h1>

                        <p className="max-w-xl text-lg text-slate-400">
                            Soy Rafa, desarrollador full-stack apasionado por crear aplicaciones web modernas, rápidas y visualmente impactantes.
                        </p>

                        <div className="flex flex-wrap items-center justify-center gap-4 md:justify-start pt-8">
                            <Link 
                                to="/trabajos"
                                className="inline-flex items-center gap-2 rounded-xl bg-purple-600 px-6 py-3 font-semibold text-white transition-all hover:bg-purple-500 hover:shadow-[0_0_20px_rgba(168,85,247,0.4)] cursor-pointer"
                            >
                                Ver mis trabajos
                                <ArrowRight className="h-5 w-5" />
                            </Link>
                            <button className="inline-flex items-center gap-2 rounded-xl border border-slate-700 bg-slate-900/50 px-6 py-3 font-semibold text-white backdrop-blur-sm transition-all hover:bg-slate-800 cursor-pointer">
                                Contactar
                            </button>
                        </div>
                    </div>

                    <div className="relative hidden lg:block">
                        <div className="absolute -inset-1 rounded-full bg-gradient-to-r from-purple-600 to-blue-600 opacity-75 blur-lg" />
                        <img
                            src={avatar}
                            alt="Rafael"
                            className="relative h-64 w-64 rounded-full border-4 border-slate-900 object-cover shadow-2xl"
                        />
                    </div>
                </div>
            </section>

            {/* Features Section */}
            <section className="grid gap-8 md:grid-cols-3">
                <div className="group rounded-2xl border border-slate-800 bg-slate-900/50 p-8 transition-all hover:border-purple-500/50 hover:bg-slate-900">
                    <div className="mb-4 inline-flex h-12 w-12 items-center justify-center rounded-xl bg-purple-500/10 text-purple-400 ring-1 ring-purple-500/20 group-hover:scale-110 transition-transform">
                        <Code className="h-6 w-6" />
                    </div>
                    <h3 className="mb-2 text-xl font-bold text-white">Desarrollo Web</h3>
                    <p className="text-slate-400">
                        Aplicaciones robustas y escalables utilizando las últimas tecnologías como React, Next.js y Node.js.
                    </p>
                </div>

                <div className="group rounded-2xl border border-slate-800 bg-slate-900/50 p-8 transition-all hover:border-blue-500/50 hover:bg-slate-900">
                    <div className="mb-4 inline-flex h-12 w-12 items-center justify-center rounded-xl bg-blue-500/10 text-blue-400 ring-1 ring-blue-500/20 group-hover:scale-110 transition-transform">
                        <Layout className="h-6 w-6" />
                    </div>
                    <h3 className="mb-2 text-xl font-bold text-white">UI/UX Design</h3>
                    <p className="text-slate-400">
                        Interfaces intuitivas y atractivas diseñadas con el usuario en el centro de cada decisión.
                    </p>
                </div>

                <div className="group rounded-2xl border border-slate-800 bg-slate-900/50 p-8 transition-all hover:border-emerald-500/50 hover:bg-slate-900">
                    <div className="mb-4 inline-flex h-12 w-12 items-center justify-center rounded-xl bg-emerald-500/10 text-emerald-400 ring-1 ring-emerald-500/20 group-hover:scale-110 transition-transform">
                        <Server className="h-6 w-6" />
                    </div>
                    <h3 className="mb-2 text-xl font-bold text-white">Cloud & DevOps</h3>
                    <p className="text-slate-400">
                        Despliegue optimizado y gestión de infraestructuras en la nube para asegurar el máximo rendimiento.
                    </p>
                </div>
            </section>
        </div>
    )
}