import { NavBar } from "../components/NavBar";
import { Outlet } from "react-router-dom";

export const MainLayout = () => {
    return (
        <div className="min-h-screen bg-slate-950 text-slate-50 flex flex-col w-full font-sans">
            <header className="w-full border-b border-slate-800 bg-slate-950/80 backdrop-blur-md sticky top-0 z-50">
                <NavBar />
            </header>

            <main className="flex-grow w-full max-w-5xl mx-auto p-8 flex flex-col">
                <Outlet />
            </main>

            <footer className="w-full border-t border-slate-800 p-6 text-center text-slate-400">
                <p>© 2026 Portfolio Pages. All rights reserved.</p>
            </footer>
        </div>
    )
}