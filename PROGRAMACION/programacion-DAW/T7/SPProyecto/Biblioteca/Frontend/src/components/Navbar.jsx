import { Link } from 'react-router-dom';

const Navbar = () => {
  return (
    <nav className="bg-slate-900 border-b border-slate-800 text-white sticky top-0 z-50 shadow-md">
      <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div className="flex items-center justify-between h-16">
          <div className="flex items-center gap-8">
            <Link to="/" className="flex items-center space-x-2 group">
              <span className="text-3xl font-bold bg-gradient-to-r from-blue-400 to-emerald-400 bg-clip-text text-transparent group-hover:from-blue-300 group-hover:to-emerald-300 transition-all">
                BIBLIOTECA
              </span>
            </Link>
            <div className="hidden md:block">
              <div className="flex items-baseline space-x-4">
                <Link
                  to="/"
                  className="px-3 py-2 rounded-lg text-lg font-medium hover:bg-slate-800 hover:text-blue-400 transition-colors"
                >
                  Biblioteca
                </Link>
                <Link
                  to="/cv"
                  className="px-3 py-2 rounded-lg text-lg font-medium hover:bg-slate-800 hover:text-blue-400 transition-colors"
                >
                  Mi CV
                </Link>
                <Link
                  to="/nuevo"
                  className="px-3 py-2 rounded-lg text-lg font-medium hover:bg-slate-800 hover:text-blue-400 transition-colors"
                >
                  Añadir Libro
                </Link>
              </div>
            </div>
          </div>
          <div className="flex items-center">
            <button className="bg-blue-600 hover:bg-blue-500 text-white px-4 py-2 rounded-full text-md font-semibold transition-all shadow-lg shadow-blue-500/30 active:scale-95">
              Acceder
            </button>
          </div>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
