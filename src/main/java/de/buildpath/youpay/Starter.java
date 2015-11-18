package de.buildpath.youpay;

import javax.inject.Inject;

import de.buildpath.youpay.account.AccountListView;
import de.buildpath.youpay.account.AccountListViewModel;
import de.buildpath.youpay.favourite.FavouriteView;
import de.buildpath.youpay.favourite.FavouriteViewModel;
import de.buildpath.youpay.navigation.NavigationController;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import de.saxsys.mvvmfx.cdi.MvvmfxCdiApplication;
import de.saxsys.mvvmfx.utils.commands.Action;
import de.saxsys.mvvmfx.utils.commands.DelegateCommand;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
		favTuple.getViewModel().setAccountListRequest(new DelegateCommand(() -> new Action() {
			
			@Override
			protected void action() throws Exception {
				ViewTuple<AccountListView, AccountListViewModel> accListTuple = FluentViewLoader.fxmlView(
						AccountListView.class).load();
				navigationController.pushNavigationView(accListTuple.getCodeBehind());
			}
		}));
		navigationController.pushNavigationView(favTuple.getCodeBehind());
	}
}
