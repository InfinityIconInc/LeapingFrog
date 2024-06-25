import java.io.*;
import java.util.ArrayList;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class leapingFrog extends Applet {

	//int numRed = 3; // number of red frogs
	//int numGreen = 3; // number of green frogs
	//int numPlaces = numGreen + numRed + 1;
	//int[] frogs = { 2, 2, 2, 0, 1, 1, 1 }; // 2 = red frog, 1 = green
	int numRed; // number of red frogs
	int numGreen; // number of green frogs
	int numPlaces;
	ArrayList <Integer> frogs; // 2 = red frog, 1 = green
	
	int autoCounter = 0;

	Image redPic, greenPic, Pic, Win, moon, grass, pond, rst; // The images of the frogs
	AudioClip ac, jump;
	//Button reset;
	int displayMode = 10;
	Font textFont = new Font("Helvetica", Font.BOLD, 17);
	Label message = new Label("The Leaping Frogs Game");

	public void init() {
		setBackground(Color.BLACK);
		setFont(textFont);
		setForeground(Color.blue);
		//Label a = new Label("FROG LEAPING GAME");
		//add(a);

		//

		Pic = getImage(getDocumentBase(), "mzl.ucenpfct.jpg");
		Win = getImage(getDocumentBase(), "winner.jpg");
		redPic = getImage(getDocumentBase(), "redpic.gif");
		greenPic = getImage(getDocumentBase(), "greenpic.gif");
		moon = getImage(getDocumentBase(), "moon.jpg");
		grass = getImage(getDocumentBase(), "grass.png");
		pond = getImage(getDocumentBase(), "pond.png");
		rst = getImage(getDocumentBase(), "reset.png");
		//rules = new Button("Explain the rules");
		//add(rules);
		//reset = new Button("Reset");
		//add(reset);
		//autosolve = new Button("Autosolve");
		//add(autosolve);
		ac = getAudioClip(getCodeBase(), "welcome.wav");
		jump = getAudioClip(getCodeBase(), "frog.wav");
		ac.play();
		//autosolve.disable();
	}

	// ************* The action of the paint function depends on the
	// mode****************

	public void lvlEasy ( ) {
		numRed = 3; // number of red frogs
		numGreen = 3; // number of green frogs
		numPlaces = numGreen + numRed + 1;
		frogs = new ArrayList<Integer> ( );
	}

	public void lvlMedium ( ) {
		numRed = 5; // number of red frogs
		numGreen = 5; // number of green frogs
		numPlaces = numGreen + numRed + 1;
		frogs = new ArrayList<Integer> ( );		
	}
	
	public void lvlHard ( ) {
		numRed = 8; // number of red frogs
		numGreen = 8; // number of green frogs
		numPlaces = numGreen + numRed + 1;
		frogs = new ArrayList<Integer> ( );		
	}

	
	public void paint(Graphics g) {
		if (displayMode == 0) {
			//autosolve.enable();
			showGame(g, numGreen, numRed);
		}
		else if (displayMode == 10) {
			g.drawImage(Pic, 0, 0, 1360, 660, this);
			//autosolve.disable();
		}
		else if ( displayMode == 11 ) {
			showRules(g);
		}
	}

	// **************** Display the game itself***************
	public void showGame(Graphics g, int gf, int rf ) {
		int i;
		int firstturn = 1;
		int iGreen = 1;
		int iRed = 1;
		int places = gf + rf + 1;
		if ( firstturn == 1 ){
			for ( int x=0; x < rf; x++ ) {
				frogs.add(2);
			}
			
			frogs.add( 0 );
			
			for ( int y=0; y < places; y++ ) {
				frogs.add(1);
			}			
		}
		if ( displayMode == 0 ) {
			g.drawImage(rst, 0, 0, 160, 45, this);
			g.drawImage(moon, 550, 0, 100, 90, this);
			g.drawImage(grass, 0, 200, 750, 90, this);
			g.drawImage(grass, 750, 200, 900, 90, this);
			g.drawImage(pond, 0, 300, 750, 90, this);
			g.drawImage(pond, 450, 300, 900, 90, this);
		}
		int width = 660 - 25 * places;
		boolean b;
		for (i = 0; i < places; i++) {
			g.setColor(Color.yellow);

			g.fillRect(i * 50 + width, 200, 40, 10);
			switch (frogs.get(i)) {
			case 0:
				g.setColor(Color.black);
				g.fillRect(i * 50 + width, 150, 50, 50);
				break;
			case 1:
				b = g.drawImage(greenPic, i * 50 + width, 150, 50, 50, this);
				break;
			case 2:
				b = g.drawImage(redPic, i * 50 + width, 150, 50, 50, this);
				break;
			}
		}
		for ( int j=0; j < gf; j++ ) {
			iGreen *= frogs.get(j);
			//showStatus ( "Green: " + iGreen );
		}
		for ( int k=places-1; k > rf; k-- ) {
			iRed *= frogs.get(k);
			//showStatus ( "Red: " + iRed + " Green: " + iGreen + " rf*2=" + Math.pow(2, rf) );
		}
		if ( iRed == (Math.pow(2, rf))  &&  iGreen == 1 ) {
			g.setColor(Color.black);
			g.drawImage(Win, 0, 0, 1360, 660, this);
			//g.drawString("Well done! you WIN your mind is outstanding.", 150,
			//		360);
		}// Display the well done message
		else
			g.setColor(Color.black); // Hide the well done message

	}
	
	public void SetPositions ( int gf, int rf  ) {
		int places = gf+rf+1;
		
		for ( int x=0; x < rf; x++ ) {
			frogs.add(2);
		}
		
		frogs.add( 0 );
		
		for ( int y=0; y < places; y++ ) {
			frogs.add(1);
		}
		int width = 660 - 25 * places;
		boolean b;
		
		Graphics g = getGraphics ( );

		for (int i = 0; i < places; i++) {
			g.setColor(Color.yellow);

			g.fillRect(i * 50 + width, 200, 40, 10);
			switch (frogs.get(i)) {
			case 0:
				g.setColor(Color.black);
				g.fillRect(i * 50 + width, 150, 50, 50);
				break;
			case 1:
				b = g.drawImage(greenPic, i * 50 + width, 150, 50, 50, this);
				break;
			case 2:
				b = g.drawImage(redPic, i * 50 + width, 150, 50, 50, this);
				break;
			}
		}
	}

	// ********************Display the rules of the game********************

	public void showRules(Graphics g) {
		g.setColor(Color.white);

		lvlEasy(); //set variables
		SetPositions(3, 3); //fill variables and arrays
		g.drawImage(rst, 0, 0, 160, 45, this);
		g.drawString("INSTRUCTIONS", 585, 60);
		g.drawString(
				"You see some red and green frogs sitting on stands. The aim of the game is to swap the",
				365, 80);
		g.drawString(
				"frogs over using a simple set of rules The red frogs can only move to the right.",
				365, 120);
		g.drawString("The green frogs can only move to the left.", 365, 140);
		g.drawString(
				"Frogs can slide into an adjacent empty space, or leap over one frog into an empty space.",
				365, 240);
		g.drawString("Frogs can't jump over more than one frog.", 365, 260);
		g.drawString(
				"Click on a yellow stand to move the frog sitting on that stand. Click on Reset if you get stuck.",
				365, 280);
		g.drawString(
				"Click on Autosolve to see how the problem should be solved . ",
				365, 300);

		if ( autoCounter == 0 ) { //move frogs
			AutoSolve();
			autoCounter = 1;
		}

	}

	public boolean action(Event e, Object arg) {
//		if (e.target == rules) {
//			displayMode = 1 - displayMode; // 1 to 0 or vice-versa
//			repaint();
//		}
//		if (e.target == reset) {
//			resetGame(numGreen, numRed);
//			displayMode = 10;
//		}
//		if (e.target == autosolve) {
//			resetGame(numGreen, numRed);
//
//			moveFrog(4, 3);
//			moveFrog(2, 4);
//			moveFrog(1, 2);
//			moveFrog(3, 1);
//			moveFrog(5, 3);
//			moveFrog(6, 5);
//			moveFrog(4, 6);
//			moveFrog(2, 4);
//			moveFrog(0, 2);
//			moveFrog(1, 0);
//			moveFrog(3, 1);
//			moveFrog(5, 3);
//			moveFrog(4, 5);
//			moveFrog(2, 4);
//			moveFrog(3, 2);
//		}
		return true;
	}
	
	public boolean AutoSolve (  ) {
		resetGame(numGreen, numRed);

		moveFrog(4, 3);
		moveFrog(2, 4);
		moveFrog(1, 2);
		moveFrog(3, 1);
		moveFrog(5, 3);
		moveFrog(6, 5);
		moveFrog(4, 6);
		moveFrog(2, 4);
		moveFrog(0, 2);
		moveFrog(1, 0);
		moveFrog(3, 1);
		moveFrog(5, 3);
		moveFrog(4, 5);
		moveFrog(2, 4);
		moveFrog(3, 2);
		return true;
	}

	// ********************Put the frogs back to their original
	// position****************

	public void resetGame(int gf, int rf) {
		//displayMode = 0;
		setBackground(Color.white);
		int i;
		for (i = 0; i < rf; i++)
			frogs.set(i, 2);
		//showStatus ( "rf: " + rf );
		frogs.set(rf, 0); // Blank in the middle
		for (i = 0; i < gf; i++)
			frogs.set(rf+i+1, 1);
		Graphics g = getGraphics();
		showGame(g, numGreen, numRed);
		setBackground(Color.black);
	}

	// ******************** Move a frog from a given position to a given
	// position*****************
	public void moveFrog(int source, int dest) {
		int temp = frogs.get(source);
		frogs.set(source, frogs.get(dest));
		frogs.set(dest, temp);
		long time, time2, difference;
		time = System.currentTimeMillis();
		do {
			time2 = System.currentTimeMillis();
			difference = time2 - time;
		} while (difference < 1000);
		Graphics g = getGraphics();
		showGame(g, numGreen, numRed);
	}

	// *****************Decide whether the mouse has been clicked over a
	// position*****************
	public boolean mouseDown(Event event, int x, int y) {
		showStatus ( "Status: " + x + " " + y );
		if ( ( x >= 230 && x <= 520 ) && ( y>=395 && y <=470 ) && displayMode == 10 ) {
			lvlEasy ( );
			displayMode = 0;
			//autosolve.disable();
		}
		if ( ( x >= 480 && x <= 610 ) && ( y>=205 && y <=540 ) && displayMode == 10 ) {
			lvlMedium ( );
			displayMode = 0;
			//autosolve.disable();
		}
		if ( ( x >= 220 && x <= 540 ) && ( y>=560 && y <=630 ) && displayMode == 10 ) {
			lvlHard ( );
			displayMode = 0;
			//autosolve.disable();
		}

		if ( ( x >= 0 && x <= 160 ) && ( y>=525 && y <=655 ) && displayMode == 10 ) {
			autoCounter = 0;
			displayMode = 11;
			//AutoSolve ( );
			//autosolve.disable();
		}

		if ( ( x >= 0 && x <= 154 ) && ( y>=0 && y <=44 ) && displayMode == 0 ) {
			resetGame(numGreen, numRed);
			displayMode = 10;
		}

		if ( ( x >= 0 && x <= 154 ) && ( y>=0 && y <=44 ) && displayMode == 11 ) {
			resetGame(numGreen, numRed);
			displayMode = 10;
		}


		int width = 660 - 25 * numPlaces;
		for (int i = 0; i < numPlaces; i++)
			if (x >= i * 50 + width && x <= i * 50 + width + 40 && y >= 200
					&& y <= 210) { // Mouse has been clicked over yellow support
									// Detect if we are trying to slide a green
									// frog
				if (i > 0 && frogs.get(i) == 1 && frogs.get(i-1) == 0) {
					frogs.set(i, 0);
					frogs.set(i-1, 1);
					jump.play();
				}
				// Detect if we are trying to slide a red frog
				if (i < numPlaces - 1 && frogs.get(i) == 2 && frogs.get(i+1) == 0) {
					frogs.set(i, 0);
					frogs.set(i+1, 2);
					jump.play();
				}
				// Detect if we are trying to get a green frog to leap
				if (i > 1 && frogs.get(i) == 1 && frogs.get(i-2) == 0) {
					frogs.set(i, 0);
					frogs.set(i-2, 1);
					jump.play();
				}
				// Detect if we are trying to get a red frog to leap
				if (i < numPlaces - 2 && frogs.get(i) == 2 && frogs.get(i+2) == 0) {
					frogs.set(i, 0);
					frogs.set(i+2, 2);
					jump.play();
				}
			}
		repaint();
		return true;
	}
}
