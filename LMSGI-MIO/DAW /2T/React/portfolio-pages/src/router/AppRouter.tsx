import { Home } from '../pages/Home'
import { Trabajos } from '../pages/Trabajos'
import { Contacto } from '../pages/Contacto'
import Servicios from '../pages/servicios/Servicios'
import NewServicio from '../pages/servicios/NewServicio'
import ServicioDetalle from '../pages/servicios/ServicioDetalle'
import { Routes, Route, BrowserRouter } from 'react-router-dom'
import { MainLayout } from '../layouts/MainLayout'

export const AppRouter = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route element={<MainLayout />} >
                    <Route path="/" element={<Home />} />
                    <Route path="/trabajos" element={<Trabajos />} />
                    <Route path="/contacto" element={<Contacto />} />
                    <Route path="/servicios" element={<Servicios />} />
                    <Route path="/servicios/new" element={<NewServicio />} />
                    <Route path="/servicios/:cod" element={<ServicioDetalle />} />
                </Route>
            </Routes>
        </BrowserRouter>
    )
}