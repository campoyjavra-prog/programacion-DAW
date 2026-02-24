// este componente cre el front-end de la aplicacion, es la parte publica

import Header from "../components/main/Header";
import QSomos from "../sections/QSomos";
import Trabajos from "../sections/Trabajos";
import Formaciones from "../sections/Formaciones";

function MainLayout() {
    return (
        <div className="min-h-screen w-full bg-gray-900 text-white">
            <Header />
            <main>
                <QSomos />
                <Trabajos />
                <Formaciones />
            </main>
        </div>
    );
}

export default MainLayout;