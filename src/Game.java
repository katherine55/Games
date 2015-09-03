import java.util.Random;

import javax.swing.JOptionPane;

public class Game {
	public static void main(String[] args) {
		Random generator = new Random();
		String[] enemyNames = { "The Lorax", "Thing One", "Thing Two",
				"The Grinch", "Green Eggs and Ham", "Horton the Elephant",
				"Thing Three", "Dr. Seuss", "Gertrude McFuzz",
				"Yertle the Turtle", "Panda", "Kobe", "Wanda" };
		CatInTheHat cat = new CatInTheHat();
		JOptionPane.showMessageDialog(null, "You are the Cat in the Hat, on a journey to Switzerland! Defeat \nenemies, earn coins, and gain hat levels along the way!");
for(int i = 0; i < 13; i++){
	//int random2 = generator.nextInt(12);
	enemy enemy = new enemy(enemyNames[i]);
	cat.interact(enemy);
}
JOptionPane.showMessageDialog(null, "Yay! You finally made to Switzerland!");
JOptionPane.showMessageDialog(null, "This is your final score:");
cat.notice();
	}
}
