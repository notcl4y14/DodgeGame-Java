package dodge.entity.entities;

import java.awt.Color;

import dodge.entity.Box;
import dodge.entity.EntityID;

public class Enemy extends Box {
	public Enemy () {
		super(EntityID.Enemy);
		this.color = Color.RED;
	}
}
