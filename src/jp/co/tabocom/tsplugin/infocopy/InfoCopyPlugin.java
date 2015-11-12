package jp.co.tabocom.tsplugin.infocopy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.widgets.Shell;

import jp.co.tabocom.teratermstation.model.TargetNode;
import jp.co.tabocom.teratermstation.plugin.TeratermStationPlugin;
import jp.co.tabocom.teratermstation.ui.action.TeratermStationAction;
import jp.co.tabocom.teratermstation.ui.action.TeratermStationBulkAction;

public class InfoCopyPlugin implements TeratermStationPlugin {

    @Override
    public List<TeratermStationAction> getActions(TargetNode node, Shell shell, ISelectionProvider selectionProvider) {
        return new ArrayList<TeratermStationAction>(Arrays.asList(new InfoCopyAction(node, shell, selectionProvider)));
    }

    @Override
    public List<TeratermStationBulkAction> getBulkActions(List<TargetNode> nodeList, Shell shell) {
        return null;
    }

    @Override
    public PreferencePage getPreferencePage() {
        return null;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void teminate(PreferenceStore preferenceStore) {
    }
}
