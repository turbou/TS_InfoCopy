package jp.co.tabocom.tsplugin.infocopy;

import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Shell;

import jp.co.tabocom.teratermstation.model.TargetNode;
import jp.co.tabocom.teratermstation.ui.action.TeratermStationAction;

public class InfoCopyAction extends TeratermStationAction {
    protected InfoCopyAction(TargetNode node, Shell shell, ISelectionProvider selectionProvider) {
        super("情報をコピー", "info.png", node, shell, selectionProvider);
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public void run() {
        StringBuilder builder = new StringBuilder();
        if (node.getChildren().isEmpty()) {
            // 要は子供（サーバ号機）の場合
            builder.append(String.format("%-8s", node.getHostName()));
            builder.append(",");
            builder.append(String.format("%-15s", node.getIpAddr()));
            builder.append(",");
            builder.append(node.getParent().getName());
            builder.append(",");
            builder.append(node.getName());
        } else {
            // 要は親（サーバ種別）の場合
            builder.append(node.getName());
            builder.append("\r\n");
            for (TargetNode nd : node.getChildren()) {
                builder.append(String.format("%-8s", nd.getHostName()));
                builder.append(",");
                builder.append(String.format("%-15s", nd.getIpAddr()));
                builder.append(",");
                builder.append(nd.getName());
                builder.append("\r\n");
            }
        }
        // クリップボード
        Clipboard clipBoard = new Clipboard(shell.getDisplay());
        clipBoard.setContents(new Object[] { builder.toString() }, new Transfer[] { TextTransfer.getInstance() });
    }
}
