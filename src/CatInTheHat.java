import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

public class CatInTheHat {
	Random generator;
	int random;
	String name = "Cat in the Hat";
	String[] enemyNames = { "The Lorax", "Thing One", "Thing Two",
			"The Grinch", "Green Eggs and Ham", "Horton the Elephant",
			"Thing Three", "Dr. Seuss", "Gertrude McFuzz", "Yertle the Turtle",
			"Panda", "Kobe", "Wanda" };
	String[] lostLifeOptions = { "Oh no! You lost a life!", "The Enemy Won!",
			"Lives - 1" };
	int hatSize;
	int enemiesDefeated;
	int livesLeft;
	int coins;
	int distanceWalked;
	int maxDistance;

	public CatInTheHat() {
		generator = new Random();
		random = generator.nextInt(2);
		hatSize = 1;
		enemiesDefeated = 0;
		livesLeft = 4;
		coins = 0;
		distanceWalked = 0;
		maxDistance = 300;
	}

	public void interact(enemy x) {
		String enemyName = x.name;
		switch (enemyName) {
		case "The Lorax":
			JOptionPane.showMessageDialog(null,
					"You have come across the Lorax...");
			Object[] possibilities = { "Feather", "Marshmallow", "Thneed" };
			String option1 = (String) JOptionPane
					.showInputDialog(
							null,
							"The Lorax claims that you cut down one of his truffela trees!",
							"Customized Dialog", JOptionPane.PLAIN_MESSAGE,
							null, possibilities, null);
			if (option1.equals("Feather")) {
				JOptionPane
						.showMessageDialog(null,
								"You used the feather to tickle the Lorax \nso he didn't notice you passing.");
				enemyDefeat();
				notice();
			} else if (option1.equals("Marshmallow")) {
				JOptionPane
						.showMessageDialog(
								null,
								"\"I'm gonna eat this, but I'm highly offended by it.\" \nThe Lorax does not let you pass- lose a life");
				lostLife();
				notice();
				gameOver();
			} else if (option1.equals("Thneed")) {
				JOptionPane
						.showMessageDialog(null, "He kills you- lose a life");
				lostLife();
				notice();
				gameOver();
			}
			break;
		case "Thing One":
			JOptionPane.showMessageDialog(null,
					"You have come across Thing One...");
			Object[] possibilities2 = { "Fight", "Run", "Give Contrapion" };
			String option2 = (String) JOptionPane.showInputDialog(null,
					"Thing One wants to have a pie fight", "Customized Dialog",
					JOptionPane.PLAIN_MESSAGE, null, possibilities2, null);
			if (option2.equals("Fight")) {
				boolean win = generator.nextBoolean();
				if (win) {
					enemyDefeat();
				} else {
					lostLife();
					gameOver();
				}
				notice();
			} else if (option2.equals("Run")) {
				boolean win = generator.nextBoolean();
				if (win) {
					enemyDefeat();
				} else {
					lostLife();
					gameOver();
				}
				notice();
			} else if (option2.equals("Give Contraption")) {
				JOptionPane
						.showMessageDialog(null,
								"Thing One is distracted with the contraption and does not see you leaving.");
				enemyDefeat();
				notice();
			}
			break;
		case "Thing Two":
			JOptionPane.showMessageDialog(null,
					"You have come across Thing Two...");
			Object[] possibilities3 = { "Contraption", "Map",
					"Hair Conditioner" };
			String option3 = (String) JOptionPane.showInputDialog(null,
					"Thing Two needs help trying to find Thing One",
					"Customized Dialog", JOptionPane.PLAIN_MESSAGE, null,
					possibilities3, null);
			if (option3.equals("Contraption")) {
				JOptionPane
						.showMessageDialog(
								null,
								"Thing Two already has a contraption! Because you ignored \nhim, he uses his death ray on you-lose a life");
				lostLife();
				notice();
				gameOver();
			} else if (option3.equals("Map")) {
				JOptionPane
						.showMessageDialog(null,
								"Thing Two asks for you to go with him- you spend 5 coins on travel costs");
				coins -= 5;
				enemyDefeat();
				notice();
			} else if (option3.equals("Hair Conditioner")) {
				JOptionPane
						.showMessageDialog(
								null,
								"That's what Thing Two was going to get from his \nbrother- he pays you 5 coins for the bottle");
				coins += 5;
				enemyDefeat();
				notice();
			}
			break;
		case "The Grinch":
			JOptionPane.showMessageDialog(null,
					"You have come across the Grinch...");
			Object[] possibilities4 = { "Therapy", "Gift", "Christmas Tree" };
			String option4 = (String) JOptionPane.showInputDialog(null,
					"The Grinch is stealing a christmas tree!",
					"Customized Dialog", JOptionPane.PLAIN_MESSAGE, null,
					possibilities4, null);
			if (option4.equals("Therapy")) {
				JOptionPane
						.showMessageDialog(
								null,
								"You talk to him and the Grinch shares his feelings, \nhe promises to make better choices in the future- he \ngives you 10 coins for the session");
				coins += 10;
				enemyDefeat();
				notice();
			} else if (option4.equals("Gift")) {
				JOptionPane
						.showMessageDialog(null,
								"He tries to hug you but he is still holding a knife- lose a life");
				lostLife();
				notice();
				gameOver();
			} else if (option4.equals("Christmas Tree")) {
				JOptionPane
						.showMessageDialog(null,
								"The Grinch yells, 'I hate Christmas!' and kills you- lose a life");
				lostLife();
				notice();
				gameOver();
			}
			break;
		case "Green Eggs and Ham":
			JOptionPane.showMessageDialog(null,
					"You have come across Green Eggs and Ham...");
			Object[] possibilities5 = { "Go Around", "Eat it",
					"Go through transporter to the next level" };
			String option5 = (String) JOptionPane.showInputDialog(null,
					"The Green Eggs and Ham is rotting!", "Customized Dialog",
					JOptionPane.PLAIN_MESSAGE, null, possibilities5, null);
			if (option5.equals("Go Around")) {
				JOptionPane.showMessageDialog(null,
						"The smell is too bad- you die");
				lostLife();
				notice();
				gameOver();
			} else if (option5.equals("Eat it")) {
				JOptionPane.showMessageDialog(null, "you die");
				lostLife();
				notice();
				gameOver();
			} else if (option5
					.equals("Go through transporter to the next level")) {
				JOptionPane.showMessageDialog(null, "Sam I Am kills you");
				lostLife();
				notice();
				gameOver();
			}
			break;
		case "Horton the Elephant":
			JOptionPane.showMessageDialog(null,
					"You have come across Horton the Elephant...");
			Object[] possibilities6 = { "Step Aside",
					"Hand him the dust speck",
					"Ask- 'What's so special about a dusk speck?'" };
			String option6 = (String) JOptionPane
					.showInputDialog(
							null,
							"'You're standing in the way of me and my dust speck,' Horton says",
							"Customized Dialog", JOptionPane.PLAIN_MESSAGE,
							null, possibilities6, null);
			if (option6.equals("Step Aside")) {
				JOptionPane.showMessageDialog(null, "You are not fast enough and are trampled by Horton");
				lostLife();
				notice();
				gameOver();
			}
			if(option6.equals("Hand him the dust speck")){
				boolean win = generator.nextBoolean();
				if (win) {
					JOptionPane.showMessageDialog(null, "You got through!");
					enemyDefeat();
					notice();
				} else {
					JOptionPane.showMessageDialog(null, "Uh Oh! You dropped the dust speck!");
					lostLife();
					notice();
					gameOver();
				}
			}
			if(option6.equals("Ask- 'What's so special about a dusk speck?'")){
				JOptionPane.showMessageDialog(null, "you die");
				lostLife();
				notice();
				gameOver();
			}
			break;
		case "Thing Three":
			JOptionPane.showMessageDialog(null,
					"You have come across Thing Three...");
			Object[] possibilities7 = { "Fight Back" };
			String option7 = (String) JOptionPane
					.showInputDialog(
							null,
							"'You're standing in the way of me and my dust speck,' Horton says",
							"Customized Dialog", JOptionPane.PLAIN_MESSAGE,
							null, possibilities7, null);
			break;
		case "Dr. Seuss":
			break;
		case "Gertrude McFuzz":
			break;
		case "Yertle the Turtle":
			break;
		case "Panda":
			break;
		case "Kobe":
			break;
		case "Wanda":
			break;
		}
	}

	public void notice() {
		JOptionPane.showMessageDialog(null, "Cat in the Hat:\nHat Size: "
				+ hatSize + " levels\nLives Left: " + livesLeft
				+ "\nEnemies Defeated: " + enemiesDefeated
				+ "\nCoins Collected: " + coins + "\nDistance Walked: "
				+ distanceWalked + "/325");
	}

	public void lostLife() {
		livesLeft--;
		JOptionPane.showMessageDialog(null, lostLifeOptions[random]);
		distanceWalked += 25;

	}

	public void enemyDefeat() {
		enemiesDefeated++;
		coins += random;
		distanceWalked += 25;
		hatSize++;
		JOptionPane.showMessageDialog(null,
				"Yes! An ememy conquered and coins gained!");
	}

	public void gameOver() {
		if (livesLeft <= 0) {
			JOptionPane.showMessageDialog(null, "Game Over");
			notice();
		}
	}
}
