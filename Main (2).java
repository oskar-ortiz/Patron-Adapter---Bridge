// Propuesta 3: Plataforma de Streaming con Adapter + Bridge
// Código mejorado con más proveedores y simulación de opciones predefinidas.

interface ProveedorDeVideo {
    void reproducirVideo(String titulo);
}

// ----------------- Adaptadores -----------------
class NetflixAPI {
    public void playMovie(String name) {
        System.out.println("[Netflix] Reproduciendo película: " + name);
    }
}

class YouTubeAPI {
    public void startVideo(String name) {
        System.out.println("[YouTube] Reproduciendo video: " + name);
    }
}

class DisneyAPI {
    public void streamContent(String name) {
        System.out.println("[Disney+] Transmitiendo contenido: " + name);
    }
}

class HBOAPI {
    public void hboPlay(String name) {
        System.out.println("[HBO Max] Mostrando contenido: " + name);
    }
}

class PrimeAPI {
    public void primeWatch(String name) {
        System.out.println("[Prime Video] Transmitiendo: " + name);
    }
}

// Adaptadores concretos
class NetflixAdapter implements ProveedorDeVideo {
    private NetflixAPI netflix;
    public NetflixAdapter(NetflixAPI netflix) {
        this.netflix = netflix;
    }
    public void reproducirVideo(String titulo) {
        netflix.playMovie(titulo);
    }
}

class YouTubeAdapter implements ProveedorDeVideo {
    private YouTubeAPI youtube;
    public YouTubeAdapter(YouTubeAPI youtube) {
        this.youtube = youtube;
    }
    public void reproducirVideo(String titulo) {
        youtube.startVideo(titulo);
    }
}

class DisneyAdapter implements ProveedorDeVideo {
    private DisneyAPI disney;
    public DisneyAdapter(DisneyAPI disney) {
        this.disney = disney;
    }
    public void reproducirVideo(String titulo) {
        disney.streamContent(titulo);
    }
}

class HBOAdapter implements ProveedorDeVideo {
    private HBOAPI hbo;
    public HBOAdapter(HBOAPI hbo) {
        this.hbo = hbo;
    }
    public void reproducirVideo(String titulo) {
        hbo.hboPlay(titulo);
    }
}

class PrimeAdapter implements ProveedorDeVideo {
    private PrimeAPI prime;
    public PrimeAdapter(PrimeAPI prime) {
        this.prime = prime;
    }
    public void reproducirVideo(String titulo) {
        prime.primeWatch(titulo);
    }
}

// ----------------- Bridge -----------------
abstract class Contenido {
    protected ProveedorDeVideo proveedor;
    public Contenido(ProveedorDeVideo proveedor) {
        this.proveedor = proveedor;
    }
    public abstract void reproducir();
}

class Pelicula extends Contenido {
    private String titulo;
    public Pelicula(ProveedorDeVideo proveedor, String titulo) {
        super(proveedor);
        this.titulo = titulo;
    }
    public void reproducir() {
        proveedor.reproducirVideo("Película - " + titulo);
    }
}

class Serie extends Contenido {
    private String titulo;
    public Serie(ProveedorDeVideo proveedor, String titulo) {
        super(proveedor);
        this.titulo = titulo;
    }
    public void reproducir() {
        proveedor.reproducirVideo("Serie - " + titulo);
    }
}

class Documental extends Contenido {
    private String titulo;
    public Documental(ProveedorDeVideo proveedor, String titulo) {
        super(proveedor);
        this.titulo = titulo;
    }
    public void reproducir() {
        proveedor.reproducirVideo("Documental - " + titulo);
    }
}

// ----------------- Main -----------------
public class Main {
    public static void main(String[] args) {
        // Adaptadores (Adapter)
        ProveedorDeVideo netflix = new NetflixAdapter(new NetflixAPI());
        ProveedorDeVideo youtube = new YouTubeAdapter(new YouTubeAPI());
        ProveedorDeVideo disney = new DisneyAdapter(new DisneyAPI());
        ProveedorDeVideo hbo = new HBOAdapter(new HBOAPI());
        ProveedorDeVideo prime = new PrimeAdapter(new PrimeAPI());

        // Contenidos de prueba (Bridge)
        Contenido[] playlist = {
            new Pelicula(netflix, "Matrix"),
            new Serie(youtube, "Breaking Bad"),
            new Documental(disney, "Nuestro Planeta"),
            new Pelicula(hbo, "Juego de Tronos"),
            new Serie(prime, "The Boys")
        };

        // Simulación automática (como si fueran elecciones del usuario)
        System.out.println("=== Simulación Plataforma de Streaming ===\n");
        for (Contenido c : playlist) {
            c.reproducir();
        }

        System.out.println("\n[Simulación completada con éxito]");
    }
}

