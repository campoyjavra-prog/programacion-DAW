// 3 forma, arrow function
const QSomos = () => {
    //codigo TS o JS
    return (
        // Mezclaremos codigo html + componentes de Tailwind + xs
        <section id="qsomos" className="min-h-screen flex items-center justify-center">
            <h1 className="text-4xl font-bold">Quiénes somos</h1>
        </section>
    );
}

export default QSomos;


// 1 forma de definir un componente en react con funcion JS tradicional
// function QSomos() {
//     return (
//         <section>
//             <h2>¿Quiénes somos?</h2>
//         </section>
//     );
// }

// export default QSomos;

// 2 forma, Idem anterior pero con funcion + exportacion directa
// export default function QSomos1() {
//     return (
//         <section>
//             <h2>¿Quiénes somos?</h2>
//         </section>
//     );
// }


