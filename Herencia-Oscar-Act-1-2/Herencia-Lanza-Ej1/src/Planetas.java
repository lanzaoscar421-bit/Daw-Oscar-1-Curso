public class Planetas extends Astros{

    private double distanciaSol;
    private double orbitaSol;
    private boolean tieneAstros;

    public Planetas(double radioEcuatorial, double rotacionSobreEje, double masa, double gravedad, double temperatura, double distanciaSol, double orbitaSol, boolean tieneAstros) {
        super(radioEcuatorial, rotacionSobreEje, masa, gravedad, temperatura);
        this.distanciaSol = distanciaSol;
        this.orbitaSol = orbitaSol;
        this.tieneAstros = tieneAstros;
    }

    public double getDistanciaSol() {
        return distanciaSol;
    }

    public double getOrbitaSol() {
        return orbitaSol;
    }

    public boolean isTieneAstros() {
        return tieneAstros;
    }


    @Override
    public void info() {
        System.out.println("---- PLANETA ----");
        System.out.println("Radio ecuatorial: " + getRadioEcuatorial());
        System.out.println("Rotación sobre su eje: " + getRotacionSobreEje());
        System.out.println("Masa: " + getMasa());
        System.out.println("Temperatura media: " + getTemperatura());
        System.out.println("Gravedad: " + getGravedad());
        System.out.println("Distancia al Sol: " + getDistanciaSol());
        System.out.println("Órbita alrededor del Sol:\n " + getOrbitaSol());
    }



    }
