import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void everyBranchTest() {

        // allItems = null
        RuntimeException ex1 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 100));
        assertTrue(ex1.getMessage().contains("allItems list can't be null!"));

        // barcode with invalid character
        List<Item> allItemsInvalidBarcode = new ArrayList<>();
        allItemsInvalidBarcode.add(new Item("item1", "123a5", 100, 0.1f));
        RuntimeException ex2 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(allItemsInvalidBarcode, 100));
        assertTrue(ex2.getMessage().contains("Invalid character in item barcode!"));

        // barcode = null
        List<Item> allItemsNullBarcode = new ArrayList<>();
        allItemsNullBarcode.add(new Item(null, null, 100, 0.1f));
        RuntimeException ex3 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(allItemsNullBarcode, 100));
        assertTrue(ex3.getMessage().contains("No barcode!"));

        // return true
        List<Item> allItemsReturnTrue = new ArrayList<>();
        allItemsReturnTrue.add(new Item("item1", "12345", 90, 0));
        allItemsReturnTrue.add(new Item("item2", "67891", 90, 0));
        boolean resultTrue = SILab2.checkCart(allItemsReturnTrue, 180);
        assertTrue(resultTrue);

        // return false
        List<Item> allItemsReturnFalse = new ArrayList<>();
        allItemsReturnFalse.add(new Item("item1", "01234", 350, 0.1f));
        allItemsReturnFalse.add(new Item("item2", "67891", 350, 0.1f));
        boolean resultFalse = SILab2.checkCart(allItemsReturnFalse, 1);
        assertFalse(resultFalse);
    }

    @Test
    void multipleConditionsTest(){

        //F && X && X
        //F && F && X
        //F && F && F
        //T && T && T

        //F && X && X
        List<Item> test1 = new ArrayList<>();
        test1.add(new Item("item1", "012345", 300, 0.1f));
        boolean result1 = SILab2.checkCart(test1,300);
        assertTrue(result1);

        //F && F && X
        List<Item> test2 = new ArrayList<>();
        test2.add(new Item("item2", "012345", 300, 0));
        boolean result2 = SILab2.checkCart(test2,300);
        assertTrue(result2);

        //F && F && F
        List<Item> test3 = new ArrayList<>();
        test3.add(new Item("item3", "112345", 300, 0));
        boolean result3 = SILab2.checkCart(test3,300);
        assertTrue(result3);

        //T && T && T
        List<Item> test4 = new ArrayList<>();
        test4.add(new Item("item4", "012345", 350, 0.1f));
        boolean result4 = SILab2.checkCart(test4,1);
        assertFalse(result4);
    }
}