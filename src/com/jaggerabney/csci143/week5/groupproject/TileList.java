package com.jaggerabney.csci143.week5.groupproject;

import java.util.*;

public class TileList {
  private ArrayList<Tile> tiles;

  public TileList() {
    this.tiles = new ArrayList<>();
  }

  public Tile moveToBack(int x, int y) {
    Tile resultTile = null;

    for (Tile tile : tiles) {
      if (tile.inside(x, y)) {
        resultTile = tile;
      }
    }

    if (resultTile != null) {
      tiles.remove(resultTile);
      insertBack(resultTile);
    }

    return resultTile;
  }

  // post: inserts t at the back of the list of tiles

  public void insertBack(Tile t) {
    tiles.add(t);
  }

  // post: returns the number of tiles in this list

  public int size() {
    return tiles.size();
  }

  // post: returns the Tile at the given index

  public Tile get(int index) {
    return tiles.get(index);
  }
}
