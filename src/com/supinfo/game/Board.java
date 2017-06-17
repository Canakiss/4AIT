package com.supinfo.game;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private Square[][] tab;
	private int width;
	private int height;
	private List<Point> points;
	private List<Line> lines;

	public Board(int x, int y) {
		points = new ArrayList<Point>();
		lines = new ArrayList<Line>();
		tab = new Square[x][y];
		this.width = x;
		this.height = y;
		initBoard();
	}

	private void initBoard() {

		for(int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				Point p1, p2, p3, p4;
				Line top, right, bottom ,left;
				Square square;
				if (x== 0 && y ==0) {
					p1 = new Point(x, y, y*width+x); points.add(p1);
					p2 = new Point(x+1, y, y*width+x+1); points.add(p2);
					p3 = new Point(x, y+1, (y+1)*width+x+1); points.add(p3);
					p4 = new Point(x+1, y+1, (y+1)*width+x+2); points.add(p4);

					top = new Line(p1, p2); lines.add(top);
					right = new Line(p2, p4); lines.add(right);
					bottom = new Line(p3, p4); lines.add(bottom);
					left = new Line(p1, p3); lines.add(left);

				} else if (y == 0) {
					p1 = tab[x-1][y].getRight().getPoint1(); 
					p2 = new Point(x+1, y, y*width+x+1); points.add(p2);
					p3 = tab[x-1][y].getRight().getPoint2();
					p4 = new Point(x+1, y+1, (y+1)*width+x+(y+2)); points.add(p4);

					top = new Line(p1, p2); lines.add(top);
					right = new Line(p2, p4); lines.add(right);
					bottom = new Line(p3, p4); lines.add(bottom);
					left = tab[x-1][y].getRight();
				} else if (x == 0) {
					p1 = tab[x][y-1].getBottom().getPoint1();
					p2 = tab[x][y-1].getBottom().getPoint2();
					p3 = new Point(x, y+1, (y+1)*width+x+y+1); points.add(p3);
					p4 = new Point(x+1, y+1, (y+1)*width+x+y+2); points.add(p4);

					top = tab[x][y-1].getBottom();
					right = new Line(p2, p4); lines.add(right);
					bottom = new Line(p3, p4); lines.add(bottom);
					left = new Line(p1, p3); lines.add(left);
				} else {
					//p1 = tab[x-1][y].getTop().getPoint1();
					p2 = tab[x][y-1].getBottom().getPoint2();
					p3 = tab[x-1][y].getRight().getPoint2();
					p4 = new Point(x+1, y+1, (y+1)*width+x+y+2); points.add(p4);

					top = tab[x][y-1].getBottom();
					right = new Line(p2, p4); lines.add(right);
					bottom = new Line(p3, p4); lines.add(bottom);
					left = tab[x-1][y].getRight();
				}
				square = new Square(top, bottom, left, right);
				tab[x][y] = square;
			}
		}
	}
	public void promptBoard() {
		for(int y = 0; y < height; y++) {
			String line1 = tab[0][y].getTop().getPoint1().getValue()+"";
			String line2 = "";
			for (int x = 0; x < width; x++) {

				if (tab[x][y].getTop().isAvailable()) {
					line1 += " ";
				} else {
					line1+="-";
				}
				line1+=tab[x][y].getTop().getPoint2().getValue();
				if (tab[x][y].getLeft().isAvailable()) {
					line2 += "    ";
				} else {
					line2+=" |  ";
				}
				if (x == width-1) {
					if (tab[x][y].getRight().isAvailable()) {
						line2 += "  ";
					} else {
						line2+=" |";
					}
				}
			}
			System.out.println(line1+'\n'+line2);
		}
		String lastline = "";
		lastline+=tab[0][height-1].getBottom().getPoint1().getValue();
		for (int x = 0; x < width; x++) {
			if (tab[x][height-1].getBottom().isAvailable()) {
				lastline += " ";
			} else {
				lastline+="-";
			}
			lastline+=tab[x][height-1].getBottom().getPoint2().getValue();
		}
		System.out.println(lastline);
	}

	public Line addLine(int p1, int p2) {
		int searchPoint1, searchPoint2;
		Point point1 = null, point2 = null;
		if (p1<p2) {
			searchPoint1 = p1;
			searchPoint2 = p2;
		} else {
			searchPoint1 = p2;
			searchPoint2 = p1;
		}

		for (Point p : points) {
			if (p.getValue() == searchPoint1) {
				point1=p;
			}
			if (p.getValue() == searchPoint2) {
				point2=p;
			}
		}
		for(Line line : lines) {
			if (line.getPoint1()==point1 && line.getPoint2()==point2 && line.isAvailable()) {
				line.setAvailable(false);
				return line;
			}
		}
		return null;
	}

	public boolean lineAvailable(int p1, int p2) {
		int searchPoint1, searchPoint2;
		Point point1 = null, point2 = null;
		if (p1<p2) {
			searchPoint1 = p1;
			searchPoint2 = p2;
		} else {
			searchPoint1 = p2;
			searchPoint2 = p1;
		}

		for (Point p : points) {
			if (p.getValue() == searchPoint1) {
				point1=p;
			}
			if (p.getValue() == searchPoint2) {
				point2=p;
			}
		}
		for(Line line : lines) {
			if (line.getPoint1()==point1 && line.getPoint2()==point2 && line.isAvailable()) {
				return true;
			}
		}

		return false;
	}

	public int winPoints(Line line) {
		
		int res = 0;
		
		for(int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (tab[x][y].belongsSquare(line) && tab[x][y].squareValue() == 4) {
					res+=1;
				}
			}
		}
		return res;
	}
	
	public boolean canPlay() {
		for(Line line : lines) {
			if (line.isAvailable()) {
				return true;
			}
		}
		return false;
	}

	//GETTERS
	public List<Point> getPoints() {
		return points;
	}

	public List<Line> getLines() {
		return lines;
	}
}
