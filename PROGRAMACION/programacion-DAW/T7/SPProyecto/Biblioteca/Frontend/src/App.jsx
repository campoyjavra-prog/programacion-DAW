import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import CV from './pages/CV';
import Biblioteca from './pages/Biblioteca';
import NuevoLibro from './pages/NuevoLibro';
import EditarLibro from './pages/EditarLibro';

function App() {
  return (
    <BrowserRouter>
      {/* El Navbar estará visible en todas las páginas */}
      <Navbar />

      <main className="min-h-screen bg-slate-50 text-slate-900">
        <Routes>
          <Route path="/" element={<Biblioteca />} />
          <Route path="/nuevo" element={<NuevoLibro />} />
          <Route path="/editar/:id" element={<EditarLibro />} />
          <Route path="/cv" element={<CV />} />
        </Routes>
      </main>
    </BrowserRouter>
  );
}

export default App;
