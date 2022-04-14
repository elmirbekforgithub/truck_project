package pubg;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String data = new String(Files.readAllBytes(Paths.get("cars.json")));
        JSONArray jsonArray = new JSONArray(data);
        Auto[] autos = new Auto[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            autos[i] = new Auto();
            String str = jsonArray.get(i).toString();
            JSONObject object = new JSONObject(str);
            autos[i].setId(object.getInt("id"));
            autos[i].setAutoName(object.getString("name"));
            autos[i].setDriver(object.getString("driver"));
            autos[i].setState(State.BASE);
        }

        String driverData = new String(Files.readAllBytes(Paths.get("driver.json")));
        JSONArray json = new JSONArray(driverData);
        Driver[] drivers = new Driver[json.length()];
        for (int i = 0; i < drivers.length; i++) {
            drivers[i] = new Driver();
            String str = json.get(i).toString();
            JSONObject object = new JSONObject(str);
            drivers[i].setId(object.getInt("id"));
            drivers[i].setName(object.getString("name"));
        }

        Auto.print(autos);
        while (true) {
            System.out.println("choose one of the truck");
            int choice = scanner.nextInt();
            scanner.nextLine();
            Auto.getInfo(autos[choice -1]);
            Auto.injection();
            String action = scanner.nextLine();
            Auto.action(action,autos[choice -1],drivers);
            Auto.print(autos);
            Driver.print(drivers);
        }
    }

    }

