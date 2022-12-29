package stepDefinitions.files;

public class payLoad {

    public static String AddPlace(){
        return "{\"location\": \n" +
                "{\n" +
                "\t\"lat\": -38.383494,\n" +
                "\t\"lng\": 33.427362\n" +
                "\t },\n" +
                "\t \"accuracy\": 50,\n" +
                "\t \"name\": \"Rahul Shetty Academy\",\n" +
                "\t \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "\t \"address\": \"29, side layout, cohen 09\",\n" +
                "\t \"types\": \n" +
                "\t [\n" +
                "\t \t\"shoe park\",\n" +
                "\t \t\"shop\"\n" +
                "\t ],\n" +
                "\t\t\t\t\"website\": \"http://rahulshettyacademy.com\", \n" +
                "\t\t\t\t\"language\": \"French-IN\"\n" +
                "\t\t\t}";
    }
}
