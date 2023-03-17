package mcloudapps.connectFour.models;

import java.util.ArrayList;
import java.util.List;

public class Registry {

    private List<Memento> mementos;
    private Game game;
    private int currentMemento;

    public Registry(Game game) {
        this.game = game;
        this.reset();
    }

    public void reset() {
        this.currentMemento = 0;
        this.mementos = new ArrayList<>();
        this.register();
    }

    public void register() {
        this.currentMemento++;
        this.mementos.add(new Memento(this.game)); 
    }

    public void redo() {
        assert isRedoable();
        this.game.setMemento(this.mementos.get(--this.currentMemento));
    }

    public void undo() {
        assert isUndoable();
        this.game.setMemento(this.mementos.get(++this.currentMemento));
    }


    public boolean isRedoable() {
        return this.currentMemento > 1;
    }

    public boolean isUndoable() {
        return this.currentMemento > 1;
        //return this.currentMemento < this.mementos.size() - 1;
    }

}
