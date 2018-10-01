import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TicTacToe extends JFrame {

	private TicTacToeBoard playBoard;
	private ScoreBoard scoreBoard;
	
	private Player player1;
	private Player player2;
	private Player currentPlayer;
	
	
	public TicTacToe() {
		this.player1 = new Player("Wonderwoman", "W");
		this.player2 = new Player("Superman", "S");
		this.currentPlayer = this.player1;
		
		setLayout(new BorderLayout());
		
		playBoard = new TicTacToeBoard();
		add(playBoard, BorderLayout.CENTER);
		
		scoreBoard = new ScoreBoard();
		add(scoreBoard, BorderLayout.NORTH);
		
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	
	private class TicTacToeBoard extends JPanel implements ActionListener {
		private JButton[][] board;
		
		public TicTacToeBoard() {
			setLayout(new GridLayout(3, 3));
			displayBoard();
		}
		
		public void displayBoard() {
			this.board = new JButton[3][3];
			
			for ( int row = 0 ; row < this.board.length ; row++ ) {
				for ( int col = 0 ; col < this.board[row].length ; col++ ) {
					this.board[row][col] = new JButton();
					this.board[row][col].setEnabled(true);
					this.board[row][col].addActionListener(this);
					add(this.board[row][col]);
				}
			}
		}
		
		public void clearBoard() {
			for ( int row = 0 ; row < this.board.length ; row++ ) {
				for ( int col = 0 ; col < this.board[row].length ; col++ ) {
					this.board[row][col].setText("");
					this.board[row][col].setEnabled(true);
				}
			}
		}

		
		public void switchCurrentPlayer() {
			if (currentPlayer.equals(player1)) {
				currentPlayer = player2;
			} else {
				currentPlayer = player1;
			}
		}
		
		
		public boolean isWinner(String symbol) {
			int foundCount = 0;
			
			// check rows
			for ( int row = 0 ; row < this.board.length ; row++ ) {
				foundCount = 0;
				for ( int col = 0 ; col < this.board[row].length ; col++ ) {
					String buttonText = this.board[row][col].getText();
					if (buttonText.equals(symbol)) {
						foundCount++;
						if (foundCount == 3) {
							return true;
						}
					} else {
						break;
					}
				}
			}
			
			// check columns
			for ( int col = 0 ; col < this.board[0].length ; col++ ) {
				foundCount = 0;
				for ( int row = 0 ; row < this.board.length ; row++ ) {
					String buttonText = this.board[row][col].getText();
					if (buttonText.equals(symbol)) {
						foundCount++;
						if (foundCount == 3) {
							return true;
						}
					} else {
						break;
					}
				}
			}
			
			// check main diagonal [0][0] [1][1] [2][2]
			foundCount = 0;
			for ( int i = 0 ; i < this.board.length ; i++ ) {
				String buttonText = this.board[i][i].getText();
				if (buttonText.equals(symbol)) {
					foundCount++;
					if (foundCount == 3) {
						return true;
					}
				} else {
					break;
				}
			}
			
			// check secondary diagonal [2][0] [1][1] [0][2]
			foundCount = 0;
			int row = this.board.length - 1;
			int col = 0;
			while (row >= 0 && col < this.board.length) {
				String buttonText = this.board[row][col].getText();
				if (buttonText.equals(symbol)) {
					foundCount++;
					if (foundCount == 3) {
						return true;
					}
					row--;
					col++;
				} else {
					break;
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
			for ( int row = 0 ; row < this.board.length ; row++ ) {
				for ( int col = 0 ; col < this.board[row].length ; col++ ) {
					String buttonText = this.board[row][col].getText();
					if (buttonText.isEmpty()) {
						return false;
					}
				}
			}
			return true;
		}
		
		
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton clickedButton = (JButton) e.getSource();
			clickedButton.setText(currentPlayer.getPlayerSymbol());
			clickedButton.setEnabled(false);
			
			if (isWinner(currentPlayer.getPlayerSymbol())) {
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
		
		public ScoreBoard() {
			setLayout(new BorderLayout());
			genScoreInfo = new JPanel(new GridLayout(2, 2));
			genScoreInfo.setBackground(Color.YELLOW);
			
			playScoreInfo = new JPanel(new GridLayout(3, 3));
			playScoreInfo.setBackground(Color.CYAN);
			
			labelForChamp = new JLabel("Champion");
			champName = new JLabel("----------");
			
			labelForLastWinner = new JLabel("Last Winner");
			lastWinnerName = new JLabel("----------");
			
			JLabel[] genLabels = {labelForChamp, champName, 
									labelForLastWinner, lastWinnerName};
			
			for ( int i = 0 ; i < genLabels.length ; i++ ) {
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

			JLabel[] playLabels = {labelPlaceHolder, labelForPlayer1Name, labelForPlayer2Name,
									labelForPlayerNames, player1Name, player2Name,
									labelForPlayerScore, player1Score, player2Score};
			
			for ( int i = 0 ; i < playLabels.length ; i++ ) {
				playLabels[i].setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 14));
				playScoreInfo.add(playLabels[i]);
			}
			
			add(playScoreInfo, BorderLayout.CENTER);
			add(genScoreInfo, BorderLayout.NORTH);
		}
		
		private void setChampName(String champName) {
			this.champName.setText(champName);
		}
		
		private void setLastWinnerName(String lastWinnerName) {
			this.lastWinnerName.setText(lastWinnerName);
		}

		private void setPlayer1Score(int score) {
			this.player1Score.setText(""+score);
		}

		private void setPlayer2Score(int score) {
			this.player2Score.setText(""+score);
		}
		
	}
	
}
