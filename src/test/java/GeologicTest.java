import org.junit.Assert;
import org.junit.Test;

public class GeologicTest {
    @Test
    public void test1() {
        int[] target = { 0,2,4,3,2,1,0 };
        int points = target.length;
        Modification[] sequence = {
                new Modification(1, 3, Operation.HILL),
                new Modification(2,4,Operation.RAISE),
                new Modification(1, 5, Operation.RAISE)
        };
        Assert.assertTrue(Geological.verify(points, sequence, target));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test2() {
        int[] target = { 0,2,4,3,2,1,0 };
        int points = target.length - 1;
        Modification[] sequence = {
                new Modification(1, 3, Operation.HILL),
                new Modification(2,4,Operation.RAISE),
                new Modification(1, 5, Operation.RAISE)
        };
        Geological.verify(points, sequence, target);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test3() {
        int[] target = { 0,2,4,3,2,1,0 };
        int points = -1;
        Modification[] sequence = {
                new Modification(1, 3, Operation.HILL),
                new Modification(2,4,Operation.RAISE),
                new Modification(1, 5, Operation.RAISE)
        };
        Geological.verify(points, sequence, target);
    }

    @Test(expected = NullPointerException.class)
    public void test4() {
        int[] target = { 0,2,4,3,2,1,0 };
        int points = target.length;
        Modification[] sequence = null;
        Geological.verify(points, sequence, target);
    }

    @Test(expected = NullPointerException.class)
    public void test5() {
        int[] target = null;
        int points = 0;
        Modification[] sequence = {
                new Modification(1, 3, Operation.HILL),
                new Modification(2,4,Operation.RAISE),
                new Modification(1, 5, Operation.RAISE)
        };
        Geological.verify(points, sequence, target);
    }

    @Test(expected = NullPointerException.class)
    public void test6() {
        int[] target = null;
        int points = -1;
        Modification[] sequence = {
                new Modification(3, 1, Operation.HILL),
                new Modification(2,4,Operation.RAISE),
                new Modification(1, 5, Operation.RAISE)
        };
        Geological.verify(points, sequence, target);
    }

    @Test
    public void test7() {
        int[] target = { 1,0,2,1,0,-1,0 };
        int points = target.length;
        Modification[] sequence = {
                new Modification(1, 3, Operation.HILL),
                new Modification(2,4,Operation.RAISE),
                new Modification(1, 5, Operation.DEPRESS),
                new Modification(2, 3, Operation.VALLEY),
                new Modification(2, 4, Operation.VALLEY),
                new Modification(2, 4, Operation.HILL),
                new Modification(2, 5, Operation.HILL),
        };
        Assert.assertFalse(Geological.verify(points, sequence, target));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test8() {
        int[] target = { 0,2,4,3,2,1,0 };
        int points = target.length;
        Modification[] sequence = {
                new Modification(-1, 3, Operation.HILL),
                new Modification(2,4,Operation.RAISE),
                new Modification(1, 5, Operation.RAISE)
        };
        Assert.assertTrue(Geological.verify(points, sequence, target));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test9() {
        int[] target = { 0,2,4,3,2,1,0 };
        int points = target.length;
        Modification[] sequence = {
                new Modification(3, 3, Operation.HILL),
                new Modification(2,4,Operation.RAISE),
                new Modification(1, 5, Operation.RAISE)
        };
        Assert.assertTrue(Geological.verify(points, sequence, target));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test10() {
        int[] target = { 0,2,4,3,2,1,0 };
        int points = target.length;
        Modification[] sequence = {
                new Modification(1, 3, Operation.HILL),
                new Modification(2,4,Operation.RAISE),
                null,
                new Modification(1, 5, Operation.RAISE)
        };
        Assert.assertTrue(Geological.verify(points, sequence, target));
    }
}
