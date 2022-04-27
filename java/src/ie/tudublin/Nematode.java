package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Nematode {
    private String name;
    private int length;
    private boolean limbs;
    private String gender;
    private boolean eyes;

    public Nematode(String name, int length, boolean limbs, String gender, boolean eyes) {
        this.name = name;
        this.length = length;
        this.limbs = limbs;
        this.gender = gender;
        this.eyes = eyes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isLimbs() {
        return limbs;
    }

    public void setLimbs(boolean limbs) {
        this.limbs = limbs;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isEyes() {
        return eyes;
    }

    public void setEyes(boolean eyes) {
        this.eyes = eyes;
    }

    public Nematode(TableRow tr) {

        this(tr.getString("name"), tr.getInt("length"), tr.getInt("limbs") == 1, tr.getString("gender"),
                tr.getInt("eyes") == 1);
    }

    @Override
    public String toString() {
        return "Nematode [eyes=" + eyes + ", gender=" + gender + ", length=" + length + ", limbs=" + limbs + ", name="
                + name + "]";
    }

    public void render(NematodeVisualiser na) {

        for (int i = 0; i < getLength(); i++) {

            na.fill(0);
            na.stroke(255);
            na.circle(400, 25 * i + 200, 25);

            if (isLimbs() == true) {
                na.stroke(255);
                na.fill(0);
                na.line(412, 25 * i + 200, 425, 25 * i + 200);
                na.line(385, 25 * i + 200, 370, 25 * i + 200);
            }

            if (isEyes() == true && i == 0) {
                na.line(412, 190, 420, 170);
                na.line(385, 190, 370, 170);
                na.circle(420, 170, 5);
                na.circle(370, 170, 5);
            }

            na.textSize(15);
            na.fill(255);
            na.text(getName(), 390, 155);

        }

    }
}
