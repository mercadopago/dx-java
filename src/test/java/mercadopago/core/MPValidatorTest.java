// package mercadopago.core;

// import com.mercadopago.core.MPValidator;
// import com.mercadopago.core.ValidationViolation;
// import com.mercadopago.exceptions.MPValidationException;
// import com.mercadopago.resources.Preference;
// import com.mercadopago.resources.datastructures.preference.Item;
// import com.mercadopago.resources.datastructures.preference.Payer;
// import org.junit.Test;

// import java.math.BigInteger;
// import java.security.SecureRandom;
// import java.util.Collection;

// import static org.junit.Assert.*;

// /**
//  * Mercado Pago MercadoPago
//  * MPValidator Test
//  *
//  * Created by Eduardo Paoletta on 11/23/16.
//  */
// public class MPValidatorTest {

//     @Test
//     public void validateNotNullError() {
//         Preference preference = new Preference();

//         MPValidationException validationException = null;
//         try {
//             MPValidator.validate(preference);
//         } catch (MPValidationException ex) {
//             validationException = ex;
//         }
//         assertSame("Exception type must be \"MPValidationException\"", MPValidationException.class, validationException.getClass());
//         Collection<ValidationViolation> colViolations = validationException.getColViolations();
//         assertNotNull(colViolations);
//         assertNotNull(colViolations.toArray()[0]);
//         assertEquals("can not be 'null'", ((ValidationViolation)colViolations.toArray()[0]).getMessage());
//         assertNotNull(colViolations.toArray()[1]);
//         assertEquals("can not be 'null'", ((ValidationViolation)colViolations.toArray()[1]).getMessage());
//     }

//     @Test
//     public void validateNotNullPass() {
//         Item item = new Item();
//         item.setQuantity(1);
//         item.setUnitPrice(.01f);

//         Payer payer = new Payer();

//         Preference preference = new Preference();
//         preference.appendItem(item);
//         preference.setPayer(payer);

//         MPValidationException validationException = null;
//         try {
//             MPValidator.validate(preference);
//         } catch (MPValidationException ex) {
//             validationException = ex;
//         }
//         assertNull(validationException);
//     }

//     @Test
//     public void validateNumericError() {
//         Item item = new Item();
//         item.setQuantity(0);
//         item.setUnitPrice(.01f);

//         Payer payer = new Payer();

//         Preference preference = new Preference();
//         preference.appendItem(item);
//         preference.setPayer(payer);

//         MPValidationException validationException = null;
//         try {
//             MPValidator.validate(preference);
//         } catch (MPValidationException ex) {
//             validationException = ex;
//         }
//         assertSame("Exception type must be \"MPValidationException\"", MPValidationException.class, validationException.getClass());
//         Collection<ValidationViolation> colViolations = validationException.getColViolations();
//         assertNotNull(colViolations);
//         assertNotNull(colViolations.toArray()[0]);
//         assertEquals("falls short of the minimum value", ((ValidationViolation)colViolations.toArray()[0]).getMessage());

//         item.setQuantity(1);
//         item.setUnitPrice(1.001f);
//         validationException = null;
//         try {
//             MPValidator.validate(preference);
//         } catch (MPValidationException ex) {
//             validationException = ex;
//         }
//         assertSame("Exception type must be \"MPValidationException\"", MPValidationException.class, validationException.getClass());
//         colViolations = validationException.getColViolations();
//         assertNotNull(colViolations);
//         assertNotNull(colViolations.toArray()[0]);
//         assertEquals("exceeds the maximum decimal digits", ((ValidationViolation)colViolations.toArray()[0]).getMessage());

//         item.setUnitPrice(1000000f);
//         validationException = null;
//         try {
//             MPValidator.validate(preference);
//         } catch (MPValidationException ex) {
//             validationException = ex;
//         }
//         assertSame("Exception type must be \"MPValidationException\"", MPValidationException.class, validationException.getClass());
//         colViolations = validationException.getColViolations();
//         assertNotNull(colViolations);
//         assertNotNull(colViolations.toArray()[0]);
//         assertEquals("exceeds the maximum value", ((ValidationViolation)colViolations.toArray()[0]).getMessage());
//     }

//     @Test
//     public void validateNumericPass() {
//         Item item = new Item();
//         item.setQuantity(1);
//         item.setUnitPrice(1f);

//         Payer payer = new Payer();

//         Preference preference = new Preference();
//         preference.appendItem(item);
//         preference.setPayer(payer);

//         MPValidationException validationException = null;
//         try {
//             MPValidator.validate(preference);
//         } catch (MPValidationException ex) {
//             validationException = ex;
//         }
//         assertNull(validationException);
//     }

//     @Test
//     public void validateSizeError() {
//         String string257 = "";
//         for (int i = 0; i < 257; i ++)
//             string257 += new BigInteger(5, new SecureRandom()).toString(32);

//         Item item = new Item();
//         item.setQuantity(1);
//         item.setUnitPrice(1f);

//         Payer payer = new Payer();

//         Preference preference = new Preference();
//         preference.appendItem(item);
//         preference.setPayer(payer);
//         preference.setExternalReference(string257);

//         MPValidationException validationException = null;
//         try {
//             MPValidator.validate(preference);
//         } catch (MPValidationException ex) {
//             validationException = ex;
//         }
//         assertSame("Exception type must be \"MPValidationException\"", MPValidationException.class, validationException.getClass());
//         Collection<ValidationViolation> colViolations = validationException.getColViolations();
//         assertNotNull(colViolations);
//         assertNotNull(colViolations.toArray()[0]);
//         assertEquals("exceed the maximum length value", ((ValidationViolation)colViolations.toArray()[0]).getMessage());

//         preference.setExternalReference(string257.substring(1));
//         item.setCurrencyId("AA");

//         validationException = null;
//         try {
//             MPValidator.validate(preference);
//         } catch (MPValidationException ex) {
//             validationException = ex;
//         }
//         assertSame("Exception type must be \"MPValidationException\"", MPValidationException.class, validationException.getClass());
//         colViolations = validationException.getColViolations();
//         assertNotNull(colViolations);
//         assertNotNull(colViolations.toArray()[0]);
//         assertEquals("fall short of the minimum length", ((ValidationViolation)colViolations.toArray()[0]).getMessage());
//     }

//     @Test
//     public void validateSizePass() {
//         String string256 = "";
//         for (int i = 0; i < 256; i ++)
//             string256 += new BigInteger(5, new SecureRandom()).toString(32);

//         Item item = new Item();
//         item.setQuantity(1);
//         item.setUnitPrice(1f);
//         item.setCurrencyId("ARS");

//         Payer payer = new Payer();

//         Preference preference = new Preference();
//         preference.appendItem(item);
//         preference.setPayer(payer);
//         preference.setExternalReference(string256);

//         MPValidationException validationException = null;
//         try {
//             MPValidator.validate(preference);
//         } catch (MPValidationException ex) {
//             validationException = ex;
//         }
//         assertNull(validationException);
//     }

// }
