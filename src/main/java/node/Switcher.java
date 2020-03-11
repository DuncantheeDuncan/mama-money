package node;

import org.json.simple.JSONObject;
import java.sql.SQLException;
import java.util.List;


public interface Switcher {
    String addData(int id, String label, int parentId) throws SQLException;
    int getNodeSize();
    String linkingNodes();
    String WriteToJSon() throws Exception;
    void readNodes(JSONObject jsonObject);
    void printTree(List<PrintTree.Node> nodes);
}
