package cs208;

import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class PracticeController
{
    // http://localhost:8080/display_name?first_name=<yourFirstName>&last_name=<yourLastName>
   @GetMapping("/display_name")
    public String getTwoParameters(
            @RequestParam("first_name") String parameter1,
            @RequestParam("last_name") String parameter2) {
        System.out.println("PracticeController.getTwoParameters - START");
        System.out.println("parameter1 sent in the browser URL = " + parameter1);
        System.out.println("parameter2 sent in the browser URL = " + parameter2);
        System.out.println("PracticeController.getTwoParameters - END");
        String valueReturnedToBrowser =
                parameter1 + " " + parameter2 +"<br>";

        return valueReturnedToBrowser;
    }


    @GetMapping("/user/{username}/profile")
    String getUsernameWithPathname(@PathVariable("username") String username)
    {

        System.out.println("Parameter received in the path of the URL:");
        System.out.println("Username = " + username);


        String valueReturnedToBrowser =
                        "Username = " + username + "<br>";

        return valueReturnedToBrowser;
    }


    @PostMapping("/create_user")
    String postNewUser(
            @RequestParam("first_name") String firstName,
            @RequestParam("last_name") String lastName
    )
    {

        System.out.println("Parameters received in the body of the POST request:");
        System.out.println("title       = " + firstName);
        System.out.println("description = " + lastName);


        String valueReturnedToClient =

                        "First name = " + firstName + "\n" +
                        "Last name = " + lastName;


        return valueReturnedToClient;
    }



    @PatchMapping("/user/{username}/update_profile")
    String patch(
            @PathVariable("username") String username,
            @RequestParam("theme") String theme,
            @RequestParam("language_code") String code
    )
    {

        System.out.println("Username = " + username);
        System.out.println("Theme = " + theme);
        System.out.println("Code    = " + code);


        String valueReturnedToClient =
                        "Username = " + username + "\n" +
                        "Theme = " + theme + "\n" +

                        "Code    = " + code;

        return valueReturnedToClient;
    }


    @DeleteMapping("/resource/{resource_id}")
    String deleteID(@PathVariable("resource_id") String resourceId,
                  @RequestParam("authentication_token") String token)

    {

        System.out.println("Parameter received in the path of the URL:");
        System.out.println("resource_id = " + resourceId);



        String valueReturnedToClient =

                        "resource_id = " + resourceId + " " +
                                "has been deleted";


        return valueReturnedToClient;
    }


    @GetMapping("/api/random_item")
    String getAPI() {
        String[] array = {"banana" , "stick", "shoe", "basketball", "water bottle"};
        Random random = new Random();
        int index = random.nextInt(array.length);
        return array[index];
}

}
