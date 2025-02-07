package math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.lwjgl.openvr.VREventWebConsole;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Vector4fTest {
    Vector4f v1;
    Vector4f v2;

    @BeforeEach
    void init() {
        v1 = new Vector4f(2, 2, 2, 2);
        v2 = new Vector4f(3, 3, 3, 3);
    }

    @Test
    void testConstructor() {
        assertEquals(new Vector4f(0, 0, 0, 0), new Vector4f());
    }

    @Test
    void testStaticNormalize() {
        Vector4f testNormalizedVector = new Vector4f(0.5f, 0.5f, 0.5f, 0.5f);
        assertEquals(testNormalizedVector, Vector4f.normalize(v1));
    }

    @Test
    void testNonStaticAddition() {
        Vector4f addedVectors = new Vector4f(5, 5, 5, 5);
        v1.add(v2);
        assertEquals(addedVectors, v1);
    }

    @Test
    void testStaticAddition() {
        Vector4f addedVectors = new Vector4f(5, 5, 5, 5);
        assertEquals(addedVectors, Vector4f.add(v1, v2));
    }

    @Test
    void testNonStaticMul() {
        Vector4f secondVecDoubled = new Vector4f(6, 6, 6, 6);
        v2.mul(2);
        assertEquals(secondVecDoubled, v2);
    }

    @Test
    void testStaticMul() {
        Vector4f secondVecDoubled = new Vector4f(6, 6, 6, 6);
        assertEquals(secondVecDoubled, Vector4f.mul(v2, 2));
    }

    @Test
    void testDot() {
        float dotProduct = 24;
        assertEquals(dotProduct, Vector4f.dot(v1, v2));
    }

    @Test
    void testNonStaticSub() {
        Vector4f subtractedVectors = new Vector4f(1, 1, 1, 1);
        v2.sub(v1);
        assertEquals(subtractedVectors, v2);
    }

    @Test
    void testStaticSub() {
        Vector4f subtractedVectors = new Vector4f(-1, -1, -1, -1);
        assertEquals(subtractedVectors, Vector4f.sub(v1, v2));
    }

    @Test
    void testNonStaticDiv() {
        Vector4f firstVecHalved = new Vector4f(0.5f, 0.5f, 0.5f, 0.5f);
        v1.div(4);
        assertEquals(firstVecHalved, v1);
    }

    @Test
    void testStaticDiv() {
        Vector4f firstVecHalved = new Vector4f(0.5f, 0.5f, 0.5f, 0.5f);
        assertEquals(firstVecHalved, Vector4f.div(v1, 4));
    }

    @Test
    void testScale() {
        Vector4f firstVecScaled = new Vector4f(4, 6, 8, 10);
        assertEquals(firstVecScaled, Vector4f.scale(v1, new Vector4f(2, 3, 4, 5)));
    }

    @Test
    void testDistance() {
        assertEquals(2, Vector4f.distance(v1, v2));
    }

    @Test
    void testLerp() {
        Vector4f lerpTestVector = new Vector4f(2.5f, 2.5f, 2.5f, 2.5f);
        assertEquals(lerpTestVector, Vector4f.lerp(v2, v1, 0.5f));
    }

    @Test
    void testProject() {
        assertEquals(v1, Vector4f.project(v1, v2));
    }

    @Test
    void testNonStaticNormalize() {
        Vector4f normalizeTestVector = new Vector4f(0.5f, 0.5f, 0.5f, 0.5f);
        v1.normalize();
        assertEquals(normalizeTestVector, v1);
    }

    @Test
    void testNegate() {
        Vector4f negateTestVector = new Vector4f(-2, -2, -2, -2);
        v1.negate();
        assertEquals(negateTestVector, v1);
    }

    @Test
    void testTranslateOne() {
        Vector4f translateTestVector = new Vector4f(2.5f, 3f, 4f, 5f);
        v1.translate(new Vector4f(0.5f, 1f, 2f, 3f));
        assertEquals(translateTestVector, v1);
    }

    @Test
    void testTranslateTwo() {
        Vector4f translateTestVector = new Vector4f(2.5f, 3f, 4f, 5f);
        v1.translate(0.5f, 1f, 2f, 3f);
        assertEquals(translateTestVector, v1);
    }

    @Test
    void testCoordinateArray() {
        float[] testArray = new float[]{2, 2, 2, 2};
        assertArrayEquals(testArray, v1.coordinateArray());
    }

    @Test
    void testZero() {
        assertEquals(new Vector4f(0, 0, 0, 0), Vector4f.zero());
    }

    @Test
    void testOne() {
        assertEquals(new Vector4f(1, 1, 1, 1), Vector4f.one());
    }

}
