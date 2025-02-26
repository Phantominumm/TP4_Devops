package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import datastruct.UnsortedList;
import datastruct.EmptyListException;
import datastruct.MyUnsortedList;

public class MyUnsortedListTest {
    // Tests pour les entiers
    @Test
    public void testIsEmptyNoElement() {
        UnsortedList<Integer> list = MyUnsortedList.of();
        assertEquals("isEmpty() doit retourner true si la liste est vide", true, list.isEmpty());
    }

    @Test
    public void testIsEmptyOneElement() {
        UnsortedList<Integer> list = MyUnsortedList.of(1);
        assertEquals("isEmpty() doit retourner false si la liste contient un élément", false, list.isEmpty());
    }

    @Test
    public void testSizeNoElement() {
        UnsortedList<Integer> list = MyUnsortedList.of();
        assertEquals("size() doit retourner 0 si la liste est vide", 0, list.size());
    }

    @Test
    public void testSizeOneElement() {
        UnsortedList<Integer> list = MyUnsortedList.of(1);
        assertEquals("size() doit retourner 1 si la liste contient un élément", 1, list.size());
    }

    @Test
    public void testIsEmptyMultipleElements() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
        assertEquals("isEmpty() doit retourner false si la liste contient des éléments", false, list.isEmpty());
    }

    @Test
    public void testSizeMultipleElements() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
        assertEquals("size() doit retourner 5 si la liste contient 5 éléments", 5, list.size());
    }

    @Test
    public void testPrependSize() {
        UnsortedList<Integer> list = MyUnsortedList.of(2, 3, 4, 5);
        list.prepend(1);
        assertEquals("size() doit retourner 5 après un prepend(1)", 5, list.size());
    }

    @Test
    public void testPrependContent() {
        UnsortedList<Integer> list = MyUnsortedList.of(2, 3, 4, 5);
        list.prepend(1);
        assertEquals("prepend() doit ajouter un élément en tête de liste", list, MyUnsortedList.of(1, 2, 3, 4, 5));
    }

    @Test
    public void testMultiplePrependSize() {
        UnsortedList<Integer> list = MyUnsortedList.of(2, 3, 4, 5);
        list.prepend(1);
        list.prepend(0);
        assertEquals("size() doit retourner 6 après deux prepend", 6, list.size());
    }

    @Test
    public void testMultiplePrependContent() {
        UnsortedList<Integer> list = MyUnsortedList.of(2, 3, 4, 5);
        list.prepend(1);
        list.prepend(0);
        assertEquals("prepend() doit ajouter les éléments en tête de liste", list, MyUnsortedList.of(0, 1, 2, 3, 4, 5));
    }

    @Test
    public void testAppendSize() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4);
        list.append(5);
        assertEquals("size() doit retourner 5 après un append(5)", 5, list.size());
    }

    @Test
    public void testAppendContent() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4);
        list.append(5);
        assertEquals("append() doit ajouter un élément en fin de liste", list, MyUnsortedList.of(1, 2, 3, 4, 5));
    }

    @Test
    public void testAppendEmptyListSize() {
        UnsortedList<Integer> list = MyUnsortedList.of();
        list.append(1);
        assertEquals("size() doit retourner 1 après un append sur une liste vide", 1, list.size());
    }


    @Test
    public void testMultipleAppendSize() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4);
        list.append(5);
        list.append(6);
        assertEquals("size() doit retourner 6 après deux append", 6, list.size());
    }

    @Test
    public void testMultipleAppendContent() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4);
        list.append(5);
        list.append(6);
        assertEquals("append() doit ajouter les éléments en fin de liste", list, MyUnsortedList.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void testInsertMiddleSize() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 4, 5);
        list.insert(3, 2);
        assertEquals("size() doit retourner 5 après un insert au milieu", 5, list.size());
    }

    @Test
    public void testInsertMiddleContent() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 4, 5);
        list.insert(3, 2);
        assertEquals("insert() doit ajouter un élément à la position donnée", list, MyUnsortedList.of(1, 2, 3, 4, 5));
    }

    @Test
    public void testInsertStartSize() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
        list.insert(0, 0);
        assertEquals("size() doit retourner 6 après un insert au début", 6, list.size());
    }

    @Test
    public void testInsertStartContent() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
        list.insert(0, 0);
        assertEquals("insert() doit ajouter un élément au début", list, MyUnsortedList.of(0, 1, 2, 3, 4, 5));
    }

    @Test
    public void testInsertEndSize() {
        UnsortedList<Integer> list = MyUnsortedList.of(0, 1, 2, 3, 4, 5);
        list.insert(6, 6);
        assertEquals("size() doit retourner 7 après un insert à la fin", 7, list.size());
    }

    @Test
    public void testInsertEndContent() {
        UnsortedList<Integer> list = MyUnsortedList.of(0, 1, 2, 3, 4, 5);
        list.insert(6, 6);
        assertEquals("insert() doit ajouter un élément à la fin", list, MyUnsortedList.of(0, 1, 2, 3, 4, 5, 6));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertNegativePosition() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
        list.insert(0, -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertPositionTooLarge() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
        list.insert(0, 6);
    }

    @Test
    public void testPopReturnValue() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
        int popped = list.pop();
        assertEquals("pop() doit retourner le premier élément de la liste", 1, popped);
    }

    @Test
    public void testPopSize() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
        list.pop();
        assertEquals("size() doit retourner 4 après un pop()", 4, list.size());
    }

    @Test
    public void testPopContent() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
        list.pop();
        assertEquals("pop() doit retirer le premier élément de la liste", list, MyUnsortedList.of(2, 3, 4, 5));
    }

    @Test
    public void testPopLastReturnValue() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
        int popped = list.popLast();
        assertEquals("popLast() doit retourner le dernier élément de la liste", 5, popped);
    }

    @Test
    public void testPopLastSize() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
        list.popLast();
        assertEquals("size() doit retourner 4 après un popLast()", 4, list.size()); // Bug trouvé ici -> 5 au lieu de 4, le size n'était pas mis à jour avec la fonction remove()
    }

    @Test
    public void testPopLastContent() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
        list.popLast();
        assertEquals("popLast() doit retirer le dernier élément de la liste", list, MyUnsortedList.of(1, 2, 3, 4));
    }

    @Test(expected = EmptyListException.class)
    public void testPopEmptyList() {
        UnsortedList<Integer> list = MyUnsortedList.of();
        list.pop();
    }

    @Test(expected = EmptyListException.class)
    public void testPopLastEmptyList() {
        UnsortedList<Integer> list = MyUnsortedList.of();
        list.popLast(); // Bug trouvé ici, génère une exception IndexOutOfBoundsException au lieu de EmptyListException
    }

    @Test
    public void testRemoveSize() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
        list.remove(2);
        assertEquals("size() doit retourner 4 après un remove()", 4, list.size());
    }

    @Test
    public void testRemoveContent() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
        list.remove(2);
        assertEquals("remove() doit retirer l'élément à la position donnée", list, MyUnsortedList.of(1, 2, 4, 5));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveNegativePosition() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
        list.remove(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemovePositionTooLarge() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
        list.remove(5);
    }

    @Test
    public void testRemoveFirstSize() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
        list.remove(0);
        assertEquals("size() doit retourner 4 après un remove(0)", 4, list.size());
    }

    @Test
    public void testRemoveFirstContent() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
        list.remove(0);
        assertEquals("remove() doit retirer le premier élément de la liste", list, MyUnsortedList.of(2, 3, 4, 5));
    }

    @Test
    public void testRemoveLastSize() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
        list.remove(4);
        assertEquals("size() doit retourner 4 après un remove(4)", 4, list.size());
    }

    @Test
    public void testRemoveLastContent() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
        list.remove(4);
        assertEquals("remove() doit retirer le dernier élément de la liste", list, MyUnsortedList.of(1, 2, 3, 4));
    }

    @Test
    public void testRemoveAllSize() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
        list.remove(0);
        list.remove(0);
        list.remove(0);
        list.remove(0);
        list.remove(0);
        assertEquals("size() doit retourner 0 après 5 remove()", 0, list.size());
    }

    @Test
    public void testRemoveAllContent() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
        list.remove(0);
        list.remove(0);
        list.remove(0);
        list.remove(0);
        list.remove(0);
        assertEquals("remove() doit retirer tous les éléments de la liste", list, MyUnsortedList.of());
    }

    @Test
    public void testRemoveConsecutiveElements() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
        list.remove(2);
        list.remove(2);
        assertEquals("remove() consécutifs doivent retirer les bons éléments", MyUnsortedList.of(1, 2, 5), list);
    }

    @Test
    public void testRemoveConsecutiveSize() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
        list.remove(2);
        list.remove(2);
        assertEquals("size() doit retourner 3 après deux remove consécutifs", 3, list.size());
    }

    @Test
    public void testToStringEmptyList() {
        UnsortedList<Integer> list = MyUnsortedList.of();
        assertEquals("toString() doit retourner [] pour une liste vide", "MyUnsortedList { size = 0, [] }", list.toString());
    }

    @Test
    public void testToStringOneElement() {
        UnsortedList<Integer> list = MyUnsortedList.of(1);
        assertEquals("toString() doit retourner [1] pour une liste contenant 1", "MyUnsortedList { size = 1, [1] }", list.toString());
    }

    @Test
    public void testToStringMultipleElements() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
        assertEquals("toString() doit retourner [1, 2, 3, 4, 5] pour une liste de 5 éléments", "MyUnsortedList { size = 5, [1, 2, 3, 4, 5] }", list.toString());
    }

    // Test pour des Objets
    @Test
    public void testListOfListOfStrings() {
        UnsortedList<UnsortedList<String>> list2 = MyUnsortedList.of(MyUnsortedList.of("a", "b"), MyUnsortedList.of("c", "d", "e"));
        assertEquals("size() doit retourner 2 pour une liste de listes de strings", 2, list2.size());
    }

    @Test
    public void testListOfListOfIntegers() {
        UnsortedList<UnsortedList<Integer>> list2 = MyUnsortedList.of(MyUnsortedList.of(1, 2), MyUnsortedList.of(3, 4, 5));
        assertEquals("size() doit retourner 2 pour une liste de listes d'entiers", 2, list2.size());
    }

    @Test
    public void testRemoveFirstElementFromListOfLists() {
        UnsortedList<UnsortedList<String>> list2 = MyUnsortedList.of(MyUnsortedList.of("a", "b"), MyUnsortedList.of("c", "d", "e"));
        list2.remove(0);
        assertEquals("remove() doit retirer le premier élément de la liste de listes de strings", list2, MyUnsortedList.of(MyUnsortedList.of("c", "d", "e")));
    }

    @Test
    public void testEqualsSameInstance() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
        assertEquals("equals() doit retourner true pour la même instance", true, list.equals(list));
    }

    @SuppressWarnings("unlikely-arg-type")
	@Test
    public void testEqualsIntAndList() {
        UnsortedList<Integer> list = MyUnsortedList.of(1, 2, 3, 4, 5);
        assertEquals("equals() doit retourner false pour une liste et un entier", false, list.equals(1));
    }

    @Test
    public void testEqualsDifferentSize() {
        UnsortedList<Integer> list1 = MyUnsortedList.of(1, 2, 3, 4, 5);
        UnsortedList<Integer> list2 = MyUnsortedList.of(1, 2, 3, 4, 5);
        assertEquals("equals() doit retourner false pour des listes de tailles différentes", false, list1.equals(list2));
    }

    @Test
    public void testEqualsDifferentSize2() {
        UnsortedList<Integer> list1 = MyUnsortedList.of(1, 2, 3, 4);
        UnsortedList<Integer> list2 = MyUnsortedList.of(1, 2, 3, 4, 5);
        assertEquals("equals() doit retourner false pour des listes de tailles différentes", false, list1.equals(list2));
    }

    @Test
    public void testEqualsDifferentElementsWithSameSize() {
        UnsortedList<Integer> list1 = MyUnsortedList.of(1, 2, 3);
        UnsortedList<Integer> list2 = MyUnsortedList.of(1, 2, 4);  // Même taille mais dernier élément différent
        
        assertEquals("equals() doit retourner false pour des listes de même taille mais avec des éléments différents", false, list1.equals(list2));
    }

    @Test
    public void testEqualsWithEmptyList() {
        UnsortedList<Integer> list1 = MyUnsortedList.of(1, 2, 3);
        UnsortedList<Integer> list2 = MyUnsortedList.of();
        
        assertEquals("equals() doit retourner false pour des listes de même taille mais avec des éléments différents", false, list1.equals(list2));
    }

    @Test
    public void testEqualsWithSameValuesButNull() {
        UnsortedList<String> list1 = MyUnsortedList.of("a", "b", null, "d");
        UnsortedList<String> list2 = MyUnsortedList.of("a", "b", null, "d");
        
        assertEquals("equals() doit retourner true pour deux listes avec les mêmes valeurs incluant null", true, list1.equals(list2)); // Bug ici en cas d'élément null qui provoque une exception
    }

    @Test
    public void testEqualsWithDifferentNullPositions() {
        UnsortedList<String> list1 = MyUnsortedList.of("a", null, "c");
        UnsortedList<String> list2 = MyUnsortedList.of("a", "b", null);
        
        assertEquals("equals() doit retourner false pour deux listes avec null à différentes positions", false, list1.equals(list2)); // Bug ici en cas d'élément null qui provoque une exception
    }

    @Test
    public void testEqualsWithNull() {
        UnsortedList<String> list1 = MyUnsortedList.of("a", "b", "c");

        assertEquals("equals() doit retourner false pour des listes de tailles différentes avec null", false, list1.equals(null));
    }
}
