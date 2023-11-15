package com.springintensivao.dslist.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_belonging")
public class Belonging {

	@EmbeddedId
	private BelongingPK primaryKeyId = new BelongingPK();
	
	private Integer position;
	
	public Belonging() {
	}

	public Belonging(Game game, GameList list, Integer position) {
		primaryKeyId.setGame(game);
		primaryKeyId.setList(list);
		this.position = position;
	}

	public BelongingPK getPrimaryKeyId() {
		return primaryKeyId;
	}

	public void setPrimaryKeyId(BelongingPK primaryKeyId) {
		this.primaryKeyId = primaryKeyId;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(primaryKeyId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Belonging other = (Belonging) obj;
		return Objects.equals(primaryKeyId, other.primaryKeyId);
	}
	
	
	
	
}
