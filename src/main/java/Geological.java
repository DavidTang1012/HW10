import java.util.Arrays;

public class Geological {
    private int[] heights;

    public Geological(int n)throws IllegalArgumentException {
        heights = new int[n];
    }

    // verify algorithm
    public static boolean verify(int points, Modification[] sequence, int[] target) {
        // verify parameters
        validParameters(points, sequence, target);
        Geological geological = new Geological(points);
        for (Modification modification : sequence) {
            geological.modifyLandscape(modification);
        }
        return Arrays.equals(geological.heights, target);
    }

    public static void validParameters(int points, Modification[] sequence, int[] target) {
        if (sequence == null) {
            throw new NullPointerException("sequence list must be not null");
        }
        if (target == null) {
            throw new NullPointerException("integer list must be not null");
        }
        if (points <= 0) {
            throw new IllegalArgumentException("points must be greater than 0");
        }
        if (target.length != points) {
            throw new IllegalArgumentException("integer list length and points must be equal");
        }
    }

    public void modifyLandscape(Modification modification) {
        if (modification == null) {
            throw new IllegalArgumentException("Modification must be not null");
        }
        if (modification.x1() >= modification.x2()) {
            throw new IllegalArgumentException("illegal x1 must be less than x2");
        }
        if (modification.x1() < 0 || modification.x2() >= heights.length) {
            throw new IllegalArgumentException("illegal x1 and x2 must be range 0 to heights length");
        }
        switch (modification.operation()) {
            case RAISE -> raise(modification.x1(), modification.x2());
            case DEPRESS -> depress(modification.x1(), modification.x2());
            case HILL -> hill(modification.x1(), modification.x2());
            case VALLEY -> valley(modification.x1(), modification.x2());
            default -> throw new IllegalArgumentException("Invalid operation");
        }
    }

    private void raise(int x1, int x2) {
        for (int i = x1; i <= x2; i++) {
            heights[i]++;
        }
    }

    private void depress(int x1, int x2) {
        for (int i = x1; i <= x2; i++) {
            heights[i]--;
        }
    }

    public int[] getHeights() {
        return heights;
    }

    private void hill(int x1, int x2) {
        int width = x2 - x1;
        heights[x1]++;
        heights[x2]++;
        if (width > 1) {
            for (int i = 1; i <= width / 2; i++) {
                int h = i * 2;
                heights[x1 + i]++;
                heights[x2 - i]++;
                if (width % 2 == 0 && i == width / 2) {
                    break;
                }
                heights[x1 + i + 1] += h;
                heights[x2 - i - 1] += h;
            }
        }
    }

    private void valley(int x1, int x2) {
        heights[x1]--;
        heights[x2]--;
        int width = x2 - x1;
        if (width > 1) {
            for (int i = 1; i <= width / 2; i++) {
                int h = i * 2;
                heights[x1 + i] -= h;
                heights[x2 - i] -= h;
                if (width % 2 == 0 && i == width / 2) {
                    break;
                }
                heights[x1 + i + 1]--;
                heights[x2 - i - 1]--;
            }
        }
    }

    public void GeologicalFormation(int size) {
        heights = new int[size];
    }
}
