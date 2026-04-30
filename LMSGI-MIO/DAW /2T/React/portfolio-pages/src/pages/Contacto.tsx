import { Mail, MapPin, Send, Github, Linkedin, Twitter } from 'lucide-react'

export const Contacto = () => {
    return (
        <div className="flex flex-col gap-12 py-12">
            {/* Encabezado */}
            <div className="space-y-4">
                <h1 className="text-4xl md:text-5xl font-bold tracking-tight text-white">
                    Hablemos de tu <span className="bg-gradient-to-r from-purple-400 to-pink-400 bg-clip-text text-transparent">próximo proyecto</span>
                </h1>
                <p className="text-slate-400 max-w-2xl text-lg leading-relaxed">
                    ¿Tienes una idea en mente o simplemente quieres saludar? Mi buzón está siempre abierto
                </p>
            </div>

            <div className="grid grid-cols-1 lg:grid-cols-2 gap-12">
                {/* Columna de Información */}
                <div className="flex flex-col gap-8">
                    <div className="space-y-6">
                        <div className="group flex items-center gap-4 rounded-2xl border border-slate-800 bg-slate-900/40 p-6 transition-all hover:border-purple-500/30">
                            <div className="flex h-12 w-12 items-center justify-center rounded-xl bg-purple-500/10 text-purple-400 group-hover:scale-110 transition-transform">
                                <Mail className="h-6 w-6" />
                            </div>
                            <div>
                                <p className="text-sm font-medium text-slate-500">Email</p>
                                <p className="text-lg font-semibold text-white">campoyjavra@gmail.com</p>
                            </div>
                        </div>

                        <div className="group flex items-center gap-4 rounded-2xl border border-slate-800 bg-slate-900/40 p-6 transition-all hover:border-blue-500/30">
                            <div className="flex h-12 w-12 items-center justify-center rounded-xl bg-blue-500/10 text-blue-400 group-hover:scale-110 transition-transform">
                                <MapPin className="h-6 w-6" />
                            </div>
                            <div>
                                <p className="text-sm font-medium text-slate-500">Ubicación</p>
                                <p className="text-lg font-semibold text-white">Huercal-Overa, Almería, España</p>
                            </div>
                        </div>
                    </div>

                    {/* Redes Sociales */}
                    <div className="space-y-4">
                        <h3 className="text-xl font-bold text-white">Sígueme</h3>
                        <div className="flex gap-4">
                            {[
                                { icon: Github, label: 'Github' },
                                { icon: Linkedin, label: 'Linkedin' },
                                { icon: Twitter, label: 'Twitter' }
                            ].map((social, i) => (
                                <button key={i} className="flex h-12 w-12 items-center justify-center rounded-xl border border-slate-800 bg-slate-900/40 text-slate-400 transition-all hover:border-white/20 hover:text-white hover:bg-slate-800">
                                    <social.icon className="h-5 w-5" />
                                </button>
                            ))}
                        </div>
                    </div>
                </div>

                {/* Columna del Formulario */}
                <div className="rounded-3xl border border-slate-800 bg-slate-900/40 p-8 shadow-2xl backdrop-blur-sm">
                    <form className="flex flex-col gap-6" onSubmit={(e) => e.preventDefault()}>
                        <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
                            <div className="space-y-2">
                                <label className="text-sm font-medium text-slate-400 ml-1">Nombre</label>
                                <input
                                    type="text"
                                    className="w-full rounded-xl border border-slate-800 bg-slate-950/50 px-4 py-3 text-white outline-none focus:border-purple-500/50 focus:ring-1 focus:ring-purple-500/20 transition-all"
                                />
                            </div>
                            <div className="space-y-2">
                                <label className="text-sm font-medium text-slate-400 ml-1">Email</label>
                                <input
                                    type="email"
                                    className="w-full rounded-xl border border-slate-800 bg-slate-950/50 px-4 py-3 text-white outline-none focus:border-purple-500/50 focus:ring-1 focus:ring-purple-500/20 transition-all"
                                />
                            </div>
                        </div>
                        <div className="space-y-2">
                            <label className="text-sm font-medium text-slate-400 ml-1">Mensaje</label>
                            <textarea
                                rows={4}
                                placeholder="¿En qué puedo ayudarte?"
                                className="w-full rounded-xl border border-slate-800 bg-slate-950/50 px-4 py-3 text-white outline-none focus:border-purple-500/50 focus:ring-1 focus:ring-purple-500/20 transition-all resize-none"
                            />
                        </div>
                        <button className="inline-flex items-center justify-center gap-2 rounded-xl bg-gradient-to-r from-purple-600 to-blue-600 px-6 py-4 font-bold text-white transition-all hover:scale-[1.02] hover:shadow-[0_0_20px_rgba(168,85,247,0.4)] active:scale-95">
                            Enviar mensaje
                            <Send className="h-5 w-5" />
                        </button>
                    </form>
                </div>
            </div>
        </div>
    )
}

