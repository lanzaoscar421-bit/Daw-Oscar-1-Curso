public abstract class Astros {

    private double radioEcuatorial;
    private double rotacionSobreEje;
    private double masa;
    private double gravedad;
    private double temperatura;

    public Astros(double radioEcuatorial, double rotacionSobreEje, double masa, double gravedad, double temperatura) {
        this.radioEcuatorial = radioEcuatorial;
        this.rotacionSobreEje = rotacionSobreEje;
        this.masa = masa;
        this.gravedad = gravedad;
        this.temperatura = temperatura;
    }

    public double getRadioEcuatorial() {
        return radioEcuatorial;
    }

    public double getRotacionSobreEje() {
        return rotacionSobreEje;
    }

    public double getMasa() {
        return masa;
    }

    public double getGravedad() {
        return gravedad;
    }

    public double getTemperatura() {
        return temperatura;
    }

    //Metodo para la informacion Abstracto
    public abstract void info();

}
