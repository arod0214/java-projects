
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Connect4 extends JFrame {

	private Connect4Board playBoard;
	private ScoreBoard scoreBoard;

	private Player player1;
	private Player player2;
	private Player currentPlayer;

	ImageIcon c1 = new ImageIcon(getClass().getResource("red.png"));
	ImageIcon c2 = new ImageIcon(getClass().getResource("yellow.png"));

	public Connect4() {
		String name1 = JOptionPane.showInputDialog("Enter Red Player's name.");
		String name2 = JOptionPane.showInputDialog("Enter Yellow Player's name.");

		this.player1 = new Player(name1, c1);
		this.player2 = new Player(name2, c2);
		this.currentPlayer = this.player1;

		setLayout(new BorderLayout());

		playBoard = new Connect4Board();
		add(playBoard, BorderLayout.CENTER);

		scoreBoard = new ScoreBoard();
		add(scoreBoard, BorderLayout.NORTH);

		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private class Connect4Board extends JPanel implements ActionListener {
		private JButton[][] board;

		public Connect4Board() {
			setLayout(new GridLayout(6, 7));
			displayBoard();
		}

		public int findLowestEmptyRow(int col) {
			for (int row = 5; row >= 0; row--) {
				if (board[row][col].getIcon() == null) {
					return row;
				}
			}
			return 5;
		}

		public int findColumn(JButton b) {
			for (int row = 0; row < 6; row++) {
				for (int col = 0; col < 7; col++) {
					if (board[row][col].equals(b)) {
						return col;
					}
				}
			}
			return 5;
		}

		public void displayBoard() {

			this.board = new JButton[6][7];

			for (int row = 0; row < this.board.length; row++) {
				for (int col = 0; col < this.board[row].length; col++) {
					this.board[row][col] = new JButton();
					this.board[row][col].setEnabled(true);
					this.board[row][col].addActionListener(this);
					this.board[row][col].setText("");
					add(this.board[row][col], BorderLayout.NORTH);
				}
			}
		}

		public void clearBoard() {
			for (int row = 0; row < this.board.length; row++) {
				for (int col = 0; col < this.board[row].length; col++) {
					this.board[row][col].setIcon(null);
					this.board[row][col].setText("");
					this.board[row][col].setEnabled(true);
				}
			}
		}

		public void switchCurrentPlayer() {
			if (currentPlayer.equals(player1)) {
				currentPlayer = player2;
				scoreBoard.setCurrPlayerName(currentPlayer.getPlayerName());
			} else {
				currentPlayer = player1;
				scoreBoard.setCurrPlayerName(currentPlayer.getPlayerName());
			}
		}

		public boolean isWinner(String name) {
			int foundCount = 0;
			// check rows
			for (int row = 0; row < this.board.length; row++) {
				foundCount = 0;
				for (int col = 0; col < this.board[row].length; col++) {
					String buttonText = this.board[row][col].getText();
					if (buttonText.equals(name)) {
						foundCount++;
						if (foundCount == 4) {
							return true;
						}
					} 
					else {
						foundCount = 0;
					}
				}
			}
			
			// check columns
			for (int col = 0; col < this.board[0].length; col++) {
				foundCount = 0;
				for (int row = 0; row < this.board.length; row++) {
					String buttonText = this.board[row][col].getText();
					if (buttonText.equals(name)) {
						foundCount++;
						if (foundCount == 4) {
							return true;
						}
					} 
					else {
						foundCount = 0;
					}
				}
			}

			 // check for a diagonal win (negative slope)
			for (int row = 0; row < 3; row++) {
				for (int col = 0; col < 4; col++) {
					if((this.board[row][col].getText().equals(name)) && (this.board[row+1][col+1].getText().equals(name))
					  && (this.board[row+2][col+2].getText().equals(name) && (this.board[row+3][col+3].getText().equals(name))))
					{
						return true;
					}
				}
			}

			// check for a diagonal win (positive slope)
			for (int row = 3; row < 6; row++) {
				for (int col = 0; col < 4; col++) {
					if ((this.board[row][col].getText().equals(name)) && (this.board[row - 1][col + 1].getText().equals(name))
					     && (this.board[row - 2][col + 2].getText().equals(name) && (this.board[row - 3][col + 3].getText().equals(name)))) {
						return true;
					}
				}
			}

			return false;
		}

		public void displayWinner() {
			currentPlayer.addNumWins();
			int numWins = currentPlayer.getNumWins();

			if (currentPlayer.equals(player1)) {
				scoreBoard.setPlayer1Score(numWins);
			} else {
				scoreBoard.setPlayer2Score(numWins);
			}

			scoreBoard.setLastWinnerName(currentPlayer.getPlayerName());

			if (player1.compareTo(player2) > 0) {
				scoreBoard.setChampName(player1.getPlayerName());
			} else if (player2.compareTo(player1) > 0) {
				scoreBoard.setChampName(player2.getPlayerName());
			} else {
				scoreBoard.setChampName("----------");
			}

		}

		public void promptPlayAgain() {
			int yesno = JOptionPane.showConfirmDialog(null, "Play Again?", "Yes or No", JOptionPane.YES_NO_OPTION);
			if (yesno == JOptionPane.YES_OPTION) {
				clearBoard();
			} else {
				System.exit(EXIT_ON_CLOSE);
			}
		}

		public boolean boardIsFull() {
			for (int row = 0; row < this.board.length; row++) {
				for (int col = 0; col < this.board[row].length; col++) {
					Icon buttonText = this.board[row][col].getIcon();
					if (buttonText == null) {
						return false;
					}
				}
			}
			return true;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton clickedButton = (JButton) e.getSource();
			int col = findColumn(clickedButton);
			int row = findLowestEmptyRow(col);
			this.board[row][col].setText(currentPlayer.getPlayerName());
			this.board[row][col].setIcon(currentPlayer.getPlayerSymbol());
			clickedButton.setEnabled(true);

			if (isWinner(currentPlayer.getPlayerName())) {
				JOptionPane.showMessageDialog(null, "Winner Is " + currentPlayer.getPlayerName());
				displayWinner();
				promptPlayAgain();
			}

			if (boardIsFull()) {
				JOptionPane.showMessageDialog(null, "Game Is A Draw");
				promptPlayAgain();
			}

			switchCurrentPlayer();

		}

	}

	private class ScoreBoard extends JPanel {

		private JPanel genScoreInfo;
		private JLabel labelForChamp, champName;
		private JLabel labelForLastWinner, lastWinnerName;

		private JPanel playScoreInfo;
		private JLabel labelPlaceHolder, labelForPlayer1Name, labelForPlayer2Name;
		private JLabel labelForPlayerNames, player1Name, player2Name;
		private JLabel labelForPlayerScore, player1Score, player2Score;

		private JPanel currPlayerInfo;
		private JLabel labelForCurrPlayer, currPlayerName;

		public ScoreBoard() {
			setLayout(new BorderLayout());
			genScoreInfo = new JPanel(new GridLayout(2, 2));
			genScoreInfo.setBackground(Color.MAGENTA);

			playScoreInfo = new JPanel(new GridLayout(3, 3));
			playScoreInfo.setBackground(Color.CYAN);

			currPlayerInfo = new JPanel(new GridLayout(1, 2));
			currPlayerInfo.setBackground(Color.LIGHT_GRAY);

			labelForChamp = new JLabel("Champion");
			champName = new JLabel("----------");

			labelForLastWinner = new JLabel("Last Winner");
			lastWinnerName = new JLabel("----------");

			JLabel[] genLabels = { labelForChamp, champName, labelForLastWinner, lastWinnerName };

			for (int i = 0; i < genLabels.length; i++) {
				genLabels[i].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
				genScoreInfo.add(genLabels[i]);
			}

			labelPlaceHolder = new JLabel("          ");
			labelForPlayer1Name = new JLabel("Player 1");
			labelForPlayer2Name = new JLabel("Player 2");

			labelForPlayerNames = new JLabel("Name");
			player1Name = new JLabel(player1.getPlayerName());
			player2Name = new JLabel(player2.getPlayerName());

			labelForPlayerScore = new JLabel("Score");
			player1Score = new JLabel("----------");
			player2Score = new JLabel("----------");

			JLabel[] playLabels = { labelPlaceHolder, labelForPlayer1Name, labelForPlayer2Name, labelForPlayerNames,
					player1Name, player2Name, labelForPlayerScore, player1Score, player2Score };

			for (int i = 0; i < playLabels.length; i++) {
				playLabels[i].setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 14));
				playScoreInfo.add(playLabels[i]);
			}

			labelForCurrPlayer = new JLabel("Current Player");
			currPlayerName = new JLabel(currentPlayer.getPlayerName());

			JLabel[] currLabels = { labelForCurrPlayer, currPlayerName };

			for (int i = 0; i < currLabels.length; i++) {
				currLabels[i].setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 14));
				currPlayerInfo.add(currLabels[i]);
			}

			add(playScoreInfo, BorderLayout.CENTER);
			add(genScoreInfo, BorderLayout.NORTH);
			add(currPlayerInfo, BorderLayout.SOUTH);
		}

		private void setCurrPlayerName(String currPlayerName) {
			this.currPlayerName.setText(currPlayerName);
		}

		private void setChampName(String champName) {
			this.champName.setText(champName);
		}

		private void setLastWinnerName(String lastWinnerName) {
			this.lastWinnerName.setText(lastWinnerName);
		}

		private void setPlayer1Score(int score) {
			this.player1Score.setText("" + score);
		}

		private void setPlayer2Score(int score) {
			this.player2Score.setText("" + score);
		}

	}

}
