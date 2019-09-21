//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P09 Badgers Settle Down
// Files: Badger.java, Sett.java, P9Tests.java,
// BadgersSettleDown.java
// Course: CS300, Fall 2018
//
// Author: Stephen Fan
// Email: sfan54@wisc.edu
// Lecturer's Name: Alexi Brooks
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * This class represents a Badger which is designed to live in a Sett. Each 
 * Badger object represents a single node within a BST (known as a Sett).
 * 
 * @author Stephen Fan
 *
 */
public class Badger {
  // declare class fields
  private Badger leftLowerNeighbor;
  private Badger rightLowerNeighbor;
  private int size;

  /**
   * Creates a new Badger with specified size. initializes size and sets both 
   * neighbors to null
   * 
   * @param size is the size of the Badger
   */
  public Badger(int size) {
    // initialize class fields
    this.size = size;
    this.leftLowerNeighbor = null;
    this.rightLowerNeighbor = null;
  }

  /**
   * simple accessor method Retrieves neighboring badger that is smaller than 
   * this one.
   * 
   * @return leftLowerNeighbor is the left node of the Badger
   */
  public Badger getLeftLowerNeighbor() {
    return this.leftLowerNeighbor;
  }

  /**
   * simple accessor method Retrieves neighboring badger that is larger than 
   * this one.
   * 
   * @return rightLowerNeighbor is the right node of the Badger
   */
  public Badger getRightLowerNeighbor() {
    return this.rightLowerNeighbor;
  }

  /**
   * simple accessor method Retrieves the size of this badger.
   * 
   * @return size is the size of the Badger
   */
  public int getSize() {
    return this.size;
  }

  /**
   * simple mutator method Changes this badger's lower left neighbor.
   * 
   * @param badger is the badger to set the left lower neighbor to
   */
  public void setLeftLowerNeighbor(Badger badger) {
    this.leftLowerNeighbor = badger;
  }

  /**
   * simple mutator method Changes this badger's lower right neighbor.
   * 
   * @param badger is the badger to set the right lower neighbor to
   */
  public void setRightLowerNeighbor(Badger badger) {
    this.rightLowerNeighbor = badger;
  }
}
