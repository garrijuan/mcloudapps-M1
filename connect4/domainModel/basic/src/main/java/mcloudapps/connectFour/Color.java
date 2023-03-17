package mcloudapps.connectFour;

public enum Color {
    R, Y, NONE;

    static Color get(int ordinal){
		assert ordinal >= 0 && ordinal < Color.NONE.ordinal();

		return Color.values()[ordinal];
	}

	boolean isNull() {
		return this == Color.NONE;
	}

    public String toString() {
        return this.name();
    }

}
