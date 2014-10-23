package de.buildpath.youpay;

import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.inject.Inject;

import de.buildpath.youpay.account.AccountListView;
import de.buildpath.youpay.account.AccountListViewModel;
import de.buildpath.youpay.favourite.FavouriteView;
import de.buildpath.youpay.favourite.FavouriteViewModel;
import de.buildpath.youpay.navigation.NavigationController;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import de.saxsys.mvvmfx.cdi.MvvmfxCdiApplication;

public class Starter extends MvvmfxCdiApplication {

    @Inject
    private NavigationController navigationController;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void startMvvmfx(Stage stage) throws Exception {
        Scene scene = new Scene(navigationController.getView());
        stage.setScene(scene);
        stage.show();

        ViewTuple<FavouriteView, FavouriteViewModel> favTuple = FluentViewLoader.fxmlView(FavouriteView.class).load();
        favTuple.getViewModel().setAccountListRequest(
                () -> {
                    ViewTuple<AccountListView, AccountListViewModel> accListTuple = FluentViewLoader.fxmlView(
                            AccountListView.class).load();
                    navigationController.pushNavigationView(accListTuple.getCodeBehind());
                });
        navigationController.pushNavigationView(favTuple.getCodeBehind());
    }
}
