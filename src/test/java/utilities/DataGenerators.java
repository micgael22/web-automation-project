package utilities;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataGenerators {
    public String firstName;
    public String lastName;
    public String description;
    public String currentFirstName;
    public String currentLastName;
    public String currentDescription;
    public String currentEmail;
    private final Faker faker;
    private final FakeValuesService fakeValuesService;
    public static String currentCellNumber;
    public static String storeGeneratedFirstName;
    public static String storeGeneratedLastName;
    public static String storeGeneratedEmail;
    public static String storeGeneratedDescription;

    public DataGenerators() {
        fakeValuesService = new FakeValuesService(new Locale("en-NG"), new RandomService());
        faker = new Faker(new Locale("en-NG"));
    }

    // DATA GENERATORS USING -FAKER
    public String GenerateRequiredData(String dataTypeRequired) {
        String dataRequired = null;

        switch (dataTypeRequired.toUpperCase()) {
            case "GENERATED DESCRIPTION":
                description = "Lorem Ipsum Generated Automated Text.";
                dataRequired = description;
                currentDescription = dataRequired;
                storeGeneratedDescription = currentDescription;
                break;
            case "GENERATED NAME":
                firstName = faker.name().firstName();
                dataRequired = firstName;
                currentFirstName =  dataRequired;
                storeGeneratedFirstName = currentFirstName;
                break;
            case "GENERATED LAST NAME":
                lastName = faker.name().lastName();
                dataRequired = lastName;
                currentLastName =  dataRequired;
                storeGeneratedLastName = currentLastName;
                break;
            case "GENERATED EMAIL":
                firstName = faker.name().firstName();
                currentFirstName = firstName;
                dataRequired = firstName.toLowerCase() + faker.number().digits(5) + "@gmail.com".toLowerCase();
                currentEmail = dataRequired;
                storeGeneratedEmail = currentEmail;
                break;
            case "GENERATED CELL NUMBER":
                dataRequired = GenerateCellNumber(true);
                currentCellNumber = dataRequired;
                break;
        }
        return dataRequired;
    }

    // CELL NUMBER GENERATOR
    private String GenerateCellNumber(Boolean valid) {
        String CellNumber;
        if (valid) {
            while (true) {
                CellNumber = fakeValuesService.regexify("(0)[156789][0-9]{8}");
                Pattern pattern = Pattern.compile("(0)[156789][0-9]{8}");
                Matcher matcher = pattern.matcher(CellNumber);
                if (matcher.matches()) {
                    break;
                }
            }
            return CellNumber;
        } 
        else {
            while (true) {
                CellNumber = fakeValuesService.bothify("##############");
                Pattern pattern = Pattern.compile("(0)[156789][0-9]{9}");
                Matcher matcher = pattern.matcher(CellNumber);
                if (!matcher.matches()) {
                    break;
                }
            }
            return CellNumber;
        }
    }

}
