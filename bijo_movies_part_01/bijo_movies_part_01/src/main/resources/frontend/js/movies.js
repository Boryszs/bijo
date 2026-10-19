document.addEventListener('DOMContentLoaded', () => {
    const moviesContainer = document.getElementById('movies');
    const addMovieBtn = document.getElementById('add-movie');

    // Obsługa przycisku nawigacji
    addMovieBtn.addEventListener('click', () => {
        window.location.href = 'add-movie.html';
    });

    moviesContainer.addEventListener('click', (event) => {
        const button = event.target.closest('button[data-movie-id]');
        if (button && moviesContainer.contains(button) && !button.disabled) {
            deleteMovie(button);
        }
    });

    // Pobranie danych przy uruchomieniu
    fetchMovies();

    async function fetchMovies() {
        try {
            const response = await fetch('http://127.0.0.1:8080/api/movies');

            if (!response.ok) {
                throw new Error('Błąd sieci lub serwera');
            }

            const data = await response.json();
            console.log('Pobrane dane:', data);

            renderMovies(data);
        } catch (error) {
            console.error('Błąd pobierania:', error);
            moviesContainer.innerHTML = `
                <div class="error-msg" style="grid-column: 1 / -1;">
                    Mam problem z wyświetleniem danych... :/ <br>
                    (Upewnij się, że aplikacja Spring Boot jest uruchomiona)
                </div>`;
        }
    }

    async function deleteMovie(button) {
        button.disabled = true;

        try {
            const movieId = encodeURIComponent(button.dataset.movieId);
            const response = await fetch(`http://127.0.0.1:8080/api/${movieId}`, {
                method: 'DELETE'
            });

            if (!response.ok) {
                throw new Error('Serwer zwrócił błąd podczas usuwania filmu');
            }

            await fetchMovies();
        } catch (error) {
            console.error('Błąd usuwania:', error);
            window.alert('Nie udało się usunąć filmu. Spróbuj ponownie.');
        } finally {
            button.disabled = false;
        }
    }

    function renderMovies(movies) {
        if (!movies || movies.length === 0) {
            moviesContainer.innerHTML = "<p style='grid-column: 1 / -1; text-align: center;'>Brak filmów w bazie.</p>";
            return;
        }

        const html = movies.map(movie => {
            const imageUrl = isImage(movie.image) ? movie.image : getPlaceholder();
            const year = movie.year ? movie.year : "????";

            return `
                <div class="card">
                    <img src="${imageUrl}" alt="Plakat filmu ${movie.title}">
                    <div class="card-content">
                        <h3>${movie.title}</h3>
                        <p class="title-label">Rok produkcji</p>
                        <p class="year">${year}</p>
                        <button type="button" onclick="deleteData(${movie.movieId})" data-movie-id="${movie.movieId}" title="Usuń film" aria-label="Usuń film o ID ${movie.movieId}">ID: ${movie.movieId}</button>
                    </div>
                </div>
            `;
        }).join(''); // join łączący tablicę w jeden długi string HTML

        moviesContainer.innerHTML = html;
    }

    // Funkcje pomocnicze
    function isImage(url) {
        if (!url) return false;
        const lowerUrl = url.toLowerCase();
        return lowerUrl.endsWith(".jpg") || lowerUrl.endsWith(".png") || lowerUrl.endsWith(".jpeg");
    }

    async function deleteData() {
        try {
                const response = await fetch('http://127.0.0.1:8080/api/delete');

                if (!response.ok) {
                    throw new Error('Błąd sieci lub serwera');
                }

                const data = await response.json();
                console.log('Pobrane dane:', data);

                renderMovies(data);
            } catch (error) {
                console.error('Błąd pobierania:', error);
                moviesContainer.innerHTML = `
                    <div class="error-msg" style="grid-column: 1 / -1;">
                        Mam problem z wyświetleniem danych... :/ <br>
                        (Upewnij się, że aplikacja Spring Boot jest uruchomiona)
                    </div>`;
            }
    }

    function getPlaceholder() {
        return './img/placeholder.png';
    }
});
