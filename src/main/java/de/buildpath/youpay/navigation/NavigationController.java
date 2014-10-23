package de.buildpath.youpay.navigation;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;

import javax.enterprise.context.ApplicationScoped;

import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;

@ApplicationScoped
public class NavigationController {

    private final MainNavigationView mainNavigationView;
    private final MainNavigationViewModel mainNavigationViewModel;

    private final ObservableList<NavigationView> navigationViews = FXCollections.observableArrayList();

    public NavigationController() {
        ViewTuple<MainNavigationView, MainNavigationViewModel> tuple = FluentViewLoader.fxmlView(
                MainNavigationView.class).load();
        mainNavigationView = tuple.getCodeBehind();
        mainNavigationViewModel = tuple.getViewModel();
        mainNavigationViewModel.backNavigationPossibleProperty().bind(Bindings.size(navigationViews).greaterThan(1));
        mainNavigationViewModel.setBackRequest(() -> popNavigationView());
    }

    public Parent getView() {
        return mainNavigationView.getView();
    }

    public void pushNavigationView(NavigationView navigationView) {
        navigationViews.add(navigationView);
        mainNavigationView.setContent(navigationView.getView());
        mainNavigationViewModel.titleProperty().bind(navigationView.titleProperty());

    }

    public void popNavigationView() {
        int removeIndex = navigationViews.size() - 1;
        if (removeIndex >= 0) {
            // Display the last view
            mainNavigationView.setContent(navigationViews.get(removeIndex - 1).getView());
            navigationViews.remove(removeIndex);
        }
    }
}
