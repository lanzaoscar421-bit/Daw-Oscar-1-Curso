public class Satelites extends Astros {


    private double distanciaPlaneta;
    private double orbitaPlaneta;
    private String planetaPertence;

    public Satelites(double radioEcuatorial, double rotacionSobreEje, double masa, double gravedad, double temperatura, double distanciaPlaneta, double orbitaPlaneta, String planetaPertence) {
        super(radioEcuatorial, rotacionSobreEje, masa, gravedad, temperatura);
        this.distanciaPlaneta = distanciaPlaneta;
        this.orbitaPlaneta = orbitaPlaneta;
        this.planetaPertence = planetaPertence;
    }

    public double getDistanciaPlaneta() {
        return distanciaPlaneta;
    }

    public double getOrbitaPlaneta() {
        return orbitaPlaneta;
    }

    public String getPlanetaPertence() {
        return planetaPertence;
    }
    @Override
    public void info() {
        System.out.println("---- SATÉLITE ----");
        System.out.println("Planeta al que pertenece: " + getPlanetaPertence());
        System.out.println("Radio ecuatorial: " + getRadioEcuatorial());
        System.out.println("Rotación sobre su eje: " + getRotacionSobreEje());
        System.out.println("Masa: " + getMasa());
        System.out.println("Temperatura media: " + getTemperatura());
        System.out.println("Gravedad: " + getGravedad());
        System.out.println("Distancia al planeta: " + distanciaPlaneta);
        System.out.println("Órbita planetaria: " + getOrbitaPlaneta());
    }


}
