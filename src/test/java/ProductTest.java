import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {

    Product product;

    @Before
    public void setUp() throws Exception {
        product = new Product();
    }

    @Test
    public void getType() {
        assertEquals("Gold", product.getType());
    }

    @Test
    public void setType() {
        product.setType("Bronze");
        assertNotNull(product.getType());
    }

    @Test
    public void getDiscount() {
        assertEquals(Integer.valueOf(20), product.getDiscount());
    }

    @Test
    public void setDiscount() {
        product.setDiscount(25);
        assertNotNull(product.getDiscount());
    }
}