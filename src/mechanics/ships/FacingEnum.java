package mechanics.ships;

public enum FacingEnum {
	POSITIVE_X,
	NEGATIVE_X,
	POSITIVE_Y,
	NEGATIVE_Y,
	POSITIVE_Z,
	NEGATIVE_Z;
	
	public boolean isOppositeOf(FacingEnum facingDirection){
		if(facingDirection.equals(POSITIVE_X) && this.equals(NEGATIVE_X)
				|| facingDirection.equals(NEGATIVE_X) && this.equals(POSITIVE_X)
				|| facingDirection.equals(POSITIVE_Y) && this.equals(NEGATIVE_Y)
				|| facingDirection.equals(NEGATIVE_Y) && this.equals(POSITIVE_Y)
				|| facingDirection.equals(POSITIVE_Z) && this.equals(NEGATIVE_Z)
				|| facingDirection.equals(NEGATIVE_Z) && this.equals(POSITIVE_Z)){
			return true;
		}
		return false;
	}
}
