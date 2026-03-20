import { NavLink } from "react-router-dom";

export const NavBar = () => {
    const linkClass = ({ isActive }: { isActive: boolean }) =>
        isActive ? 'text-blue-400 font-bold tracking-wide' : 'text-slate-300 hover:text-white transition-colors duration-200 tracking-wide';

    return (
        <nav className="justify-center max-w-5xl mx-auto flex items-center gap-6 p-4">
            <NavLink to="/" className={linkClass}>Home</NavLink>
            <span className="text-slate-600 font-light select-none">|</span>
            <NavLink to="/trabajos" className={linkClass}>Trabajos</NavLink>
            <span className="text-slate-600 font-light select-none">|</span>
            <NavLink to="/contacto" className={linkClass}>Contactos</NavLink>
        </nav>
    )
}