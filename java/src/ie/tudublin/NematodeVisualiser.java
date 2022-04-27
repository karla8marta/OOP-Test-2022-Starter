package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet {
	ArrayList<Nematode> nematodes = new ArrayList<Nematode>();

	public void keyPressed() {
		if (keyCode == LEFT) {
		}
	}

	public void settings() {
		size(800, 800);
		loadNematodes();
		printNematodes();
	}

	public void setup() {
		colorMode(HSB);
		background(0);
		smooth();
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

	}
}
