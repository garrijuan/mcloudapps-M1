package mcloudapps.utils.models;

public class Coordinate {

    protected int row;
	protected int column;

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}

    public boolean isNull() {
		return false;
	}
    
    public void shift(Direction direction) {
        this.row += direction.directionRow;
        this.column += direction.directionColumn;
    }

    public boolean isValid(int row, int column) {
        return row > 0 && column > 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) this.row;
        result = prime * result + (int) this.column;
        return result;       
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        Coordinate other = (Coordinate) obj;
        return this.row == other.row && this.column == other.column;
    }

    @Override
    public Object clone(){
        return new Coordinate(this.row, this.column);
    }
}
