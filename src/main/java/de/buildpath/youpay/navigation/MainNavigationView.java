package de.buildpath.youpay.navigation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;

public class MainNavigationView implements FxmlView<MainNavigationViewModel> {

    @FXML
    private Parent view;

    @FXML
    private StackPane contentArea;

    @FXML
    private Label titleLabel;

    @FXML
    private Button backButton;

    @InjectViewModel
    private MainNavigationViewModel viewModel;

    private Node content;

    public void initialize() {
        titleLabel.textProperty().bind(viewModel.titleProperty());
        backButton.visibleProperty().bind(viewModel.backNavigationPossibleProperty());
    }

    protected void setContent(Parent newContent) {
        if (this.content != null) {
            contentArea.getChildren().remove(this.content);
        }
        this.content = newContent;
        contentArea.getChildren().add(0, newContent);
    }

    protected Parent getView() {
        return view;
    }

    @FXML
    void backButtonPressed(ActionEvent event) {
        viewModel.getBackRequest().call();
    }

}
