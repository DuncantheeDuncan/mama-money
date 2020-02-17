package node;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Processor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintTree list = new PrintTree();// temp memory
//        PrintTreeUsingJDBC list = new PrintTreeUsingJDBC(); database

        System.out.print("number of nodes you want to add: ");
        int count = sc.nextInt();
        int id, parentId;
//        String lable = " ";


        for (int i = 0; i < count; i++) {

            System.out.println("please enter the id of the node");
            id = sc.nextInt();
            System.out.println("please enter the parent id of the node");
            parentId = sc.nextInt();

            sc.nextLine();// https://stackoverflow.com/a/13102066/669576
            System.out.println("please enter the label of the node");
            String label = sc.nextLine();

            list.addData(id, label, parentId);
        }

        list.printValues();// recorded data
//        System.out.println(list.getRootNodes());


        PrintTree pp = new PrintTree();
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("nodesfile.json"))
        {

            Object obj = jsonParser.parse(reader);

            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList + " short");

            employeeList.forEach( emp -> {
                pp.readNodes((JSONObject) emp);
            });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
