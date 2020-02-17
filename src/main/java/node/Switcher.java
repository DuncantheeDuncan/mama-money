package node;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import org.json.simple.JSONObject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface Switcher {

    ArrayList<PrintTree.Node>list = new ArrayList<>();
    Map<Integer, PrintTree.Node> forID = new HashMap<>();
    ListMultimap<Integer, String> forParent = ArrayListMultimap.create();
    String addData(int id, String label, int parentId) throws SQLException;
    int getNodeSize();
    String linkingNodes();
    String WriteToJSon() throws Exception;
    void readNodes(JSONObject jsonObject);
    void printTree(List<PrintTree.Node> nodes);
}
