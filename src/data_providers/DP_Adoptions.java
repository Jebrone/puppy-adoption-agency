package data_providers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.google.common.collect.ImmutableMap;

public class DP_Adoptions {

    public static final String TEST_NAME_SINGLE_ADOPTION = "Adopt a Puppy";
    public static final String TEST_NAME_DOUBLE_ADOPTION = "Adopt 2 Puppies";
    public static final String TEST_NAME_DOUBLE_ADOPTION_WITH_ACCESSORIES = "Adopt 2 Puppies with Accessories";

    public static final List<Map<String, Object>> puppies = Arrays.asList(
            ImmutableMap.<String, Object>builder()
                .put("Name", "Brook")
                .put("Breed", "Golden Retriever")
                .put("Gender", "Female")
                .put("Adoption Fee", 34.95)
                .put("ID", 4)
                .build(),
            ImmutableMap.<String, Object>builder()
                .put("Name", "Hanna")
                .put("Breed", "Labrador Retriever Mix")
                .put("Gender", "Female")
                .put("Adoption Fee", 22.99)
                .put("ID", 3)
                .build(),
            ImmutableMap.<String, Object>builder()
                .put("Name", "Maggie Mae")
                .put("Breed", "Border Colie Mix")
                .put("Gender", "Female")
                .put("Adoption Fee", 14.95)
                .put("ID", 1)
                .build(),
            ImmutableMap.<String, Object>builder()
                .put("Name", "Ruby Sue")
                .put("Breed", "Pit Bull Terrier")
                .put("Gender", "Female")
                .put("Adoption Fee", 52.50)
                .put("ID", 8)
                .build(),
            ImmutableMap.<String, Object>builder()
                .put("Name", "Sparky")
                .put("Breed", "Austrailian Cattle Dog (Blue Heeler)")
                .put("Gender", "Male")
                .put("Adoption Fee", 79.99)
                .put("ID", 9)
                .build(),
            ImmutableMap.<String, Object>builder()
                .put("Name", "Spud")
                .put("Breed", "Beagle/Hound Mix")
                .put("Gender", "Male")
                .put("Adoption Fee", 18.75)
                .put("ID", 2)
                .build(),
            ImmutableMap.<String, Object>builder()
                .put("Name", "Tipsy")
                .put("Breed", "Terrier Mix")
                .put("Gender", "Female")
                .put("Adoption Fee", 42.00)
                .put("ID", 6)
                .build(),
            ImmutableMap.<String, Object>builder()
                .put("Name", "Topsy")
                .put("Breed", "Terrier Mix")
                .put("Gender", "Female")
                .put("Adoption Fee", 42.00)
                .put("ID", 5)
                .build(),
            ImmutableMap.<String, Object>builder()
                .put("Name", "Twinkie")
                .put("Breed", "Boxer/Rat Terrier Mix")
                .put("Gender", "Female")
                .put("Adoption Fee", 22.50)
                .put("ID", 7)
                .build()
            );
    public static final Map<String, String> testPerson = ImmutableMap.<String, String>builder()
            .put("Name", "Tester")
            .put("Address", "123 Fake Address Ave")
            .put("Email", "adoption@email.qa")
            .build();
    
    @DataProvider(name = TEST_NAME_SINGLE_ADOPTION)
    public Object[][] dp_AdoptAPuppy() {
        Object[][] testData = new Object[][] {
            {puppies.get(0), testPerson, "Check"}
        };

        return testData;
    }
    
    @DataProvider(name = TEST_NAME_DOUBLE_ADOPTION)
    public Object[][] dp_AdoptTwoPuppies() {
        Object[][] testData = new Object[][] {
            {puppies.get(0), puppies.get(1), testPerson, "Credit card"}
        };

        return testData;
    }
    
    @DataProvider(name = TEST_NAME_DOUBLE_ADOPTION_WITH_ACCESSORIES)
    public Object[][] dp_AdoptTwoPuppiesWithAccessories() {
        List<Map<String, Object>> puppyList = puppies;
        Collections.shuffle(puppyList);
        
        Object[][] testData = new Object[][] {
            {puppyList.get(0), puppyList.get(1), testPerson, "Purchase order"}
        };

        return testData;
    }

}
