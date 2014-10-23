package de.buildpath.youpay.favourite;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import de.buildpath.youpay.navigation.NavigationView;
import de.jensd.fx.fontawesome.AwesomeDude;
import de.jensd.fx.fontawesome.AwesomeIcon;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;

public class FavouriteView implements FxmlView<FavouriteViewModel>, NavigationView {

    @FXML
    private GridPane view;

    @FXML
    private Button favouriteCashierButton;

    @FXML
    private PieChart moneyChart;

    @FXML
    private Button listButton;

    @InjectViewModel
    private FavouriteViewModel viewModel;

    @Override
    public StringProperty titleProperty() {
        return new SimpleStringProperty("Favourite");
    }

    @Override
    public Parent getView() {
        return view;
    }

    public void initialize() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(new PieChart.Data("Alex", 13),
                new PieChart.Data("Steffi", 25));
        moneyChart.setData(pieChartData);
        AwesomeDude.setIcon(listButton, AwesomeIcon.LIST, "1.5em");
        AwesomeDude.setIcon(favouriteCashierButton, AwesomeIcon.MONEY, "1.5em");
    }

    @FXML
    void listButtonPressed(ActionEvent event) {
        viewModel.getAccountListRequest().call();
    }

    @FXML
    void favouriteCashierButtonPressed(ActionEvent event) {
        viewModel.getFavouriteDetailViewRequest().call();
    }

}
