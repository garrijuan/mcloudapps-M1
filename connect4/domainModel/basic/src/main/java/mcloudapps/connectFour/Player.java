package mcloudapps.connectFour;

import mcloudapps.utils.BoundedIntDialog;

public class Player {

    private Color color;
    private Board board;

    public Player(Color color, Board board) {
        assert color != Color.NONE;;
        assert board != null;
        this.color = color;
        this.board = board;
    }

    public Color getColor() {
        return this.color;
    }    

    public void play(){
        int column;
        Error error;
        do {
            column = this.getColumn(Message.ENTER_COLUMN_TO_PUT);
            error = this.getPutTokenError(column, this.color);
        } while (!error.isNull());
        this.board.putToken(column, this.color);
    }

    private int getColumn(Message message) {
        assert message != null;
        BoundedIntDialog boundedIntDialog = new BoundedIntDialog(1, Board.NCOLS);
        return boundedIntDialog.read(message.toString().replaceAll("#player", "" + this.color));
    }

    public Error getPutTokenError(int column, Color color) {
        Error error = Error.NULL;
        if (!this.board.isColumnValid(column)) {
            error = Error.WRONG_COLUMN;
        } else if (this.board.isColumnFull(column)) {
            error = Error.COLUMN_FULL;
        }
        error.writeln();
        return error;
    }
}
