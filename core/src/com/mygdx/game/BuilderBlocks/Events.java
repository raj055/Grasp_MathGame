package com.mygdx.game.BuilderBlocks;

/**
 *
 *
 */

public enum Events {
  // Chapter 1
  BALL_DRAG_EVENT,
  REMAINDER_BALL_DRAG,
  SCROLL_NUMBER_SELECT,
  DRAG_CIRCLE,
  DRAG_TEXT,
  DRAG_LABEL,
  DRAG_IMAGE,
  DRAG_SHAPE,
  DOUBLE_CLICK,

  // Chapter 2 : level 2
  CLICK_ScrollingCh1,
  CLICK_ScrollingCh2,
  CLICK_ScrollingCh3,
  CLICK_ScrollingCh4,
  CLICK_ScrollingCh5,
  CLICK_ScrollingCh6,
  CLICK_ScrollingCh7,
  CLICK_ScrollingCh8,

  // Chapter 3 : level 2
  DOUBLE_CLICK_IMG_Y1,
  DOUBLE_CLICK_IMG_Y2,
  DOUBLE_CLICK_IMG_SQ1,
  DOUBLE_CLICK_IMG_SQ2,
  DOUBLE_CLICK_IMG_C1,
  DOUBLE_CLICK_IMG_C2,


  // Chapter 4 : level 3


  // Chapter 5 : level 1
  DOUBLE_CLICK_ADD,

  // Chapter 6 : level 1
  DRAG_SQUARE,
  DRAG_SQUARE1,
  DRAG_SQUARE_L,
  DRAG_CIRCLE_1,
  DRAG_TRIANGLE_P,

  // Chapter 6 : level 2
  DOUBLE_CLICK_LabelAC,

  // Chapter 6 : level 3
  DOUBLE_CLICK_IMG,
  DOUBLE_CLICK_IMG1,
  DOUBLE_CLICK_IMG2,
  DOUBLE_CLICK_IMG3,
  DOUBLE_CLICK_IMG4,
  DOUBLE_CLICK_IMG5,
  DOUBLE_CLICK_IMG6,
  DOUBLE_CLICK_IMG7,
  DOUBLE_CLICK_IMG8,
  DOUBLE_CLICK_IMG9,
  DOUBLE_CLICK_IMG9_2,



  // Chapter 8 : level 1
  DOUBLE_CLICK_AC,
  DOUBLE_CLICK_AC1,
  DOUBLE_CLICK_AB,
  DOUBLE_CLICK_AB1,
  DOUBLE_CLICK_BC,
  DOUBLE_CLICK_BC1,

  DEFAULT_EVENT;

  private final String[] strlist = {
    "",
    "",
  };

  public int getEventSequence (Events events){
    return events.ordinal();
  }
}
