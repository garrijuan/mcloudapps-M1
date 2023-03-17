package mcloudapps.connectFour.models;

import mcloudapps.connectFour.types.Color;
import mcloudapps.connectFour.types.Error;

public class Player {

    private Color color;
    private Board board;

    public Player(Color color, Board board) {
        assert color != Color.NONE;;
        assert board != null;
        this.color = color;
        this.board = board;
    }

    public void putToken(int column)
    {
        this.board.putToken(column, this.color);
    }

    public Error getPutTokenError(int column) {
        Error error = Error.NULL;
        if (!this.board.isColumnValid(column)) {
            error = Error.INVALID_COLUMN;
        } else if (this.board.isColumnFull(column)) {
            error = Error.FULL_COLUMN;
        }
        return error;
    }
    
    public Color getColor() {
        return this.color;
    }    

    @Override
    public boolean equals(Object object) {
        boolean result = false;
        if (object instanceof Player) {
            Player player = (Player) object;
            result = this.color == player.color;
        }
        return result;
    }

}
