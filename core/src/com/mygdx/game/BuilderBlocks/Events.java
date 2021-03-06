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
  CLICK_SCROLLCH2_BALLDISPLAY,

  //Chapter3 - Drag12 : Level (11-15)
  DRAG_VALUE_A1,
  DRAG_VALUE_B1,
  DRAG_VALUE_B11,
  DRAG_VALUE_C1,
  DRAG_VALUE_A2,
  DRAG_VALUE_B2,
  DRAG_VALUE_B22,
  DRAG_VALUE_C2,

  // Chapter 4 : level (6-10)
  DRAG_IMGLIGHT,
  DRAG_IMGSQUARE,
  DRAG_IMGSQUARE1,
  DRAG_IMGSQUARE2,
  DRAG_IMGBOX1,

  // Chapter 4 : level (11-15)
  DRAGA1,
  DRAGA2,
  DRAGB1,
  DRAGB2,
  DRAGB3,
  DRAGC1,
  DRAGC2,

  // Chapter 5 : level (1-5)
  DOUBLE_CLICK_ADD,

  DRAG_C5L1_VALUE1,
  DRAG_C5L1_VALUE2,
  DRAG_C5L1_VALUE12,
  DRAG_C5L1_VALUE13,

  // Chapter 5 : level (6-10)
  CLICK_ScrollingCh5L3,

  DRAG_C5L2_VALUE1,
  DRAG_C5L2_VAL1,

  // Chapter 5 : level (11-15)
  DRAG_C5L3S1_VALUE1,
  DRAG_C5L3S1_VAL1,

  DRAG_C5L3S2_VALUE1,
  DRAG_C5L3S2_VAL1,

  // Chapter 6 : level 1
  DRAG_SQUARE,
  DRAG_SQUARE1,
  DRAG_SQUARE_L,
  DRAG_CIRCLE_1,
  DRAG_TRIANGLE_P,

  // Chapter 6 : level 2
  DOUBLE_CLICK_LabelAC,
  DOUBLE_CLICK_LabelAB,
  DOUBLE_CLICK_LabelBC,

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

  // Chapter 7 : level 1-5
  DRAG_L1_VALUE,
  DRAG_L1_VALUE3,
  DRAG_L1_VALUE12,
  DRAG_L1_VALUE14,

  // Chapter 7 : level 6-10
  DRAG_L2_VALUE12,
  DRAG_L2_VALUE14,
  DRAG_L2_VALUEK1,
  DRAG_L2_VALUEK2,

  DRAG_L2_VALUE1,
  DRAG_L2_VALUE3,
  DRAG_L2_VALUEK3,
  DRAG_L2_VALUEK4,

  // Chapter 7 : level 11-15
  DRAG_L3_VALUE1,
  DRAG_L3_VALUE1_1,
  DRAG_L3_VALUE3,
  DRAG_L3_VALUE3_1,
  DRAG_L3_VALUE12,
  DRAG_L3_VALUE12_1,
  DRAG_L3_VALUE14,
  DRAG_L3_VALUE14_1,
  DRAG_L3_VALUE22,
  DRAG_L3_VALUE22_1,
  DRAG_L3_VALUE24,
  DRAG_L3_VALUE24_1,

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
