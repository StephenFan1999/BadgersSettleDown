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

import java.util.*;

/**
 * This class represents a Sett, where a group of Badgers live together. Each 
 * Sett is organized as a BST of Badger nodes.
 * 
 * @author Stephen Fan
 *
 */
public class Sett {
  // declare class fields
  private Badger topBadger;

  /**
   * Constructs an empty Sett.
   */
  public Sett() {
    // initialize class fields
    this.topBadger = null;
  }

  /**
   * Empties this Sett, to no longer contain any Badgers.
   */
  public void clear() {
    // reset class fields
    this.topBadger = null;
  }

  /**
   * This recursive helper method is used to help count the number of Badgers 
   * in this Sett.
   * 
   * @param current - The current Badger that is the root of a (sub) tree that 
   * we are counting the number of Badgers within.
   * @return the number of Badgers living in the Sett rooted at the current 
   * Badger.
   */
  private int countHelper(Badger current) {
    // checks if the current badger is null
    if (current == null) {
      // returns 0 if the current badger is null
      return 0;
    } else {
      // adds up the number of Badgers under the current badger recursively
      int count = 1;
      // adds up the number of Badgers under the current badger's left side
      count += countHelper(current.getLeftLowerNeighbor());
      // adds up the number of Badgers under the current badger's right side
      count += countHelper(current.getRightLowerNeighbor());

      return count;
    }
  }

  /**
   * Counts how many Badgers live in this Sett.
   * 
   * @return The number of Badgers living in this Sett.
   */
  public int countBadger() {
    // calls the countHelper with the topBadger as the parameter in order to
    // count all the Badgers in the tree
    return countHelper(topBadger);
  }

  /**
   * Finds a Badger of a specified size in this Sett.
   * 
   * @param size - The size of the Badger object to search for and return.
   * @return The Badger found with the specified size.
   * @throws java.util.NoSuchElementException - When there is no Badger in this 
   * Sett with the specified size.
   */
  public Badger findBadger(int size) {
    // calls the findHelper with the topBadger as the parameter in order to
    // check all the Badgers in the tree
    return findHelper(topBadger, size);
  }

  /**
   * This recursive helper method is used to help find a Badger within this 
   * Sett.
   * 
   * @param current - The current Badger that is the root of a (sub) tree that 
   * we are searching for a Badger with the specified size within.
   * @param size    - The size of the Badger object to search for and return.
   * @return The Badger found with the specified size.
   * @throws java.util.NoSuchElementException - When there is no Badger in this 
   * Sett with the specified size.
   */
  private Badger findHelper(Badger current, int size) {
    // create a Badger to return if the Badger isn't found
    Badger foundBadger = null;

    // if the Sett isn't empty try to find the Badger
    if (current != null) {
      int currentSize = current.getSize();
      // recursively calls itself if the size wanted is less than the current
      // size
      if (size < currentSize) {
        foundBadger = findHelper(current.getLeftLowerNeighbor(), size);
      }
      // recursively calls itself if the size wanted is greater than the
      // current size
      else if (size > currentSize) {
        foundBadger = findHelper(current.getRightLowerNeighbor(), size);
      }
      // returns the correct Badger when it is found
      else {
        return current;
      }
    } else {
      // throws a NoSuchElementException if the Sett is empty or the Badger
      // was not found
      throw new NoSuchElementException(
          "WARNING: failed to find a badger with size " + size + " in the "
              + "sett");
    }

    return foundBadger;

  }

  /**
   * Creates a new Badger object with the specified size, and inserts them into 
   * this Sett (BST).
   * 
   * @param size - The size of the new Badger that will be settled.
   * @throws java.lang.IllegalArgumentException - When a Badger with the 
   * specified size already exists within this Sett.
   */
  public void settleBadger(int size) {
    // creates a new Badger to settle
    Badger newBadger = new Badger(size);
    // calls the settleHelper method
    settleHelper(topBadger, newBadger);
  }

  /**
   * This recursive helper method is used to help settle a new Badger within 
   * this Sett.
   * 
   * @param current   - The current Badger (previously settled within this 
   * Sett) that we are considering settling the newBadger beneath (either to 
   * its left or right).
   * @param newBadger - The new Badger that needs to be settled within this 
   * Sett.
   * @throws java.lang.IllegalArgumentException - When a Badger with the 
   * specified size already exists within this Sett.
   */
  private void settleHelper(Badger current, Badger newBadger) {
    // checks if the current Badger is null and sets it to the newBadger if it
    // is
    if (current == null) {
      this.topBadger = newBadger;
    } else {
      int currentSize = current.getSize();
      // checks if the newBadger's size is greater than the current size
      if (newBadger.getSize() > currentSize) {
        // set the right lower neighbor to the newBadger if it's null
        if (current.getRightLowerNeighbor() == null) {
          current.setRightLowerNeighbor(newBadger);
        } else {
          // recursively call settleHelper until you can set a node to
          // newBadger
          settleHelper(current.getRightLowerNeighbor(), newBadger);
        }
      }
      // checks if the newBadger's size is less than the current size
      else if (newBadger.getSize() < currentSize) {
        // sets the left lower neighbor to the newBadger if it's null
        if (current.getLeftLowerNeighbor() == null) {
          current.setLeftLowerNeighbor(newBadger);
        } else {
          // recursively call settleHelper until you can set a node to
          // newBadger
          settleHelper(current.getLeftLowerNeighbor(), newBadger);
        }
      } else {
        // throw an IllegalArgumentException if there is already a Badger in
        // the Sett with the same size
        throw new IllegalArgumentException(
            "WARNING: failed to settle the badger with size "
                + newBadger.getSize() + ", as there is already a badger with "
                    + "the same size in this sett");
      }
    }
  }

  /**
   * Gets all Badgers living in the Sett as a list in ascending order of their 
   * size: smallest one in the front (at index zero), through the largest one 
   * at the end (at index size-1).
   * 
   * @return A list of all Badgers living in the Sett in ascending order by 
   * size.
   */
  public java.util.List<Badger> getAllBadgers() {
    // create a List to return
    ArrayList<Badger> allBadgers = new ArrayList<Badger>();
    Badger current = topBadger;

    // call the getAllHelper method
    getAllHelper(current, allBadgers);

    return allBadgers;
  }

  /**
   * This recursive helper method is used to help collect the Badgers within 
   * this Sett into a List.
   * 
   * @param current    - The current Badger that is the root of a (sub) tree 
   * that we are collecting all contained Badgers within, into the allBadgers 
   * List.
   * @param allBadgers - The list of all Badgers living in the Sett that is 
   * rooted at the current Badger node. The contents of this list should be in 
   * ascending order by Badger size.
   */
  private void getAllHelper(Badger current, java.util.List<Badger> allBadgers) {
    // if the current Badger isn't null
    if (current != null) {
      // add Badgers starting from the left side of the Sett and then add
      // Badgers on the right side of the Sett
      getAllHelper(current.getLeftLowerNeighbor(), allBadgers);
      allBadgers.add(current);
      getAllHelper(current.getRightLowerNeighbor(), allBadgers);
    }
  }

  /**
   * Computes the height of the Sett, as the number of nodes from root to the 
   * deepest leaf Badger node.
   * 
   * @return The depth of this Sett.
   */
  public int getHeight() {
    // calls the getHeightHelper method
    return getHeightHelper(this.topBadger);
  }

  /**
   * This recursive helper method is used to help compute the height of this 
   * Sett.
   * 
   * @param current - The current Badger that is the root of a (sub) tree that 
   * we are calculating the height of.
   * @return The height of the (sub) tree that we are calculating.
   */
  private int getHeightHelper(Badger current) {
    // checks if the current Badger is null
    if (current == null) {
      // if the current Badger is null the tree has height 0
      return 0;
    } else {
      // initialize height to 1 because we know the tree has at least 1 Badger
      int height = 1;

      // calculates the height of the left side of the tree recursively
      int leftHeight = countHelper(current.getLeftLowerNeighbor());

      // calculates the height of the right side of the tree recursively
      int rightHeight = countHelper(current.getRightLowerNeighbor());

      // add the height of the larger side to the initial height of 1
      if (leftHeight > rightHeight) {
        height += leftHeight;
      } else {
        height += rightHeight;
      }

      return height;
    }
  }

  /**
   * Retrieves the largest Badger living in this Sett.
   * 
   * @return The largest Badger living in this Sett.
   */
  public Badger getLargestBadger() {
    Badger currentBadger = this.topBadger;

    // continue to take the furthest right Badger in the Sett until you get to
    // the Badger on the end of the right side which is the largest one
    while (currentBadger.getRightLowerNeighbor() != null) {
      currentBadger = currentBadger.getRightLowerNeighbor();
    }

    return currentBadger;
  }

  /**
   * Retrieve the top Badger within this Sett (the one that was settled first).
   * 
   * @return The Badger living on the top of the current Sett.
   */
  public Badger getTopBadger() {
    // returns the topBadger
    return this.topBadger;
  }

  /**
   * Checks whether this Sett is empty.
   * 
   * @return true if this Sett is empty, false otherwise.
   */
  public boolean isEmpty() {
    // initialize boolean variable to return
    boolean isEmpty = false;

    // if there is no topBadger in the Sett, the Sett is empty
    if (topBadger == null) {
      isEmpty = true;
    }

    return isEmpty;
  }
}
