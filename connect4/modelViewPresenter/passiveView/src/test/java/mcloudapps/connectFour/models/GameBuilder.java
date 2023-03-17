package mcloudapps.connectFour.models;

import mcloudapps.connectFour.types.Color;

public class GameBuilder {

    private String[] rows;
    private Color color;
    private Game game;

    public GameBuilder() {
        this.rows = new String[]{
                "       ",
                "       ",
                "       ",
                "       ",
                "       ",
                "       "};
    }

    public GameBuilder rows(String... rows) {
        this.rows = rows;
        return this;
    }

    public GameBuilder turn(Color color) {
        this.color = color;
        return this;
    }

    public Game build() {
        this.game = new Game();
        this.buildBoard();
        if (this.color != null && this.game.getActivePlayerColor() != this.color) {
            this.game.next();
        }
        return this.game;
    }

    private void buildBoard() {
        this.putTokens(Color.R);
        this.game.next();
        this.putTokens(Color.Y);
    }

    private void putTokens(Color color) {
        for (int i = this.rows.length; i > 0; i--) {
            String string = this.rows[i-1];
            for (int j = 1; j < string.length(); j++) {
                if(Character.toString(string.charAt(j-1)).equals(color.name())) {
                    this.game.putToken(j, color);
                }
            }
        }
    }
    
}
