package node;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PrintTreeUsingJDBC {

    final String GET_ALL_NODES_SQL = "select * from NodesDB";
    final String PUT_INTO_THE_DB_SQL = "insert into NodesDB(nodeId,nodeLabel,parentId) values(?,?,?)";
    final String DELETE_ALL_NODES_FROM_DB_SQL = "delete NodesDB";
    final String DELETE_A_NODE_SQL = "delete NodesDB  where nodeLabel = ?";
    final String FIND_NODE_SQL = "select * from NodesDB where nodeLabel = ?";
    final String UPDATE_NODE_SQL = "update NodesDb set parentId = parentId where nodeLabel = ?";//TODO attempting to update a node

    final PreparedStatement findAllNodesPreparedStatement;
    final PreparedStatement addNodesToDBPreparedStatement;
    final PreparedStatement updateNode;
    final PreparedStatement findNode;
    final PreparedStatement deleteANode;
    final PreparedStatement deleteAllNodes;

    final String jdbcURL ="jdbc:h2:./target/jdbc_addingnodes";
    Connection connection;

    public PrintTreeUsingJDBC() throws SQLException, ClassNotFoundException {
       Class.forName("org.h2.Driver");

       connection = DriverManager.getConnection(jdbcURL,"sa","");

       findAllNodesPreparedStatement = connection.prepareStatement(GET_ALL_NODES_SQL);
       addNodesToDBPreparedStatement = connection.prepareStatement(PUT_INTO_THE_DB_SQL);
       deleteAllNodes = connection.prepareStatement(DELETE_ALL_NODES_FROM_DB_SQL);
       deleteANode = connection.prepareStatement(DELETE_A_NODE_SQL);
       findNode = connection.prepareStatement(FIND_NODE_SQL);
       updateNode = connection.prepareStatement(UPDATE_NODE_SQL);

    }
    private ArrayList<PrintTree.Node> listDB = new ArrayList<>();
    private Map<Integer, PrintTree.Node> forIDDB = new HashMap<>();
    private ListMultimap<Integer, String> forParentDB = ArrayListMultimap.create();


//    public

    public String addNodes(int nodeId,String label,int parentId) throws SQLException {

        ResultSet resultSet = findAllNodesPreparedStatement.executeQuery();//while
        findNode.setString(2,label);

        ResultSet rs = findNode.executeQuery();//loop

//        if (rs.next()){
//            updateNode.setString(2,label);
//            updateNode.execute();
//        }else {
            addNodesToDBPreparedStatement.setInt(1,nodeId);
            addNodesToDBPreparedStatement.setString(2,label);
            addNodesToDBPreparedStatement.setInt(3,parentId);
            addNodesToDBPreparedStatement.execute();
//        }
        while (resultSet.next()){
            int nodeIdDB = resultSet.getInt("nodeId");
            String nodeLabelDB = resultSet.getString("nodeLabel");
            int parentIdDB = resultSet.getInt("parentId");
            listDB.add(new PrintTree.Node(nodeIdDB,nodeLabelDB,parentIdDB));
            System.out.println("does get in here");
        }



        return "k";
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        PrintTreeUsingJDBC r = new PrintTreeUsingJDBC();
        r.addNodes(2,"kk",5);
    }
}
