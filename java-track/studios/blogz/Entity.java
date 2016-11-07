package blogz;

public abstract class Entity {

	private final int uid;

	public Entity(int uid){
		this.uid = uid;
	}
	
	public int getUid(){
		return this.uid;
		
	}


}