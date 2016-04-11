package jp.co.tabocom.tsplugin.infocopy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.swt.widgets.Shell;

import jp.co.tabocom.teratermstation.model.TargetNode;
import jp.co.tabocom.teratermstation.plugin.TeratermStationPlugin;
import jp.co.tabocom.teratermstation.ui.action.TeratermStationAction;
import jp.co.tabocom.teratermstation.ui.action.TeratermStationContextMenu;

public class InfoCopyPlugin implements TeratermStationPlugin {

    @Override
    public PreferencePage getPreferencePage() {
        return null;
    }

    @Override
    public void initialize() throws Exception {
    }

    @Override
    public void teminate(PreferenceStore preferenceStore) throws Exception {
    }

    @Override
    public List<TeratermStationContextMenu> getActions(TargetNode[] nodes, Shell shell) {
        InfoCopyAction action = new InfoCopyAction(nodes, null, shell);
        TeratermStationContextMenu menu = new TeratermStationContextMenu();
        menu.addAction(action);
        return new ArrayList<TeratermStationContextMenu>(Arrays.asList(menu));
    }

    @Override
    public List<TeratermStationAction> getBulkActions(TargetNode[] nodes, Shell shell) {
        return null;
    }

    @Override
    public List<TeratermStationContextMenu> getDnDActions(TargetNode[] nodes, Object value, Shell shell) {
        return null;
    }
}
