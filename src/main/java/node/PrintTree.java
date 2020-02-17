package node;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.util.*;

public class PrintTree implements Switcher {

    static class Node {
        private int id;
        private int parentId;
        private String label;

        public Node(int id, String label, int parentId) {
            this.id = id;
            this.parentId = parentId;
            this.label = label;
        }

    }

    private ArrayList<Node> list = new ArrayList<>();
    private Map<Integer, Node> forID = new HashMap<>();
    private ListMultimap<Integer, String> forParent = ArrayListMultimap.create();


    public String addData(int id, String label, int parentId) {
        if (!forID.containsKey(id)) {
            if (!forParent.containsKey(0)) {
                parentId = 0;
                forID.put(id, (new Node(id, label, parentId)));
                forParent.put(parentId, ((id + ":" + label + ":" + parentId)));
                list.add(new Node(id, label, parentId));

                return "Parent ID has been set to zero. Root-level=0\n" + id + " " + label + " " + parentId;
            }
            forID.put(id, (new Node(id, label, parentId)));
            forParent.put(parentId, ((id + ":" + label + ":" + parentId)));
            list.add(new Node(id, label, parentId));
        } else {
            return id + " is a duplicate of ID, please enter again";
        }
        return id + " " + label + " " + parentId;
    }


    public int getNodeSize() {
        return list.size();
    }

    public void printValues() {
        for (int i = 0; i < list.size(); i++) {
            Node populate = list.get(i);

            System.out.println(populate.id + " " + populate.label + " " + populate.parentId);

        }

    }

@Override
    public String linkingNodes() {

        List<String> childnodes = null;
        int keyId = 0;
        for (Integer key : forParent.keySet()) {
            childnodes = forParent.get(key);
            keyId = key;
        }
        return "Node ID - " + keyId + ": child nodes - " + childnodes;
    }


    public String WriteToJSon() throws Exception {

        int nodeID = 0;
        int parentID = 0;
        String nodeLable = null;
        String fullNodeDetails = null;
        String[] splitNodes = null;


        JSONArray nodesList = new JSONArray();
        JSONObject nodesObject = null;
        for (Map.Entry<Integer, String> json : forParent.entries()) {
            JSONObject nodesDetails = new JSONObject();
            nodesObject = new JSONObject();


            fullNodeDetails = json.getValue();
            splitNodes = fullNodeDetails.split(":");
            nodeID = Integer.parseInt(splitNodes[0]);
            nodeLable = splitNodes[1];
            parentID = Integer.parseInt(splitNodes[2]);

            nodesDetails.put("Node ID", nodeID);
            nodesDetails.put("Lable", nodeLable);
            nodesDetails.put("Parent ID", parentID);
            JSONArray childNodes = new JSONArray();


            for (Integer key : forID.keySet()) {//bug
                if (key.equals(forParent.get(parentID))) {
                    childNodes.add(nodeID);
                    childNodes.add(nodeLable);
                    childNodes.add(parentID);
                }
            }


            nodesDetails.put("child-node", childNodes);


            nodesObject.put("nodes", nodesDetails);

            nodesList.add(nodesObject);

            FileWriter file = new FileWriter("nodesfile.json");

            file.write(nodesList.toJSONString());
            file.flush();
        }

        return String.valueOf(nodesObject);
    }

    public void readNodes(JSONObject node) {

        JSONObject nodesObject = (JSONObject) node.get("nodes");


        String label = (String) nodesObject.get("Lable");
        Long parentID = (Long) nodesObject.get("Parent ID");
        Long nodeID = (Long) nodesObject.get("Node ID");
        JSONArray child = (JSONArray) nodesObject.get("child-node");
//        System.out.println(employeeObject);// prints each node
        System.out.print("Node ID: " + nodeID);
        System.out.print(" Parent ID: " + parentID);
        System.out.print(" Lable: " + label);
        System.out.println(" child: " + child);
        System.out.println();
    }


    public void printTree(List<Node> nodes) {}


}
