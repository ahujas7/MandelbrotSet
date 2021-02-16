import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Mandelbrot {

	JFrame frame;

	DrawCanvas canvas;

	static int xCoord = 1440;
	static int yCoord = 540;

	static double scaleX = 480;
	static double scaleY = 360;

	static double complexX = 0;
	static double complexY = 0;

	static int iterations = 0;


	static double toComplexX (int javaX) {

		return (javaX - xCoord) / scaleX;

	}

	static double toComplexY (int javaY) {

		return (yCoord - javaY) / scaleY;

	}

	static boolean belongsToSet(ComplexNumber input) {

		ComplexNumber CN = new ComplexNumber();

		for (int x = 0; x < 100; x++) {

			iterations++;

			ComplexNumber nextCN = CN.square().add(input);

			double mod = nextCN.modulus();

			CN = nextCN;

			if (mod >= 2) break;

		}


		if (CN.modulus() >= 2) return false;
		else return true;

	}

	class DrawCanvas extends JPanel {

		public void paintComponent(Graphics g) {

			super.paintComponent(g);

			for (int y = 0; y < 1080; y++) {

				for (int x = 0; x < 1920; x++) {

					boolean check = belongsToSet(new ComplexNumber(toComplexX(x), toComplexY(y)));

					if (check) { 

						g.setColor(Color.BLACK); g.drawLine(x, y, x, y);

					}
					else if (iterations > 0 && iterations <= 100) {

						float h = 278f / 360f;
						float s = 0.8f;
						float b = iterations/ 100f;

						g.setColor(Color.getHSBColor(h, s, b)); g.drawLine(x, y, x, y);

					}

					iterations = 0;
          
				}
			}

			g.setColor(Color.WHITE);

			//Coordinates

			g.drawString("Coordinates:", 10, 20);
			g.drawString("X: " + complexX, 10, 40);
			g.drawString("Y: " + complexY, 10, 60);

		}	
	}

	public Mandelbrot() {

		frame = new JFrame();

		frame.addMouseMotionListener(new MouseMotionListener() {

			public void mouseMoved(MouseEvent evt) {

				complexX = toComplexX(evt.getX());
				complexY = toComplexY(evt.getY());

				frame.repaint();
			}


			public void mouseDragged(MouseEvent e) {}

		});

		frame.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent evt) {

				switch(evt.getKeyCode()) {

				case KeyEvent.VK_LEFT: 

					xCoord += 20;
					frame.repaint();
					break;

				case KeyEvent.VK_RIGHT: 

					xCoord -= 20;	
					frame.repaint();
					break;

				case KeyEvent.VK_UP: 

					yCoord += 20;
					frame.repaint();
					break;

				case KeyEvent.VK_DOWN: 

					yCoord -= 20;
					frame.repaint();
					break;

				case KeyEvent.VK_I: // Zoom In

					scaleX *= 1.5;
					scaleY *= 1.5;
					frame.repaint();
					break;

				case KeyEvent.VK_O: // Zoom Out

					scaleX /= 1.5;
					scaleY /= 1.5;
					frame.repaint();
					break;

				case KeyEvent.VK_R: // Reset

					scaleX = 480;
					scaleY = 360;
					xCoord = 1440;
					yCoord = 540;
					frame.repaint();
					break;

				}
			}
		});

		canvas = new DrawCanvas();
		canvas.setPreferredSize(new Dimension(1920, 1080));

		Container cp = frame.getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(canvas);

		frame.setTitle("Mandelbrot Set");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack(); 
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	public static void main (String [] args) {

		new Mandelbrot();
	}
}
