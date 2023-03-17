package mcloudapps.connectFour.types;

public enum Color {
    R, Y, NONE;

    public static Color get(int ordinal){
		assert ordinal >= 0 && ordinal < Color.NONE.ordinal();

		return Color.values()[ordinal];
	}

	public boolean isNull() {
		return this == Color.NONE;
	}

    public String toString() {
        return this.name();
    }

}
