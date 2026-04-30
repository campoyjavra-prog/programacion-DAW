import { Home } from '../pages/Home'
import Trabajos from '../pages/Trabajos'
import { Contacto } from '../pages/Contacto'
import { Routes, Route, BrowserRouter } from 'react-router-dom'
import { MainLayout } from '../layouts/MainLayout'
import { BackLayout } from '../layouts/BackLayout'
import { Cursos } from '../pages/cursos/Cursos'
import { AdminCursosHome } from '../pages/admin/cursos/home'
import { AdminTrabajos } from '../pages/admin/trabajos/home'
import { AdminServicios } from '../pages/admin/servicios/home'
// He eliminado la importación de NewCurso porque el usuario pidió renderizarlo dentro de AdminCursosHome.

export const AppRouter = () => {
    return (
        <BrowserRouter>
            <Routes>
                {/* Rutas Públicas */}
                <Route element={<MainLayout />} >
                    <Route path="/" element={<Home />} />
                    <Route path="/trabajos" element={<Trabajos />} />
                    <Route path="/contacto" element={<Contacto />} />
                    <Route path="/cursos" element={<Cursos />} />
                </Route>

                {/* Rutas de Administración */}
                <Route element={<BackLayout />}>
                    <Route path="/admin/cursos" element={<AdminCursosHome />} />
                    <Route path="/admin/trabajos" element={<AdminTrabajos />} />
                    <Route path="/admin/servicios" element={<AdminServicios />} />
                </Route>
            </Routes>
        </BrowserRouter>
    )
}