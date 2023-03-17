package mcloudapps.connectFour;

import mcloudapps.utils.YesNoDialog;

public class ConnectFour 
{
    private Board board;
    private Turn turn;
    private Result result;

    public ConnectFour() {
        board = new Board();
        turn = new Turn(this.board);
        result = new Result(this.board);
    }

    public void play() {
        do {
            this.playGame();
            }
        while (this.isResumedGame());
    }

    private void playGame() {
		Message.TITLE.writeln();
		this.board.write();        
        do {
            this.turn.play();
            this.board.write();
        } while (!this.result.isGameOver());
        this.result.writeResult();
    }

    private boolean isResumedGame() {
		YesNoDialog yesNoDialog = new YesNoDialog();
		yesNoDialog.read(Message.RESUME.toString());
		if (yesNoDialog.isAffirmative()) {
			this.board.reset();
			this.turn.reset();
		}
		return yesNoDialog.isAffirmative();
	}

    public static void main( String[] args )
    {
        new ConnectFour().play();
    }
}