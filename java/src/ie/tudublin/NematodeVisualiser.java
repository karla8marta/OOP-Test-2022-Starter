package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet {
	ArrayList<Nematode> nematodes = new ArrayList<Nematode>();

	int worm_num = 0;

	public void keyPressed() {
		if (keyCode == LEFT) {
			worm_num -= 1;
			if (worm_num == -1) {
				worm_num = 12;

			}
		}

		if (keyCode == RIGHT) {
			worm_num += 1;
			if (worm_num == 13) {
				worm_num = 0;
			}
		}
	}

	public void settings() {
		size(800, 800);
	}

	public void setup() {
		colorMode(HSB);
		background(0);
		smooth();
		loadNematodes();
		printNematodes();
	}

	public void loadNematodes() {
		Table table = loadTable("nematodes.csv", "header");

		for (TableRow r : table.rows()) {
			Nematode s = new Nematode(r);
			nematodes.add(s);
		}
	}

	public void printNematodes() {
		for (Nematode s : nematodes) {
			System.out.println(s);
		}
	}

	public void draw() {
		drawNematodes();
	}

	public void drawNematodes() {

		nematodes.get(worm_num).render(this);

	}

}
