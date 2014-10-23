package de.buildpath.youpay.account;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import de.buildpath.youpay.navigation.NavigationView;
import de.saxsys.mvvmfx.FxmlView;

public class AccountListView implements FxmlView<AccountListViewModel>, NavigationView {

    @FXML
    private Parent view;

    @Override
    public StringProperty titleProperty() {
        return new SimpleStringProperty("Accounts");
    }

    @Override
    public Parent getView() {
        return view;
    }

}
