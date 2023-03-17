package mcloudapps.connectFour.models;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import mcloudapps.connectFour.types.Color;

public class BoardBuilder {

    private List<String> rows;

    public BoardBuilder() {
        this.rows = new ArrayList<String>();
    }

    public BoardBuilder rows(String... rows) {
        assert rows.length == 6;
        for (String row : rows) {
            assert Pattern.matches("[RY ]{7}", row);
            this.rows.add(row);
        }
        return this;
    }

    public Board build() {
        Board board = new Board();
        if (!this.rows.isEmpty()) {
            for (int i = this.rows.size() - 1; i >= 0; i--) {
                String row = this.rows.get(i);
                for (int j = 1; j <= row.length(); j++) {
                    char character = row.charAt(j-1);
                    if (character != ' ') {
                        board.putToken(j, Color.valueOf(character + ""));
                    }
                }
            }
        }
        return board;
    }
    
}
