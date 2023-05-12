package mini_project_restaurantbillgenerator;

public class Dish {
    private int kod;
    private String yiyecekIsmi;
    private double ucret;

    public Dish(int kod, String yiyecekIsmi, double ucret) {
        this.kod = kod;
        this.yiyecekIsmi = yiyecekIsmi;
        this.ucret = ucret;
    }

    public int getKod() {
        return kod;
    }

    public String getYiyecekIsmi() {
        return yiyecekIsmi;
    }

    public double getUcret() {
        return ucret;
    }

    @Override
    public String toString() {
        return "kod=" + kod +
                ", yiyecekIsmi='" + yiyecekIsmi + '\'' +
                ", ucret=" + ucret;
    }
}
