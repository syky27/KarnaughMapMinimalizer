package FourLogic;

import java.util.ArrayList;

/**
 * Class where all the logic is written
 * 
 * @author Tomas Sykora, jr
 */
public class FourEvalOperations {

    /**
     * Adding product to list
     * @param list, takes product
     * @param product, store it in list
     */
    public void additem(FourEval list, int product[]) {
        FourEval elem = new FourEval();
        while (list.next != null) {
            list = list.next;
        }
        elem.next = list.next;
        elem.product = product;
        list.next = elem;
    }

    /**
     * Compare the logic binary representation
     * 
     * @param product1, left side of comparation
     * @param product2, right side of comparation
     * @param nvar, maximum value in for cycle
     * @return boolean
     */
    public boolean equal(int product1[], int product2[], int nvar) {
        for (int i = 0; i < nvar; i++) {
            if (product1[i] != product2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * Check is the value already exists
     * 
     * @param item1, checking this value with item2
     * @param item2, checking this value with item1
     * @return size of memory
     */
    public boolean complementary(FourEval item1, FourEval item2) {
        int sum, i;
        for (i = sum = 0; i < item1.nvar; i++) {
            if (item1.product[i] != item2.product[i]) {
                sum += 1;
            }
        }
        return (sum == 1);
    }

    /**
     * Deleting ${item}, from ${list} 
     * @param list, deleting item from here
     * @param item, deletes this item
     */
    public void deleteitem(FourEval list, FourEval item) {
        while (list.next != item) {
            list = list.next;
        }
        if (list.next != null) {
            list.next = list.next.next;
        } else {
            list.next = null;
        }
    }

    /**
     *
     *  Qrec equals the logic boolean expression
     * 
     * @param set, memory where the expressions are stored
     * @param index, helps navigate thought set 
     */
    public void Qrec(ArrayList<FourEval> set, int index) {
        FourEval item1, item2, trav;
        boolean exist;
        int[] prod;
        int j, i;
        if (index < 1) {
            return;
        }
        for (item1 = set.get(index).next; item1 != null;) {
            if (item1.next != null) {
                item2 = item1.next;
                while (item2 != null) {

                    if (this.complementary(item1, item2)) {
                        for (j = i = 0, prod = new int[item1.nvar]; i < item1.nvar; i++, j++) {
                            if (item1.product[i] == item2.product[i]) {
                                prod[j] = item1.product[i];
                            } else {
                                prod[j] = -1;
                            }
                        }

                        for (exist = false, trav = set.get(index - 1).next; trav != null; trav = trav.next) {
                            if (equal(prod, trav.product, trav.nvar)) {
                                exist = true;
                            }
                        }
                        if (!exist) {
                            this.additem(set.get(index - 1), prod);
                        }

                        item1.used = item2.used = 1;
                    }
                    prod = new int[3];
                    item2 = item2.next;
                }
            }
            item2 = item1;
            item1 = item1.next;
            if (item2.used == 1) {
                deleteitem(set.get(index), item2);
            }
        }
        Qrec(set, index - 1);
    }

    /**
     *
     * Giving output
     * 
     * @param set, takes the value from here
     * @return returns string with solved expression
     */
    public String CollectVar(ArrayList<FourEval> set) {
        String var[] = {"A", "B", "C", "D", "\0"};
        FourEval trail = new FourEval();

        String simplified_bool = new String(" ");
        for (int i = 0; i < 3; i++) {
            for (FourEval trav = set.get(i).next; trav != null; trav = trav.next) {
                trail = trav;
                if (trav.product[0] != -1) {
                    if (trav.product[0] == 1) {
                        simplified_bool = simplified_bool.concat(var[0] + ".");
                    } else {
                        simplified_bool = simplified_bool.concat("not(" + var[0] + ")");
                    }
                }
                if (trav.product[1] != -1) {
                    if (trav.product[1] == 1) {
                        simplified_bool = simplified_bool.concat(var[1] + ".");
                    } else {
                        simplified_bool = simplified_bool.concat("not(" + var[1] + ")");
                    }
                }
                if (trav.product[2] != -1) {
                    if (trav.product[2] == 1) {
                        simplified_bool = simplified_bool.concat(var[2] + ".");
                    } else {
                        simplified_bool = simplified_bool.concat("not(" + var[2] + ")");
                    }
                }
                if (trav.product[3] != -1) {
                    if (trav.product[3] == 1) {
                        simplified_bool = simplified_bool.concat(var[3] + ".");
                    } else {
                        simplified_bool = simplified_bool.concat("not(" + var[3] + ")");
                    }
                }
                if (trav.next != null) {
                    simplified_bool = simplified_bool.concat(" + ");
                }
            }
            if (trail != null) {
                simplified_bool = simplified_bool.concat(" + ");
            }
        }

        return simplified_bool;


    }
}
