import javax.swing.ImageIcon;

public class Player {

	private String playerName;
	private ImageIcon playerSymbol;
	private int numWins;

	
//	public Player() {
//		this("Jane Doe", "*");
//	}
	
	public Player(ImageIcon playerSymbol) {
		this("Jane Doe", playerSymbol);
	}
	
	public Player(String playerName, ImageIcon playerSymbol) {
		this.playerName = playerName;
		this.playerSymbol = playerSymbol;
		this.numWins = 0;
	}
	
	public void addNumWins() {
		this.numWins++;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public ImageIcon getPlayerSymbol() {
		return playerSymbol;
	}

	public void setPlayerSymbol(ImageIcon playerSymbol) {
		this.playerSymbol = playerSymbol;
	}

	public int getNumWins() {
		return numWins;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Player) {
			Player otherPlayer = (Player) obj;
			if (this.playerName.equals(otherPlayer.getPlayerName())) {
				if (this.playerSymbol.equals(otherPlayer.getPlayerSymbol())) {
					if (this.numWins == otherPlayer.getNumWins()) {
						return true; 
					}
				}
			}
		}
		
		return false;
	}

	@Override
	public String toString() {
		return "Player [ playerName = " + this.playerName +
						", playerSymbol = " + this.playerSymbol +
						", numWins = " + this.numWins + "]";
	}

	public int compareTo(Player o) {
		if (this.numWins > o.getNumWins()) {
			return 1;
		} else if (this.numWins == o.getNumWins()) {
			return 0;
		} else {
			return -1;
		}
	}

}
