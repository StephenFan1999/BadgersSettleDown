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

public class P9Tests {

  /**
   * Tests the countBadger() method in the Sett class
   * 
   * @return true if the test passed and false if it didn't
   */
  private static boolean testCountBadger1() {
    // create new Sett
    Sett sett = new Sett();

    // settle Badgers
    sett.settleBadger(5);
    sett.settleBadger(6);
    sett.settleBadger(4);

    // if countBadger() doesn't return 3 return false otherwise return true
    if (sett.countBadger() != 3) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * test countBadger() method in the Sett class
   * 
   * @return true if the test passed and false if it didn't
   */
  private static boolean testCountBadger2() {
    // create new Sett
    Sett sett = new Sett();

    // settle Badgers
    sett.settleBadger(5);
    sett.settleBadger(4);
    sett.settleBadger(6);
    sett.settleBadger(7);
    sett.settleBadger(1);
    sett.settleBadger(2);
    sett.settleBadger(10);

    // if countBadger() returns 7 return true otherwise return false
    if (sett.countBadger() == 7) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Test method for settleBadger() method in the Sett class
   * 
   * @return true if the test passed and false if it didn't
   */
  private static boolean testSettleBadger() {
    // create new Sett
    Sett sett = new Sett();

    // settle Badgers
    sett.settleBadger(5);
    sett.settleBadger(4);
    sett.settleBadger(6);
    sett.settleBadger(7);
    sett.settleBadger(1);
    sett.settleBadger(2);
    sett.settleBadger(10);

    // settleBadger() with a size already in the tree should throw an
    // IllegalArgumentException so if it does then return true otherwise return
    // false
    try {
      sett.settleBadger(10);
      return false;
    } catch (IllegalArgumentException e) {
      return true;
    }
  }

  /**
   * Test method for the findBadger() method in the Sett class
   * 
   * @return true if the test passed and false if it didn't
   */
  private static boolean testFindBadger1() {
    // create new Sett
    Sett sett = new Sett();

    // settle Badgers
    sett.settleBadger(5);
    sett.settleBadger(4);
    sett.settleBadger(6);
    sett.settleBadger(7);
    sett.settleBadger(1);
    sett.settleBadger(2);
    sett.settleBadger(10);

    // the Badger found with findBadger(10) should have size 10 and if it does
    // then return true otherwise return false
    if (sett.findBadger(10).getSize() == 10) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Test method for the findBadger() method in the Sett class
   * 
   * @return true if the test passed and false if it didn't
   */
  private static boolean testFindBadger2() {
    // create new Sett
    Sett sett = new Sett();

    // settle Badgers
    sett.settleBadger(5);
    sett.settleBadger(4);
    sett.settleBadger(6);
    sett.settleBadger(7);
    sett.settleBadger(1);
    sett.settleBadger(2);
    sett.settleBadger(10);

    // trying to find a Badger with size 9 when it doesn't exist should throw
    // a NoSuchElementException and if it does, return true otherwise return
    // false
    try {
      sett.findBadger(9);
      return false;
    } catch (NoSuchElementException e) {
      return true;
    }
  }

  /**
   * Test method for the clear() method in the Sett class
   * 
   * @return true if the test passed and false if it didn't
   */
  private static boolean testClear() {
    // create new Sett
    Sett sett = new Sett();

    // settle Badgers
    sett.settleBadger(5);
    sett.settleBadger(4);
    sett.settleBadger(6);
    sett.settleBadger(7);
    sett.settleBadger(1);
    sett.settleBadger(2);
    sett.settleBadger(10);

    // clears the Sett
    sett.clear();

    // checks if the Sett is now empty and if it is, return true otherwise
    // return false
    if (sett.countBadger() == 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Test method for the getAllBadgers() method in the Sett class
   * 
   * @return true if the test passed and false if it didn't
   */
  private static boolean testGetAllBadgers() {
    // create new Sett
    Sett sett = new Sett();

    // settle Badgers
    sett.settleBadger(5);
    sett.settleBadger(4);
    sett.settleBadger(6);
    sett.settleBadger(7);
    sett.settleBadger(1);
    sett.settleBadger(2);
    sett.settleBadger(10);

    // checks if each value in the List of Badgers is correct and in order from
    // least to greatest in size and returns true if they are and false
    // otherwise
    List<Badger> badgerList = sett.getAllBadgers();
    if (badgerList.get(0).getSize() != 1) {
      return false;
    } else if (badgerList.get(1).getSize() != 2) {
      return false;
    } else if (badgerList.get(2).getSize() != 4) {
      return false;
    } else if (badgerList.get(3).getSize() != 5) {
      return false;
    } else if (badgerList.get(4).getSize() != 6) {
      return false;
    } else if (badgerList.get(5).getSize() != 7) {
      return false;
    } else if (badgerList.get(6).getSize() != 10) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * Test method for the getHeight() method in the Sett class
   * 
   * @return true if the test passed and false if it didn't
   */
  private static boolean testGetHeight() {
    // create new Sett
    Sett sett = new Sett();

    // settle Badgers
    sett.settleBadger(5);
    sett.settleBadger(4);
    sett.settleBadger(6);
    sett.settleBadger(7);
    sett.settleBadger(1);
    sett.settleBadger(2);
    sett.settleBadger(10);

    // if the height of Sett is 4 return true and otherwise return false
    if (sett.getHeight() == 4) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Test method for the getLargestBadger() method in the Sett class
   * 
   * @return true if the test passed and false if it didn't
   */
  private static boolean testGetLargestBadger1() {
    // create new Sett
    Sett sett = new Sett();

    // settle Badgers
    sett.settleBadger(5);
    sett.settleBadger(4);
    sett.settleBadger(6);
    sett.settleBadger(7);
    sett.settleBadger(1);
    sett.settleBadger(2);
    sett.settleBadger(10);

    // the largest badger has size 10 so the getLargestBadger() method should
    // return a Badger of size 10 and return true if it does and false
    // otherwise
    if (sett.getLargestBadger().getSize() == 10) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Test method for the getLargestBadger() method in the Sett class
   * 
   * @return true if the test passed and false if it didn't
   */
  private static boolean testGetLargestBadger2() {
    // create new Sett
    Sett sett = new Sett();

    // settle Badgers
    sett.settleBadger(9);
    sett.settleBadger(8);
    sett.settleBadger(5);
    sett.settleBadger(4);
    sett.settleBadger(1);

    // the largest badger has size 9 so the getLargestBadger() method should
    // return a Badger of size 9 and return true if it does and false
    // otherwise
    if (sett.getLargestBadger().getSize() == 9) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Test method for the getTopBadger() method in the Sett class
   * 
   * @return true if the test passed and false if it didn't
   */
  private static boolean testGetTopBadger() {
    // create new Sett
    Sett sett = new Sett();

    // settle Badgers
    sett.settleBadger(5);
    sett.settleBadger(4);
    sett.settleBadger(6);
    sett.settleBadger(7);
    sett.settleBadger(1);
    sett.settleBadger(2);
    sett.settleBadger(10);

    // TopBadger should have size 5 and return true if it does and false
    // otherwise
    if (sett.getTopBadger().getSize() == 5) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Test method for the isEmpty() method in the Sett class
   * 
   * @return true if the test passed and false if it didn't
   */
  private static boolean testIsEmpty() {
    // create new Sett
    Sett sett = new Sett();

    // settle Badgers
    sett.settleBadger(5);
    sett.settleBadger(4);
    sett.settleBadger(6);
    sett.settleBadger(7);
    sett.settleBadger(1);
    sett.settleBadger(2);
    sett.settleBadger(10);

    // the Sett isn't empty so if isEmpty() returns true, return false
    if (sett.isEmpty() == true) {
      return false;
    } else {
      // clears Sett. Sett is now empty.
      sett.clear();
      // Sett is now empty so isEmpty() should return true. Return true if it
      // does and false otherwise
      if (sett.isEmpty() == true) {
        return true;
      } else {
        return false;
      }
    }
  }

  /**
   * Test method for the getNeighbors() method in the Badger class
   * 
   * @return true if the test passed and false if it didn't
   */
  private static boolean testGetNeighbors() {
    // create 3 badgers
    Badger badger1 = new Badger(5);
    Badger badger2 = new Badger(6);
    Badger badger3 = new Badger(7);

    // set neighbors
    badger2.setLeftLowerNeighbor(badger1);
    badger2.setRightLowerNeighbor(badger3);

    // checks if the neighbors are correct and returns false if they are not,
    // returns true if they are correct
    if (badger2.getLeftLowerNeighbor() != badger1) {
      return false;
    } else if (badger2.getRightLowerNeighbor() != badger3) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * Test method for the getSize() method in the Badger class
   * 
   * @return true if the test passed and false if it didn't
   */
  private static boolean testGetSize() {
    // create 3 new badgers
    Badger badger1 = new Badger(5);
    Badger badger2 = new Badger(6);
    Badger badger3 = new Badger(7);

    // check that all their sizes are correct and return false if they are not
    // correct, and return true otherwise
    if (badger1.getSize() != 5) {
      return false;
    } else if (badger2.getSize() != 6) {
      return false;
    } else if (badger3.getSize() != 7) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * Test method for the Sett class constructor
   * 
   * @return true if the test passed and false if it didn't
   */
  private static boolean testSettConstructor() {
    // create new Sett
    Sett sett = new Sett();

    // the constructor for Sett should initialize an empty Sett so return
    // true if the Sett is empty and false otherwise
    if (sett.isEmpty() == true) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Test method for the Badger class' constructor
   * 
   * @return true if the test passed and false if it didn't
   */
  private static boolean testBadgerConstructor() {
    // create new Badger
    Badger badger = new Badger(5);

    // check that leftLowerNeighbor and rightLowerNeighbor are both correctly
    // initialized to null
    if (badger.getLeftLowerNeighbor() != null) {
      return false;
    } else if (badger.getRightLowerNeighbor() != null) {
      return false;
    }
    // check that the size was correctly initialized to 5
    else if (badger.getSize() != 5) {
      return false;
    }
    // if everything was correctly initialized return true
    else {
      return true;
    }
  }

  /**
   * public method to run all the Badger class tests
   * 
   * @return true if all the tests passed and false if any one didn't
   */
  public static boolean runAllBadgerTests() {
    // returns true when all Badger tests pass
    if (testGetNeighbors() == false) {
      return false;
    } else if (testGetSize() == false) {
      return false;
    } else if (testBadgerConstructor() == false) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * public method to run all the Sett class tests
   * 
   * @return true if all the tests passed and false if any one didn't
   */
  public static boolean runAllSettTests() {
    // returns true when all Sett tests pass
    if (testCountBadger1() == false) {
      return false;
    } else if (testCountBadger2() == false) {
      return false;
    } else if (testFindBadger1() == false) {
      return false;
    } else if (testFindBadger2() == false) {
      return false;
    } else if (testClear() == false) {
      return false;
    } else if (testGetAllBadgers() == false) {
      return false;
    } else if (testGetHeight() == false) {
      return false;
    } else if (testGetLargestBadger1() == false) {
      return false;
    } else if (testGetLargestBadger2() == false) {
      return false;
    } else if (testIsEmpty() == false) {
      return false;
    } else if (testGetTopBadger() == false) {
      return false;
    } else if (testSettleBadger() == false) {
      return false;
    } else if (testSettConstructor() == false) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * main method for visual feedback of test performance
   * 
   * @param args command line argument not used
   */
  public static void main(String[] args) {
    System.out.println("Badger tests have returned " + runAllBadgerTests());
    System.out.println("Sett tests have returned " + runAllSettTests());
  }
}
