/*
    * Edit by Alexander Eric
    * Libray SUN
 */



import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

@SuppressWarnings("serial")
public class MetalworksInBox extends JInternalFrame {

    public MetalworksInBox() {
        super("In Box", true, true, true, true);

        DefaultMutableTreeNode unread;
        DefaultMutableTreeNode personal;
        DefaultMutableTreeNode business;
        DefaultMutableTreeNode spam;

        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Mail Boxes");

        top.add(unread = new DefaultMutableTreeNode("Unread Mail"));
        top.add(personal = new DefaultMutableTreeNode("Personal"));
        top.add(business = new DefaultMutableTreeNode("Business"));
        top.add(spam = new DefaultMutableTreeNode("Spam"));

        unread.add(new DefaultMutableTreeNode("Inbox"));
        unread.add(new DefaultMutableTreeNode("Inbox"));
        unread.add(new DefaultMutableTreeNode("Inbox"));
        unread.add(new DefaultMutableTreeNode("Inbox"));
        unread.add(new DefaultMutableTreeNode("Inbox"));

        personal.add(new DefaultMutableTreeNode("Inbox"));
        personal.add(new DefaultMutableTreeNode("Inbox"));
        personal.add(new DefaultMutableTreeNode("Inbox"));

        business.add(new DefaultMutableTreeNode("Inbox"));
        business.add(new DefaultMutableTreeNode("Inbox"));
        business.add(new DefaultMutableTreeNode("Inbox"));
        business.add(new DefaultMutableTreeNode(
                "Project Metal: delivered on time"));
        business.add(new DefaultMutableTreeNode("Inbox"));

        spam.add(new DefaultMutableTreeNode("Inbox"));
        spam.add(new DefaultMutableTreeNode("Inbox"));
        spam.add(new DefaultMutableTreeNode("Inbox"));
        spam.add(new DefaultMutableTreeNode("Inbox"));
        spam.add(new DefaultMutableTreeNode("Inbox"));
        spam.add(new DefaultMutableTreeNode("Inbox"));
        spam.add(new DefaultMutableTreeNode("Inbox"));
        spam.add(new DefaultMutableTreeNode("Inbox"));
        spam.add(new DefaultMutableTreeNode("Inbox"));
        spam.add(new DefaultMutableTreeNode("Inbox"));
        spam.add(new DefaultMutableTreeNode("Inbox"));
        spam.add(new DefaultMutableTreeNode("Inbox"));

        JTree tree = new JTree(top);
        JScrollPane treeScroller = new JScrollPane(tree);
        treeScroller.setBackground(tree.getBackground());
        setContentPane(treeScroller);
        setSize(325, 200);
        setLocation(75, 75);

    }
}
