document.addEventListener('DOMContentLoaded', () => {
    const showroom = document.getElementById('showroom');

    // Función para formatear precio
    const formatPrice = (price) => {
        return new Intl.NumberFormat('es-ES', { style: 'currency', currency: 'EUR' }).format(price);
    };

    // Fecth de datos
    fetch('coches.json')
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al cargar los datos');
            }
            return response.json();
        })
        .then(coches => {
            // Limpiar estado de carga
            showroom.innerHTML = '';

            // Renderizar cada coche
            coches.forEach(coche => {
                const card = document.createElement('article');

                // Generar HTML con la estructura Flex-Basis solicitada
                card.innerHTML = `
                    <div class="envio">${coche.marca}</div>
                    
                    <figure>
                        <img src="${coche.imagen}" alt="${coche.marca} ${coche.modelo}" loading="lazy">
                    </figure>
                    
                    <div class="nombre">${coche.modelo}</div>
                    
                    <div class="caracteristicas">
                        <div class="disco">${formatPrice(coche.precio)}</div>
                    </div>
                    
                    <div class="valoraciones">
                        <div class="star">
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                        </div>
                        <div class="nvaloraciones">(12)</div>
                    </div>
                `;

                showroom.appendChild(card);
            });
        })
        .catch(error => {
            console.error('Error:', error);
            showroom.innerHTML = `
                <div class="error-message">
                    <p>⚠️ No se pudieron cargar los vehículos. Por favor, intenta de nuevo más tarde.</p>
                </div>
            `;
        });
});
