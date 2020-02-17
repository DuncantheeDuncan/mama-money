package node;


import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class PrintTreeTests {

    @Test
    public void shouldBeAbleToAdd() {
        PrintTree shouldAdd = new PrintTree();
        assertEquals("5 NodeA 0", shouldAdd.addData(5, "NodeA", 87));
        assertEquals("7 NodeC 56", shouldAdd.addData(7, "NodeC", 56));
        assertEquals("30 NodeG 56", shouldAdd.addData(30, "NodeG", 56));
        assertEquals(3, shouldAdd.getNodeSize());
    }

    @Test
    public void shouldBeAbleToSetFirstNodeToZero() {
        PrintTree setNodeToZero = new PrintTree();
        // will only have one assert since it only changes the first node
        assertEquals("200 FirstNode 0", setNodeToZero.addData(200, "FirstNode", 304));
    }

    @Test
    public void shouldBeAbleToCheckForIdDuplicates() {
        PrintTree checkIdDuplicates = new PrintTree();

        checkIdDuplicates.addData(4, "NodeM", 0);
        checkIdDuplicates.addData(5, "NodeX", 78);
        checkIdDuplicates.addData(9, "NodeAA", 23);
        checkIdDuplicates.addData(4, "NodeX", 78);
        checkIdDuplicates.addData(5, "NodeX", 78);

        assertEquals("4 is a duplicate of ID, please enter again", checkIdDuplicates.addData(4, "NodeR", 7));
        assertEquals("5 is a duplicate of ID, please enter again", checkIdDuplicates.addData(5, "NodeR", 7));
    }

    @Test
    public void shouldGetSize() {
        PrintTree getSize = new PrintTree();

        getSize.addData(98, "NodeX", 18);
        getSize.addData(4, "NodeM", 20);
        getSize.addData(9, "NodeAA", 23);
        getSize.addData(4, "NodeV", 78);// will not add this line
        getSize.addData(5, "NodeX", 78);
        getSize.addData(6, "NodeCC", 87);

        assertEquals(5, getSize.getNodeSize());
    }

    @Test
    public void shouldLinkIdWithParentID() {
        PrintTree linked = new PrintTree();

        linked.addData(56, "Sfiso", 0);
        linked.addData(12, "Avuyile", 56);
        linked.addData(34, "Sbonelo", 56);

        assertEquals("Node ID - 56: child nodes - [12:Avuyile:56, 34:Sbonelo:56]", linked.linkingNodes());
    }

    @Test
    public void shouldWriteToJSONFile() throws Exception {
        PrintTree linkedNodes = new PrintTree();

        linkedNodes.addData(56, "Sfiso", 0);
        linkedNodes.addData(12, "Avuyile", 56);
        linkedNodes.addData(8, "Sbonelo jr", 34);
        linkedNodes.addData(5, "Sdufuza", 89);
        linkedNodes.addData(34, "Sbonelo", 56);
        linkedNodes.addData(89, "Bavumile", 0);
        linkedNodes.addData(48, "Foreigner", 23);
        linkedNodes.addData(42, "Foreigner", 23);
        linkedNodes.WriteToJSon();
//        assertEquals("[{\"nodes\":{\"child-node\":[56,\"Sfiso\",0],\"Node ID\":56,\"Parent ID\":0,\"Lable\":\"Sfiso\"}},{\"nodes\":{\"child-node\":[89,\"Bavumile\",0],\"Node ID\":89,\"Parent ID\":0,\"Lable\":\"Bavumile\"}},{\"nodes\":{\"child-node\":[8,\"Sbonelo jr\",34],\"Node ID\":8,\"Parent ID\":34,\"Lable\":\"Sbonelo jr\"}},{\"nodes\":{\"child-node\":[48,\"Foreigner\",23],\"Node ID\":48,\"Parent ID\":23,\"Lable\":\"Foreigner\"}},{\"nodes\":{\"child-node\":[42,\"Foreigner\",23],\"Node ID\":42,\"Parent ID\":23,\"Lable\":\"Foreigner\"}},{\"nodes\":{\"child-node\":[12,\"Avuyile\",56],\"Node ID\":12,\"Parent ID\":56,\"Lable\":\"Avuyile\"}},{\"nodes\":{\"child-node\":[34,\"Sbonelo\",56],\"Node ID\":34,\"Parent ID\":56,\"Lable\":\"Sbonelo\"}},{\"nodes\":{\"child-node\":[5,\"Sdufuza\",89],\"Node ID\":5,\"Parent ID\":89,\"Lable\":\"Sdufuza\"}}]",linkedNodes.WriteToJSon());

    }

}
